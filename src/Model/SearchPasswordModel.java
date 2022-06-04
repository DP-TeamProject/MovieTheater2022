
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchPasswordModel {
    
    DBConnection dbConn = new DBConnection();
    String user_id;
    String password;
    String name;
    String SQL = null;
    Statement stmt = null;
    ResultSet rs = null;

    public SearchPasswordModel(String name, String user_id) {
        dbConn.connect();
        this.user_id = user_id;
        this.name = name;
        System.out.println("실행");
    }

    public void SearchPassword() {

        try {
            SQL = "use dp";
            stmt = dbConn.connection.createStatement();
            rs = stmt.executeQuery(SQL);
            SQL = "select password from user where user_id = " + user_id + " and name =" + name;
            stmt = dbConn.connection.createStatement();
            rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                password = rs.getString("password");
                System.out.println("회원님의 비밀번호는 " + password + "입니다.");
            } else {
                System.out.println("일치하는 회원정보가 없습니다 다시 시도해주세요.");
            }

        } catch (SQLException e) {
            System.out.println("[SELECT 쿼리 오류]\n" + e.getStackTrace());
        }
    }
    
}
