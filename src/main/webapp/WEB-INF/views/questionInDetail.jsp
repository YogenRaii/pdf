<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld" %>

<link rel="stylesheet" href="<spring:url value="/resource/css/wall.css"/>"/>

<div>

    <div class="panel-body">
        <div class="row">
            <div class="list-todo">
                <div id="main-todo-content-${question.id}">
                    <div class="todoheader">
                        <h3>${question.heading }</h3>
                        <span>Question Category: ${question.questionType.name}</span>
                        <p>${question.questionContent}</p>


                        <div class="todoimg">
                            <img src="<c:url value="/resource/images/todo.png" />"/>
                        </div>
                        <div class="userinfo">
                            asked by: ${question.user.username} <span><g:dateFromNow
                                date="${question.dateCreated}"></g:dateFromNow></span>
                        </div>


                        <c:forEach items="${question.answers }" var="answer">

                            <div class="delete-comment-container"
                                 id="delete-comment-${answer.id}">
                                <div class="comment-image">
                                    <img src="<c:url value="/resource/images/user.png" />">
                                </div>
                                <div class="comment-text-main">
                                    <div class="comment-text"
                                         id="comment-text-${answer.id}">${answer.answerContent}</div>
                                    <div class="userinfo">
                                        Answered by: ${answer.user.username} <span><g:dateFromNow
                                            date="${answer.dateCreated}"></g:dateFromNow></span>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>


        </div>

    </div>
</div>
