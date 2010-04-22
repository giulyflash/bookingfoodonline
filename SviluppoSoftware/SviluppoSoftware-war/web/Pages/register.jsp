<jsp:include page="/Box/header.jsp"/>
        
    <div id="page">
    <div id="page-bgtop">
      <div id="content">
          <div class="post">
          <h2 class="title"><a href="#">Benvenuto nel form di registrazione:</a></h2>
          <div class="entry">
            <form name="formReg" action="LoginServlet" method="POST">
                <table>
                    <input type="hidden" name="op" value="datiRegistrazione" />
                    <tbody>
                        <tr>
                            <td>username:</td>
                            <td><input type="text" name="username" value="" /></td>

                        <tr>
                        <tr>
                            <td>password:</td>
                            <td><input type="password" name="password" value="" /></td>

                        <tr>
                            <td>nome:</td>
                            <td><input type="text" name="nome" value="" /></td>
                        </tr>
                        <tr>
                            <td>cognome:</td>
                            <td><input type="text" name="cognome" value="" /></td>
                        </tr>
                        <tr>
                            <td>mail:</td>
                            <td><input type="text" name="mail" value="" /></td>
                        </tr>
                        <tr>
                            <td>indirizzo:</td>
                            <td><input type="text" name="indirizzo" value="" /></td>
                        </tr>
                        <tr>
                            <td>carta_credito:</td>
                            <td><input type="text" name="n_cartacredito" value="" /></td>
                        </tr>
                        <tr>
                            <td>Invia:</td>
                            <td><input type="submit" value="Invia" name="Register" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
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