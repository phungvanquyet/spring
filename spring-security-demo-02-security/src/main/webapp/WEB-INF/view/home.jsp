<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title> pvquyet Conpany Home Page</title>
</head>

<body>
	<h2> pvquyet Conpany Page</h2>
	<p>
	Welcome to the pvquyet Company home page!</p>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
	<!-- add link point to leaders .. this is for Managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders"> Leadership  Meeting</a>
		(Only for Manager peeps)
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- add link point to systems .. this is for admins -->
	<p>
		<a href="${pageContext.request.contextPath}/systems"> Systems  Meeting</a>
		(Only for Systems peeps)
	</p>
	</security:authorize>
	<!-- Display user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		Role(s): <security:authentication property="principal.authorities"/>
	
	</p>
	<!-- logout -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout" />
		
	</form:form>
</body>
</html>