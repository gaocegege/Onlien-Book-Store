<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="domain.Book" %>
<%@ page import="java.lang.Math.*" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.BasketItem" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"content="text/html;charset=utf-8"/>
	<meta name="CEce" content="width=device-width, initial-scale=1.0">
	<title>login</title>
	<!-- Loading Bootstrap -->
    <link href="./bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="./css/flat-ui.css" rel="stylesheet">
    <link href="./css/demo.css" rel="stylesheet">
	<link rel="shortcut icon" href="./images/favicon.ico">
</head>
<body>
<div class="container">
	<div class="demo-headline">
        <h1 class="demo-logo">
          Online Book Store
          <small>Nothing but for display</small>
        </h1>
    </div>
    <%HttpSession s = request.getSession();%>
    <div class="row demo-row" style = "width:100%">
          <div class="navbar navbar-inverse">
          	<div class="navbar-header">
	          	<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-collapse-01"></button>
          	</div>            
            <div class="navbar-collapse collapse navbar-collapse-01">
              <ul class="nav navbar-nav navbar-left">
                <li>
                  <a href="./homepage.jsp">
                    Homepage
                    <span class="navbar-unread">1</span>
                  </a>
                </li>
                
                <li>
                  <a href="allbooks.jsp">
                    View Books
                  </a>
                </li>
                
                <li>
                	<a href="">Statistics</a>
                	<ul>
                  		<li><a href="sbookShow.action">Statistics for the books</a></li>
                  	</ul>
                </li>
                
                <li class="active">
                  <a href="basket.jsp">
                    Basket
                    <span class="navbar-unread">1</span>
                  </a>
                  <ul>
                  	<%
                  	List<BasketItem> basketBuf = (List<BasketItem>) session.getAttribute("basket");
                  	if (basketBuf == null)
                  	{
                  		out.println("<li><a>");
                  		out.println("Void");
                  		out.println("</a></li>");
                  	}
                  	else
                  	{
                  		for (int i = 0; i < basketBuf.size(); i++)
                      	{
                      		out.println("<li><a>");
                      		out.println(basketBuf.get(i).getISBN());
                      		out.println(", ");
                      		out.println(basketBuf.get(i).getCount());
                      		out.println("</a></li>");
                      	}
                  	}
                  	%>
                  </ul> 
                </li>
                
                <li>
                  <a href="changeinfo.jsp">
                    Change User Info
                  </a>
                </li>
                
                <li>
                  <a href="orderShow.action">
                    View Orders
                  </a>
                </li>
                
                <li>
                	<a href="logout.action">
                	Logout(<%=s.getAttribute("username") %>)
                	</a>
                </li>
              </ul>
            </div><!--/.nav -->
          </div>
      </div>
    <div>
    	<%
    		out.println("<table class='table table-hover'><tr><th>Username</th><th>Count</th></tr>");
    		for (int i = 0; i < ((List<String>) request.getAttribute("userList")).size(); i++)
    		{
    			out.println("<tr><td>" + ((List<String>) request.getAttribute("userList")).get(i) + "</td>");
    			out.println("<td>" + ((List<Integer>) request.getAttribute("countList")).get(i) + "</td></tr>");
    		}
    		out.println("</table>");
    	%>
    </div>
</div>
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
</body>
</html>