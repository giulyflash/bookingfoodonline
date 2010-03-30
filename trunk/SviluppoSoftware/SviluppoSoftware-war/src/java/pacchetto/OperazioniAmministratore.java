/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prova.GestorePiattoBeanLocal;
import prova.Piatto;

/**
 *
 * @author dani1913
 */
public class OperazioniAmministratore extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        // Recupero i riferimenti alle pagine
        RequestDispatcher index = getServletContext().getRequestDispatcher("/index.jsp");
        RequestDispatcher reg = getServletContext().getRequestDispatcher("/Pages/register.jsp");
        RequestDispatcher gotReg = getServletContext().getRequestDispatcher("/Pages/gotReg.jsp");
        RequestDispatcher admin_panel = getServletContext().getRequestDispatcher("/admin/admin_panel.jsp");
        
        try {

              String operazione=request.getParameter("op");
              
              if(operazione.equals("insertPiatto")){
                    RequestDispatcher insertPiatto = getServletContext().getRequestDispatcher("/Pages/insertPiatto.jsp");
                    insertPiatto.forward(request, response);
              }

              //recupero le informazioni del piatto da inserire
              if(operazione.equals("datiPiatto")){
                    Piatto tmp=new Piatto();
                    tmp.setNome(request.getParameter("nomepiatto"));
                    tmp.setCosto(Double.valueOf(request.getParameter("costopiatto")));
                    tmp.setCategoria(request.getParameter("categoriapiatto"));
                    tmp.setUrl_immagine(request.getParameter("urlimmagine"));

                    
                    String[] listaNonMod=request.getParameter("listaNonModificabili").split(";");
                    String[] matSottraibili=request.getParameter("materieSottraibili").split(";");
                    String[] matAggiungibili=request.getParameter("materieAggiungibili").split(";");
                    
                    ArrayList<String> nonMod=new ArrayList<String>();
                    for(int i=0; i<listaNonMod.length; i++)
                        nonMod.add(listaNonMod[i]);

                    ArrayList<String> matSot=new ArrayList<String>();
                    for(int i=0; i<matSottraibili.length; i++)
                        matSot.add(matSottraibili[i]);

                    ArrayList<String> matAgg=new ArrayList<String>();
                    for(int i=0; i<matAggiungibili.length; i++)
                        matAgg.add(matAggiungibili[i]);


                    tmp.setListaMaterieNonModificabili(nonMod);
                    tmp.setListaMaterieSottraibili(matSot);
                    tmp.setListaPossibiliAggiunte(matAgg);

                    gestorePiattoBean.addPiatto(tmp);

                    RequestDispatcher piattoInserito = getServletContext().getRequestDispatcher("/Pages/piattoInserito.jsp");
                    piattoInserito.forward(request, response);
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
