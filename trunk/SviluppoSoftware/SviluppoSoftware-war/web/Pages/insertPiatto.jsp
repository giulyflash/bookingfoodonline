<jsp:include page="/Box/header.jsp"/>
  <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <div class="post">
          <h2 class="title"><a href="#">Mello uomo del sud</a></h2>
          <div class="entry">
              <p>Questa è la pagina dell' amministratore.</p>
              Da qui puoi <a href="Pages/insertPiatto.jsp">inserire</a>, <a href="#">modificare</a> o <a href="#">cancellare</a> un piatto.
              <form name="insertForm" action="OperazioniAmministratore" method="POST">

                  <table border="0">
                      <input type="hidden" name="op" value="datiPiatto" />
                      <tbody>
                          <tr>
                              <td>Nome:</td>
                              <td><input type="text" name="nomepiatto" value="" /></td>
                          </tr>
                          <tr>
                              <td>Costo:</td>
                              <td><input type="text" name="costopiatto" value="" /></td>
                          </tr>
                          <tr>
                              <td>Categoria:</td>
                              <td><input type="text" name="categoriapiatto" value="" /></td>
                          </tr>
                          <tr>
                              <td>URL immagine:</td>
                              <td><input type="text" name="urlimmagine" value="" /></td>
                          </tr>
                          <tr>
                              <td>Materie non modificabili:</td>
                              <td><textarea name="listaNonModificabili" rows="4" cols="20">
                                  </textarea></td>
                          </tr>
                          <tr>
                              <td>Materie sottraibili:</td>
                              <td><textarea name="materieSottraibili" rows="4" cols="20">
                                  </textarea></td>
                          </tr>
                          <tr>
                              <td>Materie aggiungibili:</td>
                              <td><textarea name="materieAggiungibili" rows="4" cols="20">
                                  </textarea></td>
                          </tr>
                          <tr>
                              <td></td>
                              <td></td>
                          </tr>
                      </tbody>
                  </table>

                  <input type="submit" value="CreaPiatto" name="submitPiatto" />
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
