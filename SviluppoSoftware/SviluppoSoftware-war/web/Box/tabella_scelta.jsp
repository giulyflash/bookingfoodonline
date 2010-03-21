<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="prova.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>


<form name="selezione_piatto" action="servletOperazioni" method="POST">

<table id="minimalista-righe">

    <thead>
        <tr>
            <th>Aggiungi</th>
            <th>Sottrai</th>
            <th>Nome ingrediente</th>
        </tr>
    </thead>

    <tbody>
           <%   Piatto p= (Piatto)request.getSession().getAttribute("piatto_selezionato");                
           %>
           <%for(String m:p.getListaPossibiliAggiunte())
               {%>
    

          <tr>
              <td><input type="checkbox" name="<%=m%>" value="ON"/>
              <td><input type="checkbox" name="fake" value="OFF" disabled /></td>
              <td><%=m%></td>
          </tr>
          <%}%>
          <%for(String m:p.getMaterieSottraibili())
              {%>
          <tr>
              <td><input type="checkbox" name="fake2" value="OFF" disabled />
              <td><input type="checkbox" name="<%=m%>" value="OFF"/>
              <td><%=m%></td>
          </tr>
          <%}%>
    <input type="submit"  value="AccettaConfigurazione" name="operazione"  />
    </tbody>


</table>
</form>


