<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>User Page</title>
<style>
header {
	background-color: #4CAF50;
	padding: 20px;
	color: white;
	text-align: center;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
}

.content-container {
	display: flex;
	flex-direction: column;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
	align-items: center;
}

h2 {
	margin-bottom: 20px;
}

p {
	font-size: 18px;
	line-height: 1.5;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<h1>User Page</h1>
	</header>

	<div class="container">
		<div class="content-container">
			<h2>Chào mừng đến với Trang Người dùng</h2>
			<p>Đây là trang người dùng, nơi bạn có thể truy cập thông tin tài
				khoản và quản lý các tùy chọn của mình.</p>

		</div>
	</div>

</body>
</html>
