/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Long;
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

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import prova.*;





/**
 *
 * @author Matteo
 */@PermitAll
public class Servlet1 extends HttpServlet {
    @EJB
    private PiattoFacadeLocal piattoFacade;
    @EJB
    private FornitoreFacadeLocal fornitoreFacade;
    @EJB
    private FornitureFacadeLocal fornitureFacade;
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







    @Resource(mappedName = "jms/ConsumazioneOrdiniFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ConsumazioneOrdini")
    private Queue queue;

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
        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        //GESTIRE SESSIONE
        //GESTIRE SESSIONE*************************************************************************
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("lagoÃƒÂ²");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath () + "</h1>");

      

          /*  Piatto p = new Piatto();
            p.setId(Long.MIN_VALUE);
            p.setCategoria("secondi");
            p.setCosto(5.0);
            p.setNome("carne");
            p.setUrl_immagine("images/carne.jpg");
            ArrayList<String> l = new ArrayList<String>();
            l.add("pasta");
            p.setListaMaterieNonModificabili(l);
            p.setListaMaterieSottraibili(l);
            p.setListaPossibiliAggiunte(l);
            piattoFacade.create(p);

            Piatto p1 = new Piatto();
            p1.setId(Long.MIN_VALUE);
            p1.setCategoria("secondi");
            p1.setCosto(5.0);
            p1.setNome("focaccia");
            p1.setUrl_immagine("images/focaccia.jpg");
            ArrayList<String> l1 = new ArrayList<String>();
            l.add("farina");
            p1.setListaMaterieNonModificabili(l1);
            p1.setListaMaterieSottraibili(l1);
            p1.setListaPossibiliAggiunte(l1);
            piattoFacade.create(p1);

            Piatto p2 = new Piatto();
            p2.setId(Long.MIN_VALUE);
            p2.setCategoria("primi");
            p2.setCosto(5.0);
            p2.setNome("tagliatelle al sugo");
            p2.setUrl_immagine("images/pasta.jpg");
            ArrayList<String> l2 = new ArrayList<String>();
            l2.add("farina");
            p2.setListaMaterieNonModificabili(l2);
            p2.setListaMaterieSottraibili(l2);
            p2.setListaPossibiliAggiunte(l2);
            piattoFacade.create(p2);


            /*
            Piatto p1 = new Piatto();
            p1.setId(Long.MIN_VALUE);
            p1.setCategoria("rwr");
            p1.setCosto(40.0);
            p1.setNome("pasta alla carbonara");
            Piatto p2 = new Piatto();
            p2.setId(Long.MIN_VALUE);
            p2.setCategoria("rwr");
            p2.setCosto(40.0);
            p2.setNome("carne al sugo");

            Piatto p3 = new Piatto();
            p3.setId(Long.MIN_VALUE);
            p3.setCategoria("rwr");
            p3.setCosto(40.0);
            p3.setNome("carne al pesce");

            piattoFacade.create(p);
            piattoFacade.create(p1);
            piattoFacade.create(p2);
            piattoFacade.create(p3);

            List<Piatto> list = piattoFacade.findPiatto("pasta");
            out.println(list.get(0).getNome());
            out.println(list.get(1).getNome());
        */

            
/*

            
            Magazzino m = new Magazzino();

            m.setId(Long.MIN_VALUE);
            m.setLocalita("Milano");
            magazzinoFacade.create(m);

            MateriaPrima mp = new MateriaPrima();
            mp.setId(Long.MIN_VALUE);
            mp.setNome("carne");
            materiaPrimaFacade.create(mp);
            LineaMagazzino lm = new LineaMagazzino();
            lm.setId(Long.MIN_VALUE);
            lm.setN_rif(10);
            lm.setQuantita(300);
            lm.setSogliaMinima(350);
                List<LineaMagazzino> listaLm = new ArrayList<LineaMagazzino>();
            listaLm.add(lm);
            m.setLineaMagazzinos(listaLm);
            lm.setMatPrima(mp);
            lm.setMag(m);
            lineaMagazzinoFacade.create(lm);
            magazzinoFacade.edit(m);


            Fornitore forn = new Fornitore();
            forn.setId(Long.MIN_VALUE);
            forn.setIndirizzo("reer");
            forn.setLocalita("Milano");
            forn.setNome("carlo");
            forn.setTelefono("43433");
            fornitoreFacade.create(forn);

            Forniture f = new Forniture();
            f.setId(Long.MIN_VALUE);
            f.setForn(forn);
            f.setMatPrima(mp);
            fornitureFacade.create(f);






            ArrayList<String> listaMaterie = new ArrayList<String>();
            listaMaterie.add(mp.getNome());
            ConfigurazionePiatto piatto = new ConfigurazionePiatto();
            piatto.setId(Long.MIN_VALUE);
            piatto.setNome("pasta al sugo");
            piatto.setListaMaterieNonModificabili(listaMaterie);
            piatto.setAggiunte(new ArrayList<String>());
            piatto.setSottratte(new ArrayList<String>());

            Prenotazione p = new Prenotazione();
            p.setZona("Milano");
            ArrayList<ConfigurazionePiatto> conf = new ArrayList<ConfigurazionePiatto>();
            conf.add(piatto);
            p.setListaPiatti(conf);
      

            gestoreLineaMagazzinoBean.checkQuantita(p,out);
            
            /*List<LineaMagazzino> l = lineaMagazzinoFacade.findAll();
            LineaMagazzino lm1 = l.get(0);
            out.println(lm1.getMag().getId());
            out.println(lm1.getMatPrima().getId());
            lineaMagazzinoFacade.editLineaMagazzino(lm1.getMag().getId(), lm1.getMatPrima().getId(), lm1.getN_rif());
            */
            
          
            //out.println(p.getListaPiatti().get(0).materiePrime().toString());

   //         List<Magazzino> magazzini = mfl.findAll();
            //out.println("localitÃƒÂ :"+lineaMagazzinoFacade.findLocalitÃƒÂ ().get(0).toString());
           out.println("ciao");

 
           //Connection connection = connectionFactory.createConnection();
            //Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //MessageConsumer mc = session.createConsumer(queue);
           //List<LineaMagazzino> listaMagag = lineaMagazzinoFacade.findAll();
           //out.println(listaMagag.toString());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getQuantita());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getSogliaMinima());

           // out.println("localita:"+lineaMagazzinoFacade.findLocalitÃƒÂ ().get(0).getQuantita());

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
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
