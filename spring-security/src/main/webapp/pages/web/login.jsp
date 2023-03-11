<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập/ Đăng ký</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<link rel="stylesheet"
	href="<c:url value='template/assets/css/as-alert-message.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='template/assets/css/sign-in.css'/>">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<header style="background-color: #007f3f; padding: 10px;">
		<h1 style="color: white;">Đăng nhập</h1>
	</header>



	<div class="container_signup_signin" id="container_signup_signin"
		style="background-color: #007f3f">
		<div style="margin: auto; padding: 10px">
			<form name="sign-in-form" style="color: var(- -theme-title);"
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method='POST' onsubmit="return signInValidateForm()">
				<input name="username" type="text" placeholder="Username" /> <input
					name="password" type="password" placeholder="Password"
					style="margin-top: 10px;" />
				<button style="margin-top: 10px;">Đăng nhập</button>
				<button style="margin-top: 10px;" type="button" data-toggle="modal"
					data-target=".bd-example-modal-lg">Đăng ký</button>
			</form>
		</div>
	</div>

</body>
</html>
