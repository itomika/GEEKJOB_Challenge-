<%-- 
    Document   : 連想配列_連想配列の作成
    Created on : 2017/09/11, 13:57:59
    Author     : itou
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        HashMap<String,String> data = new HashMap<String,String>();
        data.put("1","AAA");
        data.put("hello","world");
        data.put("soeda","33");
        data.put("20","20");
        %>
    </body>
</html>

<%-- 
    "1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"
--%>