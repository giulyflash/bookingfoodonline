<%-- 
    Document   : primi
    Created on : 25-gen-2010, 10.15.36
    Author     : Matteo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Prova.*" import="java.util.*" import="javax.ejb.EJB"%>
        "
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRIMI</h1>
        <%
        
        GestorePiattoBeanLocal gp = new GestorePiattoBean();

        List<Piatto> primi = gp.findPiatti();


        for (Iterator it = primi.iterator(); it.hasNext();) {
                Piatto p = (Piatto) it.next();
                out.println("nome " + p.getNome());
                out.println("costo " + p.getCosto());
                out.println("categoria " + p.getCategoria());
                out.println("lista materie modificabili " + (p.getMaterieModificabili()).get(0));
                out.println("lista materie non modificabili " + (p.getMaterieNonModificabili()).get(0));
        }%>

    </body>
</html>
