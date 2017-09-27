<%-- 
    Document   : Data_2
    Created on : 2017/09/27, 11:46:18
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data_2</title>
    </head>
    <body>
       <%
        
        request.setCharacterEncoding("UTF-8");  //受け取るパラメータの文字コード
        
        out.print("氏名:" + request.getParameter("txtName") + "<br>");    //テキストボックスの情報
        
        out.print("性別:" + request.getParameter("gender") + "<br>");    //ラジオボタンの情報
        
        out.print("趣味:" + request.getParameter("hobby") + "<br>");   //テキストエリアの情報
        
        //out.print(request.getParameter("chkTest"));   // チェックボックスの情報
        //out.print(request.getParameter("btnTest"));   // ボタンの情報
        //out.print(request.getParameter("cmbList")); // コンボボックス（select）の情報
        
        
%>
    </body>
</html>
