<%-- 
    Document   : test1_演算子
    Created on : 2017/09/06, 16:05:50
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
          int num1 = 5;
          int num2 = 10;
          final int num3 = 300;
          final int num4 = 800;
         
          int tasu = num1+num4;
          int hiku = num3-num1;
          int kakeru = num2*num4;
          int waru = num1/num4;
          int yozyo = num3 % 6;
          
          out.print(tasu + "<br>" + hiku + "<br>" + kakeru + "<br>" + waru + "<br>" + yozyo);
          
          out.print(++tasu + "<br>" + waru--);
        %>
    </body>
</html>
