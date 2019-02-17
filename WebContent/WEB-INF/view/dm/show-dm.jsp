<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DM <c:out value="${requestScope.dm.getName() }"></c:out> page</title>
</head>
<body>
<h1>DM's List Adventures</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>DM's <c:out value="${requestScope.dm.getName() }"></c:out> Adventures</th>
		</tr>
		<c:forEach items="${requestScope.dm.getListAdventures() }" var="adv">
			<tr>
				<td><c:out value="${adv.getName() }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>