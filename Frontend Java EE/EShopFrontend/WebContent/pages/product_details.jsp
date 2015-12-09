<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="details.head" /></title>
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
		<s:text name="details.title" />
	</h2>

	<table>
		<tr>
			<td><s:text name="details.name" /></td>
			<td><s:property value="product.name" /></td>
		</tr>
		<tr>
			<td><s:text name="details.price" /></td>
			<td><s:property value="product.price" /></td>
		</tr>
		<tr>
			<td><s:text name="details.category" /></td>
			<td><s:property value="product.category.name" /></td>
		</tr>
		<tr>
			<td><s:text name="details.details" /></td>
			<td><s:property value="product.details" /></td>
		</tr>
	</table>
	<br />

	<a href="./SearchAction.action?id=<s:property value='id'/>&searchValue=<s:property value='searchValue'/>&searchMinPrice=<s:property value='searchMinPrice'/>&searchMaxPrice=<s:property value='searchMaxPrice'/>">[<s:text name="link.back" />]</a>

</body>
</html>