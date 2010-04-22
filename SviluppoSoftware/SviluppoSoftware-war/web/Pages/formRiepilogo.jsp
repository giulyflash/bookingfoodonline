<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="prova.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<div class="post">
          <h2 class="title"><a href="#">Conferma dati:</a></h2>
          <div class="entry">
              <%UtenteRegistrato utente = (UtenteRegistrato)request.getSession().getAttribute("utente");%>

              <form name="formReg" action="LoginServlet" method="POST">
                <table>
                    <input type="hidden" name="op" value="confermaDati" />
                    <tbody>                        
                        
                        <tr>
                            <td>indirizzo:</td>
                            <td><input type="text" name="indirizzo"  value="<%=utente.getIndirizzo()%>"/></td>
                        </tr>
                        <tr>
                            <td>mail:</td>
                            <td><input  type="text" name="mail" value="ciao" /></td>
                        </tr>
                        <tr>
                            <td>telefono:</td>
                            <td><input type="text" name="telefono" value="<%=utente.getTelefono()%>" /></td>
                        </tr>
                        <tr>
                            <td>carta_credito:</td>
                            <td><input type="text" name="n_cartacredito" value="<%=utente.getN_cartacredito()%>" /></td>
                        </tr>
                        <tr>
                            <td>Invia:</td>
                            <td><input type="submit" value="Invia!" name="Register"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
          </div>
        </div>

                        
