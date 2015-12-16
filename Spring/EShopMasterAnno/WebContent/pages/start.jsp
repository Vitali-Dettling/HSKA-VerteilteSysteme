<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="startpage.head" /></title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

	<p>
		<s:form action="LogoutAction">
			<s:submit method="execute" key="button.logout" />
		</s:form>
		<s:text name="login.status" />
		<s:property value="user.firstname" />
		<s:property value="user.lastname" />
	</p>

	<h1>
		<s:text name="startpage.title" />
	</h1>

	<h3>
		<s:text name="search.title" />
	</h3>
	<s:form action="SearchAction">
		<s:textfield name="searchValue" key="prompt.search" size="20" />
		<s:textfield name="searchMinPrice" key="prompt.price.min" size="10" />
		<s:textfield name="searchMaxPrice" key="prompt.price.max" size="10" />
		<s:submit method="execute" key="search.submit" />
	</s:form>
	<a href="<s:url action="listAllProducts" />"><s:text name="search.clear" /></a>

	<h3>
		<s:text name="products.title" />
	</h3>
	
	<s:if test="%{user.role.level==0}">   <!-- if admin -->
		<p>
			<a href="./InitCategorySiteAction.action?pageToGoTo=p"><s:text name="product.add" /></a>
			|
			<a href="./InitCategorySiteAction.action?pageToGoTo=c"><s:text name="categories.edit" /></a>
		</p>
	</s:if>
	
	<div id="startpage_products">
	<table>
		<tr class="header">
			<td><s:text name="product.nr" /></td>
			<td><s:text name="product.name" /></td>
			<td><s:text name="product.price" /></td>
			<td><s:text name="product.category" /></td>
			<td></td>
		</tr>
		<s:iterator value="products" status="rowstatus">
			<tr>			
			<s:if test="#rowstatus.odd == true">
				<td class="odd"><s:property value="#rowstatus.index+1" />
				<td class="odd"><s:property value="name" /></td>
				<td class="odd"><s:property value="price" /></td>
				<td class="odd"><s:property value="category.name" /></td>
								<td class="odd"><a href="./ProductDetailsAction.action?id=<s:property value='id'/>&searchValue=<s:property value='searchValue'/>&searchMinPrice=<s:property value='searchMinPrice'/>&searchMaxPrice=<s:property value='searchMaxPrice'/>"><img src="img/detBtn.png" alt="<s:text name="product.details" />"/></a></td>
				<s:if test="%{user.role.level==0}">
					<td class="odd"><a href="./DeleteProductAction.action?id=<s:property value='id'/>"><img src="img/delBtn.png" alt="<s:text name="product.delete" />"/></a></td>
				</s:if>
			</s:if>
			<s:else>
				<td><s:property value="#rowstatus.index+1" />
				<td><s:property value="name" /></td>
				<td><s:property value="price" /></td>
				<td><s:property value="category.name" /></td>
								<td><a href="./ProductDetailsAction.action?id=<s:property value='id'/>&searchValue=<s:property value='searchValue'/>&searchMinPrice=<s:property value='searchMinPrice'/>&searchMaxPrice=<s:property value='searchMaxPrice'/>"><img src="img/detBtn.png" alt="<s:text name="product.details" />"/></a></td>
				<s:if test="%{user.role.level==0}">
					<td><a href="./DeleteProductAction.action?id=<s:property value='id'/>"><img src="img/delBtn.png" alt="<s:text name="product.delete" />"/></a></td>
				</s:if>			
			</s:else>
			</tr>
		</s:iterator>
	</table>
	</div>

</body>
</html>
