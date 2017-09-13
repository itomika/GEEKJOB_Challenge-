<%-- 
    Document   : ループ処理_while文
    Created on : 2017/09/13, 10:53:20
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
        int num = 1000;
        
        while(num >= 100){
            num = num / 2;
        out.print(num + "<br>");
        }
        %>
    </body>
</html>
<%-- 
   1. 1000を2で割り続け、100より小さくなったらループを抜ける処理
--%>
