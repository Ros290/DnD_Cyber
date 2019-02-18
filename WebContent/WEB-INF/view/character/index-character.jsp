<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Characters</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<h1>Index Characters</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Race</th>
			<th>Class</th>
			<th>Player</th>
		</tr>
		<c:forEach items="${requestScope.listCharacters}" var="character">
			<tr>
				<td><c:out value="${character.getId()}"></c:out></td>
				<td><c:out value="${character.getName()}"></c:out></td>
				<td><c:out value="${character.getRace().getName()}"></c:out></td>
				<td><c:out value="${character.getCharClass().getName()}"></c:out></td>
				<td><c:out value="${character.getPlayer().getName()}"></c:out></td>
				<td>
					<form action="character-index" method="POST">
						<input type="hidden" name="id_character" value="${character.getId()}"> <input
							type="submit" value="SHOW DETAILS">
					</form>
				</td>
				<td>
					<form action="character-update" method="GET">
						<input type="hidden" name="id_character" value="${character.getId()}"> <input
							type="submit" value="UPDATE">
					</form>
				</td>
				<td>
					<form action="character-delete" method="GET">
						<input type="hidden" name="id_character" value="${character.getId()}"> <input
							type="submit" value="DELETE">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="character-create" method="GET">
		<input type="submit" value="CREATE NEW" />
	</form>

</body>
</html>