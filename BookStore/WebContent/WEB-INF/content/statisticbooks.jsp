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
	
	<!-- Load JS here for greater good =============================-->
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
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
    <p class="lead">Choose a Book</p>
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
    <div id="bookContainer"></div>
    <script>
		var pageNum = 0;
		
		jQuery(document).ready(function(){ 
			load();
			});
		
		function load()
		{
			$.ajax({
				url : "bookPageView.action",
		        type : "get",
		        data : "pageNum=" + 0,
		        dataType: "json",
		        success: function(data){
		        	$('#bookContainer').append(data.html);
		        }
		    });
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
    	<p class="lead">Order books</p>
    	<form action="bargain.action" method="post">
    		<div class="form-group">
    		<p>Book ID</p>
    		<input type="text" class="form-control input-sm flat" placeholder="Book ID" name="bookid" style = "width:250px">
    		<p>Count</p>
    		<input type="text" class="form-control input-sm flat" placeholder="Count" name="count" style = "width:250px">
    		</div>
    		<div class="form-group">
    		<input type="submit" class="btn btn-success" value="Bargain">
    		</div>
    	</form>
    </div>
	<!-- 
	<table style = "width:50%" class="table table-hover">
    	<thead>
    	  	<tr>
    	  	  <th>Book id</th>
    	      <th>Book Name</th>
    	      <th>Price</th>
    	      <th>Number</th>
    	      <th>Publishment</th>
      		</tr>
    	</thead>
    	<tbody>
    		<s:iterator value="#request.result" var="v">
  				<tr>
  				<td><s:property value="#v.ISBN"/></td>
  				<td><s:property value="#v.bookname"/></td>
  				<td><s:property value="#v.price"/></td>
  				<td><s:property value="#v.number"/></td>
  				<td><s:property value="#v.publishmentName"/></td>
  				</tr>
  			</s:iterator>
    	</tbody>
  </table>
	 -->
	<script>
		function bookinfo(cece)
		{
			window.location.href="statistic.action?ISBN=" + cece;
		}
		
		function callback()
		{
			alert("CECE");
		}
	</script>
</div>
</body>
</html>