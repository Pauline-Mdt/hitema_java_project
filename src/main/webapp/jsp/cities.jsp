<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 	CSS (w3css) de la Page -->
    <link rel="stylesheet" href="<c:url value="css/w3.css" />" />

    <title>cities JSP</title>

</head>

<body onload="init();">

<%--<jsp:include page="header.jsp"></jsp:include>--%>

<div class="w3-container">
    <h2 style="text-align: center">Sakila - cities</h2>
    <br>
    <button onclick="<c:url value="/" />" >Retour</button>
    <button onclick="<c:url value="/countries" />" >Tous les pays</button>

    <table id="citiesTable" class="w3-centered w3-table-all">
        <thead>
        <tr class="w3-light-grey">
            <th>Id</th>
            <th>Country</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cities}" var="elem">
            <tr>
                <th scope="row">${elem.id}</th>
                <td>${elem.city}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<!-- JavaScript resources dataTables + jQuery -->

</html>