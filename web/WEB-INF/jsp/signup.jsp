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
    <fmt:message key="title.signup" var="pageTitle"/>
    <fmt:message key="label.user.login" var="loginLabel"/>
    <fmt:message key="label.user.password" var="passwordLabel"/>
    <fmt:message key="label.user.confirmPassword" var="confirmPasswordLabel"/>
    <fmt:message key="label.user.name" var="nameLabel"/>
    <fmt:message key="button.user.save" var="save"/>
    <fmt:message key="format.user.login" var="loginFormat"/>
    <fmt:message key="format.user.password" var="passwordFormat"/>
    <fmt:message key="format.user.name" var="nameFormat"/>
    <fmt:message key="message.user.wrongData" var="userWrongData"/>


    <title>${pageTitle}</title>
</head>
<body>
<div class="container">
    <div class="input-container">
        <form name="loginForm" method="post" action="app">
            <input type="hidden" name="command" value="register">

            <span>${loginLabel}</span>
            <input type="text" name="login" maxlength="32"
                   pattern="[A-Za-z0-9._]{4,32}" title="${loginFormat}" required>

            <span>${passwordLabel}</span>
            <input type="password" name="password" maxlength="32" id="pass1"
                   pattern="[^<>]{8,32}" title="${passwordFormat}" required>

            <span>${confirmPasswordLabel}</span>
            <input type="password" name="confirm" maxlength="32" id="pass2"
                   pattern="[^<>]{8,32}" title="${passwordFormat}" onkeyup="checkPass()" required>

            <span>${nameLabel}</span>
            <input type="text" name="name" maxlength="32"
                   pattern="[^<>]{8,32}" title="${nameFormat}" required>

            <input class="button button-gray" type="submit" value="${save}">

            <c:if test="${not empty requestScope.wrongData}">
            <span class="errorMsg">
                ${userWrongData}: <fmt:message key="${requestScope.wrongData}"/>
            </span>
            </c:if>

        </form>
    </div>
</div>
</body>
</html>