<%-- 
    Document   : ループ処理_for文2
    Created on : 2017/09/12, 14:34:15
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
         String box = ""; 
         for(int i=0;i<=30;i++){
            box = box + "A"; 
             out.print(box + "<br>");
         }
        %>
    </body>
</html>
<%-- 
    for文を利用して、適当な変数へ文字連結を行い、中に"A"が30個入った状態にしてください。
--%>