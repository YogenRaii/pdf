
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>

	<div class="panel-body">
		<div class="row">
			<form action="addQuestion" method="post">
			Heading: <input type="text" name="heading">
				Question: <input type="text" name="questionContent"> Type: <input
					type="text" name="type"> <input type="submit">
			</form>
		</div>

	</div>
</div>
