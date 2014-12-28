<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="domain.BasketItem" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="CEce" content="width=device-width, initial-scale=1.0">
	<title>login</title>
	<!-- Loading Bootstrap -->
    <link href="./bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="./css/flat-ui.css" rel="stylesheet">
    <link href="./css/demo.css" rel="stylesheet">
	<link rel="shortcut icon" href="./images/favicon.ico">
    <!-- 
    <style>
    body
	{
		/*背景色设定*/
		background-color: #66B3FF;
	}
	#tabs
	{
		width: 48%;
		/*透明度设定*/
		opacity: 0.5;
		float: left;
	}
	#tabs1
	{
		width: 50%;
		/*透明度设定*/
		opacity: 0.5;
		float: right;
	}
	</style>
     -->
</head>
<body>
<div class="container">
	<div class="demo-headline">
        <h1 class="demo-logo">
          Online Book Store
          <small>Nothing but for display</small>
        </h1>
    </div>
    
    <div class="row demo-row">
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
                	<a href="">
                	<%HttpSession s = request.getSession();%>
                	Logout(<%=s.getAttribute("username") %>)
                	</a>
                </li>
              </ul>
            </div><!--/.nav -->
          </div>
      </div>
    <div class="lead">Dear <%=s.getAttribute("username") %>, you can change your info here</div>
	<!-- 
	<s:form action="changeUserInfo" method="post">
		<s:password name="pwd" label="password"></s:password>
    	<s:password name="pwdAgain" label="password Again"></s:password>
    	<s:textfield name="name" label="name"></s:textfield>
    	<s:textfield name="sno" label="sno"></s:textfield>
    	<s:submit label="Change now"></s:submit>
	</s:form>
	 -->
	<form action="changeUserInfo.action" method="post">
		<div class="form-group">
			<p>Password</p>
			<input type="password" class="form-control input-sm flat" placeholder="Password" name="pwd" style = "width:250px">
			<p>Password Again</p>
			<input type="password" class="form-control input-sm flat" placeholder="Password Again" name="pwdAgain" style = "width:250px">
			<p>Name</p>
			<input type="text" class="form-control input-sm flat" placeholder="Name" name="name" style = "width:250px">
			<p>Student ID</p>
			<input type="text" class="form-control input-sm flat" placeholder="StuID" name="sno" style = "width:250px">
			</div>
			<div class="form-group">
			<div class="row">
			<input type="submit" class="btn btn-success" value="Submit">
			<input type="submit" class="btn btn-success" value="Submit">
			</div>
			</div>
	</form>
</div>
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
</body>
</html>