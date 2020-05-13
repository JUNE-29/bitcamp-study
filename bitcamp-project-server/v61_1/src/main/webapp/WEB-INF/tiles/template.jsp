<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Bitcamp-LMS</title>
 <!-- <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' integrity='sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh' crossorigin='anonymous'>
 --> 
<link rel='stylesheet' href='${pageContext.getServletContext().getContextPath()}/node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='<tiles:getAsString name="css.common"/>'>
<link rel='stylesheet' href='<tiles:getAsString name="css.page"/>'>

<style>
body {
background-color: white;
}
div.container {
background-color: white;
 width: 500px;
}
.navbar {
  background-color: #fcfcce;
}
.navbar .navbar-brand {
  color: #48a0ed;
}
.navbar .navbar-brand:hover,
.navbar .navbar-brand:focus {
  color: #acd7fe;
}
.navbar .navbar-nav .nav-link {
  color: #48a0ed;
  border-radius: .25rem;
  margin: 0 0.25em;
}
.navbar .navbar-nav .nav-link:not(.disabled):hover,
.navbar .navbar-nav .nav-link:not(.disabled):focus {
  color: #acd7fe;
}
.navbar .navbar-nav .nav-item.active .nav-link,
.navbar .navbar-nav .nav-item.active .nav-link:hover,
.navbar .navbar-nav .nav-item.active .nav-link:focus,
.navbar .navbar-nav .nav-item.show .nav-link,
.navbar .navbar-nav .nav-item.show .nav-link:hover,
.navbar .navbar-nav .nav-item.show .nav-link:focus {
  color: #acd7fe;
  background-color: #baf7ff;
}

footer{
  margin-top: 20px;
  padding: 10px;
  background-color:navy;
  color:white;
  text-align: center;
}

</style>
</head>
<body>


<tiles:insertAttribute name="header"/>
<!-- tiles.xml에서 header로 저장했으니 header이름으로 꺼내기. 
원래는 name="/WEB-INF/tiles/header.jsp" -->
<div class='container'>
<tiles:insertAttribute name="body"/>
</div>

<tiles:insertAttribute name="footer"/>

</body>
</html>
