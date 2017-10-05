package DB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;  //データベースに接続するコード

/**
 *
 * @author itou
 */
public class DB_12_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            request.setCharacterEncoding("UTF-8");
            //入力フォームから送られてきた情報を取得
            
            
            String name = request.getParameter("Name");
            int age = Integer.parseInt(request.getParameter("Age"));
            String birthday = request.getParameter("Birthday");
            
            try{    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ito", "ito", "itomika");
            
                //入力されたname,age,birthdayの全てが一致したレコードを取得するSQL文を用意
                db_st = db_con.prepareStatement("select*from profiles where name = ? and age = ? and birthday = ?");
            
                db_st.setString(1, name);   //入力された各項目を設定
                db_st.setInt(2, age);
                db_st.setString(3, birthday);
                
                db_data = db_st.executeQuery(); //executeQueryメソッドで実行
                
                out.println("入力された情報に一致するデータを表示します。<br>");
                
                while(db_data.next()){      //該当するデータがある限り取得し続ける
                    out.print("profilesID:" + db_data.getInt("profilesID") + "<br>");
                    out.print("name:" + db_data.getString("name") + "<br>");
                    out.print("tel:" + db_data.getString("tel") + "<br>");
                    out.print("age:" + db_data.getInt("age") + "<br>");
                    out.print("birthday:" + db_data.getString("birthday") + "<br>");
                }
            
            db_data.close();
            db_st.close();
            db_con.close();
            
        } catch (SQLException e_sql){   //エラーハンドリング
            System.out.print("接続時にエラーが発生しました:" + e_sql.toString());
        } catch (Exception e) {
            System.out.print("接続時にエラーが発生しました:" + e.toString());
        } finally {
            if (db_con != null) {   //db_conに中身がある場合は... 
                try {
                db_con.close();  //クローズ処理を呼び出すように実装している
                } catch (Exception e_con) {  //全てのエラー
                    System.out.println(e_con.getMessage());  //getMessageでエラーメッセージを呼び出す
                }
            }
        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
