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
	
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>

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
			<p class="lead">Register</p>
			<!-- 
			<s:form action="register" method="post">  
    			<s:textfield name="username" label="username"></s:textfield>  
    			<s:password name="pwd" label="password"></s:password>
    			<s:password name="pwdAgain" label="password Again"></s:password>
    			<s:textfield name="name" label="name"></s:textfield>
    			<s:textfield name="sno" label="sno"></s:textfield>  
    			<s:submit label="register"></s:submit>
			</s:form>
			 -->
			 <form action="register.action" method="post" name="registerForm">
			 	<div class="form-group">
			 	<div class="form-group" id="usernameGroup">
			 	<p>Username</p>
			 	<input type="text" class="form-control input-sm flat" placeholder="Username" name="username" style = "width:250px" onblur="checkUsername()">
			 	</div>
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
			 	<input type="submit" class="btn btn-success" value="Register">
			 	</div>
			 	</div>
			 </form>
    </div>
</div>
	<script>
		function checkUsername()
		{
			/*
			var xmlhttp;
			if (window.XMLHttpRequest)
			{
				xmlhttp=new XMLHttpRequest();
			}
			else
			{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			document.getElementById("test").innerHTML = "BEGIN";
			xmlhttp.onreadystatechange = callback;
			xmlhttp.open("GET","registerCheckUsername.action?username=" + registerForm.username.value, true);
			Console.log(registerForm.username.value);
			xmlhttp.send(null);
			*/
			//AJAX to check whether the username is used by other users;
			$.ajax({
		        url : "registerCheckUsername.action",
		        type : "get",
		        data : "username=" + registerForm.username.value,
		        dataType: "json",
		        success: function(data){
		        	if (data.result == "AVAILABLE"){
		        		var userGroup = document.getElementById("usernameGroup");
			        	userGroup.setAttribute("class", "form-group has-success");
			        	var newElement = document.Document.createElement('p');
			        	newElement.innerHTML = data.result;
			        	document.getElementById("usernameGroup").appendChild(newElement);
		        	}
		        	else{
		        		var userGroup = document.getElementById("usernameGroup");
			        	userGroup.setAttribute("class", "form-group has-error");
			        	var newElement = document.Document.createElement('p');
			        	newElement.innerHTML = data.result;
			        	document.getElementById("usernameGroup").appendChild(newElement);
		        	}
				}
		    });
		}
	</script>
</body>
</html>