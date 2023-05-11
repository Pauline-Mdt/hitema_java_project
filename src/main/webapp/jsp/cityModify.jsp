<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 	CSS (w3css) de la Page -->
    <link rel="stylesheet" href="<c:url value="css/w3.css" />"/>

    <title>City Add/Modify JSP</title>

</head>
<body>
<%@ include file="parts/header.jsp" %>

<h2 style="text-align: center"><spring:message code="application.city.singular"/></h2>
<br>
<a href="<c:url value="/cities" />" class="w3-button"><spring:message code="application.button.return"/></a>

<div style="text-align: center" class="w3-container">
    <form name="cityForm" action="cityModify" method="POST" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Id Ville:</td>
                <td><input type="number" name="id" readonly value="${city.id}"/></td>
                <td><spring:message code="application.city.name"/> :</td>
                <td><input type="text" name="city" value="${city.city}"/></td>
                <td>Photo :</td>
                <td><input type="file" name="picture"/></td>
            </tr>
            <th><input type="submit" value="Submit"/></th>
            <th><input type="reset" value="Clear"/></th>
        </table>
    </form>
</div>
</body>
</html>
