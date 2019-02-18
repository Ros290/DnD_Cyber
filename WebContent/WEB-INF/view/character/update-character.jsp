<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Character</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<form action="character-update" method="post">
		<p>
			<label>UPDATE CHARACTER<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_character" value="${requestScope.character.getName() }"/><br>
		<br> <label>Character Class</label> <select name="id_charClass">
			<c:forEach items="${requestScope.listCharClasses}" var="charClass">
				<option value="${charClass.getId()}" 
				<c:if test="${character.getCharClass().getId() == charClass.getId()}">selected</c:if>>
					<c:out value="${charClass.getName()}"></c:out>
				</option>
				
			</c:forEach>
		</select> <br>
		<br> <label>Race</label> <select name="id_race">
			<c:forEach items="${requestScope.listRaces}" var="race">
				<option value="${race.getId()}"
				<c:if test="${character.getRace().getId() == race.getId()}">selected</c:if>>
					<c:out value="${race.getName()}"></c:out>
				</option>
			</c:forEach>
		</select> <br>
		<br> <label>Player</label> <select name="id_player">
			<c:forEach items="${requestScope.listPlayers}" var="player">
				<option value="${player.getId()}"
				<c:if test="${character.getPlayer().getId() == player.getId()}">selected</c:if>>
					<c:out value="${player.getName()}"></c:out>
				</option>
			</c:forEach>
		</select> <br>
		<br> 
		<input type = "hidden" name = "id_character" value = "${requestScope.character.getId() }">
		<input type="submit" value="Update">
	</form>
</body>
</html>