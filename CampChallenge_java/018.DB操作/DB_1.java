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
public class DB_1 extends HttpServlet {

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
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
             //Class.forNameメソッドを利用し、libフォルダにあるMysql用のJDBCドライバのインスタンスを生成
             //このインスタンスは、生成と同時にDriverManagerにセットされる
             
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ito","ito","itomika");
             //DriverManagerのgetConnectionメソッドで、DBへの接続を取得
             //接続情報は、Connectionクラスとして返却されるため、Connectionクラスの変数で受ける
             
             db_st = db_con.prepareStatement("select * from profiles where age = ?");
             //ConnectionのprepareStatementメソッドにSQL文を渡す
             //この時、SQL文の中に条件となる値の代わりに『?』を配置
             //さらに、prepareStatementメソッドの戻り値を受け取る
             
             db_st.setInt(1,30);
             //prepareStatementメソッドから受け取ったPreparedStatementに対し、『?』部分に適用する情報を設定していきます。
             //１番目の『?』に対して、30を設定する処理
             
             db_data = db_st.executeQuery();    //PreparedStatementのexecuteQueryメソッドを実行
             //『?』が実際の値に置き換わったSQL文がデータベースに実行されます。
             //executeQueryの場合、実行結果をResultSetとして返却してくれます。
             
             while(db_data.next()){
                out.print("ID：" + db_data.getString("profilesID") + "<br>");
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("tel：" + db_data.getString("tel") + "<br>");
                out.print("年齢：" + db_data.getString("age") + "<br>");
                out.print("生年月日：" + db_data.getString("birthday") + "<br>");
             //ResultSetからSQLの実行結果を取り出し、表示します。
             //nextメソッドで、データの有無を確認し、while文でデータがある限り取得し続ける
             //getStringメソッドは、１行のデータからnameカラムの情報を文字列として取得している
             } 
             
            db_data.close();
            db_st.close();
            db_con.close();
             //データベースへの同時接続数は制限があるため、操作が完了して使わなくなったものは必ずclose
            
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
