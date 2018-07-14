<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld" %>

<div>

    <div class="panel-body">
        <div class="row">
            <c:forEach items="${questions}" var="question">
                <a href='<spring:url value="/questions/question/${question.id}"></spring:url>'>
                    <h3>${question.heading }</h3></a>
                <p>${question.questionContent}</p>
                <span>asked by: ${question.user.username }</span>
                <span><g:dateFromNow date="${question.dateCreated}"></g:dateFromNow></span>

            </c:forEach>
        </div>

    </div>
</div>
