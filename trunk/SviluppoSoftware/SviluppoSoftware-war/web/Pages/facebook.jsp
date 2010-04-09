
<%@ page import="org.netbeans.saas.*, org.netbeans.saas.facebook.*" %>

<%

            try {
                String format = "xml";

                RestResponse result = FacebookSocialNetworkingService.friendsGetLists(request, response, format);
                if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.FriendsGetListsResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.FriendsGetListsResponse) {
                    facebook.socialnetworkingservice.facebookresponse.FriendsGetListsResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.FriendsGetListsResponse.class);
                } else if (result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class) instanceof facebook.socialnetworkingservice.facebookresponse.ErrorResponse) {
                    facebook.socialnetworkingservice.facebookresponse.ErrorResponse resultObj = result.getDataAsObject(facebook.socialnetworkingservice.facebookresponse.ErrorResponse.class);
                }
                //TODO - Uncomment the print Statement below to print result.
                //
              out.println("The SaasService returned: "+result.getDataAsString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

%>

