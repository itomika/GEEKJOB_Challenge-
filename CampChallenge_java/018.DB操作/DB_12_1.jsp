<%-- 
    Document   : DB_12_1
    Created on : 2017/10/05, 17:05:11
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
        <form action="./DB_12_2" method="post">
            <h2>データ検索フォーム</h2>
            
            <div>
                <p>
                    名前、年齢、誕生日の3つの情報全てに<br>一致するデータの検索ができます。
                </p>
            <p>
            <ul>
                <li>name:<br><input type="text" name="Name"></li>
                <li>age:<br><input type="text" name="Age"></li>
                <li>birthday:<br><input type="text" name="Birthday"></li>
            </ul>
            </p>
            </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" id="submit" name="Submit" value="検索">
        </form>
    </body>

</html>
