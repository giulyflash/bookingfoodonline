/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prova.UtenteRegistratoFacadeLocal;
import prova.UtenteRegistrato;


/**
 *
 * @author dani1913
 */
public class LoginServlet extends HttpServlet {
    @EJB
    private UtenteRegistratoFacadeLocal utenteRegistratoFacade;
   
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
        HttpSession s = request.getSession();

        RequestDispatcher index = getServletContext().getRequestDispatcher("/index.jsp");
        RequestDispatcher reg = getServletContext().getRequestDispatcher("/register.jsp");

        try {
            
            
            String operazione=request.getParameter("op");
            /*String id=request.getParameter("username");
            
            s.setAttribute("login", id);
            
            index.forward(request, response);
            if (operazione == null)
                index.forward(request, response);

            //Controllo che l' utente sia già registrato e lo reindirizzo alla pagina personale
            if(operazione.equals("login")){
                UtenteRegistrato tmp=utenteRegistratoFacade.find(request.getParameter("username"));
                if(tmp!=null){
                    if(tmp.getPassword().equals(request.getParameter("password"))){
                        session.setAttribute("login", id);
                        // inoltro alla pagina iniziale
                        index.forward(request, response);
                    }
                    else index.forward(request, response);
                }
                else index.forward(request, response);
            }*/


            //richiesta registrazione dell' utente
            if(operazione.equals("registrazione"))
                reg.forward(request, response);

            //dati registrazione inviati dall' utente e storaging
            if(operazione.equals("datiRegistrazione")){
                UtenteRegistrato tmp = new UtenteRegistrato();
                tmp.setId(request.getParameter("username"));
                tmp.setPassword(request.getParameter("password"));
                tmp.setNome(request.getParameter("nome"));
                tmp.setCognome(request.getParameter("cognome"));
                tmp.setMail(request.getParameter("mail"));
                tmp.setIndirizzo(request.getParameter("indirizzo"));
                tmp.setN_cartacredito(request.getParameter("n_cartacredito"));
                utenteRegistratoFacade.create(tmp);
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
