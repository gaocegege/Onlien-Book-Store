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
    	<p class="lead">Welcome to He Xie book store, Hope you happy<strong>^_^</strong></p>
    	<div class="demo-type-example">
			<span class="demo-text-note">What you can do here</span>
			<p>You can <strong>buy books, buy books and buy books</strong> across the system!</p>
    	</div>
    	<div class="demo-type-example">
			<span class="demo-text-note">The structure of the system</span>
			<p>The system is coded by SSH frameworks in Windows. The UI is faked from <a href="http://designmodo.github.io/Flat-UI/">Flat-UI</a>. And it takes the coder many weeks to code and debug. Why the coder decide to set up such a website? Because he has to do to <strong>PASS THE WEB CLASS = =</strong></p>
    	</div>
    	<div class="demo-type-example">
			<span class="demo-text-note">Who set up the system</span>
			<p>Cece, a poor student at SE school in SJTU.</p>
    	</div>
    	<div class="demo-type-example">
			<span class="demo-text-note">Contact me</span>
			<p>If you have any problems about the system, please mail to <strong>gaocegege@hotmail.com</strong>, and I will reply as soon as possible.</p>
    	</div>
    	<%	HttpSession s = request.getSession();%>
    	<p><%=s.getId()%></p>
    </div>
	<!-- 
	<div id="tabs">
		<p>Login</p>
		<s:form action="login" method="post">  
    		<s:textfield name="username" label="username"></s:textfield>  
    		<s:password name="pwd" label="password"></s:password>  
    		<s:submit label="login"></s:submit>
		</s:form>
	</div>
	<div id="tabs1">
		<p>Register</p>
		<s:form action="register" method="post">  
    		<s:textfield name="username" label="username"></s:textfield>  
    		<s:password name="pwd" label="password"></s:password>
    		<s:password name="pwdAgain" label="password Again"></s:password>
    		<s:textfield name="name" label="name"></s:textfield>
    		<s:textfield name="sno" label="sno"></s:textfield>  
    		<s:submit label="register"></s:submit>
		</s:form>
	</div>
	 -->
</div>
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <%-- <script src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="js/jquery.ui.touch-punch.min.js"></script> --%>
    <%-- <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/bootstrap-switch.js"></script>
    <script src="js/flatui-checkbox.js"></script>
    <script src="js/flatui-radio.js"></script>
    <script src="js/jquery.tagsinput.js"></script>
    <script src="js/jquery.placeholder.js"></script>
    <script src="js/jquery.stacktable.js"></script>
    <script src="http://vjs.zencdn.net/4.1/video.js"></script>
    <script src="js/application.js"></script>  --%>
</body>
</html>