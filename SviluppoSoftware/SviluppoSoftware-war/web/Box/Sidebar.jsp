        <ul>
          <li id="search">
            <h2 class="search">Cerca piatto</h2>
            <form name="ricerca_piatto" action="servletOperazioni" method="POST">
              <input type="text" id="search-text" name="nomePiatto" value="" />
              <input type="submit" name="operazione" value="Cerca"id="search-submit"  />
            </form>
          </li>
          <li>
          <% /* inserimento form login */
                if (session.getAttribute("login") == null){
                 //System.out.println("ccc");
                    /*String op = session.getAttribute("op").toString();
                 da qui faccio tutti i vari controlli */ %>
                 <jsp:include page="/Box/login.jsp" />
                 <%}%>
          </li>
          
          <li>
            <h2 class="categories">Categorie</h2>
            <ul>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Primi">Primi</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Secondi">Secondi</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Contorni">Contorni</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Dessert">Dessert</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Bevande">Bevande</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=Vini">Vini</a></li>
            </ul>
          </li>
 
          <li>
            <h2>Servizi</h2>
            <ul>
              <li><a href="servletOperazioni?servizio=Facebook">Facebook</a></li>
              <li><a href="servletOperazioni?servizio=Twitter">Twitter</a></li>
              <li><a href="servletOperazioni?servizio=Organizza_evento">Organizza il tuo evento</a></li>
              <li><a href="Servlet1">Servlet1</a></li>
            </ul>
          </li>
          

          <% /* inserimento link ai servizi */
                if (session.getAttribute("login") != null){ %>
                 
                 
                 
                      <li>
                        <h2>Servizi</h2>
                        <ul>
                          <li><a href="SaasServlet?op=facebook">Facebook</a></li>
                          <li><a href="#">Twitter</a></li>
                          <li><a href="#">Organizza il tuo evento</a></li>
                        </ul>
                      </li>
          <%}%>

        </ul>
    
