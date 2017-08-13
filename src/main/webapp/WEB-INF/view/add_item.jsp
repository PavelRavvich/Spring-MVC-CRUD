<%--
  Author: Pavel Ravvich.
  Date: 12.08.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


Add item:

<form method="post" action="/menu/add_item.do" >

    Name: <input name="name" type="text" /> <hr />
    Description: <input name="description" type="text" /><hr />

    <input type="submit" value="Add item">
</form>

</body>
</html>
