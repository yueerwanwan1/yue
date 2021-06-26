
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP: Instance Variable</title>
</head>
<body>
<% int localCount = 0; %>
<%= ++localCount %>
<br/>
<%! int count = 0; %>
<%= ++count %>
</body>
</html>
