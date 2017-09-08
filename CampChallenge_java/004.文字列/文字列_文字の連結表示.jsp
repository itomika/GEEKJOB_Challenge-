<%-- 
    Document   : 文字列_文字の連結表示
    Created on : 2017/09/08, 14:55:14
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
            String text1 = "groove";
            String text2 = "-";
            String text3 = "gear";
            
            out.print(text1 + text2 + text3);
            
        %>
    </body>
</html>
<%-- 
    「groove」「-」「gear」の３つの文字列を連結して表示してください
--%>