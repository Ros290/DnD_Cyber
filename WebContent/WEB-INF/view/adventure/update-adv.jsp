<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE ADVENTURE</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<form action="adventure-update" method="post">
		<p>
			<label>UPDATE ADVENTURE<br /> <br /></label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_adv"
			value="${adv.getName()}" /> <input type="hidden" name="id_adv"
			value="${adv.getId()}" /> <br /> <br /> <select name="id_dm">
			<c:forEach items="${requestScope.listDm}" var="dm">
				<option value="${dm.getId()}"
					<c:if test="${adv.getDm().getId() == dm.getId()}">selected</c:if>>
					<c:out value="${dm.getName()}"></c:out>
				</option>
			</c:forEach>
		</select><br> <br> <input type="submit" value="Update">
	</form>
</body>
</html>