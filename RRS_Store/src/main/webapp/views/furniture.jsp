<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Furniture</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
		<ul class="nav bg-warning">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/home"><b>Home</b></a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/home/video"><b>Video</b></a></li>
			<li class="nav-item"><a class="nav-link" href="/home/book-on-tape"><b>Book On Tape</b></a></li>
			<li class="nav-item"><a class="nav-link" href="/home/furniture"><b>Furniture</b></a></li>
		</ul>
	<h1>Video</h1>
	<div class="row">
		<form action="/home/furniture/search-furniture" method="Get">
			<b>Seri Number Of Furniture:</b>
			<input type="number" name="seri" min="0" value="${seri == null ? 0 : seri}">
			<button type="submit" class="btn btn-success">Search</button>
		</form>
		<c:if test="${not empty sessionScope.msgFurniture}">
			<span class="text-danger">${sessionScope.msgFurniture}</span>
			<c:remove var="msgFurniture" scope="session" />
		</c:if>
	</div>
	<div class="row">
		<div class="col-sm-9">
			<table class="table bordered">
				<tr>
					<th>Id</th>
					<th>Seri</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Color</th>
					<th>Material</th>
					<th>Width</th>
					<th>Height</th>
					<th>Edit</th>
				</tr>
				<c:forEach var="item" items="${furnitures}">
				<tr class="text-center">
					<td>${item.id}</td>
					<td>${item.seri}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.quantity}</td>
					<td>${item.color}</td>
					<td>${item.material}</td>
					<td>${item.width}</td>
					<td>${item.height}</td>
					<td>
						<a class="btn btn-primary" href="/home/furniture/edit?action=update&id=${item.id}">Update</a>
						<a class="btn btn-danger" href="/home/furniture/edit?action=delete&id=${item.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-sm-3">
			<form:form action="/home/furniture/save" method="post" modelAttribute="FurnitureDTO">
				<form:hidden path="id" />
				Seri:
				<form:input path="seri" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="seri" element="div" cssClass="text-danger"/>
				Name:
				<form:input path="name" placeholder="Enter name" style="width:100%"/>
				<form:errors path="name" element="div" cssClass="text-danger"/>
				Price:
				<form:input path="price" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="price" element="div" cssClass="text-danger"/>
				Quantity:
				<form:input path="quantity" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="quantity" element="div" cssClass="text-danger"/>
				Color:
				<form:input path="color" placeholder="Enter color" style="width:100%"/>
				<form:errors path="color" element="div" cssClass="text-danger"/>
				Material:
				<form:input path="material" placeholder="Enter material" style="width:100%"/>
				<form:errors path="material" element="div" cssClass="text-danger"/>
				Width:
				<form:input path="width" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="width" element="div" cssClass="text-danger"/>
				Height:
				<form:input path="height" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="height" element="div" cssClass="text-danger"/>
				<div class="mt-3">
					<button class="btn btn-primary" type="submit" style="width: 100px" >Save</button>
					<button class="btn btn-warning" type="reset" style="width: 100px"  >Reset</button>
				</div>
			</form:form>
		</div>
	</div>
	</div>
</body>
</html>