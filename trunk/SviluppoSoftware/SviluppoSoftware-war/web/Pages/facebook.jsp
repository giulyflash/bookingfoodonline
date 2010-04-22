<%--
    Document   : index
    Created on : Apr 11, 2010, 12:42:38 PM
    Author     : dani1913
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%@ page import="org.netbeans.saas.*, org.netbeans.saas.facebook.*" %>

        <%

                    try {
                        String format = null;
                        String uid = null;
                        String gids = "113959088615319"; //id del gruppo ristorante online

                        RestResponse result = FacebookSocialNetworkingService.groupsGet(request, response, format, uid, gids);
                        if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.GroupsGetResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.GroupsGetResponse) {
                            facebook.socialnetworkingservice.facebookresponse.GroupsGetResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.GroupsGetResponse.class);
                        } else if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.ErrorResponse) {
                            facebook.socialnetworkingservice.facebookresponse.ErrorResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class);
                        }
                        //TODO - Uncomment the print Statement below to print result.
                        out.println("The SaasService returned: "+result.getDataAsString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

        %>








    </body>
</html>
