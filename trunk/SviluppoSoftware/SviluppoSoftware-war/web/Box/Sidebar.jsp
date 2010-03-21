        <ul>
          <li id="search">
            <h2 class="search">Cerca piatto</h2>
            <form method="post" action="">
              <input type="text" id="search-text" name="s" value="" />
              <input type="submit" id="search-submit" value="Cerca" />
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
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=primi">Primi</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=secondi">Secondi</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=contorni">Contorni</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=dessert">Dessert</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=bevande">Bevande</a></li>
              <li><a href="servletOperazioni?operazione=ricercaPerCategoria&categoria=vini">Vini</a></li>
            </ul>
          </li>
          <li>
            <h2>Servizi</h2>
            <ul>
              <li><a href="servletOperazioni?servizio=facebook">Facebook</a></li>
              <li><a href="servletOperazioni?servizio=twitter">Twitter</a></li>
              <li><a href="servletOperazioni?servizio=organizza_evento">Organizza il tuo evento</a></li>
              <li><a href="Servlet1">Servlet1</a></li>
            </ul>
          </li>
          
        </ul>
    
