<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

  

</head>
<body>
	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	<hr>
	<tiles:insertAttribute name="head"></tiles:insertAttribute>
	<hr>
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
	<hr>
	<tiles:insertAttribute name="foot"></tiles:insertAttribute>
</body>
</html>