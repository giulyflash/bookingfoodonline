
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>MelloIencoRogno's Restaurant</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="culinarycss.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
  <div id="header">
    <div id="logo">


      <h1>Booking food online</h1>
      

      <h1><a href="#">MelloIencoRogno</a></h1>
      <h2><a href="#">Online Restaurant</a></h2>

    </div>
</div>
  <!-- end div#header -->
  <div id="menu">
    <ul>

      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#">About</a></li>
      <li><a href="#">Contact</a></li>
      <% /* inserimento link logout */
                if (session.getAttribute("login") != null){
                 //System.out.println("ccc");
                    /*String op = session.getAttribute("op").toString();
                 da qui faccio tutti i vari controlli */ %>
                 <li><a href="LoginServlet?op=logout">Logout</a></li>
                 <%}%>
      
    </ul>
  </div>
