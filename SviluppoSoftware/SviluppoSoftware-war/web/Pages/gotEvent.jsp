
<%@ page import="org.netbeans.saas.*, org.netbeans.saas.facebook.*, java.util.Calendar" %>
<jsp:include page="/Box/header.jsp"/>

<div id="page">
    <div id="page-bgtop">
        <div id="content">
            <div class="post">
                <h2 class="title"><a href="#">Il tuo evento è stato creato.</a></h2>
                <div class="entry">
                    <p>Torna alla <a href="index.jsp"> home.</a></p>

                    

                    <%
                                // {"name":"name","host":"host","start_time":1215929160,"end_time":1215929160}
                                 

                               try {

                                    String eventInfo = (String)session.getAttribute("event_info");
                                    String format = null;
                                    String callback = null;

                                    RestResponse result = FacebookSocialNetworkingService.eventsCreate(request, response, eventInfo, format, callback);
                                    if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse) {
                                        facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsCreateResponse.class);
                                    } else if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.ErrorResponse) {
                                        facebook.socialnetworkingservice.facebookresponse.ErrorResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class);
                                    }
                                    //TODO - Uncomment the print Statement below to print result.
                                    out.println("The SaasService returned: " + result.getDataAsString()+"\n");
                                    //recupero l'evento
                                    String format1 = null;
                                    String uid = "1354154534";
                                    String eids = null;
                                    String startTime = null;
                                    String endTime = null;
                                    String rsvpStatus = null;

                                    RestResponse result1 = FacebookSocialNetworkingService.eventsGet(request, response, format1, uid, eids, startTime, endTime, rsvpStatus);
                                    if (result1.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsGetResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.EventsGetResponse) {
                                        facebook.socialnetworkingservice.facebookresponse.EventsGetResponse result1Obj = result1.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.EventsGetResponse.class);
                                    } else if (result1.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.ErrorResponse) {
                                        facebook.socialnetworkingservice.facebookresponse.ErrorResponse result1Obj = result1.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class);
                                    }
                                    //TODO - Uncomment the print Statement below to print result.
                                    out.println("The SaasService returned: "+result1.getDataAsString());
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }

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

