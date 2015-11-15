
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld"%>

<div>

	<div class="panel-body">
		<div class="row">
			<c:forEach items="${questions}" var="question">
				<p>${question.questionContent}</p><span>asked by: ${question.user.username }</span>
				<span><g:dateFromNow date="${question.dateCreated}"></g:dateFromNow></span>
				<%-- <span><spring:message text="${g:getNiceTime(${question.dateCreated})}"></spring:message></span> --%>
				<c:forEach items="${answers }" var="answer">
					<p>${answer.answerContent}</p>
					<span>answered by: ${answer.user.username }</span>
					<span>${answer.dateCreated}</span>
				</c:forEach>
			</c:forEach>
		</div>

	</div>
</div>
