/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author tjdck
 */
public class m_Coupon_model {
    DBConnection dbConn = new DBConnection();
    String coupon_number;
    PreparedStatement pstmt = null;
    public  m_Coupon_model(String coupon_number){
        dbConn.connect();
        this.coupon_number=coupon_number;
        System.out.println("실행");
    }

    public m_Coupon_model() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void appendcoupon() {
		int id = -1;
		Statement statement = null;
		ResultSet rs = null;
		try {
                         String SQL = "insert into coupon(coupon_number) values(?)";
                         pstmt = dbConn.connection.prepareStatement(SQL);
                            pstmt.setString(1, coupon_number);
                            int addrow = pstmt.executeUpdate();
                            System.out.println("추가된 행의 수 : " + addrow);
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
    public void checkcoupon() {//쿠폰이 있는지 확인, 못쓰면 못 쓴다고 출력해주기
		int id = -1;
		Statement statement = null;
		ResultSet rs = null;
		try {
                         String SQL = "select * from coupon coupon(coupon_number) values(?)";
                         pstmt = dbConn.connection.prepareStatement(SQL);
                            pstmt.setString(1, coupon_number);
                            //int addrow = pstmt.executeUpdate();
                            
                            //select * from where
                            //if
                            //else
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
}