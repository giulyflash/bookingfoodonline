<%-- 
    Document   : facebookPage
    Created on : Mar 31, 2010, 9:58:40 AM
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
                        String flid = null;

                        RestResponse result = FacebookSocialNetworkingService.friendsGet(request, response, format, flid);
                        if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.FriendsGetResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.FriendsGetResponse) {
                            facebook.socialnetworkingservice.facebookresponse.FriendsGetResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.FriendsGetResponse.class);
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
