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

<center>

	<h2>
		<s:text name="login.title" />
	</h2>
	<h3>
		<s:text name="login.subtitle" />
	</h3>
	<hr>
	
	<br>
	Melden Sie sich jetzt an und genieﬂen Sie das ultimative Einkaufserlebnis.
	<br>
	<br>

	<s:form action="LoginAction" focusElement="username">
		<s:textfield name="username" key="prompt.username" size="20" required="true" />
		<s:password name="password" key="prompt.password" size="20" required="true" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:label name="dummy" />
		<s:submit method="execute" key="login.submit" align="center" />
	</s:form>

	<br>
	<br>
	
	Sie besitzen noch gar keinen WebShop-Account?
	
	<br>
	
	<a href="./pages/register.jsp"><s:text name="register.link" /></a>
</center>
	
	<font color="red">
		<s:actionerror />
	</font>
	
<center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	Angepasst durch Sebastian Schork und Vitali Dettling, Dez. 2015
</center>

</body>
</html>