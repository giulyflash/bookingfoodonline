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
          <h2 class="title"><a href="#">Da qui puoi creare il tuo evento facebook!</a></h2>
          <div class="entry">
            <p>Inserisci i dati e crea il tuo evento!</p>
            <form action="SaasServlet" method="POST">
                <table border="0">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <input type="hidden" name="op" value="event_info" />
                        <tr>
                            <td>nome:</td>
                            <td><input type="text" name="nome" value="" /></td>
                        </tr>
                        
                       
                        <tr>
                            <td>inizio:</td>
                            <td><input type="text" name="inizio:" value="" /></td>
                        </tr>
                        <tr>
                            <td>fine:</td>
                            <td><input type="text" name="fine" value="" /></td>
                        </tr>
                        
                        <tr>
                            <td>città:</td>
                            <td><input type="text" name="citta" value="" /></td>
                        </tr>
                        
                        <tr>
                            <td>privacy:</td>
                            <td><select name="privacy" size="1">
                                    <option>OPEN</option>
                                    <option>CLOSED</option>
                                    <option>SECRET</option>
                                </select></td>
                        </tr>

                       
                        <tr>
                            <td>descrizione:</td>
                            <td><textarea name="descrizione" rows="5" cols="20">
                                </textarea></td>
                        </tr>
                        <tr>
                            <td>invia:</td>
                            <td><input type="submit" value="send" /></td>
                        </tr>
                        <!--Indexable	Name	Type	Description
                            eid	int	 The ID of the event being queried.
                            name	string	 The name of the event being queried.
                            tagline	string	 The tagline or summary of the event being queried.
                            nid	int	 The network ID of the event being queried.
                            pic_small	string	 The URL to the small-sized profile picture for the user being queried. The image can have a maximum width of 50px and a maximum height of 150px. This URL may be blank.
                            pic_big	string	 The URL to the largest-sized profile picture for the user being queried. The image can have a maximum width of 200px and a maximum height of 600px. This URL may be blank.
                            pic	string	 The URL to the medium-sized profile picture for the user being queried. The image can have a maximum width of 100px and a maximum height of 300px. This URL may be blank.
                            host	string	 The name of the host of the event being queried.
                            description	string	 The description of the event being queried.
                            event_type	string	 The category of the event being queried. For a listing, see Event Categories.
                            event_subtype	string	 The event type for the event being queried. For a listing, see Event Categories.
                            start_time	time	 The starting date and time of the event being queried.
                            end_time	time	 The ending date and time of the event being queried.
                            creator	int	 The user ID of the creator of the event being queried.
                            update_time	time	 The time that the event being queried was last updated.
                            location	string	 The location of the event being queried.
                            venue	string	 The venue where the event being queried is being held.
                            privacy	string	 The privacy setting of the event being queried, indicating whether the event is OPEN, CLOSED, or SECRET.
                            hide_guest_list	bool	 Indicates whether to hide the guest list on the event's page, where true means to hide the guest list.
                        -->
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

