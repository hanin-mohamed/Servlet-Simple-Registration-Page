<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Registration</title>
</head>
<body>
<h1> Your Registration success </h1>
<p> With name :  <%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %></p>
<p> Email <%= request.getAttribute("email") %></p>
<p> And Phone Number: <%= request.getAttribute("phone") %></p>
</body>
</html>