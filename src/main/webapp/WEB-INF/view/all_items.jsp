<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all items</title>
</head>
<body>

All Items:

<c:forEach var="item" items="${requestScope.items}">
    <ul>
        <li>Model: <c:out value="${item.id}"/></li>
        <li>Mark: <c:out value="${item.name}"/></li>
        <li>Sold: <c:out value="${item.description}"/></li>
        <input name="pId" hidden type="number" value="${item.id}">
        <hr />
    </ul>
</c:forEach>
</body>
</html>