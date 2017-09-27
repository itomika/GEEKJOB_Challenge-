<%-- 
    Document   : Data_3
    Created on : 2017/09/27, 13:22:24
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data_3</title>
    </head>
    <body>
        
        <marquee>
        <hr style="border:dotted;color:#29B867;">
        </marquee>

    
    <center> <font color="#29B867"> <font size="7">zyo-ho-</font></font>     
    <br>
    <span onmouseover="document.all.item('moji2').style.visibility='visible'
          " onmouseout="document.all.item('moji2').style.visibility='hidden'">
        この文字にマウスをのせると...
    </span>

    <div ID="moji2" style="visibility:hidden;">
    こんにちは！
    </div>
    
    name:    <input type="text" name="txtName"><br>
    
    gender:    <input type="radio" name="gender"> Man &nbsp;
            <input type="radio" name="gender"> Woman <br>
            
            <br> <font color="#29B867">What are you interested in?</font><br>
            <TEXTAREA ROWS=10 COLS=30 style="border:thin dotted #29B867;
                      background-color:#ffffff;color:#29B867    ;"  >
            </TEXTAREA>
            <br>
            <!--<input type="submit" name="btnSubmit">-->  
            -Do you want to send?-
            <form action="">
            <button type="submit">yes!</button>&nbsp;<button type="submit">no!!!</button>
            </form>

        <marquee>
        <hr style="border:dotted;color:#29B867;">
        </marquee>
            
    </center>    
    </body>
</html>
