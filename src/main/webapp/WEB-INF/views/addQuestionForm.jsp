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
        <form:form modelAttribute="question" action="addQuestion"
                   method="post">
            <fieldset>
                <legend> Add Question</legend>

                    <%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>

                <div class="form-group">
                    <p>Question heading</p>
                    <input style="width: 525px;" class=" form:input-large"
                           placeholder="Enter heading here . . ." name='heading' type="text"
                           value="">
                    <p><form:errors path="heading" cssClass="alert alert-danger"/></p>
                </div>
                <div class="form-group">
                    <p>Question</p>
                    <textarea rows="6" cols="70" class="form:input-large"
                              placeholder="Write question here . . ." name='questionContent'></textarea>
                    <p><form:errors path="questionContent" cssClass="alert alert-danger"/></p>
                </div>
                <div class="form-group">
                    <p>Choose Question Type</p>
                    <form:select id="category" path="questionType.id">
                        <form:option value="0" label="--Select Question Type"/>
                        <form:options items="${questionTypes}" itemLabel="name"
                                      itemValue="id"/>
                    </form:select>
                </div>

                <input class="btn" type="submit" value="Submit">
            </fieldset>
        </form:form>
    </div>
</div>
