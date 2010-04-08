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
        <div class="post">
          <h2 class="title"><a href="#">Risultato ricerca per nome:</a></h2>
          <div id="categoria_piatto"
             <b></b>
        </div>
             <jsp:include page="/Box/tabellaNome.jsp" />
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
