<%-- 
    Document   : ループ処理_for文1
    Created on : 2017/09/12, 14:08:23
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
         long answer = 1; 
         for(long i=0;i<20;i++){
            answer = answer*8;
            out.print(answer + "<br>");
        }%>
    </body>
</html>
<%-- 
    for文を利用して、8を20回掛ける処理を実現してください。（8の20乗）
--%>