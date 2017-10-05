<%-- 
    Document   : DB_8_1
    Created on : 2017/10/05, 11:15:48
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
        <p1>名前を入力してください。</p1>
        <form action="./DB_8_2" method="post">
            <input type="text" name="searchName">
            <input type="submit" name="btnSubmit" value="検索">            
        </form>
    </body>
</html>
