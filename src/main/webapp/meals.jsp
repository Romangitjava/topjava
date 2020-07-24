<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<c:forEach var="meal" items="${requestScope.meals}">
    <ul>
        <c:if test="${meal.excess}">
        <span style="color:#00ff00">
            Дата: <c:out value="${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}"/>
            Описание: <c:out value="${meal.description}"/>
            Калории: <c:out value="${meal.calories}"/>
        </span>
        </c:if>

        <c:if test="${!meal.excess}">
        <span style="color:#ff0000">
            Дата: <c:out value="${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}"/>
            Описание: <c:out value="${meal.description}"/>
            Калории: <c:out value="${meal.calories}"/>
        </span>
        </c:if>

    </ul>
</c:forEach>

</body>
</html>
