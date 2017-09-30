<%-- 
    Document   : Data_4
    Created on : 2017/09/27, 15:33:59
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
        request.setCharacterEncoding("UTF-8");   // 文字コード指定
        
        int tl = Integer.parseInt(request.getParameter("total"));//総額
        int ct = Integer.parseInt(request.getParameter("count"));//個数
        int te = Integer.parseInt(request.getParameter("type"));//商品種別
        
    switch(te){ //商品別種について
        case 1:
            out.print("雑貨が選択されています。" + "<br>");  //case1の場合＝雑貨
            break;
        case 2:
            out.print("生鮮食品が選択されています。" + "<br>");  //case2の場合＝生鮮食品
            break;
        case 3:
            out.print("その他が選択されています。" + "<br>");    //case3の場合＝その他
    }
    
    int ichi = tl / ct; //受け取った総額と個数から、１個当たりの値段を算出
        out.print("お買い物の総額は" + tl + "円" + "<br>" + "1個あたりの値段は" + ichi + "円" + "になります。" + "<br>");
        
    if (tl >= 5000){    //訴額が5,000以上だった場合
        int point = (int)(tl*0.05);  //総額に5%掛けるint型に直す
            out.print(point + "POINT付きます。");
    }else if (tl >= 3000){
        int point = (int)(tl*0.04); //総額に4%掛ける((int)でint型に直す)
            out.print(point + "POINT付きます。");
    }else{
        out.print("今回のお買い物にPOINTは付きません。");
    }

        %>
    </body>
</html>
