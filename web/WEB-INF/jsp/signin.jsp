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
    <fmt:message key="label.user.login" var="loginLabel"/>
    <fmt:message key="label.user.password" var="passwordLabel"/>
    <fmt:message key="button.signin" var="signin"/>
    <fmt:message key="button.signup" var="signup"/>

    <fmt:message key="format.user.login" var="loginFormat"/>
    <fmt:message key="format.user.password" var="passwordFormat"/>
    <fmt:message key="message.user.authFail" var="authFailMesage"/>


    <title>${pageTitle}</title>
</head>
<body>
<div class="container">
    <div class="input-container">
        <form name="loginForm" method="post" action="app">
            <input type="hidden" name="command" value="login">

            <span>${loginLabel}</span>
            <input type="text" name="login" maxlength="32"
                   pattern="[A-Za-z0-9._]{4,32}" title="${loginFormat}" required>

            <span>${passwordLabel}</span>
            <input type="password" name="password" maxlength="32"
                   pattern="[^<>]{8,32}" title="${passwordFormat}" required>

            <input class="button button-blue" type="submit" value="${signin}">

            <c:if test="${not empty requestScope.wrongData}">
            <span class="errorMsg">
                ${authFailMesage}
            </span>
            </c:if>
        </form>
        <form action="signup">
            <input class="button button-gray" type="submit" value="${signup}">
        </form>
    </div>
</div>
</body>
</html>