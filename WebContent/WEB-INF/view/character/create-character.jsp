<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Character</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<form action="character-create" method="post">
		<p>
			<label>INSERT NEW CHARACTER<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_character" /><br>
		<br> <label>Character Class</label> <select name="id_charClass">
			<c:forEach items="${requestScope.listCharClasses}" var="charClass">
				<option value="${charClass.getId()}">
					<c:out value="${charClass.getName()}"></c:out>
				</option>
			</c:forEach>
		</select> <br>
		<br> <label>Race</label> <select name="id_race">
			<c:forEach items="${requestScope.listRaces}" var="race">
				<option value="${race.getId()}">
					<c:out value="${race.getName()}"></c:out>
				</option>
			</c:forEach>
		</select> <br>
		<br> <label>Player</label> <select name="id_player">
			<c:forEach items="${requestScope.listPlayers}" var="player">
				<option value="${player.getId()}">
					<c:out value="${player.getName()}"></c:out>
				</option>
			</c:forEach>
		</select> <br>
		<br> <input type="submit" value="Create">
	</form>
</body>
</html>