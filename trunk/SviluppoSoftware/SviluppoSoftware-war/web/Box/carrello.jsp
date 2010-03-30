<%-- 
    Document   : carrello
    Created on : 22-mar-2010, 11.04.25
    Author     : Matteo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="prova.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>



  <jsp:include page="/Box/header.jsp"/>
  <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
            <%Prenotazione p = (Prenotazione)request.getSession().getAttribute("prenotazione");
              ArrayList<ConfigurazionePiatto> lcp = p.getListaPiatti();
              Double totale = p.getPrezzo();
            %>
        <table id="minimalista-righe">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Prezzo unitario</th>
                <th>Quantità</th>
                <th>Prezzo totale</th>
                <th></th>
            </tr>
    </thead>
    <tbody>
        <% int i=0;
        for(ConfigurazionePiatto cp:lcp){%>
        <tr>
            <td><%=cp.getNome()%></td>
            <td><%=cp.getCosto()%></td>

            <td><form method="POST" action="servletOperazioni">                    
                    <input type="text" name="quantita" value="<%=cp.getQnt()%>" size="10" maxlength="5"   />
                    <input type="submit"  name="operazione" value="aggiorna"/>
                    <input type="hidden"name="indice"value="<%=String.valueOf(i)%>"/>
                </form>
            </td>
            <td><%=cp.getCosto()*cp.getQnt()%></td>
            <td><form method="POST" action="servletOperazioni">
                <input type="submit"name="operazione" value="cancella"/>
                <input type="hidden"name="indice"value="<%=String.valueOf(i)%>"/></form></td>
        </tr>
        <%i++;
        }%>

    </tbody>
    <tbody><tr>
            <td align="center" colspan="4">Prezzo totale ordine</td>
        <td align="center"><b><%=p.getPrezzo()%></b></td>
        </tr>
    </tbody>
            
     </table>
        
          </div>
        </div>
        
        </div>
      
      <!-- end div#content -->
      
      <!-- end div#sidebar -->
      <div style="clear: both; height: 1px"></div>
  </div>
  </body>
</html>
