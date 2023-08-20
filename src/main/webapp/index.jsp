<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- css  -->
<link href="css/Mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.banner-background{
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 93%, 70% 100%, 31% 93%, 0 100%, 0 0);
}
</style>
</head>
<body>

<!-- navBar -->
<%@include file="normal_navbar.jsp" %>

<!-- Banner -->
<div class="container-fluid p-0 m-0">
	<div class="jumbotron primary-background banner-background">
		<div class="container">
		<h3 class="display-3">Welcome To Techy Blog</h3>
		<p>Welcome to our technical blog website, where we provide cutting-edge insights and practical tips to empower you in the world of technology. 
		Stay ahead with the latest trends, expert opinions, and inspiring articles on AI, cybersecurity, 
		software development, and more. Let's explore the limitless possibilities of technology together.</p>
		
		<button class="btn btn-outline-dark"><span class="fa fa-user-plus"></span> Start! its Free</button>
		<a href="login_page.jsp" class="btn btn-outline-dark"><span class="fa fa-user-circle-o fa-spin"></span> Login</a>
		
		</div>
 	</div>
</div>

<!-- Cards -->
<div class="container">
	<div class="row mb-2">
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Java Programming</h5>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			    <a href="#" class="btn primary-background text-white">Read More</a>
			  </div>
			</div>
		</div>
	</div>
	
</div>

<!-- JavaScript -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>
</body>
</html>