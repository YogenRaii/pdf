<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<%-- <form method="get" action="users/user">
		<p>
			Search User:<input type="text" id="id" name="id" placeholder="Enter Id or First Name"><input
				type="submit" value="Search" />
		</p>
	</form> --%>
	
	<div class="row">
		<c:forEach items="${userList}" var="user">
			<div class="item" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${user.username} ${user.password}</h3>
						<p>ID: ${user.email }</p>
						<%-- <p>${product.description}</p> --%>
						<p>
							<a href=" <spring:url value='/users/user?id=${user.id}' /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
