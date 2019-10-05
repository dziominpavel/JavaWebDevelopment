<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <meta charset="UTF-8">
    <fmt:message key="title.login" var="pageTitle"/>
    <fmt:message key="label.login" var="loginLabel"/>
    <fmt:message key="label.password" var="passwordLabel"/>
    <fmt:message key="label.signin" var="signin"/>
    <fmt:message key="label.signup" var="signup"/>

    <fmt:message key="format.login" var="loginFormat"/>
    <fmt:message key="format.password" var="passwordFormat"/>
    <fmt:message key="format.authFailMessage" var="authFailMesage"/>


    <title>${pageTitle}</title>
</head>
<body>
<div class="container">
    <div class="input-container">
        <form name="loginForm" method="post" action="app">
            <input type="hidden" name="command" value="login">
            <span>${loginLabel}</span>
            <input type="text" name="login" maxlength="16"
                   pattern="[A-Za-z0-9._]{4,}" title="${loginFormat}" required>
            <span>${passwordLabel}</span>
            <input type="password" name="password" maxlength="32"
                   pattern="[^<>]{8,}" title="${passwordFormat}" required>
            <input class="button button-blue" type="submit" value="${signin}">
            <c:choose>
                <c:when test="${not empty requestScope.wrongData}">
                    ${authFailMesage}
                </c:when>
            </c:choose>
        </form>
        <form action="signup">
            <input class="button button-gray" type="submit" value="${signup}">
            ${sessionScope.wrongData = null}
        </form>
    </div>
</div>
</body>
</html>