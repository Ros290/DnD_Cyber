<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX DUNGEON MASTERS</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<h1>INDEX DUNGEON MASTERS</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>DM's Name</th>
		</tr>
		<c:forEach items="${requestScope.listDm }" var="dm">
			<tr>
				<td><c:out value="${dm.getName() }"></c:out></td>
				<td>
					<form action="dm-index" method="POST">
						<input type="hidden" name="id_dm" value="${dm.getId()}"> <input
							type="submit" value="SHOW DETAILS">
					</form>
				</td>
				<td>
					<form action="dm-update" method="GET">
						<input type="hidden" name="id_dm" value="${dm.getId()}"> <input
							type="submit" value="UPDATE">
					</form>
				</td>
				<td>
					<form action="dm-destroy" method="GET">
						<input type="hidden" name="id_dm" value="${dm.getId()}"> <input
							type="submit" value="DELETE">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
		<form action="dm-create" method="GET">
		<input type="submit" value="CREATE NEW" />
	</form>
</body>
</html>