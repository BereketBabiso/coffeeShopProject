<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome Page</title>
	<link href="css/habeshawelcome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<h1 id="habesha1">Friends Coffee</h1>
	<h3>User Welcome ${person.firstName}</h3>
	<a href="<c:url value="/logout" />"> Now logout </a>
	<hr/>
	<h3><a href="updateprofile" >Update Profile</a></h3>
	<h3><a href="placeOrder" >Place Order</a></h3>
	<hr/>

	<footer id="fot">
	    <div class="clearfoot">
		    <div class="foot left">
		        Friends Coffee<br/>
		        &copy;2018<br/>
		        <em>ALL RIGHTS REVERSED</em>
		    </div>
		    <div class="foot right">
		        <label id="facebookcolor"><a href=""><i class="fa fa-facebook-f" style="color:#4267b2"></i></a>  Facebook</label> <br/><br />
		        <label id="twitcolor"><a href=""><i class="fa fa-twitter-square" style="color:#1da1f2"></i></a> Twitter</label>
		    </div>
	        <div class="foot farright">
	            <i class="fa fa-phone" aria-hidden="true"></i>  +1-666666666 <br /><br />
	            <i class="fa fa-envelope" aria-hidden="true"></i>  contactus@friendscoffee.org
	        </div>
	    </div>
	</footer>

</body>
</html>