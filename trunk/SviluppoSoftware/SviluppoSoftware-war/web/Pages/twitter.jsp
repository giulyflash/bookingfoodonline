

<%@ page import="org.netbeans.saas.*, org.netbeans.saas.twitter.*" %>

<%
            out.println("ciao");
            try {
                String email = "dani1913@gmail.com";
                String id = "";
                String format = "xml";

                RestResponse result = TwitterWhatAreYouDoingService.showUsersById(request, response, email, id, format);
                if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.UserType.class) instanceof twitter.whatareyoudoingservice.twitterresponse.UserType) {
                    twitter.whatareyoudoingservice.twitterresponse.UserType resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.UserType.class);
                } else if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.NilClasses) {
                    twitter.whatareyoudoingservice.twitterresponse.NilClasses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class);
                }
                //TODO - Uncomment the print Statement below to print result.
                out.println("The SaasService returned: "+result.getDataAsString());
                out.println("ciao");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

%>

