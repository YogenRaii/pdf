<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div>
    <div class="panel-body">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <spring:message
                        code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
                <br/>
            </div>
        </c:if>
        <form:form modelAttribute="questionType" action="addQuestionType"
                   method="post">
            <fieldset>
                <legend> Add Question Type</legend>

                    <%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>

                <div class="form-group">
                    <p>Question Type Name</p>
                    <input style="width: 525px;" class=" form:input-large"
                           placeholder="Enter question Type here . . ." name='name' type="text"
                           value="">
                    <p><form:errors path="name" cssClass="alert alert-danger"/></p>
                </div>
                <div class="form-group">
                    <p>Question Type Description</p>
                    <textarea rows="6" cols="70" class="form:input-large"
                              placeholder="Write question Type description here . . ." name='description'></textarea>
                    <p><form:errors path="description" cssClass="alert alert-danger"/></p>
                </div>

                <input class="btn" type="submit" value="Submit">
            </fieldset>
        </form:form>
    </div>
</div>
