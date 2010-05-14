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
import org.netbeans.saas.facebook.FacebookSocialNetworkingService;
import org.netbeans.saas.RestResponse;

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
        try {
            String operazione = request.getParameter("op");

            String code = request.getParameter("code");

            if (operazione != null) {
                if (operazione.equals("facebook")) {
                    RequestDispatcher facebook = getServletContext().getRequestDispatcher("/Pages/facebook.jsp");
                    facebook.forward(request, response);
                }

                if (operazione.equals("event_info")) {

                    try {
                        String eventInfo = "{\"name\": \"Luca Ienco Angelo\", \"start_time\": 1273935600, \"privacy_type\": \"OPEN\"}";
                        String format = null;
                        String callback = null;

                        RestResponse result = FacebookSocialNetworkingService.eventsCreate(request, response, eventInfo, format, callback);
                        out.println("Sono dopo result events create");
                        if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse) {
                            facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse.class);
                        } else if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.ErrorResponse) {
                            facebook.socialnetworkingservice.facebookresponse.ErrorResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class);
                        }
                        //TODO - Uncomment the print Statement below to print result.
                        //out.println("The SaasService returned: "+result.getDataAsString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

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
