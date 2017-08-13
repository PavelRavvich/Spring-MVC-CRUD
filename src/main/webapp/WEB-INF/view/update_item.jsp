<%--
  Author: Pavel Ravvich.
  Date: 12.08.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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


<form:form method="post" action="/menu/update_item.do" commandName="item">

    <input name="id" hidden type="number" value="${item.id}"/>

    Name: <form:input path="name" type="text" /> <hr />
    Description: <form:input path="description" type="text" /><hr />

    <input type="submit" value="Update item">
</form:form>


</body>
</html>