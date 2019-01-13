<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="g" uri="/WEB-INF/date-format-tag.tld" %>

<link rel="stylesheet" href="<spring:url value="/resource/css/wall.css" />"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src="<spring:url value="/resource/js/wall.js" />" type="text/javascript"></script>

<div>

    <div class="panel-body">
        <div class="row">
            <%-- <div class="row welcome">
                <h1>Welcome ${currentUser} to PDF</h1>
            </div> --%>
            <ul id="sortable" class="list-unstyled" style="list-style: none;">
                <c:forEach items="${questions}" var="question">

                    <li class="list-todo">
                        <div id="main-todo-content-${question.id}">
                            <div class="todoheader">
                                <input type="hidden" id="user_id" value="${	question.user.id }">
                                <input type="hidden" id="username"
                                       value="${question.user.username }">

                                <!-- check if question belongs to current user -->
                                <c:if test="${question.user.id eq currentUserId }">

                                    <div class="deleteimage" id="${question.id}">
                                        <img src="<c:url value="/resource/images/delete.png" />">
                                    </div>
                                    <div class="update-question" id="${question.id}">
                                        <img src="<c:url value="/resource/images/edit.png" />">
                                    </div>
                                </c:if>

                                <div class="todoimg">
                                    <img src="<c:url value="/resource/images/todo.png" />"/>
                                </div>
                                <div class="userinfo">
                                    asked by: ${question.user.username} <span><g:dateFromNow
                                        date="${question.dateCreated}"></g:dateFromNow></span>
                                </div>
                                <div>
                                    <div id="heading">
                                        <h4>${question.heading}</h4>
                                    </div>
                                    <div id="question-${question.id}">

                                            ${question.questionContent}</div>
                                </div>
                                    <%-- <div id="comment-textarea-${question.id}">
                                        <textarea rows="2" cols="50"></textarea>
                                    </div>
                                    <div>
                                        <button class="comment-btn btn-sm btn-success"
                                            id="${question.id}">Comment</button>
                                    </div> --%>

                                <div id="comments-${question.id}">

                                    <c:forEach items="${question.answers}" var="answer">
                                        <div class="delete-comment-container"
                                             id="delete-comment-${answer.id}">
                                            <div class="comment-image">
                                                <img src="<c:url value="/resource/images/user.png" />">
                                            </div>
                                            <div class="comment-text-main">
                                                <div class="comment-text"
                                                     id="comment-text-${answer.id}">${answer.answerContent}</div>
                                                <div class="userinfo">Answered by:
                                                        ${answer.user.username}
                                                    <span><g:dateFromNow
                                                            date="${answer.dateCreated}"></g:dateFromNow></span>
                                                </div>
                                            </div>

                                            <c:if test="${answer.user.id eq currentUserId }">
                                                <div class="comment-delete-img" id="${answer.id}">
                                                    <img src="<c:url value="/resource/images/delete.png" />">
                                                </div>
                                                <div class="update-comment" id="${answer.id}">
                                                    <img src="<c:url value="/resource/images/edit.png" />">
                                                </div>
                                            </c:if>
                                        </div>
                                    </c:forEach>

                                </div>
                                <div id="comment-textarea-${question.id}">
                                    <textarea rows="2" cols="50"></textarea>
                                </div>
                                <div>
                                    <button class="comment-btn btn-sm btn-success"
                                            id="${question.id}">Submit Answer
                                    </button>
                                </div>

                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <!-- <div class="no-task">No Task to do yet</div> -->

        </div>

    </div>
</div>
<div id="dialog-confirm" title="Delete Question?" style="display: none">
    <p>
		<span class="ui-icon ui-icon-alert"
              style="float: left; margin: 0 7px 20px 0;"></span>Do you want to
        delete this Question?
    </p>
</div>

<div id="dialog-update-question" title="Update Question"
     style="display: none">
    <form>
		<textarea name="question" id="question"
                  class="text ui-widget-content ui-corner-all">
        </textarea>
    </form>
</div>

<div id="dialog-confirm-answer" title="Delete Answer?" style="display: none">
    <p>
		<span class="ui-icon ui-icon-alert"
              style="float: left; margin: 0 7px 20px 0;"></span>Do you want to
        delete this Answer?
    </p>
</div>

<div id="dialog-update-answer" title="Update Answer"
     style="display: none">
    <form>
        <fieldset>
            <label for="answer">Answer</label>
            <textarea name="answer" id="answer"
                      class="text ui-widget-content ui-corner-all">
            </textarea>
        </fieldset>
    </form>
</div>


