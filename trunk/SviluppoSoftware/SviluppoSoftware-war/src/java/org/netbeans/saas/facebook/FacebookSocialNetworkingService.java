/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.facebook;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FacebookSocialNetworkingService Service
 *
 * @author dani1913
 */

public class FacebookSocialNetworkingService {

    /** Creates a new instance of FacebookSocialNetworkingService */
    public FacebookSocialNetworkingService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param request
     * @param response
     * @param recipient
     * @param eventName
     * @param message
     * @return an instance of RestResponse
     */
    public static RestResponse liveMessageSend(HttpServletRequest request, HttpServletResponse response, String recipient, String eventName, String message) throws IOException {
        String v = "1.0";
        String method = "facebook.liveMessage.send";
        FacebookSocialNetworkingServiceAuthenticator.login(request, response);
        String callId = String.valueOf(System.currentTimeMillis());
        String apiKey = FacebookSocialNetworkingServiceAuthenticator.getApiKey(request, response);
        String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
        String sig = FacebookSocialNetworkingServiceAuthenticator.sign(new String[][]{{"api_key", apiKey}, {"session_key", sessionKey}, {"call_id", callId}, {"v", v}, {"recipient", recipient}, {"event_name", eventName}, {"message", message}, {"method", method}});
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"api_key", "" + apiKey + ""}, {"session_key", sessionKey}, {"call_id", callId}, {"sig", sig}, {"v", v}, {"recipient", recipient}, {"event_name", eventName}, {"message", message}, {"method", method}};
        RestConnection conn = new RestConnection("http://api.facebook.com/restserver.php", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param request
     * @param response
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse friendsGetLists(HttpServletRequest request, HttpServletResponse response, String format) throws IOException {
        String v = "1.0";
        String method = "facebook.friends.getLists";
        FacebookSocialNetworkingServiceAuthenticator.login(request, response);
        String callId = String.valueOf(System.currentTimeMillis());
        String apiKey = FacebookSocialNetworkingServiceAuthenticator.getApiKey(request, response);
        String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
        String sig = FacebookSocialNetworkingServiceAuthenticator.sign(new String[][]{{"api_key", apiKey}, {"session_key", sessionKey}, {"call_id", callId}, {"v", v}, {"format", format}, {"method", method}});
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"api_key", "" + apiKey + ""}, {"session_key", sessionKey}, {"call_id", callId}, {"sig", sig}, {"v", v}, {"format", format}, {"method", method}};
        RestConnection conn = new RestConnection("http://api.facebook.com/restserver.php", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param request
     * @param response
     * @param format
     * @param flid
     * @return an instance of RestResponse
     */
    public static RestResponse friendsGet(HttpServletRequest request, HttpServletResponse response, String format, String flid) throws IOException {
        String v = "1.0";
        String method = "facebook.friends.get";
        FacebookSocialNetworkingServiceAuthenticator.login(request, response);
        String callId = String.valueOf(System.currentTimeMillis());
        String apiKey = FacebookSocialNetworkingServiceAuthenticator.getApiKey(request, response);
        String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
        String sig = FacebookSocialNetworkingServiceAuthenticator.sign(new String[][]{{"api_key", apiKey}, {"session_key", sessionKey}, {"call_id", callId}, {"v", v}, {"format", format}, {"flid", flid}, {"method", method}});
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"api_key", "" + apiKey + ""}, {"session_key", sessionKey}, {"call_id", callId}, {"sig", sig}, {"v", v}, {"format", format}, {"flid", flid}, {"method", method}};
        RestConnection conn = new RestConnection("http://api.facebook.com/restserver.php", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param request
     * @param response
     * @param format
     * @param uid
     * @param gids
     * @return an instance of RestResponse
     */
    public static RestResponse groupsGet(HttpServletRequest request, HttpServletResponse response, String format, String uid, String gids) throws IOException {
        String v = "1.0";
        String method = "facebook.groups.get";
        FacebookSocialNetworkingServiceAuthenticator.login(request, response);
        String callId = String.valueOf(System.currentTimeMillis());
        String apiKey = FacebookSocialNetworkingServiceAuthenticator.getApiKey(request, response);
        String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
        String sig = FacebookSocialNetworkingServiceAuthenticator.sign(new String[][]{{"api_key", apiKey}, {"session_key", sessionKey}, {"call_id", callId}, {"v", v}, {"format", format}, {"uid", uid}, {"gids", gids}, {"method", method}});
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"api_key", "" + apiKey + ""}, {"session_key", sessionKey}, {"call_id", callId}, {"sig", sig}, {"v", v}, {"format", format}, {"uid", uid}, {"gids", gids}, {"method", method}};
        RestConnection conn = new RestConnection("http://api.facebook.com/restserver.php", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
