<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />


<%@page import="java.util.*"%>
<%@page import="prova.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.lang.String"%>


<title>BOOKING FOOD ONLINE</title>

<title>Culinary by melloiencorogno</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="culinarycss.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
       <jsp:include page="/Box/header.jsp" />


  <div id="page">
    <div id="page-bgtop">
      <div id="content">
        <%  Piatto p= (Piatto)request.getSession().getAttribute("piatto_selezionato");            
        %>

        <tit>
            <%=p.getNome().toUpperCase()%>
        </tit>
        <div id="piatto_info">
            <div id="im_piatto">
           
            <img  src= <%=p.getUrl_immagine()%> alt="immagine" >
            </div>
            <div id="dati_piatto">
                
            
            <table border="0">

                <tbody>
                    <tr>
                        <td>categoria:</td>
                        <td><b><%=p.getCategoria()%></b></td>
                        
                    </tr>
                    <tr>
                        <td>costo</td>

                        <td><b><%=p.getCosto()%></b></td>
                    </tr>

                </tbody>
            </table>

            <%for(String a:p.getMaterieNonModificabili()){%>
               <b><%=a%></b>
               <%}%>
           </div>
       </div>
           <div id="scelta_configurazione">
               <jsp:include page="/Box/tabella_scelta.jsp"/>
           </div>
      </div>
    </div>

      <!-- end div#content -->
      <div id="sidebar">
        <jsp:include page="/Box/Sidebar.jsp"/>
        
      </div>
      <!-- end div#sidebar -->
      <div style="clear: both; height: 1px"></div>
    </div>
  </div>  <!-- end div#page -->
</div>
<!-- end div#wrapper -->
</body>

</html>
