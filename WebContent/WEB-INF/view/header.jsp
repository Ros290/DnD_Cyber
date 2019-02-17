
<c:if test="${requestScope.ERROR != null}">
	<div>
		<h1 style="color:red;">
			<c:out value="${requestScope.ERROR}"></c:out>
		</h1>
	</div>
</c:if>
<c:if test="${requestScope.SUCCESS != null}">
	<div>
		<h1 style="color:green;">
			<c:out value="${requestScope.SUCCESS}"></c:out>
		</h1>
	</div>
</c:if>