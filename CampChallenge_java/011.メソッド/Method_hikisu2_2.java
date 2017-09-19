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
public class Method_hikisu2_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //1. ３つの引数を持ち、渡された数値で掛け算をするメソッドを作成します。
    //メソッドは、１つ目の引数と２つ目の引数を掛け算し、３つ目の引数がtrueの場合は結果を２乗させてください。
    //また、２つ目の引数は5、３つ目の引数はfalseをデフォルト値として設定してください。
    //2. 作成したメソッドを呼び出し、結果を表示してください。
    
        void methodX(int num1,int num2,boolean X,PrintWriter pw){ 
        //引数を4つ渡している（a=一つ目の値、b=二つ目の値、X=trueかfalse(三つ目の値)、pw=画面に出力(四つ目の値)）
            int answer = num1*num2;   //answerの中にnum1*num2を格納
            if(X == true){      //Xがtrueであれば    
                    pw.print(answer*answer);    //answer2乗出力
            }else{                              //そうでなければ                                 
                pw.print(answer);               //answer出力
            }
         } 
        
        void methodX(int num1,PrintWriter pw){
        //引数を2つ渡している（num=一つ目の値、pw=画面に出力(二つ目の値)）
            methodX(num1,5,false,pw);
        //デフォルト値を設定している(一つ目の値num=特に何も、二つ目の値=5、三つ目の値=false、四つ目の値=pw(画面に出力))
        }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Method_hikisu2_2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Method_hikisu2_2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        methodX(3,3,true,out);            
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
