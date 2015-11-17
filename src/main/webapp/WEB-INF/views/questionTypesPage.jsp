
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld"%>

<div>

	<div class="panel-body">
		<div class="row">
			<c:forEach items="${questionTypes}" var="questionType">
			<h3>${questionType.name }</h3>
				<p>${questionType.description}</p>
			</c:forEach>
		</div>

	</div>
</div>
