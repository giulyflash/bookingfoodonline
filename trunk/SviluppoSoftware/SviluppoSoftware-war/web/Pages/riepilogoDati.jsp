<%@page import="prova.*"%>
<jsp:include page="/Box/header.jsp"/>

    <div id="page">
    <div id="page-bgtop">
      <div id="content">
          <jsp:include page="/Pages/formRiepilogo.jsp" />
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