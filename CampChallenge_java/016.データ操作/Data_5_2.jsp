<%-- 
    Document   : Data_5_2
    Created on : 2017/09/30, 13:58:27
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>factoring</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>素因数分解tool</h1>
       
        <form action="./factoring.jsp" method="get">
        
            <p>Input val(over 2):<input type="text" name="num" size="4"></p>
            
            <p><input type="submit" name="btnSubmit" value="結果は..."></p>
        
        </form>
    </body>