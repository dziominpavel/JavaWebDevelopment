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

    <fmt:message key="title.receipt.info" var="pageTitle"/>
    <fmt:message key="title.receipt.salesItem" var="salesItemTitle"/>
    <fmt:message key="label.product.barcode" var="barcode"/>
    <fmt:message key="label.product.name" var="name"/>
    <fmt:message key="label.product.measure" var="measure"/>
    <fmt:message key="label.salesItem.count" var="count"/>
    <fmt:message key="label.product.price" var="price"/>
    <fmt:message key="label.salesItem.totalPrice" var="totalPrice"/>
    <fmt:message key="label.receipt.totalPrice" var="total"/>
    <fmt:message key="label.receipts.id" var="id"/>
    <fmt:message key="label.receipts.username" var="username"/>
    <fmt:message key="label.receipts.datetime" var="datetime"/>

    <title>${pageTitle}</title>
</head>
<body style="display: grid">

<div class="order-card-container" style="height: 50vh">
    <div class="order-card" style="height: 40vh">
        <div class="order-card_info-container">
            <p class="title">
                ${pageTitle}:
            </p>

            <p class="all-info">
                <span class="info-line">
                <span class="key">${id}</span>
                    <input type="text" name="receiptId"
                           disabled value="${requestScope.receipt.id}">
                </span>

                <span class="info-line">
                <span class="key">${username}</span>
                    <input type="text" name="username"
                           disabled value="${requestScope.receipt.userName}">
                </span>

                <span class="info-line">
                <span class="key">${datetime}</span>
                    <input type="text" name="username"
                           disabled value="${requestScope.receipt.date}">
                </span>
            </p>
        </div>
    </div>
</div>

<div class="info-table-container" style="min-height: 50vh; margin-bottom: 10px">
    <span>
        <p class="title">
            ${salesItemTitle}:
        </p>
    </span>
    <div class="info-table">
        <table style="font-style: normal; color:white">
            <tr>
                <th>${barcode}</th>
                <th>${name}</th>
                <th>${measure}</th>
                <th>${price}</th>
                <th>${count}</th>
                <th>${totalPrice}</th>
            </tr>
            <c:forEach var="salesItem" items="${requestScope.receipt.salesItems}">
                <tr>
                    <td>${salesItem.product.barcode}</td>
                    <td>${salesItem.product.name}</td>
                    <td>${salesItem.product.measure}</td>
                    <td>${salesItem.product.price}</td>
                    <td>${salesItem.count}</td>
                    <td>${salesItem.totalPrice}</td>
                </tr>
            </c:forEach>
            <tr>
                <td style="font-weight: bold">${total}:</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td style="font-weight: bold">${requestScope.receipt.totalPrice}</td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>