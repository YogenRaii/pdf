<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/login.js" type="text/javascript"></script>

<%-- <h1>Sign Up</h1>
	<form:form modelAttribute="user" action="signup" method="post">
	<form:input path="userName"/>
	<form:input path="password"/>
	<input type="submit"/>
	</form:form> --%>

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

                    <%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>

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


<%-- <div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form:form modelAttribute="user" action="signup" method="post">
								<div class="form-group">
									<input type="text" name="username" id="username" tabindex="1"
										class="form-control" placeholder="Username" value="">
								</div>
								<div class="form-group">
									<input type="email" name="email" id="email" tabindex="1"
										class="form-control" placeholder="Email Address" value="">
								</div>
								<div class="form-group">
									<input type="password" name="password" id="password"
										tabindex="2" class="form-control" placeholder="Password">
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" name="register-submit"
												id="register-submit" tabindex="4"
												class="form-control btn btn-register" value="Register Now">
										</div>
									</div>
								</div>
							</form:form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> --%>