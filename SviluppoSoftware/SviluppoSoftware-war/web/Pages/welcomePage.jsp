<%-- 
    Document   : welcomePage
    Created on : Mar 12, 2010, 5:38:48 PM
    Author     : dani1913
--%>

<jsp:include page="/Box/header.jsp"/>

    <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
          <h2 class="title"><a href="#">Benvenuto <%= session.getAttribute("login")%>,</a></h2>
          <div class="entry">
            <p>Sei nel nostro ristorante online!</p>
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
