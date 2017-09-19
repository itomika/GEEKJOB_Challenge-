/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author itou
 */
public class Method_modorichi1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //課題「ユーザー定義メソッドの作成」で定義したメソッドを拡張します。
    //メソッドへ戻り値を追加し、　true(boolean)　を返却するように修正してください。
    //また、メソッドの呼び出し側で戻り値を評価し、trueなら「この処理は正しく実行できました」
    //そうでないなら「正しく実行できませんでした」と表示してください。
            
        boolean myprofile(PrintWriter pw){  //myprofile下記の内容を出力する
            pw.print("私の名前は伊藤です<br>");
            pw.print("生年月日は1989年10月31日です<br>");
            pw.print("趣味は映画鑑賞です<br>");
            return true;    //trueがに返される
        }   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Method_modorichi1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Method_modorichi1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            // 「myprofile」と10回表示したい
            for (int i = 0; i < 10; i++) {
            myprofile(out);
            
            if(myprofile(out)==true){   //myprofileのプリント結果がtrueの時
            out.print("この処理は正しく実行できました");    
            }else{                      //myprofileのプリント結果がそれ以外の時
            out.print("正しく実行できませんでした");
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