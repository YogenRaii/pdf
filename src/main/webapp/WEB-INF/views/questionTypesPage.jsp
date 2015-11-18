
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src="/pdf/resource/js/questionType.js" type="text/javascript"></script>


<link rel="stylesheet" href="/pdf/resource/css/questionType.css">

<div>

	<div class="panel-body">
		<div class="row">
			<c:forEach items="${questionTypes}" var="questionType">
				<div class="delete-questionType-container"
					id="delete-questionType-${questionType.id}">
					<c:if test="${role eq 'admin' }">
						<div class="questionType-delete-img" id="${questionType.id}">
							<img src="<c:url value="/resource/images/delete.png" />">
						</div>
						<div class="update-questionType" id="${questionType.id}">
							<img src="<c:url value="/resource/images/edit.png" />">
						</div>

					</c:if>
					
					<div class="questionType-image">
						<img src="<c:url value="/resource/images/todo.png" />">
					</div>
					<div class="questionType-text-main">
						<div id="heading">
							<h4>${questionType.name}</h4>
						</div>
						<div class="questionType-text"
							id="questionType-text-${questionType.id}">
							<p>${questionType.description}</p>
						</div>
					</div>

					
				</div>


				<%-- <h3>${questionType.name }</h3>
				<p>${questionType.description}</p> --%>
			</c:forEach>
		</div>

	</div>
</div>

<div id="dialog-confirm" title="Delete Question Type?" style="display: none">
	<p>
		<span class="ui-icon ui-icon-alert"
			style="float: left; margin: 0 7px 20px 0;"></span>Do you want to
		delete this Question Type?
	</p>
</div>

<div id="dialog-update-questionType" title="Update Question Type"
	style="display: none">
	<form>
		<fieldset>
			<label for="question">Question Type</label>
			<textarea name="questionType" id="questionType"
				class="text ui-widget-content ui-corner-all">
            </textarea>
		</fieldset>
	</form>
</div>

