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
public class Method_hikimodori3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //課題「引数、戻り値2」の処理において、Integer limit=2を用意し、
    //limitを利用して２名のプロフィール表示までで停止する様に処理を実装してください

    
    String[] prof(int hitobito){ //引数が[hitobito]の戻り値[dareka]の[prof]メソッド   
    
        String[] hito1 ={"ID1","伊藤美香","1989/10/31","群馬"};     //hito1の中に4つの要素配列
        String[] hito2 ={"ID2","伊藤一樹","1984/08/08","香川"};     //hito2の中に4つの要素配列
        String[] hito3 ={"ID3","伊藤優香","1981/09/21",null};      //hito3の中に4つの要素配列(住所部分はnull)
        
        switch(hitobito){
            case 0:             
                return hito1;   //0と呼ぶと[hito1:伊藤美香]を返す
            case 1:
                return hito2;   //1と呼ぶと[hito2:伊藤一樹]を返す
            case 2:
                return hito3;   //2と呼ぶと[hito3:伊藤優香]を返す
    }
        return null;            //その他は何もないということを返す
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Integer limit=2;                //[limit]という変数に2を格納
           
            for(int i=0;i<limit;i++){       //iの初期値が0でiが[limit(=2)]より小さいうちは繰り返しiは1づつ増えていく
                out.print("<br>");          //hito1,hito2どうしを改行して見やすくする
                
                String[] dareka = prof(i);  //[dareka]にprof(hito1(hito2)を格納)
                
                for(int z=1;z<=3;z++){      //[[hito1(2)(3)]の名前、誕生日、住所をループしている※問いがID以外を出力なので
                    if(dareka[z] == null){  //[[hito1(2)(3)]の名前、誕生日、住所がnullであれば
                    continue;               //出力しない
                }else{
                    out.print(dareka[z]);   //そうでなければその情報を出力する
                }   
            }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Method_hikimodori3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Method_hikimodori3 at " + request.getContextPath() + "</h1>");
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
