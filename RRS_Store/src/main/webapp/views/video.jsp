<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video</title>
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
	<h1 class="text-center">Video</h1>
	<div class="row">
		<form action="/home/video/search-video" method="Get">
			Seri Number:
			<input type="number" name="seri" min="0" value="${seri == null ? 0 : seri}">
			<button type="submit" class="btn btn-success">Search</button>
		</form>
		<c:if test="${not empty sessionScope.msgVideo}">
			<span class="text-danger">${sessionScope.msgVideo}</span>
			<c:remove var="msgVideo" scope="session" />
		</c:if>
	</div>
	<div class="row">
		<div class="col-sm-9">
			<table class="table bordered">
				<tr>
					<th>Id</th>
					<th>Seri</th>
					<th>Name</th>
					<th>Director</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Time</th>
					<th>Nation</th>
					<th>Edit</th>
				</tr>
				<c:forEach var="item" items="${videos}">
				<tr class="text-center">
					<td>${item.id}</td>
					<td>${item.seri}</td>
					<td>${item.name}</td>
					<td>${item.director}</td>
					<td>${item.price}</td>
					<td>${item.quantity}</td>
					<td>${item.time}</td>
					<td>${item.nation}</td>
					<td>
						<a class="btn btn-primary" href="/home/video/edit?action=update&id=${item.id}">Update</a>
						<a class="btn btn-danger" href="/home/video/edit?action=delete&id=${item.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-sm-3">
		<h3 class="text-center text-primary">Edit Form</h3>
			<form:form action="/home/video/save" method="post" modelAttribute="VideoDTO">
				<form:hidden path="id" />
				<b>Seri:</b>
				<form:input path="seri" type="number" min="0" placeholder="99999"  style="width:100%"/>
				<form:errors path="seri" element="div" cssClass="text-danger"/>
				<b>Name:</b>
				<form:input path="name" placeholder="Enter a name"  style="width:100%"/>
				<form:errors path="name" element="div" cssClass="text-danger"/>
				<b>Director:</b>
				<form:input path="director" placeholder="Enter director"  style="width:100%"/>
				<form:errors path="director" element="div" cssClass="text-danger"/>
				<b>Price:</b>
				<form:input path="price" type="number" min="0" placeholder="99999"  style="width:100%"/>
				<form:errors path="price" element="div" cssClass="text-danger"/>
				<b>Quantity:</b>
				<form:input path="quantity" type="number" min="0" placeholder="99999"  style="width:100%"/>
				<form:errors path="quantity" element="div" cssClass="text-danger"/>
				<b>Time:</b>
				<form:input path="time" type="number" min="0" placeholder="99999" style="width:100%"/>
				<form:errors path="time" element="div" cssClass="text-danger"/>
				<b>Nation:</b>
				<form:input path="nation"  placeholder="Enter nation"  style="width:100%"/>
				<form:errors path="nation" element="div" cssClass="text-danger"/>
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