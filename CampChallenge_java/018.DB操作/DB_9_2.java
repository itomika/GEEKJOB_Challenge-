/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

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
public class DB_9_2 extends HttpServlet {

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

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        request.setCharacterEncoding("UTF-8");  //受け取る文字コードの指定
        
        //入力フォームから送られてきた情報を取得
            int id = Integer.parseInt(request.getParameter("ID")); //ID取得、int型への変換
            String name = request.getParameter("Name"); //name取得
            String tel = request.getParameter("Tel"); //tel取得
            int age = Integer.parseInt(request.getParameter("Age")); //age取得、int型への変換
            String birthday = request.getParameter("Birthday"); //birthday取得
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ito", "ito", "itomika");
        if (db_con != null) {
            out.print("接続成功しました。<br>");  //接続の確認
        }
            
        db_st = db_con.prepareStatement("insert into profiles values(?, ?, ?, ?, ?)");
        
        db_st.setInt(1, id);
        db_st.setString(2, name);
        db_st.setString(3, tel);
        db_st.setInt(4, age);
        db_st.setString(5, birthday);
        
        db_st.executeUpdate();
            out.print("下記の情報が登録されます。<br>");
            out.print("ID:" + id + "<br>");
            out.print("Name:" + name + "<br>");
            out.print("Tel:" + tel + "<br>");
            out.print("Age:" + age + "<br>");
            out.print("Birthday:" + birthday + "<br>");
                
                db_st.close();
                db_con.close();
                
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
