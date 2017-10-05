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
public class DB_8_2 extends HttpServlet {

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
            
    request.setCharacterEncoding("UTF-8");  //受け取る文字コードの指定
            
    String name = request.getParameter("searchName");   //入力された文字列を取得
    
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ito", "ito", "itomika");
        if (db_con != null) {
            out.print("接続成功しました。<br>");  //接続の確認
        }
        
        
            db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");    //入力された名前を一部含んでいるデータを取得
            db_st.setString(1, "%" + name + "%");
                
            db_data = db_st.executeQuery(); //実行
                
            out.println("「" + name + "」で検索した結果" + "<br>");
                
            while (db_data.next()) {    
                out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("電話番号：" + db_data.getString("tel") + "<br>");
                out.print("年齢：" + db_data.getInt("age") + "<br>");
                out.print("誕生日：" + db_data.getString("birthday") + "<br><br>");

            }
                
                db_st.close();
                db_con.close();
                db_data.close();
                
        } catch (SQLException e_sql) {
            System.out.println("接続時にエラーが発生しました。");
        } catch (Exception e) {
            System.out.println("エラーが発生しました。");
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
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
