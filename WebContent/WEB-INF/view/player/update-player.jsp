<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Player</title>
</head>
<body>
	<%@ include file = "/WEB-INF/view/header.jsp" %>
	<form action="player-update" method="post">
		<p>
			<label>UPDATE PLAYER<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_player" value="${player.getName()}"/><br>
		<input type="hidden" name="id_player" value="${player.getId()}"/>
		<br> <input type="submit" value="Update">
	</form>
</body>
</html>