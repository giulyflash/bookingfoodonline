<%-- 
    Document   : Sidebar
    Created on : 9-mar-2010, 12.30.31
    Author     : Matteo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>BOOKING FOOD ONLINE</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="culinarycss.css" rel="stylesheet" type="text/css" />
</head>
    <body>

        <ul>
          <li id="search">
            <h2 class="search">Cerca piatto</h2>
            <form method="post" action="">
              <input type="text" id="search-text" name="s" value="" />
              <input type="submit" id="search-submit" value="Cerca" />
            </form>
            <a href="servletOperazioni">servlet</a>

          </li>
          <li>
            <h2 class="categories">Categorie</h2>
            <ul>
              <li><a href="servletOperazioni?categoria=primi">Primi</a></li>
              <li><a href="servletOperazioni?categoria=secondi">Secondi</a></li>
              <li><a href="servletOperazioni?categoria=contorni">Contorni</a></li>
              <li><a href="servletOperazioni?categoria=dessert">Dessert</a></li>
              <li><a href="servletOperazioni?categoria=bevande">Bevande</a></li>
              <li><a href="servletOperazioni?categoria=vini">Vini</a></li>
            </ul>
          </li>
          <li>
            <h2>Servizi</h2>
            <ul>
              <li><a href="servletOperazioni.java?servizio=facebook">Facebook</a></li>
              <li><a href="servletOperazioni.java?servizio=twitter">Twitter</a></li>
              <li><a href="servletOperazioni.java?servizio=organizza_evento">Organizza il tuo evento</a></li>
            </ul>
          </li>
          <li>
          <% /* inserimento form login */
                if (session.getAttribute("login") == null){
                 //System.out.println("ccc");
                    /*String op = session.getAttribute("op").toString();
                 da qui faccio tutti i vari controlli */ %>
                 <jsp:include page="/login.jsp" />
                 <%}%>
          </li>
        </ul>
    </body>
</html>
