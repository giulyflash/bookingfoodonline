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
             HashMap<Integer,ConfigurazionePiatto> hm = p.getMappaPiatti();
             double totale = p.getPrezzo();
              Set<Integer> set= hm.keySet();
              Integer[] key =set.toArray(new Integer[hm.size()]);
              ConfigurazionePiatto[] lcp = (hm.values()).toArray(new ConfigurazionePiatto[hm.size()]);
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
        <% 
        for(int i=0;i<hm.size();i++){%>
        <tr>
            <td><%=lcp[i].getNome()%></td>
            <td><%=lcp[i].getCosto()%></td>

            <td><form method="POST" action="servletOperazioni">                    
                    <input type="text" name="quantita" value="<%=lcp[i].getQnt()%>" size="10" maxlength="5"   />
                    <input type="submit"  name="operazione" value="aggiorna"/>
                    <input type="hidden"name="indice"value="<%=String.valueOf(key[i])%>"/>
                </form>
            </td>
            <td><%=Math.floor(lcp[i].getCosto()*lcp[i].getQnt() * 100.0) / 100.0%></td>
            <td><form method="POST" action="servletOperazioni">
                <input type="submit"name="operazione" value="cancella"/>
                <input type="hidden"name="indice"value="<%=String.valueOf(key[i])%>"/></form></td>
        </tr>
        <%}%>

    </tbody>
    <tbody><tr>
            <td align="center" colspan="4">Prezzo totale ordine</td>
        <td align="center"><b><%=totale%></b></td>
        </tr>
    </tbody>
            
     </table>

              <a href="index.jsp">Continua lo shopping</a>
              <a href="LoginServlet?op=registrazione2" ><img src="images/button_prosegui.gif" ></a>
          </div>
        </div>
        
        </div>
      
      <!-- end div#content -->
      
      <!-- end div#sidebar -->
      <div style="clear: both; height: 1px"></div>
  </div>
  </body>
</html>
