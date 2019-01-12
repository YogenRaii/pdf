<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authorize access="isAnonymous()">
    <li><a href="<spring:url value="/"/>"><spring:message
            code="navigation.home.label"/></a></li>
    <li><a href="<spring:url value="/forum/"/>"><spring:message
            code="navigation.forum.label"/></a></li>
</security:authorize>

<li><a href="<spring:url value="/users/"/>"><spring:message
        code="navigation.users.label"/></a></li>

<security:authorize access="isAuthenticated()">
    <li><a href="<spring:url value="/wallPage"/>"><spring:message
            code="navigation.forum.label"/></a></li>
    <li><a href="<spring:url value="/profile/${currentUserId}"/>"><spring:message
            code="navigation.Profile.label"/></a></li>
     <li><a href="<spring:url value="/questionTypes"/>"><spring:message
                code="navigation.types.label" /></a></li>
</security:authorize>

<security:authorize access="hasRole('USER')">
    <li><a href="<spring:url value="/questions/add"/>"><spring:message
            code="navigation.addQuestion.label"/></a></li>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
     <li><a href="<spring:url value="/questionTypes/add"/>"><spring:message
                code="navigation.questionType.label" /></a></li>
    <li><a href="<spring:url value="/users/adminList"/>"><spring:message
            code="navigation.allAdmins.label"/></a></li>

    <li><a href="<spring:url value="/users/addAdminForm"/>"><spring:message
            code="navigation.addAdmin.label"/></a></li>
</security:authorize>

<security:authorize access="isAuthenticated()">
    <li><a href="<spring:url value="/doLogout"/>"><spring:message
            code="navigation.logout.label"/></a></li>
</security:authorize>

<security:authorize access="isAnonymous()">
    <li><a href="<spring:url value="/users/signupForm"/>"><spring:message
            code="navigation.signup.label"/></a></li>
</security:authorize>

<security:authorize access="isAnonymous()">
    <li><a href="<spring:url value="/login"/>"><spring:message
            code="navigation.login.label"/></a></li>
</security:authorize>