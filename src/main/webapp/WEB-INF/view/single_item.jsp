<%--
  Author: Pavel Ravvich.
  Date: 12.08.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>


    <c:set var="item" value="${requestScope.item}"/>


    <ul>
        <li>Id: <c:out value="${item.id}"/></li>
        <li>Author: <c:out value="${item.name}"/></li>
        <li>Description: <c:out value="${item.description}"/></li>
    </ul>


    <form method="post" action="/menu/delete_item.do">
        <input type="number" name="id" hidden value="${item.id}">
        <input type="submit" value="Delete item">
    </form>
    <hr />


    <form method="get" action="/menu/update_item_page.do">
        <input type="number" name="id" hidden value="${item.id}">
        <input type="submit" value="Update item">
    </form>


</body>
</html>
