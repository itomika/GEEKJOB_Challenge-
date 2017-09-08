<%-- 
    Document   : newjsp
    Created on : 2017/09/08, 17:13:56
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
        char lang = 'あ';
            switch(lang){
            case 'A':
                out.print("英語");
                break;
            case 'あ':
                out.print("日本語");
                break;
        }
        %>
    </body>
</html>

<%-- 
   switch文を利用して、以下の処理を実現してください。
    1. 値が【A】なら「英語」
    値が【あ】なら「日本語」
    それ以外は何も表示しない処理
    ※型はcharを使用してください
--%>