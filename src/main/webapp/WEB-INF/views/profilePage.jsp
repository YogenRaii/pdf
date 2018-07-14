<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<spring:url value="/resource/css/profile.css" />" type="text/css" rel="stylesheet"/>
<div>
    <% Integer userId = (Integer) (session.getAttribute("userId")); %>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            <spring:message
                    code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
            <br/>
        </div>
    </c:if>

    <form:form action="/pdf/profile/portrait/${profile.id}"
               enctype="multipart/form-data" method="post">
        <fieldset class="portrait">
            <!--<legend>My Picture</legend>-->
            <c:choose>
                <c:when test="${empty profile.portrait}">
                    <img src="<c:url value="/resource/images/user.png" />" width="130" alt="profile picture"> <br/>
                </c:when>
                <c:otherwise>
                    <img src="${profile.portrait}" width="130" width="130" alt="profile picture"> <br/>
                </c:otherwise>
            </c:choose>
            <!--<img src="<c:url value="/resource/images/user.png" />" width="130"
				alt="profile picture"> <br /> -->
            <c:choose>
                <c:when test="${operation eq 'edit' }">
                    <input type="file" name="image">
                    <input type="submit" value="Submit"/>
                </c:when>
                <c:otherwise>
                    <c:if test="${profile.id == userId}">
                        <a class="edit" href="<spring:url value="/profile/edit/${profile.id}"/>">Edit Portrait</a>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </fieldset>
    </form:form>

    <c:choose>
        <c:when test="${operation eq 'edit' }">
            <form:form action="/pdf/profile/edit/${profile.id}" modelAttribute="profile" method="post">

                <fieldset class="profile">
                    <!--<legend>My Profile</legend>-->
                    <strong>FirstName: </strong><input type="text" name="firstName"
                                                       value="${profile.firstName}" size="16"/> <form:errors
                        path="firstName" cssClass="alert alert-danger"/><br/>

                    <strong>LastName:</strong><input type="text" name="lastName" value="${profile.lastName}"
                                                     size="16"/> <form:errors path="lastName"
                                                                              cssClass="alert alert-danger"/><br/>

                    <strong>Address: </strong><input type="text"
                                                     name="address" value="${profile.address}" size="16"/> <form:errors
                        path="address" cssClass="alert alert-danger"/><br/>

                    <strong>Gender:
                    </strong> <label><input type="radio" name="gender" value="M"
                                            <c:if test="${profile.gender != 'F'}">checked</c:if> /> Male</label> <label><input
                        type="radio" name="gender" value="F"
                        <c:if test="${profile.gender == 'F'}">checked</c:if> /> Female</label> <br/>

                    <strong>Birthday: </strong><input type="date" name="dateOfBirth"
                                                      value="${profile.dateOfBirth}" size="8" maxlength="8"/>
                    <form:errors path="dateOfBirth" cssClass="alert alert-danger"/><br/>
                    <strong>Occupation:</strong> <select name="occupation">
                    <option
                            <c:if test="${profile.occupation == 'Engineer'}">selected</c:if>>Engineer
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Teacher'}">selected</c:if>>Teacher
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Student'}">selected</c:if>>Student
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Doctor'}">selected</c:if>>Doctor
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Technician'}">selected</c:if>>Technician
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Architect'}">selected</c:if>>Architect
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Lawyer'}">selected</c:if>>Lawyer
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Merchant'}">selected</c:if>>Merchant
                    </option>
                    <option
                            <c:if test="${profile.occupation == 'Accounting'}">selected</c:if>>Accounting
                    </option>
                </select> <br/> <input type="submit" value="Submit"/>
                </fieldset>

            </form:form>
        </c:when>
        <c:otherwise>
            <form>
                <fieldset class="profile">
                    <!--<legend>My Profile</legend>-->
                    <strong>FirstName: </strong>
                    <c:if test="${profile.firstName != 'NULL' }">
                        <span> ${profile.firstName}</span>
                    </c:if>
                    <br>
                    <strong>LastName: </strong>
                    <c:if test="${profile.lastName != 'NULL' }">
                        <span> ${profile.lastName}</span>
                    </c:if>
                    <br>
                    <strong>Address: </strong>
                    <c:if test="${profile.address != 'NULL' }">
                        <span> ${profile.address}</span>
                    </c:if>
                    <br>
                    <strong>Gender:</strong>
                    <c:if test="${profile.gender != 'NULL' }">
                        <span> ${profile.gender}</span>
                    </c:if>
                    <br>
                    <strong>Birthday:</strong>
                    <span>${profile.dateOfBirth}</span> <br/>
                    <strong>Occupation:</strong>
                    <c:if test="${profile.occupation != 'NULL' }">
                        <span> ${profile.occupation}</span>
                    </c:if>
                    <br>
                    <!--<strong>Potrait: </strong><span>${profile.portrait}</span>-->


                    <c:if test="${profile.id == userId}">
                        <a class="edit" href="<spring:url value="/profile/edit/${profile.id}"/>">Edit Profile</a>
                    </c:if>
                </fieldset>
            </form>
        </c:otherwise>
    </c:choose>

</div>



