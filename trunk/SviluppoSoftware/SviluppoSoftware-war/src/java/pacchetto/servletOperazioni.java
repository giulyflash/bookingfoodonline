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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;





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
        String operazione = request.getParameter("operazione");
        


        //RICERCA CATEGORIA
        if(operazione.equals("ricercaPerCategoria")){
            String categoria = request.getParameter("categoria");
            if(categoria!=null)
                {List<Piatto> listaPiatti  = gestorePiattoBean.findPiattiPerCategoria(categoria);
                 s.setAttribute("lista",listaPiatti);
                 rd = sc.getRequestDispatcher("/CategoriePiatti/PiattiPerCategoria.jsp");
                 rd.forward(request,response);
                }
        }
          //GESTIONE PIATTO        
        if(operazione.equals("selezione_piatto"))
            {String id = request.getParameter("id");
             Long i = Long.valueOf(id);
             Piatto p = gestorePiattoBean.findPiatto(Long.valueOf(id));
             s.setAttribute("piatto_selezionato", p);
             rd = sc.getRequestDispatcher("/Box/configurazionePiatto.jsp");
             rd.forward(request,response);
            }
        //configurazione piatto accettata
        if(operazione.equals("Accetta"))
            {
                Piatto p= (Piatto)request.getSession().getAttribute("piatto_selezionato");
                ArrayList<String> materieSottraibili = p.getMaterieSottraibili();
                ArrayList<String> possibiliAggiunte = p.getListaPossibiliAggiunte();
                ArrayList<String> nonModificabili = p.getMaterieNonModificabili();
                ConfigurazionePiatto cp = new ConfigurazionePiatto();
                cp.setListaMaterieNonModificabili(nonModificabili);
                cp.setListaMaterieSottraibili(materieSottraibili);
                cp.setListaPossibiliAggiunte(possibiliAggiunte);
                cp.setCategoria(p.getCategoria());
                cp.setNome(p.getNome());
                cp.setUrl_immagine(p.getUrl_immagine());
                cp.setCosto(p.getCosto());
                
                

                Enumeration names = request.getParameterNames();
                List<String> aList = Collections.list(names);
                
                ArrayList<String> aggiunte = new ArrayList<String>();
                ArrayList<String> sottratte = new ArrayList<String>();
                aList.remove("operazione");
                
                for(String a : aList)
                    {String result = request.getParameter(a);
                     if(result.equals("ON"))
                        {aggiunte.add(a);
                        }
                     else
                         sottratte.add(a);
                     }

               cp.setAggiunte(aggiunte);
               cp.setSottratte(sottratte);
               cp.setCosto(cp.calcolaTotale());
               //request.getSession().setAttribute("piattoconfigurato", cp);
               Prenotazione pr = null;
               ArrayList<ConfigurazionePiatto> lcp = new ArrayList<ConfigurazionePiatto>();
               out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletOperazioni</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletOperazioni at " + request.getContextPath () + "</h1>");
               if(request.getSession().getAttribute("prenotazione")==null){
                    pr = new Prenotazione();
                    pr.setPrezzo(cp.getCosto());
                    lcp.add(cp);
                    pr.setListaPiatti(lcp);
                    request.getSession().setAttribute("prenotazione", pr);
                    
               }
               else{
                   pr= (Prenotazione)request.getSession().getAttribute("prenotazione");
                   lcp= pr.getListaPiatti();
                   pr.setPrezzo(pr.getPrezzo()+cp.getCosto());
                   lcp.add(cp);
                   request.getSession().setAttribute("prenotazione", pr);                   
               } 
               rd = sc.getRequestDispatcher("/Box/carrello.jsp");
               rd.forward(request,response);



            
            out.println("aList: " + aList.toString());
            out.println("aggiunte: " + aggiunte.toString());
            out.println("sottratte: " + sottratte.toString());

            out.println("PROVA");
            out.println("</body>");
            out.println("</html>");        

        }
        if(operazione.equals("aggiorna"))
         {String ind = (String)request.getParameter("indice");
          int quantita = Integer.parseInt(request.getParameter("quantita"));
          Prenotazione p = (Prenotazione)request.getSession().getAttribute("prenotazione");
          ArrayList<ConfigurazionePiatto> lcp = p.getListaPiatti();
          double prezzo = p.getPrezzo();
          ConfigurazionePiatto cp=lcp.get(Integer.parseInt(ind));
          prezzo = prezzo+(cp.getCosto()*quantita)-(cp.getCosto()*cp.getQnt());
          cp.setQnt(quantita);
          lcp.set(Integer.parseInt(ind), cp);
          p.setListaPiatti(lcp);
          p.setPrezzo(prezzo);
          request.getSession().setAttribute("prenotazione", p);
          rd = sc.getRequestDispatcher("/Box/carrello.jsp");
          rd.forward(request,response);
         }

        if(operazione.equals("cancella"))
         {String ind = (String)request.getParameter("indice");
          Prenotazione p = (Prenotazione)request.getSession().getAttribute("prenotazione");
          ArrayList<ConfigurazionePiatto> lcp = p.getListaPiatti();
          ConfigurazionePiatto cp= lcp.remove(Integer.parseInt(ind));
          p.setListaPiatti(lcp);
          double prezzo = p.getPrezzo();
          prezzo= prezzo-(cp.getCosto()*cp.getQnt());
          p.setPrezzo(prezzo);
          request.getSession().setAttribute("prenotazione", p);
          rd = sc.getRequestDispatcher("/Box/carrello.jsp");
          rd.forward(request,response);
        }
             
             /*out.println("<html>");
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
