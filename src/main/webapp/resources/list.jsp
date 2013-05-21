<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DVD Katalogi</title>
</head>
<body>
Nina's DVD Catalogue
<c:if test="${not null error}">
    ${error}
</c:if>
<c:if test="${not empty movies}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Finnish Name</th>
        </tr>
        </thead>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.name}</td>
                <td>${movie.translatedName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>