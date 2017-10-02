<%-- 
    Document   : Data_Session_2
    Created on : 2017/10/02, 10:39:44
    Author     : itou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");  //文字コード指定
    
    HttpSession hs = request.getSession();  //セッションの取得
    
   //セッションへデータの書き込み
    hs.setAttribute("Name", request.getParameter("name"));   //Nameという名前、中身はname」をセッションに登録
    hs.setAttribute("Gender", request.getParameter("gender"));
    hs.setAttribute("Hobby", request.getParameter("hobby"));
    
    //セッションからデータ読み出し
    String Username = (String) hs.getAttribute("Name"); //セッションから読み出した情報がStringの中へ
    String Usergender = (String) hs.getAttribute("Gender");
    String Userhobby = (String) hs.getAttribute("Hobby");
    
    String a = "";  //変数の宣言a
    String b = "";  //変数の宣言b
    
    if (hs.getAttribute("Gender") != null) {    //読み出したGenderが空でなければ
        
        if(hs.getAttribute("Gender").equals("男性")){   //Genderと男性を比較し、一緒ならaにchecked
            a = "checked";
        }
        
        if(hs.getAttribute("Gender").equals("女性")){   //Genderと女性を比較し、一緒ならbにchecked
            b = "checked";
        }
        }
      
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action ="Data_Session_2.jsp" method="post">
            お名前:<input type="text" name="name" value=<% if(Username != null) {out.print(Username);} else {out.print("");} %>><br><br>
            性別:<input type="radio" name="gender" value="男性" <%=a%>>男性
            <input type="radio" name="gender" value="女性" <%=b%>>女性
            
            <br>趣味を書いてください<br>
            <textarea name="hobby" cols="50" rows="10"><% if(Userhobby != null) {out.print(Userhobby);} else {out.print("");} %></textarea><br><br>
            <input type="checkbox" name="check">入力内容は保存されます<br><br>
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rst" value="リセット">
        </form>
    </body>
</html>
