package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author itou
 */
public class Data_Session extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            Date now = new Date();   //当日の日時で情報作成
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //SimpleDateFormatクラスの作成（日付書式）
            
            String time = sdf.format(now);  //nowの中身をtimeに代入

            HttpSession hs = request.getSession();  //セッションの取得
            
            String lastlogin = (String) hs.getAttribute("Data");
            //セッションからデータ読み出し
            //1回目はDataを読み出してもまだ書き込まれていないので空
            //2回目以降はDataを読み出すとtimeが入っている
           
            if (lastlogin != null) {    //lastroginの中身がnullでないなら
                out.print("最後のログインは" + lastlogin + "です。<br>現在の時刻は" + time + "です。");
            }else{
                out.print("はじめてのログインです。<br>現在の時刻は、" + time + "です。");
            }
           
            hs.setAttribute("Data", time);
            //セッションへデータの書き込み
            //Dataという名前　中身はtime（現在時刻）」をセッションに登録
            //セッションを開始したら、サーバ側にデータを保存することができる
            
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
