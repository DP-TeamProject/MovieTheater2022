/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import static Model.DBConnection.dbconnection;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class food_model {
    
    private Statement st;
    private ResultSet rs;
    private Connection con;
    String SQL;
    String menuname="";
    int cost=0;
    PreparedStatement pstmt = null;

    public food_model() {
        System.out.println("실행");
    }
    public String getName(){
        return this.menuname;
    }
    public int getCost(){
        return this.cost;
    }
    public void addpopcorn() {
        cost=0;
	//food f= new popcorn();
		
	}
    public void addnacho() {
        cost=0;
		Statement statement = null;
		ResultSet rs = null;
		try {
                            System.out.println("추가된 행의 수 : " + addrow);
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
    public void addcoffe() {
        cost=0;
		Statement statement = null;
		ResultSet rs = null;
		try {
                        
                            System.out.println("추가된 행의 수 : " + addrow);
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
    public void addsoda() {
        cost=0;
		Statement statement = null;
		ResultSet rs = null;
		try {
                        
     
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
    public void addbubbletea() {
        cost=0;
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
    public void addhotdog() {
        cost=0;
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
}