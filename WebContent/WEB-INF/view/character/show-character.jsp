<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Character <c:out
		value="${requestScope.character.getName() }"></c:out> page
</title>
</head>
<body>
	<h1>
		<c:out value="${requestScope.character.getName() }"></c:out>
		's description
	</h1>
	<p>
		<b>Race :</b>
		<c:out value="${requestScope.character.getRace().getName() }"></c:out>
	</p>
	<p>
		<b>Class :</b>
		<c:out value="${requestScope.character.getCharClass().getName() }"></c:out>
	</p>
	<p>
		<b>Player :</b>
		<c:out value="${requestScope.character.getPlayer().getName() }"></c:out>
	</p>
	<p><b>Adventures :</b></p>
	<ul>
		<c:forEach items="${requestScope.character.getListAdventures() }"
			var="adventure">
			<li><c:out value="${adventure.getName() }"></c:out>, <b>DM :</b> <c:out value="${adventure.getDm().getName() }"></c:out>;</li>
		</c:forEach>
	</ul>
</body>
</html>