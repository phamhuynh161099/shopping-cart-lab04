<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/"> 
</head>
<body>
	<table>
		<tr>
			<td>Product Id</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Action</td>
		</tr>
		<c:forEach var="item" items="${products}">
			<tr>
				<td>${item.productId}</td>
				<td>${item.name}</td>
				<td>${item.price }</td>
				<td>${item.quantity}</td>
				<td>
					<a href="shoppingCart/add/${item.productId}">Add to cart</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>