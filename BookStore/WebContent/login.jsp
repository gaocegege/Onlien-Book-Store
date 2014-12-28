<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="CEce" content="width=device-width, initial-scale=1.0">
	<title>Online Book Store</title>
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
          <div class="logo"></div>
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
                  <a href="./index.jsp">
                    Homepage
                    <span class="navbar-unread">1</span>
                  </a>
                </li>
                
                <li>
                  <a href="./register.jsp">
                    Register
                  </a>
                </li>
                
                <li>
                  <a href="./login.jsp">
                    Login
                  </a>
                </li>
                <!-- 
                <li class="active">
                  <a href="#fakelink">
                    Messages
                    <span class="navbar-unread">1</span>
                  </a>
                  <ul>
                    <li><a href="#fakelink">Element One</a></li>
                    <li>
                      <a href="#fakelink">Sub menu</a>
                      <ul>
                        <li><a href="#fakelink">Element One</a></li>
                        <li><a href="#fakelink">Element Two</a></li>
                        <li><a href="#fakelink">Element Three</a></li>
                      </ul>
                    </li>
                    <li><a href="#fakelink">Element Three</a></li>
                  </ul> 
                </li>
                 -->
              </ul>
            </div><!--/.nav -->
          </div>
      </div>
    <div class="demo-row typography-row">
    	<p class="lead">Login</p>
    	<form action="login.action" method="post">
    		<div class="form-group">
    		<p>Username</p>
    		<input type="text" class="form-control input-sm flat" placeholder="Username" name="username" style = "width:250px">
    		<p>Password</p>
    		<input type="password" class="form-control input-sm flat" placeholder="Password" name="pwd" style = "width:250px">
    		</div>
    		<div class="form-group">
    		<input type="submit" class="btn btn-success" value="Login">
    		</div>
    	</form>
    </div>
</div>
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
</body>
</html>