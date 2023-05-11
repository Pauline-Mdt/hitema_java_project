<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pauline
  Date: 09/05/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="application.title.home"/> - <spring:message code="application.title.name"/></title>
</head>
<body>
<%@ include file="parts/header.jsp" %>

<a href="countries"><spring:message code="application.country.plural"/></a>
<a href="cities"><spring:message code="application.city.plural"/></a>
</body>
</html>
