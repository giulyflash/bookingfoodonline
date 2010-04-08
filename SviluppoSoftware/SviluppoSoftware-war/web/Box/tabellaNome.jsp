
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
            <th></th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>Prezzo</th>

        </tr>
    </thead>
    <tbody>
           <% List<Piatto> listaPiatti;
             if(request.getSession().getAttribute("lista") !=null){
               listaPiatti=(List<Piatto>)request.getSession().getAttribute("lista");
           %>
          <%for(int i=0;i<listaPiatti.size();i++){ %>
          <% String url = listaPiatti.get(i).getUrl_immagine();
          Long id = listaPiatti.get(i).getId();
          String a= String.valueOf(id);
          %>
          <tr>

              <td><a href="servletOperazioni?operazione=selezione_piatto&id=<%=listaPiatti.get(i).getId().toString()%>">
                      <img src= <%=url%> alt="immagine" ></a></td>
                      <td><a href="servletOperazioni?operazione=selezione_piatto&id=<%=listaPiatti.get(i).getId().toString()%>">
                      <%=listaPiatti.get(i).getNome()%></a></td>
                      <td><%=listaPiatti.get(i).getCategoria()%></td>
              <td><%= listaPiatti.get(i).getCosto()%></td>
          </tr>
        <%}}%>
    </tbody>
</table>


