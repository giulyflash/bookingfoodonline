<%--
    Document   : welcomePage
    Created on : Mar 12, 2010, 5:38:48 PM
    Author     : dani1913
--%>

<%@page import="prova.*"%>
<%@page import="java.util.*"%>
<jsp:include page="/Box/header.jsp"/>

    <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
          <h2 class="title"><a href="#">Prenotazione effettuata!</a></h2>
          <div class="entry">
            <p>Torna alla <a href="index.jsp">home</a></p>
            <% Prenotazione tmp=(Prenotazione)session.getAttribute("prenotazione");
                Collection<ConfigurazionePiatto> c = (tmp.getMappaPiatti()).values();

               for(ConfigurazionePiatto cp:c){
                    %>

                    <%=cp.getNome()%>

                    <%
               }


               session.setAttribute("prenotazione", null);
            %>
          </div>

        </div>

        </div>
      </div>
      <!-- end div#content -->
      <div id="sidebar">
        <jsp:include page="/Box/Sidebar.jsp" />
      </div>
      <!-- end div#sidebar -->
      <div style="clear: both; height: 1px"></div>
    </div>
  </div>  <!-- end div#page -->
</div>
<!-- end div#wrapper -->
</body>
</html>
