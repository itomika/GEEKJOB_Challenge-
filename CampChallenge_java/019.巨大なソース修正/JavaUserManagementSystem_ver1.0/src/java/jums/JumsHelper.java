package jums;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラスです。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    private final String homeURL = "index.jsp"; //トップへのリンクを定数として設定
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    public String home(){   //トップへのリンクを返却
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
}
