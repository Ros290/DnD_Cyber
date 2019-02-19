<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adventure <c:out
		value="${requestScope.adventure.getName() }"></c:out> page
</title>
</head>
<body>
	<h1>
		<c:out value="${requestScope.adventure.getName() }"></c:out>
		description
	</h1>
	<p>
		<b>DM :</b>
		<c:out value="${requestScope.adventure.getDm().getName() }"></c:out>
	</p>
	<p>
		<b>Party :</b>
	</p>
	<ul>
		<c:forEach items="${requestScope.adventure.getParty() }"
			var="character">
			<li><b>Name : </b> <c:out value="${character.getName() }"></c:out>,
				<b>Race : </b>
			<c:out value="${character.getRace().getName() }"></c:out>, <b>Class
					:</b>
			<c:out value="${character.getCharClass().getName() }"></c:out>, <b>Player
					:</b>
			<c:out value="${character.getPlayer().getName() }"></c:out>;</li>
		</c:forEach>
	</ul>
</body>
</html>