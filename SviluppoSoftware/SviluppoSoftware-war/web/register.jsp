<%-- 
    Document   : register
    Created on : Mar 3, 2010, 6:21:39 PM
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
        <h1>Pagina di registrazione!</h1>
        <form name="formReg" action="LoginServlet" method="POST">
            <table>
                <input type="hidden" name="op" value="datiRegistrazione" />
                <tbody>
                    <tr>
                        <td>username:</td>
                        <td><input type="text" name="username" value="" /></td>

                    <tr>
                    <tr>
                        <td>password:</td>
                        <td><input type="password" name="password" value="" /></td>

                    <tr>
                        <td>nome:</td>
                        <td><input type="text" name="nome" value="" /></td>
                    </tr>
                    <tr>
                        <td>cognome:</td>
                        <td><input type="text" name="cognome" value="" /></td>
                    </tr>
                    <tr>
                        <td>mail:</td>
                        <td><input type="text" name="mail" value="" /></td>
                    </tr>
                    <tr>
                        <td>indirizzo:</td>
                        <td><input type="text" name="indirizzo" value="" /></td>
                    </tr>
                    <tr>
                        <td>carta_credito:</td>
                        <td><input type="text" name="n_cartacredito" value="" /></td>
                    </tr>
                    <tr>
                        <td>Submit:</td>
                        <td><input type="submit" value="submit" name="Register" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
