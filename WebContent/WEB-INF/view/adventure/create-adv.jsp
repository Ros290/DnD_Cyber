<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Adventure</title>
</head>
<body>
	<%@ include file = "/WEB-INF/view/header.jsp" %>
	<form action="adventure-create" method="post">
		<p>
			<label>INSERT NEW ADVENTURE<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_adv" /><br>
		<br> <select name="id_dm">
			<c:forEach items="${requestScope.listDm}" var="dm">
				<option value="${dm.getId()}">
					<c:out value="${dm.getName()}"></c:out>
				</option>
			</c:forEach>
		</select><br>
		<br> <input type="submit" value="Create">
	</form>
</body>
</html>