<jsp:include page="/Box/header.jsp"/>
  <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
          <h2 class="title"><a href="#">Mello uomo del sud</a></h2>
          <div class="entry">
              <p>Questa � la pagina dell' amministratore.</p>
              Da qui puoi <a href="OperazioniAmministratore?op=insertPiatto">inserire</a>, <a href="#">modificare</a> o <a href="#">cancellare</a> un piatto.
              <jsp:include page="/Pages/facebook.jsp" />
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
