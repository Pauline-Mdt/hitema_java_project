<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pauline
  Date: 11/05/2023
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 	CSS (w3css) de la Page -->
    <link rel="stylesheet" href="<c:url value="css/w3.css" />"/>

    <title>Title</title>
</head>
<body>
<%@ include file="parts/header.jsp" %>

<h2 style="text-align: center"><spring:message code="application.city.singular"/></h2>
<br>
<a href="<c:url value="/cities" />" class="w3-button"><spring:message code="application.button.return"/></a>

<div class="w3-container w3-center">
    <table id="citiesTable" class="w3-centered w3-table-all">
        <tbody>
            <tr>
                <th scope="row">ID</th>
                <td>${city.id}</td>
            </tr>
            <tr>
                <th scope="row">Nom</th>
                <td>${city.city}</td>
            </tr>
            <tr>
                <th scope="row">Pays</th>
                <td>${city.country.country}</td>
            </tr>
            <tr>
                <th scope="row">MAJ</th>
                <td>${city.lastUpdate}</td>
            </tr>
        </tbody>
    </table>
    <br>
    <c:forEach items="${city.pictures}" var="elem">
        <img src="<c:url value="data:${elem.type};base64,${elem.file}" />" alt="${elem.name}" height="250" width="auto"/>
    </c:forEach>
</div>
</div>

</body>
</html>
