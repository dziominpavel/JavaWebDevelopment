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

    <fmt:message key="title.order" var="pageTitle"/>
    <fmt:message key="label.product.barcode" var="barcode"/>
    <fmt:message key="label.product.name" var="name"/>
    <fmt:message key="label.product.measure" var="measure"/>
    <fmt:message key="label.salesItem.count" var="count"/>
    <fmt:message key="label.product.price" var="price"/>
    <fmt:message key="label.salesItem.totalPrice" var="totalPrice"/>
    <fmt:message key="label.receipt.totalPrice" var="total"/>
    <fmt:message key="label.order.empty" var="emptyOrder"/>
    <fmt:message key="label.salesItem.countToAdd" var="countToAdd"/>
    <fmt:message key="button.product.open" var="open"/>
    <fmt:message key="button.product.add" var="add"/>
    <fmt:message key="button.save" var="save"/>
    <fmt:message key="button.delete" var="delete"/>
    <fmt:message key="button.cancel" var="cancel"/>

    <title>${pageTitle}</title>
</head>
<body style="display: grid">

<div class="info-table-container">
    <span>
        <p class="title">
            ${pageTitle}:
        </p>

        <form action="app" method="post" class="button-right">
            <c:if test="${not empty requestScope.wrongData}">
            <span class="errorMsg" style="margin: 0.5em;">
                <fmt:message key="${requestScope.wrongData}"/>
            </span>
            </c:if>
            <input type="hidden" name="command" value="addSalesItem">
            <span><p>${barcode}</p></span>
            <input type="text" name="barcode" maxlength="32" value="${requestScope.barcode}">
            <span><p>${countToAdd}</p></span>
            <input type="text" name="countToAdd" style="width: 70px" maxlength="3" value="1" pattern="^\d+$">
            <input type="submit" value="${add}" style="margin-block-start: 0;">
        </form>
    </span>
    <div class="info-table">
        <c:choose>
            <c:when test="${not empty sessionScope.currentReceipt.salesItems}">
                <table style="font-style: normal; color:white">
                    <tr>
                        <th>${barcode}</th>
                        <th>${name}</th>
                        <th>${measure}</th>
                        <th>${price}</th>
                        <th>${count}</th>
                        <th>${totalPrice}</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach var="salesItem" items="${sessionScope.currentReceipt.salesItems}">
                        <tr>
                            <td>${salesItem.product.barcode}</td>
                            <td>${salesItem.product.name}</td>
                            <td>${salesItem.product.measure}</td>
                            <td>${salesItem.product.price}</td>
                            <td>${salesItem.count}</td>
                            <td>${salesItem.totalPrice}</td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="productinfo">
                                    <input type="hidden" name="productId" value="${salesItem.product.id}">
                                    <input type="submit" value="${open}">
                                </form>
                            </td>
                            <td>
                                <form action="app">
                                    <input type="hidden" name="command" value="deleteSalesItem">
                                    <input type="hidden" name="productId" value="${salesItem.product.id}">
                                    <input type="submit" class="red" value="${delete}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td style="font-weight: bold">${total}:</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td style="font-weight: bold">${sessionScope.currentReceipt.totalPrice}</td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <p class="title" style="color: rgba(67,67,68,0.81);">
                        ${emptyOrder}
                </p>
            </c:otherwise>
        </c:choose>
    </div>
    <c:if test="${not empty sessionScope.currentReceipt.salesItems}">
        <span>
        <form action="app" method="get" class="button-center">
            <c:if test="${not empty requestScope.wrongData}">
            <span class="errorMsg" style="margin: 0.5em;">
                    <fmt:message key="${requestScope.wrongData}"/>
            </span>
            </c:if>
            <input type="hidden" name="command" value="createReceipt">
            <input type="submit" value="${save}">
        </form>
        <form action="app" method="get" class="button-center">
            <input type="hidden" name="command" value="cancelReceipt">
            <input type="submit" class="gray" value="${cancel}">
        </form>
    </span>
    </c:if>

</div>

</body>
</html>