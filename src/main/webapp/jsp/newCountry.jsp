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
<form name="countryForm" action="/jee-mvc/countries" method="POST">
    <h2 style="text-align: center">Sakila - nouveau pays</h2>
    <br>

    <table>
        <tr>
            <td>Country name :</td>
            <td><input type="text" name="country"/></td>
        </tr>
        <th><input type="submit" value="Submit" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <h2>${bmi}</h2>
</form>
</body>
</html>
