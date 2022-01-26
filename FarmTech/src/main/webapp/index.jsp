<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<center>
    <h2><b>Welcome to Our FarmTech Company</b></h2>
    <h3>
        <a href="<%=request.getContextPath()%>/login">login</a> ||
        <a href="<%=request.getContextPath()%>/registration">Registration</a>
    </h3>
</center>


</body>
</html>