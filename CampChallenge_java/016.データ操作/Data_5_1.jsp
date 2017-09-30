<%-- 
    Document   : Data_5_1
    Created on : 2017/09/27, 16:56:59
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
        request.setCharacterEncoding("UTF-8");
            String g = request.getParameter("num");
            int n = Integer.parseInt(g);
            int dn = n;
            
            //表示 + 処理
            out.print(n + "の素因数は ");
            
            while(dn > 1){      //dnが1より大きければ繰り返す
                if(dn % 2 == 0){        //dnを2で割った時あまりは0
                    out.print("2, ");
                    dn /= 2;
                }else if(dn % 3 == 0){      //dnを3で割った時あまりは0
                    out.print("3, ");
                    dn /= 3;
                }else if(dn % 5 == 0){      //dnを5で割った時あまりは0
                    out.print("5, ");
                    dn /= 5;
                }else if(dn % 7 == 0){      //dnを7で割った時あまりは0
                    out.print("7, ");
                    dn /= 7;
                }else{
                    out.print("余りは" + dn);   
                    break;
                }
            }
            
            out.print(" です。");
        %>
    </body>
</html>
