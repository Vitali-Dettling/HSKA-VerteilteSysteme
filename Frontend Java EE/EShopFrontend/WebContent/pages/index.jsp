<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="login.head" /></title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

	<h2>
		<s:text name="login.title" />
	</h2>

	<s:form action="LoginAction" focusElement="username">
		<s:textfield name="username" key="prompt.username" size="20" required="true" />
		<s:password name="password" key="prompt.password" size="20" required="true" />
		<s:submit method="execute" key="login.submit" align="center" />
	</s:form>

	<a href="./pages/register.jsp"><s:text name="register.link" /></a>

	<font color="red">
		<s:actionerror />
	</font>

</body>
</html>