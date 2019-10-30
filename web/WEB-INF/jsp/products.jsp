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

    <fmt:message key="title.products" var="pageTitle"/>
    <fmt:message key="label.product.barcode" var="barcode"/>
    <fmt:message key="label.product.name" var="name"/>
    <fmt:message key="label.product.measure" var="measure"/>
    <fmt:message key="label.product.count" var="count"/>
    <fmt:message key="label.product.price" var="price"/>
    <fmt:message key="label.product.empty" var="emptyProductList"/>
    <fmt:message key="button.product.open" var="open"/>
    <fmt:message key="button.product.create" var="create"/>
    <fmt:message key="button.product.search" var="search"/>
    <fmt:message key="button.product.addToReceipt" var="addToReceipt"/>

    <c:set var="pagination" value="products" scope="request" />

    <title>${pageTitle}</title>
</head>
<body>

<jsp:include page="/WEB-INF/jspf/pagination.jsp"/>
<div class="info-table-container">
    <span>
        <p class="title">
            ${pageTitle}: ${page}
        </p>
        <form action="app" method="post" class="button-right" style="margin-block-start: 0.9em">
            <c:if test="${not empty requestScope.wrongData}">
            <span class="errorMsg" style="margin: 0.5em;">
                <fmt:message key="${requestScope.wrongData}"/>
            </span>
            </c:if>
            <input type="hidden" name="command" value="products">
            <input type="text" name="searchText" maxlength="32" value="${sessionScope.searchText}">
            <input type="submit" value="${search}" style="margin-block-start: 0;">
        </form>
        <form action="productinfo">
            <input type="submit" value="${create}">
        </form>
    </span>
    <div class="info-table">
        <c:choose>
            <c:when test="${not empty requestScope.products}">
                <table style="font-style: normal; color:white">
                    <tr>
                        <th>${barcode}</th>
                        <th>${name}</th>
                        <th>${measure}</th>
                        <th>${count}</th>
                        <th>${price}</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach var="product" items="${requestScope.products}">
                        <tr>
                            <td>${product.barcode}</td>
                            <td>${product.name}</td>
                            <td>${product.measure}</td>
                            <td>${product.count}</td>
                            <td>${product.price}</td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="productinfo">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <input type="submit" value="${open}">
                                </form>
                            </td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="addSalesItem">
                                    <input type="hidden" name="barcode" value="${product.barcode}">
                                    <input type="submit" value="${addToReceipt}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                ${emptyProductList}
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="/WEB-INF/jspf/pagination.jsp"/>

</body>
</html>