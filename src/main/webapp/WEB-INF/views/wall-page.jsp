
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="/pdf/resource/js/wall.js" type="text/javascript"></script>
<link rel="stylesheet" href="/pdf/resource/css/wall.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<div>

	<div class="panel-body">
		<div class="row">
			<div class="row welcome">
				<h1>Welcome ${currentUser} to PDF</h1>
			</div>
			<ul id="sortable" class="list-unstyled">
				<c:forEach items="${questions}" var="question">
					<li class="list-todo">
						<div id="main-todo-content-${question.id}">
							<div class="todoheader">

								<div class="deleteimage" id="${question.id}">
									<img src="<c:url value="/resource/images/delete.png" />">
								</div>
								<div class="update-question" id="<?=$key?>">
									<img src="<c:url value="/resource/images/edit.png" />">
								</div>

								<div class="done-or-not">
									<label><input type="checkbox" value="0" id="${question.id}">Done</label>
								</div>

								<div class="todoimg">
									<img src="<c:url value="/resource/images/todo.png" />" />
									<div id="question-${question.id}">
										<h4>${question.heading}</h4>
										${question.questionContent}
									</div>
								</div>
								<div id="comment-textarea-${question.id}">
									<textarea rows="2" cols="50"></textarea>
								</div>
								<div>
									<button class="comment-btn btn-sm btn-success"
										id="${question.id}">Comment</button>
								</div>

								<div id="comments-${question.id}">

									<c:forEach items="${question.answers}" var="answer">
										<div class="delete-comment-container"
											id="delete-comment-${answer.id}">
											<div class="comment-image">
												<img src="<c:url value="/resource/images/user.png" />">
											</div>
											<div class="comment-text-main">
												<div class="userinfo">Answered by:
													${answer.user.username}</div>
												<div class="comment-text" id="comment-text-<?=$k?>">${answer.answerContent}</div>
											</div>

											<div class="comment-delete-img" id="${answer.id}">
												<img src="<c:url value="/resource/images/delete.png" />">
											</div>
											<div class="update-comment" id="${answer.id}">
												<img src="<c:url value="/resource/images/edit.png" />">
											</div>

										</div>


									</c:forEach>

								</div>

							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="no-task">No Task to do yet</div>

		</div>

	</div>
</div>
