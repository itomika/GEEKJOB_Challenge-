<%-- 
    Document   : DB_9_1
    Created on : 2017/10/05, 11:32:00
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
<style>
ul li {
    list-style: none;
    label {
    margin-right: 2000px;
    width:2000px;
    float: left;
}        
</style>
        
    </head>
    <body>
        <form action="./DB_9_2" method="post">
            
            <h3>新規データ登録フォーム</h3>
            
            <div>
            <p>
            <ul>
                <li>ID:<br></span><input type="text" name="ID"></li>
                <li>Name:<br></span><input type="text" name="Name"></li>
                <li>Tel:<br></span><input type="text" name="Tel"></li>
                <li>Age:<br><input type="text" name="Age"></li>
                <li>Birthday:<br></span><input type="text" name="Birthday"></li>
            </ul>
            </p>
            </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" id="submit" name="Submit" value="登録">
        </form>
    </body>
</html>
