<%-- 
    Document   : if文_変数の宣言と表示
    Created on : 2017/09/08, 15:32:58
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
        int num1 =1;
        if (num1 == 1){
            out.print("1です！");
        }else if (num1 == 2){
            out.print("プログラムキャンプ！");
        }else{
            out.print("その他です！");
        }
        %>
    </body>
</html>

<%-- 
    変数を宣言し、その変数の中身によって以下の表示を行ってください
    値が 1 なら「１です！」
    値が 2 なら「プログラミングキャンプ！」
    それ以外なら「その他です！」
--%>
