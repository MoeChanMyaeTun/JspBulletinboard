
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
</head>
<body>
    <h2>Forgot Password</h2>
    <form action="ForgotServlet" method="post">
        Enter your email:
        <input type="email" name="email" required>
        <input type="submit" value="Reset Password">
    </form>
</body>
</html>
