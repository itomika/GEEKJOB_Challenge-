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
public class Method_hikimodori1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //引数が１つのメソッドを作成してください。
    //メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
    //それ以降は課題「戻り値2」と同じ処理にしてください。
    
    String[] prof(String hitobito){ //引数(hitobito)が1つのprofメソッド   
    
        String[] hito1 ={"1","伊藤美香","1989/10/31","群馬"};    //hito1の中に4つの要素の配列
        String[] hito2 ={"2","伊藤一樹","1984/08/08","香川"};
        String[] hito3 ={"3","伊藤優香","1981/09/21","広島"};
        
        if(hitobito == "1"){     //[hitobito]と[1234]が等しければ
            return hito1;           //hito1の内容をメソッドに返す
        }else if(hitobito == "2"){   //[hitobito]と[5678]が等しければ
            return hito2;               //hito2の内容をメソッドに返す
        }else if(hitobito == "3"){   //[hitobito]と[9101]が等しければ
            return hito3;               //hito3の内容をメソッドに返す
        }else{
            return null;    //ないことを返す。
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String[] dareka = prof("2");
                for(int i=1;i<dareka.length;i++){
                    out.print(dareka[i]);
                }
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Method_hikimodori1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Method_hikimodori1 at " + request.getContextPath() + "</h1>");
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
