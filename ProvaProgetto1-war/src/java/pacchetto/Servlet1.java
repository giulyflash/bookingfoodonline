/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacchetto;

import Prova.*;
import Prova.ConfigurazionePiatto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Connection;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 *
 * @author Matteo
 */
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        //GESTIRE SESSIONE
        //GESTIRE SESSIONE*************************************************************************
        try {
            /*Magazzino m = new Magazzino();
            Magazzino m2 = new Magazzino();
            m.setLocalita("Milano");
            m.setId(Long.MIN_VALUE);
            MagazzinoFacadeLocal mfl = new MagazzinoFacade();
            magazzinoFacade.create(m);
            m2.setId(Long.MIN_VALUE);
            m2.setLocalita("Torino");
            magazzinoFacade.create(m2);
            MateriaPrima mp = new MateriaPrima();
            mp.setId(Long.MIN_VALUE);
            mp.setNome("pepe");
            //MateriaPrimaFacadeLocal mpfl = new MateriaPrimaFacade();
            materiaPrimaFacade.create(mp);
            LineaMagazzino lm = new LineaMagazzino();
            lm.setId(Long.MIN_VALUE);
            lm.setMag(m);
            lm.setMatPrima(mp);
            lm.setN_rif("150");
            lm.setQuantita(300);
            lm.setSogliaMinima("50");*/
            //List<LineaMagazzino> listLm= lineaMagazzinoFacade.findAll();
            //listLm.get(0).setQuantita(30);
            //lineaMagazzinoFacade.edit(listLm.get(0));
            MateriaPrima mp = new MateriaPrima();
            mp.setNome("pepe");
            ConfigurazionePiatto cp= new ConfigurazionePiatto();
            cp.addMateriaNonModificabile(mp);
            Prenotazione p = new Prenotazione();
            ArrayList<ConfigurazionePiatto> array = new ArrayList<ConfigurazionePiatto>();
            array.add(cp);
            p.setZona("Milano");
            p.setListaPiatti(array);
            //gestoreLineaMagazzinoBean.checkQuantità(p);
              /*try {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //MessageProducer messageProducer = session.createProducer(queue);
        //MessageConsumer messageConsumer = session.createConsumer(queue);
        //ObjectMessage message = session.createObjectMessage();
        // here we create NewsEntity, that will be sent in JMS message

        //messageConsumer.receive();
        //message.setObject("salve giovani");
        //messageProducer.send(message);
        //messageConsumer.close();
        connection.close();


    } catch (JMSException ex) {
        ex.printStackTrace();
    }*/


        


             /*
        Piatto p= new Piatto();
        MateriaPrima mp = new MateriaPrima();
        mp.setNome("pepe");
        mp.setId(Long.MIN_VALUE);
        p.setNome("polpette");
        p.setCosto(30.30);
        p.setCategoria("secondi");
        p.setId(Long.MIN_VALUE);
        p.addMateriaSottraibile(mp);
        MateriaPrima mp2 = new MateriaPrima();
        mp2.setNome("sale");
        mp2.setId(Long.MIN_VALUE);
        p.addMateriaNonModificabile(mp2);
        gpb.addPiatto(p);*/
            /*if(request.getAttribute("Prenota Subito")!=null){
                Piatto p = (Piatto)request.getAttribute("Prenota Subito");
                int qnt = Integer.parseInt(request.getParameter("quantita"));
               // HttpSession s = request.getSession();
                //if(s.isNew()) s.setAttribute("tipo","ospite");*/
                //rd = sc.getRequestDispatcher("/primi.jsp");//redirige dopo la prima riga
                //rd.forward(request,response);
            /*}else{  rd = sc.getRequestDispatcher("/index.jsp");//redirige dopo la prima riga
                    rd.forward(request,response);*/

           // }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("lagoò");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath () + "</h1>");
   //         List<Magazzino> magazzini = mfl.findAll();
            //out.println("località:"+lineaMagazzinoFacade.findLocalità().get(0).toString());
           out.println("ciao");
           //List<LineaMagazzino> listaMagag = lineaMagazzinoFacade.findAll();
           //out.println(listaMagag.toString());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getQuantita());
           //out.println("quantita:"+lineaMagazzinoFacade.findCheckMateria("pepe","Milano" ).get(0).getSogliaMinima());

           // out.println("localita:"+lineaMagazzinoFacade.findLocalità().get(0).getQuantita());
            
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
