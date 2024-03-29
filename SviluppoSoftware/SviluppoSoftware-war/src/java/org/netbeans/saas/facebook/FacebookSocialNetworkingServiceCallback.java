/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.facebook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author dani1913
 */
public class FacebookSocialNetworkingServiceCallback extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            String authToken = request.getParameter("auth_token");
            session.setAttribute("facebook_auth_token", authToken);

           
                        
            /* richiama la login perchè ha ottenuto l'auth token */
            FacebookSocialNetworkingServiceAuthenticator.login(request, response);
            
            //String sessionKey=(String) request.getSession().getAttribute("facebook_session_key");
            String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FacebookCallback</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FacebookCallback at " + request.getContextPath() + "</h1>");
            out.println("<p> Your Session Key is " + sessionKey + "</p>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
