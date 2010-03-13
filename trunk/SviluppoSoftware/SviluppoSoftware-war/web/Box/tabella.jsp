

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="prova.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<table id="minimalista-righe">

    <thead>
        <tr>
            <th>Immagine</th>
            <th>Nome</th>
            <th>Prezzo</th>
        </tr>
    </thead>
    <tbody>
           <% List<Piatto> listaPiatti;
             if(request.getSession().getAttribute("lista") !=null){
               listaPiatti=(List<Piatto>)request.getSession().getAttribute("lista");
           %>
          <%for(Piatto p: listaPiatti){ %>
          <% String url = p.getUrl_immagine();
          %>
          <tr>
              <td><img src= <%=url%> alt="immagine" ></td>
            <td><%= p.getNome()%></td>
            <td><%= p.getCosto()%></td>

          </tr>
        <%}}%>
    </tbody>
</table>


