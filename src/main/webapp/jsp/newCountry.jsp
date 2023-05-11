<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pauline
  Date: 10/05/2023
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add country</title>
</head>
<body>
<%@ include file="parts/header.jsp" %>

<form name="countryForm" action="/jee-mvc/countries" method="POST">
    <h2 style="text-align: center"><spring:message code="application.title.name"/> - <spring:message code="application.country.new"/></h2>
    <br>

    <table>
        <tr>
            <td><spring:message code="application.country.name"/> :</td>
            <td><input type="text" name="country"/></td>
        </tr>
        <th><input type="submit" value="<spring:message code="application.button.submit"/>" name="find"/></th>
        <th><input type="reset" value="<spring:message code="application.button.reset"/>" name="reset" /></th>
    </table>
</form>
</body>
</html>
