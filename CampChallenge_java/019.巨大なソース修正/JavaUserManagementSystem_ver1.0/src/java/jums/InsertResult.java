package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        HttpSession hs = request.getSession();  //セッションスタート
        
        try{            
            
            request.setCharacterEncoding("UTF-8");  //文字コードを指定
            
            String accesschk =request.getParameter("ac");   //"ac"を取り出す
            
            if (accesschk == null || (Integer)hs.getAttribute("ac") != Integer.parseInt(accesschk)) {   //アクセスチェック
                throw new Exception("不正なアクセスです");
            }

            UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb"); //セッションに入れた"udb"を取り出す
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            //DTOのインスタンスを作って、値をセット
            UserDataDTO userdata = new UserDataDTO();
            
            userdata.setName(udb.getName());    //カレンダークラスのインスタンスを生成
            
            Calendar day = Calendar.getInstance();
            
            day.set(udb.getYear(),udb.getMonth() -1,udb.getDay());  //年、月、日付をセット
            
            userdata.setBirthday(day.getTime());    //getTimeで日付を取り出す
            userdata.setType(udb.getType());
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());
            
            UserDataDAO.getInstance().insert(userdata);  //DBへデータの挿入　DTOにセットした値をDAOにINSERTする
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(Exception e){
            
            request.setAttribute("error", e.getMessage());  //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.getRequestDispatcher("/error.jsp").forward(request, response);        
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
