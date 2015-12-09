<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="categories.head" /></title>
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
		<s:text name="categories.title" />
	</h2>

	<!-- Form to add a new Category in DB: -->
	<s:form action="AddCategoryAction">
		<s:textfield name="newCatName" key="prompt.catname" size="20" required="true" />
		<s:submit method="execute" key="category.submit" />
	</s:form>

	<font color="red"> <s:actionerror />
	</font>

	<div id="categories">
		<table>
			<tr class="header">
				<td><s:text name="categories.nr" /></td>
				<td><s:text name="categories.name" /></td>
				<td></td>
			</tr>
			<s:iterator value="categories" status="rowstatus">
				<tr>
				<s:if test="#rowstatus.odd == true">
					<td class="odd"><s:property value="id" />
					<td class="odd"><s:property value="name" /></td>
					<td class="odd"><a href="<s:url action="DeleteCategoryAction"><s:param name="catId" value="id" /></s:url>"><img src="img/delBtn.png" alt="<s:text name="product.delete" />"/></a></td>
				</s:if>
				<s:else>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><a href="<s:url action="DeleteCategoryAction"><s:param name="catId" value="id" /></s:url>"><img src="img/delBtn.png" alt="<s:text name="product.delete" />"/></a></td>
					<td><s:form action ="DeleteCategoryAction" >
							<s:hidden name="catId" value="%{id}" />
							<s:submit value="loeschen"/>
						</s:form>
						</td>
				</s:else>
				</tr>
			</s:iterator>
			
		</table>
	</div>
	<br />
	<a href="<s:url action="listAllProducts"></s:url>"><s:text name="link.back" /></a>

</body>
</html>