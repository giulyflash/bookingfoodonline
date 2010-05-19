/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prova.Amministratore;
import prova.GestoreAmministratoreLocal;
import prova.GestoreLineaMagazzinoBeanLocal;
import prova.GestoreUtenteRegistratoLocal;
import prova.Magazzino;
import prova.MagazzinoFacadeLocal;
import prova.UtenteRegistrato;
import prova.Prenotazione;

/**
 *
 * @author dani1913
 */
public class LoginServlet extends HttpServlet {
    @EJB
    private MagazzinoFacadeLocal magazzinoFacade;
    @EJB
    private GestoreLineaMagazzinoBeanLocal gestoreLineaMagazzinoBean;
    @EJB
    private GestoreAmministratoreLocal gestoreAmministratore;
    @EJB
    private GestoreUtenteRegistratoLocal gestoreUtenteRegistrato;



    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();


        response.setContentType("text/html;charset=UTF-8");



        // Recupero i riferimenti alle pagine
        RequestDispatcher index = getServletContext().getRequestDispatcher("/index.jsp");


        RequestDispatcher err = getServletContext().getRequestDispatcher("/Pages/error.jsp");

        RequestDispatcher admin_panel = getServletContext().getRequestDispatcher("/admin/admin_panel.jsp");


        Amministratore tmp_admin;
        UtenteRegistrato tmp_user;


        try {

            // sezione login utente
            String operazione=request.getParameter("op");


            if (operazione == null)
                index.forward(request, response);


            if(operazione.equals("login")){
                // Controllo che non sia l' amministratore
                String id=request.getParameter("username");
                String password=request.getParameter("password");


                tmp_admin=gestoreAmministratore.findAdmin(id);
                if (tmp_admin!=null && tmp_admin.getPassword().equals(password)) {
                    session.setAttribute("login", id);
                    admin_panel.forward(request, response);
                }
                //Controllo che l' utente sia già registrato e lo reindirizzo alla pagina personale
                else{
                    tmp_user=gestoreUtenteRegistrato.findUser(id);
                    if (tmp_user!=null && tmp_user.getPassword().equals(password)) {
                        session.setAttribute("login", id);

                        // controllo se l' utente si e' loggato durante una prenotazione
                        //*******************************************************
                        if(session.getAttribute("callback")!=null){
                            session.setAttribute("login", tmp_user.getNome());
                            session.setAttribute("utente", tmp_user);
                            request.getSession().setAttribute("utente", tmp_user);
                            Prenotazione p = (Prenotazione)session.getAttribute("prenotazione");
                            p.setZona(tmp_user.getZona());
                            request.getSession().setAttribute("prenotazione", p);
                            List<Magazzino> listaMag =magazzinoFacade.findAll();
                            session.setAttribute("zone", listaMag);

                            RequestDispatcher riepilogo = getServletContext().getRequestDispatcher("/Pages/riepilogoDati.jsp");

                            riepilogo.forward(request, response);
                        }
                        else{
                            RequestDispatcher welcome = getServletContext().getRequestDispatcher("/Pages/welcomePage.jsp");
                            welcome.forward(request, response);
                        }


                    }
                    else
                        err.forward(request, response);
                }
            }

            if(operazione.equals("checkAccount"))
            {
                List<Magazzino> listaMag =magazzinoFacade.findAll();
                session.setAttribute("zone", listaMag);

                String user=(String)session.getAttribute("login");
                // se l' utente è loggato
                if(user!=null){
                    //se si è loggato tramite
                    if(session.getAttribute("openid")!=null){
                        UtenteRegistrato utente=new UtenteRegistrato();
                        utente.setId(user);
                        utente.setIndirizzo("inserisci la via");
                        utente.setN_cartacredito("inserisci numero carta di credito");
                        session.setAttribute("utente", utente);
                        RequestDispatcher riepilogo = getServletContext().getRequestDispatcher("/Pages/riepilogoDati.jsp");
                        riepilogo.forward(request, response);
                    }
                    else{
                        UtenteRegistrato utente = gestoreUtenteRegistrato.findUser(user);
                        session.setAttribute("utente", utente);
                        RequestDispatcher riepilogo = getServletContext().getRequestDispatcher("/Pages/riepilogoDati.jsp");
                        riepilogo.forward(request, response);

                    }
                }
                //se l'utente non è  registrato deve registrarsi
                else{
                    //setto la sessione per redirezionare l'utente nella pagina finale
                    session.setAttribute("callback", true);

                    RequestDispatcher regOrlog = getServletContext().getRequestDispatcher("/Pages/regOrlog.jsp");
                    regOrlog.forward(request, response);
                }
            }

            if(operazione.equals("confermaDati"))
            {
                    UtenteRegistrato utente=(UtenteRegistrato)session.getAttribute("utente");
                    utente.setIndirizzo(request.getParameter("indirizzo"));
                    utente.setN_cartacredito("n_cartacredito");
                    //aggiorno le informazioni dell' utente nella sessione
                    session.setAttribute("utente", utente);
                    Prenotazione p= (Prenotazione)session.getAttribute("prenotazione");

                    p.setZona(request.getParameter("zone"));

                    gestoreLineaMagazzinoBean.checkQuantita(p, out);

                    RequestDispatcher gotBooking = getServletContext().getRequestDispatcher("/Pages/gotBooking.jsp");
                    gotBooking.forward(request, response);
            }


            //richiesta registrazione dell' utente
            if(operazione.equals("registrazione"))
            {

                List<Magazzino> listaMag =magazzinoFacade.findAll();
                session.setAttribute("zone", listaMag);
                RequestDispatcher reg = getServletContext().getRequestDispatcher("/Pages/register.jsp");
                reg.forward(request, response);
            }

            //dati registrazione inviati dall' utente e storaging
            if(operazione.equals("datiRegistrazione"))
                {
                    tmp_user = new UtenteRegistrato();
                    tmp_user.setId(request.getParameter("username"));
                    tmp_user.setPassword(request.getParameter("password"));
                    tmp_user.setNome(request.getParameter("nome"));
                    tmp_user.setCognome(request.getParameter("cognome"));
                    tmp_user.setMail(request.getParameter("mail"));
                    tmp_user.setIndirizzo(request.getParameter("indirizzo"));
                    tmp_user.setN_cartacredito(request.getParameter("n_cartacredito"));
                    tmp_user.setZona(request.getParameter("zone"));
                    gestoreUtenteRegistrato.addUser(tmp_user);
                    //controllo se l'utente arriva da una registrazione sollevata durante una prenotazione
                    //*************************************************************
                    if(request.getSession().getAttribute("callback")!=null){
                        session.setAttribute("login", tmp_user.getNome());
                        request.getSession().setAttribute("utente", tmp_user);
                        Prenotazione p = (Prenotazione)session.getAttribute("prenotazione");
                        p.setZona(tmp_user.getZona());
                        request.getSession().setAttribute("prenotazione", p);

                        List<Magazzino> listaMag =magazzinoFacade.findAll();
                        session.setAttribute("zone", listaMag);

                        RequestDispatcher gotBooking = getServletContext().getRequestDispatcher("/Pages/riepilogoDati.jsp");
                        gotBooking.forward(request, response);
                    }
                    else{
                        RequestDispatcher gotReg = getServletContext().getRequestDispatcher("/Pages/gotReg.jsp");
                        gotReg.forward(request, response);
                    }

                }


            //operazione di logout
            if(operazione.equals("logout")){
                session.invalidate();
                index.forward(request, response);
            }




        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
