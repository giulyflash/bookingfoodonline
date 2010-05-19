<%--
    Document   : index
    Created on : 3-mar-2010, 11.21.55
    Author     : dani1913
--%>

  <jsp:include page="/Box/header.jsp"/>
  <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
          <h2 class="title"><a href="#">Benvenuti nel nostro ristorante online</a></h2>
          <div class="entry">
              <img src="images/piatti_tipici.jpg"/>

              <h4>Il nostro sito nato dalla collaborazione di tre amici nasce per offrire un servizio di catering online mediante il quale l'utente puÚ prenotare i piatti desiderati. L'utente inoltre ha la possibilit? di personalizzare i piatti scelti aggiungendo o togliendo alcuni ingredienti. Il sito guider? l'utente in ogni suo aspetto fino al completamento dell'acquisto. Per iniziare la prenotazione l'utente puÚ ricercare i suoi piatti per categoria o per nome utilizzando i collegamenti appositi situati sulla barra laterale. Inoltre offriamo la possibilit? all'utente loggato di organizzare il suo evento utilizzando la piattaforma di social network Facebook.</h4>

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
<!--RPX Code-->
<script type="text/javascript">
  var rpxJsHost = (("https:" == document.location.protocol) ? "https://" : "http://static.");
  document.write(unescape("%3Cscript src='" + rpxJsHost +
"rpxnow.com/js/lib/rpx.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
  RPXNOW.overlay = true;
  RPXNOW.language_preference = 'en';
</script>
</body>
</html>
