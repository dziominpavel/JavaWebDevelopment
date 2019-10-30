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

    <fmt:message key="title.receipts" var="pageTitle"/>
    <fmt:message key="label.receipts.empty" var="emptyReceiptsList"/>
    <fmt:message key="label.receipts.id" var="id"/>
    <fmt:message key="label.receipts.username" var="username"/>
    <fmt:message key="label.receipts.datetime" var="datetime"/>
    <fmt:message key="label.receipts.sum" var="sum"/>
    <fmt:message key="button.receipts.open" var="open"/>

    <c:set var="pagination" value="receipts" scope="request" />

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
            <c:when test="${not empty requestScope.receipts}">
                <table style="font-style: normal; color:white">
                    <tr>
                        <th>${id}</th>
                        <th>${username}</th>
                        <th>${datetime}</th>
                        <th>${sum}</th>
                        <th></th>
                    </tr>
                    <c:forEach var="receipt" items="${requestScope.receipts}">
                        <tr>
                            <td>${receipt.id}</td>
                            <td>${receipt.userName}</td>
                            <td>${receipt.date}</td>
                            <td>${receipt.totalPrice}</td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="receiptinfo">
                                    <input type="hidden" name="receiptId" value="${receipt.id}">
                                    <input type="submit" value="${open}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                ${emptyReceiptsList}
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="/WEB-INF/jspf/pagination.jsp"/>

</body>
</html>