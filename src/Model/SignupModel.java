package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupModel {

    DBConnection dbConn = new DBConnection();
    String user_id;
    String password;
    String name;
    String birth;
    String phone_num;
    String SQL = null;
    PreparedStatement pstmt;
    Statement stmt = null;
    ResultSet rs = null;

    public SignupModel(String name, String user_id, String password, String birth, String phone_num) {
        dbConn.connect();
        this.name = name;
        this.user_id = user_id;
        this.password = password;
        this.birth = birth;
        this.phone_num = phone_num;

        System.out.println("실행");
    }

    public void Signup() {

        try {
            SQL = "use dp";
            stmt = dbConn.connection.createStatement();
            rs = stmt.executeQuery(SQL);
            SQL = "select * from user where user_id = " + user_id;
            stmt = dbConn.connection.createStatement();
            rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                System.out.println("일치하는 아이디가 존재합니다 다른 아이디를 사용해주세요");
                stmt.close();
                rs.close();
            } else {
                SQL = "use dp";
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                SQL = "select * from user where phone_num =" + phone_num;
                stmt = dbConn.connection.createStatement();
                rs = stmt.executeQuery(SQL);
                if (rs.next()) {
                    System.out.println("이미 존재하는 휴대폰 번호입니다 다른 번호 사용 부탁드립니다.");
                } else {
                    if (password.length() > 8) {
                        System.out.println("비밀번호는 8자리 이내로 설정해주세요");
                    } else {
                        SQL = "use dp";
                        stmt = dbConn.connection.createStatement();
                        rs = stmt.executeQuery(SQL);
                        SQL = "insert into user(user_id, password, name, birth, phone_num) values(?, ?, ?, ?, ?)";
                        pstmt = dbConn.connection.prepareStatement(SQL);
                        pstmt.setString(1, user_id);
                        pstmt.setString(2, password);
                        pstmt.setString(3, name);
                        pstmt.setString(4, birth);
                        pstmt.setString(5, phone_num);
                        int addrow = pstmt.executeUpdate();
                        System.out.println("추가된 행의 수 : " + addrow);
                    }

                }

            }

        } catch (SQLException e) {
            System.out.println("[SELECT 쿼리 오류]\n" + e.getStackTrace());
        }
    }

}
