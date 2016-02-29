<%-- 
    Document   : Index
    Created on : 21-feb-2016, 11:32:41
    Author     : Yovanny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <table>
            <tr>
                <td>DNI</td>
                <td>NOMBRE</td>
            </tr>
            <c:forEach var="item" items="${personas}">
                <tr>
                    <td>${item.getDni()}</td>
                     <td>${item.getNombre()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
