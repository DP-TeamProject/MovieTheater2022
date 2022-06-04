package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginModel { // 데이터베이스에서 받은 데이터를 가공하는 역할

    DBConnection dbConn = new DBConnection();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    String id;
    String pw;
    String user;
    String manager;
    String auth;
    String pass;

    public LoginModel(String id, String pw, String user, String manager) {
        this.id=id;
        this.pw=pw;
        this.user=user;
        this.manager=manager;
    }

    public LoginModel() {
        
        String SQL;

        try {
            if ("manger".equals(manager)) {
                System.out.println(manager);
                SQL = "use dp";
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                SQL = "select * from manager where manager_id = " + id;
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("manager_id");
                    pass = rs.getString("password");
                }
            } else if ("user".equals(user)) {
                System.out.println(user);
                SQL = "use dp";
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                SQL = "select * from user where user_id = " + id;
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("user_id");
                    pass = rs.getString("password");
                }
            }

            if (id.equals(auth) && pw.equals(pass)) {
                showMessageDialog(null, "로그인 성공");
                //return true;
            } else if (!id.equals(auth)) {
                showMessageDialog(null, "등록되지 않은 회원 정보입니다. 아이디를 다시 확인해주세요");
                //return false;
            } else {
                showMessageDialog(null, "암호가 틀렸습니다. 다시 확인해주세요");
                //return false;
            }

        } catch (Exception e) {
            System.out.println("데이터베이스 검색 오류 :" + e.getMessage());
        }
        //return false;

    }

}
