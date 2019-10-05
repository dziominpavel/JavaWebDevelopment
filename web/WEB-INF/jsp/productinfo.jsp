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

    <fmt:message key="title.product" var="pageTitle"/>
    <fmt:message key="label.product.name" var="name"/>
    <fmt:message key="label.product.barcode" var="barcode"/>
    <fmt:message key="label.product.count" var="count"/>
    <fmt:message key="label.product.price" var="price"/>
    <fmt:message key="label.product.measure" var="measure"/>
    <fmt:message key="button.edit" var="edit"/>
    <fmt:message key="button.delete" var="delete"/>

    <title>${pageTitle}</title>
</head>
<body>
<div class="order-card-container">
    <div class="order-card">
        <div class="order-card_info-container">
            <p class="title">
                ${pageTitle}:
            </p>
            <p class="all-info">
                <span class="info-line">
                    <span class="key">${barcode}</span>
                    <span class="value">${requestScope.product.barcode}</span>
                </span>
                <span class="info-line">
                    <span class="key">${name}</span>
                    <span class="value">${requestScope.product.name}</span>
                </span>
                <span class="info-line">
                    <span class="key">${measure}</span>
                    <span class="value">${requestScope.product.measure}</span>
                </span>
                <span class="info-line">
                    <span class="key">${count}</span>
                    <span class="value">${requestScope.product.count}</span>
                </span>
                <span class="info-line">
                    <span class="key">${price}</span>
                    <span class="value">${requestScope.product.price}</span>
                </span>
            </p>

            <c:if test="${not empty sessionScope.currentUser.role && sessionScope.currentUser.role == 'MANAGER'}">
                <form action="app" method="post">
                    <input type="hidden" name="command" value="deleteproduct">
                    <input type="hidden" name="productId" value="${requestScope.product.id}">
                    <input class="gray" type="submit" value="${delete}">
                </form>
                <form action="app" method="post">
                    <input type="hidden" name="command" value="editproduct">
                    <input type="hidden" name="productId" value="${requestScope.product.id}">
                    <input type="submit" value="${edit}">
                </form>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>