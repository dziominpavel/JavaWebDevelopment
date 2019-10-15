<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="pagecontent"/>


<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="../../js/main.js"></script>

    <fmt:message key="title.users" var="pageTitle"/>
    <fmt:message key="label.users.empty" var="emptyUserList"/>
    <fmt:message key="label.users.id" var="id"/>
    <fmt:message key="label.users.name" var="name"/>
    <fmt:message key="label.users.login" var="login"/>
    <fmt:message key="label.users.role" var="role"/>
    <fmt:message key="button.product.open" var="open"/>

    <c:set var="pagination" value="users" scope="request" />

    <title>${pageTitle}</title>
</head>
<body>

<jsp:include page="/WEB-INF/jspf/pagination.jsp"/>
<div class="info-table-container">
    <span>
        <p class="title">
            ${pageTitle}:
        </p>
    </span>
    <div class="info-table">
        <c:choose>
            <c:when test="${not empty requestScope.users}">
                <table style="font-style: normal; color:white">
                    <tr>
                        <th>${id}</th>
                        <th>${name}</th>
                        <th>${login}</th>
                        <th>${role}</th>
                        <th></th>
                    </tr>
                    <c:forEach var="user" items="${requestScope.users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.login}</td>
                            <td>${user.role}</td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="userinfo">
                                    <input type="hidden" name="userId" value="${user.id}">
                                    <input type="submit" value="${open}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                ${emptyUserList}
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="/WEB-INF/jspf/pagination.jsp"/>

</body>
</html>