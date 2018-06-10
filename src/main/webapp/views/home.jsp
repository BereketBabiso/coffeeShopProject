<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>FriendsCoffee</title>
<%-- 	<link href="<c:url value="/resources/css/habeshawelcome.css" />" rel="stylesheet"> --%>
 	<link href="css/habeshawelcome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<h1 id="habesha1">Friends Coffee <i class="fa fa-coffee" style="font-size:24px;color:white" aria-hidden="true"></i></h1>
	
	You can choose any presentation framework that could be integrated with
	Spring
	
	<p>
		The only user is "<b>super</b>" and the password is "<b>pw</b>"
	</p>
		<a href="<c:url value="/secure" />"> Go to Secure Area </a>
		
	<div class="Outercontainer">
	    <div class="clearfix">
	        <div class="image1 common"><img id="img1" width="300px" height="200px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Latte_at_Doppio_Ristretto_Chiang_Mai_01.jpg/170px-Latte_at_Doppio_Ristretto_Chiang_Mai_01.jpg"></div>
	        <div class="image2 common"><img id="img2" width="300px" height="200px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIVELGolHvCCkMxyFUUlN2wjWOY0aWltMFn54y6wxAnYMGNFaMjg"></div>
	        <div class="image3 common"><img id="img3" width="300px" height="200px" src="https://i2.wp.com/shebasjewels.com/wp-content/uploads/Family-Doro-Wat.jpg?resize=400%2C267&ssl=1"></div>
	    </div>

	</div>
		
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