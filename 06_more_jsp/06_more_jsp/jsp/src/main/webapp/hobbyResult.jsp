<%@ page import="java.util.List" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhongpu
  Date: 4/2/21
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
   
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
       <link href="asset/css/team.css" rel="stylesheet">
    <link href="asset/css/footer.css" rel="stylesheet">
    <title>Hobby Results</title>

</head>
<body> 

<jsp:include page="head.jsp" />
<h2>The friends who share your hobby of ${requestScope.hobby} are:</h2>
<%
List<String> names = (ArrayList<String>) request.getAttribute("names");
for (String name : names) {
%>
<%=name %>
<br/>
<% } %>

<div class="container">
    <div class="row">
    <c:forEach var="item" items="${names}" > 
        <div class="col-12 col-sm-6 col-md-4 col-lg-3">
            <div class="our-team">
                <div class="picture">
                    <img class="img-fluid" src="asset/image/${item}.jpg">
                </div>
                <div class="team-content">
                    <h3 class="name">${item}</h3>
                    <h4 class="title">Hobby: ${requestScope.hobby}</h4>
                </div>
            </div>
        </div> 
       </c:forEach> 
    </div>
</div>

<jsp:include page="footer.jsp" />


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
