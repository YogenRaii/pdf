<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<div>

    <div class="panel-body">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <spring:message
                        code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
                <br/>
            </div>
        </c:if>
        <form:form modelAttribute="user" action="${url}" method="post">
            <fieldset>
                <legend>
                    <c:choose>
                        <c:when test="${not empty admin}">Add Admin</c:when>
                        <c:otherwise>Sign Up</c:otherwise>
                    </c:choose>
                </legend>

                <div class="form-group">
                    <input class="form:input-large" placeholder="User Name"
                           name='username' type="text"><form:errors path="username" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <input class=" form:input-large" placeholder="Password"
                           name='password' type="password" value=""><form:errors path="password"
                                                                                 cssClass="alert alert-danger"></form:errors>
                </div>

                <div class="form-group">
                    <input class=" form:input-large" placeholder="Email" name='email'
                           type="text" value=""><form:errors path="email" cssClass="alert alert-danger"/>
                </div>
                <input class="btn" type="submit" value="Register Now">
            </fieldset>
        </form:form>
    </div>
</div>