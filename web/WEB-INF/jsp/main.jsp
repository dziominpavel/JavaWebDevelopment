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

    <title>${pageTitle}</title>
</head>
<body>

<div class="info-table-container">
    <div class="info-table">
        <p>${pageTitle}:</p>
    </div>
</div>

</body>
</html>