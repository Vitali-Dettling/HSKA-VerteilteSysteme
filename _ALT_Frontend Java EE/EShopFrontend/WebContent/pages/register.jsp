<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="register.head" /></title>
<link rel="stylesheet" type="text/css" href="../style.css" />
</head>
<body>

<center>
	<h2>
		<s:text name="register.title" />
	</h2>

	<s:form action="RegisterAction">
		<s:textfield name="firstname" key="prompt.name"     size="20" required="false" />
		<s:textfield name="lastname" key="prompt.lastname"  size="20" required="false" />
		<s:textfield name="username" key="prompt.username"  size="20" required="true" />
		<s:password name="password1" key="prompt.password1" size="20" required="true" />
		<s:password name="password2" key="prompt.password2" size="20" required="true" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:submit method="execute" key="register.submit" align="center" />
	</s:form>

	<br>
	
	<a href="../index.jsp"><s:text name="link.back" /></a>

</center>

	<font color="red">
		<s:actionerror />
	</font>

</body>
</html>