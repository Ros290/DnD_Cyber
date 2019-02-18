<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Character Class <c:out value="${requestScope.charClass.getName() }"></c:out> page</title>
</head>
<body>
<h1><c:out value="${requestScope.race.getName() }"></c:out> List Characters</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>Character Name</th>
			<th>Race</th>
			<th>Player</th>
		</tr>
		<c:forEach items="${requestScope.charClass.getListCharacters() }" var="character">
			<tr>
				<td><c:out value="${character.getName() }"></c:out></td>
				<td><c:out value="${character.getRace().getName() }"></c:out></td>
				<td><c:out value="${character.getPlayer().getName() }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>