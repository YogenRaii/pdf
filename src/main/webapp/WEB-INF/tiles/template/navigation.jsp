<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<li><a href="<spring:url value="/"/>"><spring:message
			code="navigation.home.label" /></a></li>
<li><a href="<spring:url value="/forum/"/>"><spring:message
			code="navigation.forum.label" /></a></li>
<security:authorize access="isAuthenticated()">
	<li><a href="<spring:url value="/questions/add"/>"><spring:message
				code="navigation.addQuestion.label" /></a></li>

	<li><a href="<spring:url value="/categories/"/>"><spring:message
				code="navigation.categories.label" /></a></li>
	<li><a href="<spring:url value="/categories/add"/>"><spring:message
				code="navigation.category.label" /></a></li>
</security:authorize>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<li><a href="<spring:url value="/users/"/>"><spring:message
				code="navigation.users.label" /></a></li>
	<li><a href="<spring:url value="/users/add"/>"><spring:message
				code="navigation.user.label" /></a></li>
</security:authorize>

<security:authorize access="isAuthenticated()">
	<li><a href="<spring:url value="/logout"/>"><spring:message
				code="navigation.logout.label" /></a></li>
</security:authorize>

<security:authorize access="isAnonymous()">
<li><a href="<spring:url value="/users/signupForm"/>"><spring:message
			code="navigation.signup.label" /></a></li>

</security:authorize>

<security:authorize access="isAnonymous()">
	<li><a href="<spring:url value="/login"/>"><spring:message
				code="navigation.login.label" /></a></li>
</security:authorize>