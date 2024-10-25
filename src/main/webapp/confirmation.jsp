<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Confirm Registration</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="my-4 text-success">Your Registration was Successful!</h1>
    <p><strong>Name:</strong> <%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %></p>
    <p><strong>Email:</strong> <%= request.getAttribute("email") %></p>
    <p><strong>Phone Number:</strong> <%= request.getAttribute("phone") %></p>
</div>
</body>
</html>
