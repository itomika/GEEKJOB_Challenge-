<%-- 
    Document   : challenge1-2
    Created on : 2017/09/06, 14:39:28
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
            String name = "名前：伊藤美香";
            String birth = "誕生日：10月31日";
            String age = "年齢：27歳";
            String hobby = "趣味：映画鑑賞";
            out.print(name + "<br>" + birth + "<br>" + age + "<br>" + hobby + "<br>");
        %>
    </body>
</html>
