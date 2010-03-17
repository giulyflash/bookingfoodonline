/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author dani1913
 */
public class openIDServlet extends HttpServlet {
    /**
     * The logger.
     */
    private static Logger logger = Logger.getLogger("pacchetto.rpxauth");
    /**
     * The RPX base URL.
    */
    private static final String RPX_BASEURL = "https://rpxnow.com";
    /**
     * Your secret API code.
     */
    private static final String RPX_APIKEY = "160508fd7895a37901a5bbabff83b298e7849a4d";
   
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
        RequestDispatcher welcome = getServletContext().getRequestDispatcher("/Pages/welcomePage.jsp");

        try {

            // We had to use the token_url of this servlet to get back here, and
            // the magic token is in a parameter.
            String rpxToken = request.getParameter("token");
            Rpx rpx = new Rpx(RPX_APIKEY,RPX_BASEURL);
            //Make an auth dom element from the xml returned by the provider.

            Element rpxAuth = rpx.authInfo(rpxToken);
            
            // Check if authentication failed.
            String stat = rpxAuth.getAttribute("stat");
            if (!"ok".equals(stat)) {
                String error = "User authentication failed";
                logger.info(error);
                response.sendError(HttpServletResponse.SC_FORBIDDEN, error);
                return;
            }
            
            // Generate a map of the profile attributes.
            Map<String, String> openIdMap = new HashMap<String, String>();
            Node profile = rpxAuth.getFirstChild();
            NodeList profileFields = profile.getChildNodes();
            for(int k = 0; k < profileFields.getLength(); k++) {
                Node n = profileFields.item(k);
                if (n.hasChildNodes()) {
                    NodeList nFields = n.getChildNodes();
                    for (int j = 0; j < nFields.getLength(); j++) {
                        Node nn = nFields.item(j);
                        String nodename = n.getNodeName();
                        if (!nn.getNodeName().startsWith("#"))
                            nodename += "." + nn.getNodeName();
                        openIdMap.put(nodename, nn.getTextContent());
                    }
                } else
                    openIdMap.put(n.getNodeName(), n.getTextContent());
            }
            logger.info("RPX login: " + openIdMap.toString());

            // Now openIdMap contains a hash map of all the profile fields we got back.
            String username = openIdMap.get("preferredUsername");
            // Nested elements can be accessed with the full path:
            //String name = openIdMap.get("name.formatted");
            //String mail = openIdMap.get("email");
            // Do something useful with them...


            //setting session
            session.setAttribute("login", username);

            //redirecting to the welcome page
            welcome.forward(request, response);
            
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
