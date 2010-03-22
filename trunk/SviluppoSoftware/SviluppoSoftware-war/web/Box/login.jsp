<li id="login">
    <h2 class="search">Login</h2>
    <form name="login" action="LoginServlet" method="POST">
        <input type="hidden" name="op" value="login" />
        <input type="text" id="user-text" name="username" value="username"/>
        <input type="password" id="password-text" name="password" value="password" />
        <input type="submit" id="login-submit" value="Login" name="Login" />
    </form>
</li>
<li>
    <a href="LoginServlet?op=registrazione">Non hai un account?</a>
    <!--RPX link-->
    <br>
    <a class="rpxnow" onclick="return false;"
href="https://sviluppo-software.rpxnow.com/openid/v2/signin?token_url=http%3A%2F%2Flocalhost%3A2192%2FSviluppoSoftware-war%2FopenIDServlet?format=xml"> Usa OpenID </a>
</li>
