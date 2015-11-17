
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>

	<div class="panel-body">
		<div class="row">
			<form action="addQuestion" method="post">
				Heading: <input type="text" name="heading"> Question: <input
					type="text" name="questionContent"> Type: <input
					type="text" name="type"> <input type="submit">
			</form>
		</div>

	</div>
</div>

<div>
	<div class="panel-body">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<spring:message
					code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
				<br />
			</div>
		</c:if>
		<form:form modelAttribute="question" action="addQuestion"
			method="post">
			<fieldset>
				<legend> Add Question </legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="form-group">
					<input class=" form:input-large"
						placeholder="Enter heading here . . ." name='heading' type="text"
						value="">
				</div>
				<div class="form-group">
					<textarea class="form:input-large"
						placeholder="Write question here . . ." name='questionContent'></textarea>
				</div>
				<div class="form-group">

					<form:select id="category" path="questionType.id">
						<form:option value="0" label="--Select Question Type" />
						<form:options items="${questionTypes}" itemLabel="name"
							itemValue="id" />
					</form:select>
				</div>

				<input class="btn" type="submit" value="Submit">
			</fieldset>
		</form:form>
	</div>
</div>
