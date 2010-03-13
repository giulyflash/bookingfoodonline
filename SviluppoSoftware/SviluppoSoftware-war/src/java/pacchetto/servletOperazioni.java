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
import prova.*;
import java.lang.String;



/**
 *
 * @author Matteo
 */
public class servletOperazioni extends HttpServlet {
    @EJB
    private GestorePiattoBeanLocal gestorePiattoBean;
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


        HttpSession s = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
        RequestDispatcher rd;
        String categoria = request.getParameter("categoria");


        //RICERCA CATEGORIA
        if(categoria!=null)
            {List<Piatto> listaPiatti  = gestorePiattoBean.findPiattiPerCategoria(categoria);
             s.setAttribute("lista",listaPiatti);
             rd = sc.getRequestDispatcher("/CategoriePiatti/PiattiPerCategoria.jsp");
             rd.forward(request,response);
            }



             
             /*
             out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletOperazioni</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletOperazioni at " + request.getContextPath () + "</h1>");
            out.println(listaPiatti.get(0).getNome());
            out.println("</body>");
            out.println("</html>");


             


            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletOperazioni</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletOperazioni at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        
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
