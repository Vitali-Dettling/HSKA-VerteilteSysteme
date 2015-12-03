<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="product.add.head" /></title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<p>
		<s:form action="LogoutAction">
			<s:submit method="execute" key="button.logout" />
		</s:form>
		<s:text name="login.status" />
		<s:property value="user.name" />
		<s:property value="user.lastname" />
	</p>

	<h2>
		<s:text name="product.add.title" />
	</h2>

	<s:form action="AddProductAction" focusElement="title">
		<s:textfield name="name" key="product.prompt.name" size="20" required="true" />
		<s:textfield name="price" key="prompt.price" size="20" required="true" />
		<s:select name="categoryId" key="prompt.category" list="categories" listKey="id" listValue="name" value="%{categories.{name}}" required="true" />
		<s:textarea name="details" key="prompt.details" cols="15" rows="3" />
		<s:submit method="execute" key="product.submit" />
		<s:reset key="product.reset" />
	</s:form>

	<font color="red">
		<s:actionerror />
	</font>

	<br />
	<a href="<s:url action="listAllProducts"></s:url>"><s:text name="link.back" /></a>
</body>
</html>