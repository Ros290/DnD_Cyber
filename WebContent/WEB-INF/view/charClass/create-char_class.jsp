<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Character Class</title>
</head>
<body>
	<%@ include file = "/WEB-INF/view/header.jsp" %>
	<form action="char_class-create" method="post">
		<p>
			<label>INSERT NEW CHARACTER CLASS<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_charClass" /><br>
		<br> <input type="submit" value="Create">
	</form>
</body>
</html>