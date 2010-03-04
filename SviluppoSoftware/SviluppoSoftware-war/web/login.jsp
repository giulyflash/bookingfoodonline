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
    <a href="register.jsp">Non hai un account?</a>
</li>
