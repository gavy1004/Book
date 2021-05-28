<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
     <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/style.css" type="text/css">
  
     <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/main.js"></script>

</head>
<body>
   <tiles:insertAttribute name="title"></tiles:insertAttribute>
   <hr>
   <tiles:insertAttribute name="head"></tiles:insertAttribute>
   <hr>
      <tiles:insertAttribute name="section"></tiles:insertAttribute>
   <hr>
   <tiles:insertAttribute name="body"></tiles:insertAttribute>
   <hr>
   <tiles:insertAttribute name="foot"></tiles:insertAttribute>
 
</body>
</html>