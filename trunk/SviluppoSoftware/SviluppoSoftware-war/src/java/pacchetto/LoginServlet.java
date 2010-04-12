/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;

import java.io.IOException;
import java.io.PrintWriter;
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
import prova.GestoreUtenteRegistratoLocal;
import prova.UtenteRegistrato;


/**
 *
 * @author dani1913
 */
public class LoginServlet extends HttpServlet {
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

        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        // Recupero i riferimenti alle pagine
        RequestDispatcher index = getServletContext().getRequestDispatcher("/index.jsp");
        RequestDispatcher welcome = getServletContext().getRequestDispatcher("/Pages/welcomePage.jsp");
        RequestDispatcher reg = getServletContext().getRequestDispatcher("/Pages/register.jsp");
        RequestDispatcher err = getServletContext().getRequestDispatcher("/Pages/error.jsp");
        RequestDispatcher gotReg = getServletContext().getRequestDispatcher("/Pages/gotReg.jsp");
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
                 out.println("id" + id);
                    out.println("passw" + password);
                if (tmp_admin!=null && tmp_admin.getPassword().equals(password)) {
                    session.setAttribute("login", id);
                    admin_panel.forward(request, response);
                }
                //Controllo che l' utente sia già registrato e lo reindirizzo alla pagina personale
                else{
                   
                    tmp_user=gestoreUtenteRegistrato.findUser(id);
                    if (tmp_user!=null && tmp_user.getPassword().equals(password)) {
                        session.setAttribute("login", id);
                        welcome.forward(request, response);
                    }
                    else
                        err.forward(request, response);
                }
            }


            //richiesta registrazione dell' utente
            if(operazione.equals("registrazione"))
                {  request.getSession().setAttribute("reg", "reg1");
                   reg.forward(request, response);
                }
            //registrazione richiesta dal sistema
            if(operazione.equals("registrazione2"))
                {request.getSession().setAttribute("reg", "reg2");
                 reg.forward(request, response);
                }

            //dati registrazione inviati dall' utente e storaging
            if(operazione.equals("datiRegistrazione"))                            
                {   tmp_user = new UtenteRegistrato();
                    tmp_user.setId(request.getParameter("username"));
                    tmp_user.setPassword(request.getParameter("password"));
                    tmp_user.setNome(request.getParameter("nome"));
                    tmp_user.setCognome(request.getParameter("cognome"));
                    tmp_user.setMail(request.getParameter("mail"));
                    tmp_user.setIndirizzo(request.getParameter("indirizzo"));
                    tmp_user.setN_cartacredito(request.getParameter("n_cartacredito"));
                    gestoreUtenteRegistrato.addUser(tmp_user);
                  out.println(request.getParameter("Register"));
                 /*if(request.getParameter("Register").equals("Invia"))
                    gotReg.forward(request, response);
                  else
                  {rd = sc.getRequestDispatcher("/Pages/riepilogoDati.jsp");
                   rd.forward(request,response);
                  }*/
                }




             //CONFERMA DATI
            if(operazione.equals("conferma_dati"))
                {UtenteRegistrato utente = (UtenteRegistrato)request.getSession().getAttribute("login");
                 gestoreUtenteRegistrato.findUser(operazione);
                 session.setAttribute("utente", utente);
                 rd = sc.getRequestDispatcher("/Box/riepilogoDati.jsp");
                 rd.forward(request,response);
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
