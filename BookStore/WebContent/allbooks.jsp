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
    
    <!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>

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
                  <ul>
                  		<li><a href="addbooks.jsp">Add Books</a></li>
                  </ul>
                </li>
                
                <li>
                	<a href="#">Statistics</a>
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
    <div class="row demo-row">
    	<div class="col-md-9">
    		<p class="lead">Add to the basket</p>
    	</div>
    	<div class="col-md-3">
    		<%
    			int pageNum = 0;
    			int type = -1;
    		%>
    		<ul class="pager">
  			<li class="previous" onclick="previous()">
      		<span>
        		<i class="fui-arrow-left"></i>
        		All Books
      		</span>
  			</li>

  			<li class="next" onclick="next()">
      			<i class="fui-arrow-right"></i>
	  		</li>
			</ul>
    	</div>
    </div>
    <div class="row demo-row">
    	<div class="col-md-3">
    		<select style="display: none;" name="info" class="mbn" onchange="changeItem()" id="select">
            		<optgroup label="Book">
              			<option value="0">By Bookname</option>
              			<option selected="selected" value="1">By ISBN</option>
            		</optgroup>
            		<optgroup label="Order">
            			<option value="2">By Date</option>
              			<option value="3">By Orderid</option>
            		</optgroup>
            		<optgroup label="All">
            			<option value="4">All</option>
            		</optgroup>
          	</select>
          	<form action="addBook.action" method="post" id="queryForm">
    		<div class="form-group" id="queryGroup">
    			<input type='hidden' name='type' value='1'>
    			<input type="text" class="form-control input-sm flat" style="margin-top: 20px" placeholder="ISBN" name="ISBN">
    		</div>
    		<div class="form-group">
    			<input type="button" class="btn btn-success" value="Search" onclick="search()">
    		</div>
    	</form>
    	</div>
    	<div class="col-md-9">
			<div id="bookContainer"></div>
    	</div>
    </div>
    <div>
        <script type="text/javascript">
        	var type = -1;
        	function changeItem(){
        		var form = document.getElementById("queryGroup");
        		var childs=form.childNodes;    
        		for(var i=childs.length-1;i>=0;i--){    
        			form.removeChild(childs.item(i));    
        		}    
        		if (document.getElementById("select").value == 0){
        			type = 0;
        			var html = "<input type='hidden' name='type' value='0'><input type='text' style='margin-top: 20px' class='form-control input-sm flat' placeholder='Book Name' name='bookname'>";
        			$('#queryGroup').append(html);
        		}
        		else if (document.getElementById("select").value == 1){
        			type = 1;
        			var html = "<input type='hidden' name='type' value='1'><input type='text' style='margin-top: 20px' class='form-control input-sm flat' placeholder='ISBN' name='ISBN'>";
        			$('#queryGroup').append(html);
        		}
        		else if (document.getElementById("select").value == 2){
        			type = 2;
        			var html = "<input type='hidden' name='type' value='2'><input type='month' name='date' style='margin-top: 20px' class='form-control input-sm flat'>";
        			$('#queryGroup').append(html);
        		}
        		else if (document.getElementById("select").value == 3){
        			type = 3;
        			var html = "<input type='hidden' name='type' value='3'><input type='text' style='margin-top: 20px' class='form-control input-sm flat' placeholder='Book Name' name='bookname'>";
        			$('#queryGroup').append(html);
        		}
        		else if (document.getElementById("select").value == 4){
        			type = 4;
        		}
        	}
        	
        	function search(){
        		$('#bookContainer').empty();
        		$.ajax({
    				url : "bookShowSearch.action",
    		        type : "post",
    		        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		        data : {
    		        	"type": type,
    		        	"bookname": $("input[name=bookname]").val(),
    		        	"ISBN": $("input[name=ISBN]").val()
    		        },
    		        dataType: "json",
    		        success: function(data){
    		        	$('#bookContainer').append(data.html);
    				}
    		    });
        	}
        </script>
    </div>
	<script>
		var pageNum = 0;
		function bookinfo(cece)
		{
			window.location.href="bookinfo.jsp?ISBN=" + cece;
		}
	
		function previous()
		{
			pageNum = pageNum - 1;
			if (pageNum == -1){
				pageNum = 0;
			}
			$('#bookContainer').empty();
			$.ajax({
				url : "bookPageView.action",
		        type : "get",
		        data : "pageNum=" + pageNum,
		        dataType: "json",
		        success: function(data){
		        	/*
		        	var bookContainer = document.getElementById("bookContainer");
		        	var countBuf = data.count;
		        	if (countBuf == 0){
		        		$('#bookContainer').alt = 'Nothing';
		        	}
		        	var buf = 0;
		        	var html = "";
		        	while (countBuf > 0){
		        		html += "<div class='row demo-row' style = 'width:100%'>";
		        		
		        		for (var i = 0; i < Math.min(3, countBuf); i++){
		        			var bookBuf = data.result[buf + i];
		        			html += "<div class='col-md-4'>";
		        			html += "<div class='pallete-item' style = 'width:100%' onclick='bookinfo(";
		        			html += bookBuf['ISBN'];
		        			html += ")'><dl class='palette palette-wet-asphalt'><dt>ISBN:";
		        			html += bookBuf['ISBN'];
		        			html += "</dt></dl>";
		        			html += "<dl class='palette palette-midnight-blue'><dt>Book Name:";
		        			html += bookBuf['bookname'];
		        			html += "</dt></dl>";
		        			html += "<dl class='palette palette-midnight-blue'><dt>Price:";
		        			html += bookBuf['price'];
		        			html += "</dt></dl>";
		        			html += "<dl class='palette palette-midnight-blue'><dt>Number:";
		        			html += bookBuf['number'];
		        			html += "</dt></dl>";
		        			html += "<dl class='palette palette-midnight-blue'><dt>PublishMent:";
		        			html += bookBuf['publishmentName'];
		        			html += "</dt></dl></div>";
		        			html += "</div>";
		        		}
		        		countBuf = countBuf - 3;
		            	buf = buf + 3;
		            	
		            	html += "</div>";
		        	}*/
		        	$('#bookContainer').append(data.html);
		        }
		    });
		}
		
		function next()
		{
			pageNum = pageNum + 1;
			$('#bookContainer').empty();
			$.ajax({
				url : "bookPageNum.action",
		        type : "get",
		        data : "pageNum=" + pageNum,
		        dataType: "json",
		        success: function(data){
		        		if (pageNum >= data.pageNum){
		        			pageNum = data.pageNum - 1;
		        		}
		        	}
		        });
			$.ajax({
				url : "bookPageView.action",
		        type : "get",
		        data : "pageNum=" + pageNum,
		        dataType: "json",
		        success: function(data){
		        	$('#bookContainer').append(data.html);
				}
		    });
		}
	</script>
	<%
    /*int countBuf = (Integer) request.getAttribute("count");
    int buf = 0;
    while (countBuf > 0)
    {
    	out.println("<div class='row demo-row' style = 'width:100%'>");
    	// BUG: <4
    	for (int i = 0; i < Math.min(3, countBuf); i++)
    	{
    		Book bookBuf = (Book)((List<Book>) request.getAttribute("result")).get(buf + i);
    		out.println("<div class='col-md-4'>");
    		out.println("<div class='pallete-item' style = 'width:100%' onclick='bookinfo(");
    		out.println(bookBuf.getISBN());
    		out.println(")'><dl class='palette palette-wet-asphalt'><dt>ISBN:");
    		out.println(bookBuf.getISBN());
    		out.println("</dt></dl>");
    		out.println("<dl class='palette palette-midnight-blue'><dt>Book Name:");
    		out.println(bookBuf.getBookname());
    		out.println("</dt></dl>");
    		out.println("<dl class='palette palette-midnight-blue'><dt>Price:");
    		out.println(bookBuf.getPrice());
    		out.println("</dt></dl>");
    		out.println("<dl class='palette palette-midnight-blue'><dt>Number:");
    		out.println(bookBuf.getNumber());
    		out.println("</dt></dl>");
    		out.println("<dl class='palette palette-midnight-blue'><dt>PublishMent:");
    		out.println(bookBuf.getPublishmentName());
    		
    		out.println("</dt></dl></div>");
    		out.println("</div>");
    	}
    	countBuf = countBuf - 3;
    	buf = buf + 3;
    	out.println("</div>");
    }*/
    %>
    </div>
    
    <div class="demo-row typography-row">
    </div>
</div>
</body>
</html>