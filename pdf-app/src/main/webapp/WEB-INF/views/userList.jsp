<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
      href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src="<spring:url value="/resource/js/user.js" />" type="text/javascript"></script>

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
                        <h3>${user.username}</h3>
                        <p>ID: ${user.email }</p>
                            <%-- <p>${product.description}</p> --%>
                        <p class="user-details" id="${user.id }">
						<span class="btn btn-primary"
                              class="glyphicon-info-sign glyphicon"> Details</span>

                                <%-- <a href=" <spring:url value='/users/user?id=${user.id}' /> "
                                    class="btn btn-primary"> <span
                                    class="glyphicon-info-sign glyphicon" /></span> Details
                                </a> --%>
                        </p>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<div id="user-detail" title="User Detail" style="display: none;">

</div>
