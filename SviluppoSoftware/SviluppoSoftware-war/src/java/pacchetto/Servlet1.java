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

            ArrayList<String> nonMod = new ArrayList<String>();
            ArrayList<String> sott = new ArrayList<String>();
            ArrayList<String> possAgg = new ArrayList<String>();












            //INSERIMENTO PIATTI
            Piatto p = new Piatto();
            p.setId(Long.MIN_VALUE);
            p.setCategoria("Secondi");
            p.setCosto(5.0);
            p.setNome("carne al sugo");
            p.setUrl_immagine("images/polpette.jpg");

            nonMod.add("carne");
            nonMod.add("sugo");


            sott.add("sale");
            sott.add("olio");
            possAgg.add("pepe");
            possAgg.add("origano");
            p.setListaMaterieNonModificabili(nonMod);
            p.setListaMaterieSottraibili(sott);
            p.setListaPossibiliAggiunte(possAgg);
            piattoFacade.create(p);

            Piatto p1 = new Piatto();
            p1.setId(Long.MIN_VALUE+1);
            p1.setCategoria("Secondi");
            p1.setCosto(5.0);
            p1.setNome("focaccia");
            p1.setUrl_immagine("images/focaccia.jpg");
            nonMod.clear();
            nonMod.add("farina");
            nonMod.add("formaggio");
            sott.clear();
            sott.add("sale");
            sott.add("prosciutto");
            possAgg.clear();
            possAgg.add("sugo");

            p1.setListaMaterieNonModificabili(nonMod);
            p1.setListaMaterieSottraibili(sott);
            p1.setListaPossibiliAggiunte(possAgg);
            piattoFacade.create(p1);

            Piatto p2 = new Piatto();
            p2.setId(Long.MIN_VALUE+2);
            p2.setCategoria("Primi");
            p2.setCosto(5.0);
            p2.setNome("tagliatelle al sugo");
            p2.setUrl_immagine("images/pasta.jpg");
            nonMod.clear();
            nonMod.add("farina");
            nonMod.add("sugo");
            sott.clear();
            sott.add("sale");
            sott.add("uovo");
            possAgg.clear();
            possAgg.add("formaggio");
            possAgg.add("basilico");
            p2.setListaMaterieNonModificabili(nonMod);
            p2.setListaMaterieSottraibili(sott);
            p2.setListaPossibiliAggiunte(possAgg);
            piattoFacade.create(p2);









            //INSERIMENTO MAGAZZINI
            Magazzino m = new Magazzino();
            m.setId(Long.MIN_VALUE+3);
            m.setLocalita("Milano");
            magazzinoFacade.create(m);

            Magazzino m1 = new Magazzino();
            m1.setId(Long.MIN_VALUE+4);
            m1.setLocalita("Torino");
            magazzinoFacade.create(m1);


            //INSERIMENTO MATERIE PRIME
            MateriaPrima mp = new MateriaPrima();
            mp.setId(Long.MIN_VALUE+7);
            mp.setNome("carne");
            materiaPrimaFacade.create(mp);

            MateriaPrima mp1 = new MateriaPrima();
            mp1.setId(Long.MIN_VALUE+8);
            mp1.setNome("sugo");
            materiaPrimaFacade.create(mp1);

            MateriaPrima mp2 = new MateriaPrima();
            mp2.setId(Long.MIN_VALUE+9);
            mp2.setNome("sale");
            materiaPrimaFacade.create(mp2);

            MateriaPrima mp3 = new MateriaPrima();
            mp3.setId(Long.MIN_VALUE+10);
            mp3.setNome("olio");
            materiaPrimaFacade.create(mp3);

            MateriaPrima mp4 = new MateriaPrima();
            mp4.setId(Long.MIN_VALUE+11);
            mp4.setNome("pepe");
            materiaPrimaFacade.create(mp4);

            MateriaPrima mp5 = new MateriaPrima();
            mp5.setId(Long.MIN_VALUE+12);
            mp5.setNome("origano");
            materiaPrimaFacade.create(mp5);

            MateriaPrima mp6 = new MateriaPrima();
            mp6.setId(Long.MIN_VALUE+13);
            mp6.setNome("farina");
            materiaPrimaFacade.create(mp6);

            MateriaPrima mp7 = new MateriaPrima();
            mp7.setId(Long.MIN_VALUE+14);
            mp7.setNome("formaggio");
            materiaPrimaFacade.create(mp7);

            MateriaPrima mp8 = new MateriaPrima();
            mp8.setId(Long.MIN_VALUE+15);
            mp8.setNome("prosciutto");
            materiaPrimaFacade.create(mp8);

            MateriaPrima mp9 = new MateriaPrima();
            mp9.setId(Long.MIN_VALUE+16);
            mp9.setNome("uovo");
            materiaPrimaFacade.create(mp9);

            MateriaPrima mp10 = new MateriaPrima();
            mp10.setId(Long.MIN_VALUE+17);
            mp10.setNome("basilico");
            materiaPrimaFacade.create(mp10);

            List<LineaMagazzino> listaLm = new ArrayList<LineaMagazzino>();


            //INSERIMENTO LINEEMAGAZZINO
            LineaMagazzino lm = new LineaMagazzino();
            lm.setId(Long.MIN_VALUE+18);
            lm.setN_rif(50);
            lm.setQuantita(300);
            lm.setSogliaMinima(350);
            lm.setMatPrima(mp);
            lm.setMag(m);
            listaLm.add(lm);
            lineaMagazzinoFacade.create(lm);




            LineaMagazzino lm1 = new LineaMagazzino();
            lm1.setId(Long.MIN_VALUE+19);
            lm1.setN_rif(70);
            lm1.setQuantita(500);
            lm1.setSogliaMinima(150);
            lm1.setMatPrima(mp1);
            lm1.setMag(m);
            listaLm.add(lm1);
            lineaMagazzinoFacade.create(lm1);



            LineaMagazzino lm2 = new LineaMagazzino();
            lm2.setId(Long.MIN_VALUE+20);
            lm2.setN_rif(90);
            lm2.setQuantita(290);
            lm2.setSogliaMinima(150);
            lm2.setMatPrima(mp2);
            lm2.setMag(m);
            listaLm.add(lm2);
            lineaMagazzinoFacade.create(lm2);

            LineaMagazzino lm3 = new LineaMagazzino();
            lm3.setId(Long.MIN_VALUE+21);
            lm3.setN_rif(60);
            lm3.setQuantita(260);
            lm3.setSogliaMinima(150);
            lm3.setMatPrima(mp3);
            lm3.setMag(m);
            listaLm.add(lm3);
            lineaMagazzinoFacade.create(lm3);

            LineaMagazzino lm4 = new LineaMagazzino();
            lm4.setId(Long.MIN_VALUE+22);
            lm4.setN_rif(30);
            lm4.setQuantita(200);
            lm4.setSogliaMinima(270);
            lm4.setMatPrima(mp4);
            lm4.setMag(m);
            listaLm.add(lm4);
            lineaMagazzinoFacade.create(lm4);

            LineaMagazzino lm5 = new LineaMagazzino();
            lm5.setId(Long.MIN_VALUE+23);
            lm5.setN_rif(15);
            lm5.setQuantita(100);
            lm5.setSogliaMinima(80);
            lm5.setMatPrima(mp5);
            lm5.setMag(m);
            listaLm.add(lm5);
            lineaMagazzinoFacade.create(lm5);

            LineaMagazzino lm6 = new LineaMagazzino();
            lm6.setId(Long.MIN_VALUE+24);
            lm6.setN_rif(10);
            lm6.setQuantita(200);
            lm6.setSogliaMinima(170);
            lm6.setMatPrima(mp6);
            lm6.setMag(m);
            listaLm.add(lm6);
            lineaMagazzinoFacade.create(lm6);

            LineaMagazzino lm7 = new LineaMagazzino();
            lm7.setId(Long.MIN_VALUE+25);
            lm7.setN_rif(20);
            lm7.setQuantita(200);
            lm7.setSogliaMinima(180);
            lm7.setMatPrima(mp7);
            lm7.setMag(m);
            listaLm.add(lm7);
            lineaMagazzinoFacade.create(lm7);

            LineaMagazzino lm8 = new LineaMagazzino();
            lm8.setId(Long.MIN_VALUE+26);
            lm8.setN_rif(10);
            lm8.setQuantita(360);
            lm8.setSogliaMinima(350);
            lm8.setMatPrima(mp8);
            lm8.setMag(m);
            listaLm.add(lm8);
            lineaMagazzinoFacade.create(lm8);

            LineaMagazzino lm9 = new LineaMagazzino();
            lm9.setId(Long.MIN_VALUE+27);
            lm9.setN_rif(10);
            lm9.setQuantita(360);
            lm9.setSogliaMinima(350);
            lm9.setMatPrima(mp9);
            lm9.setMag(m);
            listaLm.add(lm9);
            lineaMagazzinoFacade.create(lm9);

            LineaMagazzino lm10 = new LineaMagazzino();
            lm10.setId(Long.MIN_VALUE+28);
            lm10.setN_rif(10);
            lm10.setQuantita(360);
            lm10.setSogliaMinima(350);
            lm10.setMatPrima(mp10);
            lm10.setMag(m);
            listaLm.add(lm10);
            lineaMagazzinoFacade.create(lm10);

            LineaMagazzino lm11 = new LineaMagazzino();
            lm11.setId(Long.MIN_VALUE+60);
            lm11.setN_rif(40);
            lm11.setQuantita(400);
            lm11.setSogliaMinima(450);
            lm11.setMatPrima(mp);
            lm11.setMag(m1);
            listaLm.add(lm11);
            lineaMagazzinoFacade.create(lm11);




            LineaMagazzino lm12 = new LineaMagazzino();
            lm12.setId(Long.MIN_VALUE+61);
            lm12.setN_rif(80);
            lm12.setQuantita(450);
            lm12.setSogliaMinima(150);
            lm12.setMatPrima(mp1);
            lm12.setMag(m1);
            listaLm.add(lm12);
            lineaMagazzinoFacade.create(lm12);



            LineaMagazzino lm13 = new LineaMagazzino();
            lm13.setId(Long.MIN_VALUE+62);
            lm13.setN_rif(80);
            lm13.setQuantita(260);
            lm13.setSogliaMinima(190);
            lm13.setMatPrima(mp2);
            lm13.setMag(m1);
            listaLm.add(lm13);
            lineaMagazzinoFacade.create(lm13);

            LineaMagazzino lm14 = new LineaMagazzino();
            lm14.setId(Long.MIN_VALUE+63);
            lm14.setN_rif(80);
            lm14.setQuantita(165);
            lm14.setSogliaMinima(150);
            lm14.setMatPrima(mp3);
            lm14.setMag(m1);
            listaLm.add(lm14);
            lineaMagazzinoFacade.create(lm14);

            LineaMagazzino lm15 = new LineaMagazzino();
            lm15.setId(Long.MIN_VALUE+64);
            lm15.setN_rif(35);
            lm15.setQuantita(300);
            lm15.setSogliaMinima(390);
            lm15.setMatPrima(mp4);
            lm15.setMag(m1);
            listaLm.add(lm15);
            lineaMagazzinoFacade.create(lm15);

            LineaMagazzino lm16 = new LineaMagazzino();
            lm16.setId(Long.MIN_VALUE+65);
            lm16.setN_rif(15);
            lm16.setQuantita(100);
            lm16.setSogliaMinima(80);
            lm16.setMatPrima(mp5);
            lm16.setMag(m1);
            listaLm.add(lm16);
            lineaMagazzinoFacade.create(lm16);

            LineaMagazzino lm17 = new LineaMagazzino();
            lm17.setId(Long.MIN_VALUE+66);
            lm17.setN_rif(10);
            lm17.setQuantita(200);
            lm17.setSogliaMinima(170);
            lm17.setMatPrima(mp6);
            lm17.setMag(m1);
            listaLm.add(lm17);
            lineaMagazzinoFacade.create(lm17);

            LineaMagazzino lm18 = new LineaMagazzino();
            lm18.setId(Long.MIN_VALUE+67);
            lm18.setN_rif(20);
            lm18.setQuantita(200);
            lm18.setSogliaMinima(180);
            lm18.setMatPrima(mp7);
            lm18.setMag(m1);
            listaLm.add(lm18);
            lineaMagazzinoFacade.create(lm18);

            LineaMagazzino lm19 = new LineaMagazzino();
            lm19.setId(Long.MIN_VALUE+68);
            lm19.setN_rif(10);
            lm19.setQuantita(360);
            lm19.setSogliaMinima(350);
            lm19.setMatPrima(mp8);
            lm19.setMag(m1);
            listaLm.add(lm19);
            lineaMagazzinoFacade.create(lm19);

            LineaMagazzino lm20 = new LineaMagazzino();
            lm20.setId(Long.MIN_VALUE+69);
            lm20.setN_rif(10);
            lm20.setQuantita(360);
            lm20.setSogliaMinima(350);
            lm20.setMatPrima(mp9);
            lm20.setMag(m1);
            listaLm.add(lm20);
            lineaMagazzinoFacade.create(lm20);

            LineaMagazzino lm21 = new LineaMagazzino();
            lm21.setId(Long.MIN_VALUE+70);
            lm21.setN_rif(10);
            lm21.setQuantita(360);
            lm21.setSogliaMinima(350);
            lm21.setMatPrima(mp10);
            lm21.setMag(m1);
            listaLm.add(lm21);
            lineaMagazzinoFacade.create(lm21);



            m.setLineaMagazzinos(listaLm);
            magazzinoFacade.edit(m);


            //INSERIMENTO FORNITORI
            Fornitore forn = new Fornitore();
            forn.setId(Long.MIN_VALUE+29);
            forn.setIndirizzo("via lisbona");
            forn.setLocalita("Milano");
            forn.setNome("carlo");
            forn.setTelefono("43433");
            fornitoreFacade.create(forn);

            Fornitore forn1 = new Fornitore();
            forn1.setId(Long.MIN_VALUE+50);
            forn1.setIndirizzo("via degli angeli");
            forn1.setLocalita("Torino");
            forn1.setNome("alessandro");
            forn1.setTelefono("43433");
            fornitoreFacade.create(forn1);

            //INSERIMENTO FORNITURE
            Forniture f = new Forniture();
            f.setId(Long.MIN_VALUE+30);
            f.setForn(forn);
            f.setMatPrima(mp);
            fornitureFacade.create(f);

            Forniture f1 = new Forniture();
            f1.setId(Long.MIN_VALUE+31);
            f1.setForn(forn);
            f1.setMatPrima(mp1);
            fornitureFacade.create(f1);


            Forniture f2 = new Forniture();
            f2.setId(Long.MIN_VALUE+32);
            f2.setForn(forn);
            f2.setMatPrima(mp2);
            fornitureFacade.create(f2);


            Forniture f3 = new Forniture();
            f3.setId(Long.MIN_VALUE+33);
            f3.setForn(forn);
            f3.setMatPrima(mp3);
            fornitureFacade.create(f3);

            Forniture f4 = new Forniture();
            f4.setId(Long.MIN_VALUE+34);
            f4.setForn(forn);
            f4.setMatPrima(mp4);
            fornitureFacade.create(f4);


            Forniture f5 = new Forniture();
            f5.setId(Long.MIN_VALUE+35);
            f5.setForn(forn);
            f5.setMatPrima(mp5);
            fornitureFacade.create(f5);

            Forniture f6 = new Forniture();
            f6.setId(Long.MIN_VALUE+36);
            f6.setForn(forn);
            f6.setMatPrima(mp6);
            fornitureFacade.create(f6);

            Forniture f7 = new Forniture();
            f7.setId(Long.MIN_VALUE+37);
            f7.setForn(forn);
            f7.setMatPrima(mp7);
            fornitureFacade.create(f7);

            Forniture f8 = new Forniture();
            f8.setId(Long.MIN_VALUE+38);
            f8.setForn(forn);
            f8.setMatPrima(mp8);
            fornitureFacade.create(f8);

            Forniture f9 = new Forniture();
            f9.setId(Long.MIN_VALUE+39);
            f9.setForn(forn);
            f9.setMatPrima(mp9);
            fornitureFacade.create(f9);

            Forniture f10 = new Forniture();
            f10.setId(Long.MIN_VALUE+40);
            f10.setForn(forn);
            f10.setMatPrima(mp10);
            fornitureFacade.create(f10);

            Forniture f11 = new Forniture();
            f11.setId(Long.MIN_VALUE+80);
            f11.setForn(forn1);
            f11.setMatPrima(mp);
            fornitureFacade.create(f11);

            Forniture f12 = new Forniture();
            f12.setId(Long.MIN_VALUE+81);
            f12.setForn(forn1);
            f12.setMatPrima(mp1);
            fornitureFacade.create(f12);


            Forniture f13 = new Forniture();
            f13.setId(Long.MIN_VALUE+82);
            f13.setForn(forn1);
            f13.setMatPrima(mp2);
            fornitureFacade.create(f13);


            Forniture f14 = new Forniture();
            f14.setId(Long.MIN_VALUE+83);
            f14.setForn(forn1);
            f14.setMatPrima(mp3);
            fornitureFacade.create(f14);

            Forniture f15 = new Forniture();
            f15.setId(Long.MIN_VALUE+84);
            f15.setForn(forn1);
            f15.setMatPrima(mp4);
            fornitureFacade.create(f15);


            Forniture f16 = new Forniture();
            f16.setId(Long.MIN_VALUE+85);
            f16.setForn(forn1);
            f16.setMatPrima(mp5);
            fornitureFacade.create(f16);

            Forniture f17 = new Forniture();
            f17.setId(Long.MIN_VALUE+86);
            f17.setForn(forn1);
            f17.setMatPrima(mp6);
            fornitureFacade.create(f17);

            Forniture f18 = new Forniture();
            f18.setId(Long.MIN_VALUE+87);
            f18.setForn(forn1);
            f18.setMatPrima(mp7);
            fornitureFacade.create(f18);

            Forniture f19 = new Forniture();
            f19.setId(Long.MIN_VALUE+88);
            f19.setForn(forn1);
            f19.setMatPrima(mp8);
            fornitureFacade.create(f19);

            Forniture f20 = new Forniture();
            f20.setId(Long.MIN_VALUE+89);
            f20.setForn(forn1);
            f20.setMatPrima(mp9);
            fornitureFacade.create(f20);

            Forniture f21 = new Forniture();
            f21.setId(Long.MIN_VALUE+90);
            f21.setForn(forn1);
            f21.setMatPrima(mp10);
            fornitureFacade.create(f21);






            //LineaMagazzino lm = (LineaMagazzino)lineaMagazzinoFacade.findCheckMateria("farina", "Milano").get(0);
            //lm.setQuantita(12);
            //lineaMagazzinoFacade.edit(lm);

