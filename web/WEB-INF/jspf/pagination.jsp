<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale scope="session" value="${sessionScope.locale}"/>
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">

    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="../../js/main.js"></script>

    <fmt:message key="pagination.next" var="next"/>
    <fmt:message key="pagination.previous" var="previous"/>

</head>
<body>
<div class="page-number-container">
    <c:if test="${requestScope.page > 1}">
        <form action="app">
            <input type="hidden" name="command" value="${pagination}">
            <input type="hidden" name="page" value="${requestScope.page - 1}">
            <input type="hidden" name="searchText" value="${sessionScope.searchText}">
            <input class="page-number-blue" type="submit" value="${previous}">
        </form>
    </c:if>
    <c:if test="${requestScope.page > 1 && requestScope.page > requestScope.pagesCount}">
        ${requestScope.page = requestScope.pagesCount}
    </c:if>
    <c:forEach begin="1" end="${requestScope.pagesCount}" var="i">
        <c:choose>
            <c:when test="${requestScope.page eq i}">
                <form>
                    <button class="page-number-gray" disabled>${i}</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="app">
                    <input type="hidden" name="command" value="${pagination}">
                    <input type="hidden" name="page" value="${i}">
                    <input type="hidden" name="searchText" value="${sessionScope.searchText}">
                    <input class="page-number-blue" type="submit" value=${i}>
                </form>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${requestScope.page < requestScope.pagesCount}">
        <form action="app">
            <input type="hidden" name="command" value="${pagination}">
            <input type="hidden" name="page" value="${requestScope.page + 1}">
            <input type="hidden" name="searchText" value="${sessionScope.searchText}">
            <input class="page-number-blue" type="submit" value="${next}">
        </form>
    </c:if>
</div>
</body>
</html>