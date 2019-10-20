<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <script src="../../js/main.js"></script>
    <meta charset="UTF-8">
    <fmt:message key="title.user.info" var="pageTitle"/>
    <fmt:message key="label.user.login" var="loginLabel"/>
    <fmt:message key="label.user.password" var="passwordLabel"/>
    <fmt:message key="label.user.confirmPassword" var="confirmPasswordLabel"/>
    <fmt:message key="label.user.name" var="nameLabel"/>
    <fmt:message key="label.users.role" var="roleLabel"/>
    <fmt:message key="button.save" var="save"/>
    <fmt:message key="button.cancel" var="cancel"/>

    <fmt:message key="format.user.login" var="loginFormat"/>
    <fmt:message key="format.user.password" var="passwordFormat"/>
    <fmt:message key="format.user.name" var="nameFormat"/>
    <fmt:message key="message.user.wrongData" var="wrongDataMessage"/>


    <title>"${pageTitle}"</title>
</head>
<body>
<div class="container">
    <div class="input-container">
        <h1>${pageTitle}</h1>
        <form name="loginForm" method="post" action="app">
            <input type="hidden" name="command" value="userupdate">
            <input type="hidden" name="id" value="${requestScope.user.id}">

            <span>${loginLabel}</span>
            <input type="text" name="login" maxlength="32" disabled
                   pattern="[A-Za-z0-9._]{4,32}" title="${loginFormat}" required value="${requestScope.user.login}">


            <span>${passwordLabel}</span>
            <input type="password" name="password" maxlength="32" id="pass1"
            pattern="[^<>]{8,32}" title="${passwordFormat}" required
                   value="${requestScope.user.password}">

            <span>${confirmPasswordLabel}</span>
            <input type="password" name="confirm" maxlength="32" id="pass2"
            pattern="[^<>]{8,32}" title="${passwordFormat}" onkeyup="checkPass()"
                   required value="${requestScope.user.password}">

            <span>${nameLabel}</span>
            <input type="text" name="name" maxlength="32"
                   pattern="[^<>]{8,32}" title="${nameFormat}" required value="${requestScope.user.name}">

            <span>${roleLabel}</span>
            <select name="role" id="role">
                <c:forEach items="${requestScope.roleList}" var="roleOption">
                    <c:choose>
                        <c:when test="${requestScope.user.role == roleOption}">
                            <option value="${roleOption}" selected><fmt:message key="${roleOption}"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="${roleOption}"><fmt:message key="${roleOption}"/></option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <script></script>

            <input class="button button-blue" type="submit" value="${save}">

            <c:if test="${not empty requestScope.wrongData}">
                <span class="errorMsg">
                    ${wrongDataMessage}: ${requestScope.wrongData}
                </span>
            </c:if>

        </form>
        <form action="home">
            <input class="button button-gray" type="submit" value="${cancel}">
        </form>

        <c:if test="${sessionScope.currentUser.role != 'ADMIN'}">
            <script>disableRoleDropdown()</script>
        </c:if>
    </div>
</div>
</body>
</html>