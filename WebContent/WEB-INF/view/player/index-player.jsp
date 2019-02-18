<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Players</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<h1>Index Players</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${requestScope.listPlayers}" var="player">
			<tr>
				<td><c:out value="${player.getId()}"></c:out></td>
				<td><c:out value="${player.getName()}"></c:out></td>
				<td>
					<form action="player-index" method="POST">
						<input type="hidden" name="id_player" value="${player.getId()}"> <input
							type="submit" value="SHOW DETAILS">
					</form>
				</td>
				<td>
					<form action="player-update" method="GET">
						<input type="hidden" name="id_player" value="${player.getId()}"> <input
							type="submit" value="UPDATE">
					</form>
				</td>
				<td>
					<form action="player-delete" method="GET">
						<input type="hidden" name="id_player" value="${player.getId()}"> <input
							type="submit" value="DELETE">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="player-create" method="GET">
		<input type="submit" value="CREATE NEW" />
	</form>

</body>
</html>