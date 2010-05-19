/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacchetto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dani1913
 */
public class SaasServlet extends HttpServlet {

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
        HttpSession session=request.getSession();
        try {
            String operazione = request.getParameter("op");

            String code = request.getParameter("code");


            if (operazione != null) {
                if (operazione.equals("facebook")) {
                    RequestDispatcher facebook = getServletContext().getRequestDispatcher("/Pages/facebook.jsp");
                    facebook.forward(request, response);
                }

                if (operazione.equals("event_info")) {

                    String nome= request.getParameter("nome");
                    String citta=request.getParameter("citta");
                    String privacy=request.getParameter("privacy");
                    String descrizione=request.getParameter("descrizione");

                    String event_info="{\"name\": \"" + nome + "\", \"citta\": \""+citta+"\" ,\"start_time\": 1275796800, \"privacy_type\": \""+ privacy +"\",\"descrizione\": \""+descrizione+"\"}";
                    session.setAttribute("event_info",event_info);
                    RequestDispatcher gotEvent = getServletContext().getRequestDispatcher("/Pages/gotEvent.jsp");
                    gotEvent.forward(request, response);


                }
            }

            if (code != null) {

                out.println(code);
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
