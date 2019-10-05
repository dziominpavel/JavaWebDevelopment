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
    <fmt:message key="title.login" var="pageTitle"/>
    <fmt:message key="label.login" var="loginLabel"/>
    <fmt:message key="label.password" var="passwordLabel"/>
    <fmt:message key="label.confirmPassword" var="confirmPasswordLabel"/>
    <fmt:message key="label.name" var="nameLabel"/>
    <fmt:message key="label.registration" var="registration"/>
    <fmt:message key="format.login" var="loginFormat"/>
    <fmt:message key="format.password" var="passwordFormat"/>
    <fmt:message key="format.authFailMessage" var="authFailMesage"/>
    <fmt:message key="format.name" var="nameFormat"/>


    <title>${pageTitle}</title>
</head>
<body>
<div class="container">
    <div class="input-container">
        <form name="loginForm" method="post" action="app">
            <input type="hidden" name="command" value="register">
            <span>${loginLabel}</span>
            <input type="text" name="login" maxlength="16"
                   pattern="[A-Za-z0-9._]{4,}" title="${loginFormat}" required>
            <span>${passwordLabel}</span>
            <input type="password" name="password" maxlength="32" id="pass1"
                   pattern="[^<>]{8,}" title="${passwordFormat}" required>
            <span>${confirmPasswordLabel}</span>
            <input type="password" name="confirm" maxlength="32" id="pass2"
                   pattern="[^<>]{8,}" title="${passwordFormat}" onkeyup="checkPass()" required>
            <span>${nameLabel}</span>
            <input type="text" name="name" maxlength="32"
                   pattern="[^<>]{8,}" title="${nameFormat}" required>

            <input class="button button-gray" type="submit" value="${registration}">
            <c:choose>
                <c:when test="${not empty requestScope.dataExists}">
                    ${registerFailMessage}
                </c:when>
                <c:when test="${not empty requestScope.wrongData}">
                    ${passwordsDoNotMatch}
                </c:when>
            </c:choose>

        </form>
    </div>
</div>
</body>
</html>