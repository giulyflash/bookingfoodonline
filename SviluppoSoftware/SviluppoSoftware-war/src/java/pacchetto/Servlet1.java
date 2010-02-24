/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.security.PermitAll;

import prova.*;





/**
 *
 * @author Matteo
 */@PermitAll    
public class Servlet1 extends HttpServlet {
    @EJB
    private GestoreLineaMagazzinoBeanLocal gestoreLineaMagazzinoBean;
    
    @EJB
    private MateriaPrimaFacadeLocal materiaPrimaFacade;
    @EJB
    private MagazzinoFacadeLocal magazzinoFacade;
    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;
    @EJB
    private GestorePiattoBeanLocal gpb;



    @Resource(mappedName = "jms/ConsumerOrdineFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ConsumerOrdine")
    private Queue queue;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @PermitAll    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        //GESTIRE SESSIONE
        //GESTIRE SESSIONE*************************************************************************
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("lagoÃ²");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath () + "</h1>");
            Magazzino m = new Magazzino();
            m.setId(Long.MIN_VALUE);
            m.setLocalita("Milano");

            MateriaPrima mp = new MateriaPrima();
            mp.setId(Long.MIN_VALUE);
            mp.setNome("carne");
            materiaPrimaFacade.create(mp);
            LineaMagazzino lm = new LineaMagazzino();
            lm.setId(Long.MIN_VALUE);
            lm.setMag(m);
            lm.setN_rif(10);
            lm.setQuantita(300);
            lm.setSogliaMinima(350);
            List<LineaMagazzino> listaLm = new ArrayList<LineaMagazzino>();
            listaLm.add(lm);
            m.setLineaMagazzinos(listaLm);
            magazzinoFacade.create(m);
            lm.setMatPrima(mp);
            lineaMagazzinoFacade.create(lm);

            Prenotazione p = new Prenotazione();
            p.setZona("Milano");

            ConfigurazionePiatto piatto = new ConfigurazionePiatto();
            piatto.setId(Long.MIN_VALUE);
            piatto.setNome("pasta al sugo");
            
            


            gestoreLineaMagazzinoBean.checkQuantita(null);
   //         List<Magazzino> magazzini = mfl.findAll();
            //out.println("localitÃ :"+lineaMagazzinoFacade.findLocalitÃ ().get(0).toString());
           out.println("ciao");
           //List<LineaMagazzino> listaMagag = lineaMagazzinoFacade.findAll();
           //out.println(listaMagag.toString());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getQuantita());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getSogliaMinima());

           // out.println("localita:"+lineaMagazzinoFacade.findLocalitÃ ().get(0).getQuantita());

           /* for (Iterator it = magazzini.iterator(); it.hasNext();) {
                Magazzino ma = (Piatt) it.next();
                out.println("nome " + pi.getNome());
                out.println("costo " + pi.getCosto());
                out.println("categoria " + pi.getCategoria());
                out.println("lista materie modificabili " + (pi.getMaterieSottraibili()).get(0));
                out.println("lista materie non modificabili " + (pi.getMaterieNonModificabili()).get(0));
            }*/

            out.println("</body>");
            out.println("</html>");

        }catch(Exception e){}
        finally {
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
