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

public class Class_keisho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //課題「クラスの作成」で作成したクラスを継承し、以下の機能を持つクラスを作成してください。
    //1. ２つの変数の中身をクリアするパブリックなメソッド
    
class Ziko extends Human{   //extendsでHumanクラスを継承しているZikoクラスの宣言

    public void Clear(){    //フォールドの中身をクリアするメソッド
        this.name = "";       //nameフィールド内の変数クリア
        this.age = 0;         //ageフィールド内の変数のクリア
    } 
    
    public void Shokai(){   //（extendsでHumanクラスを継承している）フィールドへセットされた変数を出力するためのメソッド
        System.out.print(name + "です。" + age + "歳です。よろしくお願いします。");
    } 
   
} 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Ziko cl = new Ziko();       //Zikoクラスのインスタンス生成
          
            cl.setHuman("伊藤美香", 27);    //Humanクラスを利用してそれぞれのフィールドに値をセットしている      
            cl.Shokai();                    //Shokaiメソッドで出力
            
            cl.Clear();                     //Clearメソッドで中身をクリアに
            
            cl.Shokai();                    //クリアになっているか確認で出力
    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Class_keisho</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Class_keisho at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
