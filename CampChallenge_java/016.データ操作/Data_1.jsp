<%-- 
    Document   : Data_1
    Created on : 2017/09/27, 11:11:25
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data_1</title>
    </head>
    <body>
    <form action="./test.jsp" method="post">
        
    名前:    <input type="text" name="txtName"><br>
    性別:    <input type="radio" name="gender"> 男 &nbsp;
            <input type="radio" name="gender"> 女 <br>
    趣味:<br> 
            <textarea name="hobby" cols="30" rows="5"></textarea><br>
            <input type="submit" name="btnSubmit">  
            
    <!--<input type="checkbox" name="chkTest">-->
    <!--<input type="button" name="btnTest">-->
    <!--<input type="submit" name="btnSubmit">-->

    <!--<select name="cmbList"></select>-->
    <!--<textarea name="mulText"></textarea>-->
    
    </form>
    </body>
</html>