/*



            ArrayList<String> listaMaterie = new ArrayList<String>();
            listaMaterie.add(mp.getNome());
            ConfigurazionePiatto piatto = new ConfigurazionePiatto();
            piatto.setId(Long.MIN_VALUE);
            piatto.setNome("pasta al sugo");
            piatto.setListaMaterieNonModificabili(listaMaterie);
            piatto.setAggiunte(new ArrayList<String>());
            piatto.setSottratte(new ArrayList<String>());
x
            Prenotazione p = new Prenotazione();
            p.setZona("Milano");
            ArrayList<ConfigurazionePiatto> conf = new ArrayList<ConfigurazionePiatto>();
            conf.add(piatto);
            p.setListaPiatti(conf);


            gestoreLineaMagazzinoBean.checkQuantita(p,out);

            /*List<LineaMagazzino> l = lineaMagazzinoFacade.findAll();
            LineaMagazzino lm = l.get(0);
            out.println(lm.getMag().getId());
            out.println(lm.getMatPrima().getId());
            lineaMagazzinoFacade.editLineaMagazzino(lm.getMag().getId(), lm.getMatPrima().getId(), lm.getN_rif());
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

          //  out.println(materiaPrimaFacade.findAll().get(0).getId());







           //List<LineaMagazzino> lista= lineaMagazzinoFacade.findAll();
           //LineaMagazzino linea = lista.get(0);
           //linea.setQuantita(linea.getQuantita() + linea.getN_rif());
           //lineaMagazzinoFacade.edit(linea);
           //lineaMagazzinoFacade.editLineaMagazzino(linea.getMag().getId(),linea.getMatPrima().getId(),1777);

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
