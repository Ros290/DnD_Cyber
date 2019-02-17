<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update DM reference</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp"%>
	<form action="dm-update" method="POST">
		<p>
			<label>Update DM Reference</label>
		</p>
		<label>NAME<br></label> <input type="text" name="name_dm" value="${dm.getName()}"/><br><br>
		<input type="hidden" name="id_dm" value="${dm.getId() }">
		<input type="submit" value="Update">
	</form>
</body>
</html>