<%-- 
    Document   : ループ処理_for文3
    Created on : 2017/09/12, 14:48:47
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        int total = 0;
        for(int i=0;i<=100;i++){
        total = total + i;
        }
        out.print(total + "<br>");
        %>
    </body>
</html>
<%--for文を利用して、0から100を全部足す処理を実現してください。--%>