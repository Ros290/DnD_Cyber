<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Adventures</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<h1>Index Adventures</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DM</th>
		</tr>
		<c:forEach items="${requestScope.listAdv}" var="adv">
			<tr>
				<td><c:out value="${adv.getId()}"></c:out></td>
				<td><c:out value="${adv.getName()}"></c:out></td>
				<td><c:out value="${adv.getDm().getName()}"></c:out></td>
				<td>
					<form action="adventure-index" method="POST">
						<input type="hidden" name="id_adventure" value="${adv.getId()}">
						<input type="submit" value="SHOW DETAILS">
					</form>
				</td>
				<td>
					<form action="adventure-update" method="GET">
						<input type="hidden" name="id_adv" value="${adv.getId()}">
						<input type="submit" value="UPDATE">
					</form>
				</td>
				<td>
					<form action="adventure-delete" method="GET">
						<input type="hidden" name="id_adv" value="${adv.getId()}">
						<input type="submit" value="DELETE">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="adventure-create" method="GET">
		<input type="submit" value="CREATE NEW" />
	</form>

</body>
</html>