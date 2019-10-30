<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"
         language="java" %>
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
    <fmt:message key="button.cancel" var="cancel"/>
    <fmt:message key="button.save" var="save"/>
    <fmt:message key="message.product.wrongData" var="productWrongData"/>

    <title>${pageTitle}</title>
</head>
<body>
<div class="order-card-container">
    <div class="order-card">
        <div class="order-card_info-container">
            <p class="title">
                ${pageTitle}:
            </p>

            <form action="app" method="post">
                <p class="all-info">
                <c:choose>
                    <c:when test="${empty requestScope.product || empty requestScope.product.id}">
                        <input type="hidden" name="command" value="createProduct">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="command" value="updateProduct">
                        <input type="hidden" name="productId" value="${requestScope.product.id}">
                    </c:otherwise>
                </c:choose>


                <span class="info-line">
                <span class="key">${barcode}</span>
                    <input type="text" name="barcode" maxlength="32"
                           title="${barcodeFormat}" required disabled
                           value="${requestScope.product.barcode}">
                </span>
                <span class="info-line">
                    <span class="key">${name}</span>
                    <input type="text" name="name" maxlength="32"
                           title="${nameFormat}" required disabled
                           value="${requestScope.product.name}">
                </span>
                <span class="info-line">
                    <span class="key">${measure}</span>
                    <input type="text" name="measure" maxlength="32"
                           title="${measureFormat}" required disabled
                           value="${requestScope.product.measure}">
                </span>
                <span class="info-line">
                    <span class="key">${count}</span>
                    <input type="text" id="count" name="count" maxlength="32"
                           title="${countFormat}" required disabled
                           value="${requestScope.product.count}"
                           pattern="^\d+$">
                </span>
                <span class="info-line">
                    <span class="key">${price}</span>
                    <input type="text" name="price" maxlength="32"
                           title="${priceFormat}" required disabled
                           value="${requestScope.product.price}"
                           pattern="^\d*(\.\d{0,2})?$">
                </span>

                <c:if test="${not empty requestScope.wrongData}">
                    <span class="errorMsg">
                        ${productWrongData}: <fmt:message key="${requestScope.wrongData}"/>
                    </span>
                </c:if>
                <input id="save" hidden type="submit" value="${save}">
            </p>
            </form>

            <c:if test="${not empty sessionScope.currentUser.role
            && (sessionScope.currentUser.role == 'MANAGER'
            || sessionScope.currentUser.role == 'ADMIN')}">

                <input id="edit" type="submit"
                       value="${edit}" onclick="makeEditable()">

                <form action="app" method="post">
                    <input type="hidden" name="command" value="productinfo">
                    <input type="hidden" name="productId"
                           value="${requestScope.product.id}">
                    <input id="cancel" class="gray" hidden type="submit"
                           value="${cancel}">
                </form>
                <c:if test="${not empty requestScope.product.id}">
                    <form action="app" method="post">
                        <input type="hidden" name="command" value="deleteproduct">
                        <input type="hidden" name="productId"
                               value="${requestScope.product.id}">
                        <input id="delete" class="red" type="submit"
                               value="${delete}">
                    </form>
                </c:if>
            </c:if>
            <c:if test="${not empty requestScope.wrongData || empty requestScope.product}">
                <script>makeEditable()</script>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>