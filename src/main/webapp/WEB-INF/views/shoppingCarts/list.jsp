<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/"/>
</head>
<body>
	<h2>Shopping Cart</h2>
	<hr />
	<table>
		<tr>
			<td>No.</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Action</td>
		</tr>
		<c:set var="no" value="1"></c:set>
		<c:forEach items="${cartItems}" var="item">
			<form action="shoppingCart/update">
				<tr>
					<td>${no }</td>
					<td>${item.name }</td>
					<td><input type="number" value="${item.quantity }"
						name="quantity" onblur="this.form.submit()" /></td>
					<td>${item.price}</td>
					<td><a href="shoppingCart/remove/${item.productId}">Remove</a>
					</td>
				</tr>
			</form>
			<c:set value="${no+1}" var="no"></c:set>
		</c:forEach>
	</table>
</body>
</html>