/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
/**
 *
 * @author tjdck
 */
public class m_movie_info_regis_model {
    int number;
    String moviename;
    String runtime;
    int age;
    String dirctor;
    String actor;
    String category;
    String releaseday;
    PreparedStatement pstmt = null;
    public  m_movie_info_regis_model(String moviename){
            this.moviename=moviename;
    }
    public  m_movie_info_regis_model(String moviename, String runtime, String age,String dirctor,String actor,String category,String releaseday){
        this.actor=actor;
        this.age=Integer.parseInt(age);
        this.category=category;
        this.dirctor=dirctor;
        this.runtime=runtime;
        this.releaseday=releaseday;
        System.out.println("실행");
    }
    public void appendMovie() {
		//int id = -1;
		//Statement statement = null;
		//ResultSet rs = null;
		try {
                         String SQL = "insert into customers(moviename, runtime, age, dirctor, actor,category,releaseday) values(?, ?, ?, ?, ?,?,?)";
                         
                            pstmt.setString(1, moviename);
                            pstmt.setString(2, runtime);
                            pstmt.setInt(3, age);
                            pstmt.setString(4, dirctor);
                            pstmt.setString(5, actor);
                            pstmt.setString(6, category);
                            pstmt.setString(7, releaseday);
                            int addrow = pstmt.executeUpdate();
                            System.out.println("추가된 행의 수 : " + addrow);
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
    public void deleteMovie() {
		//int id = -1;
		//Statement statement = null;
		//ResultSet rs = null;
		try {
                         String SQL = "DELETE FROM table WHERE moviename = ?";
                         pstmt = dbConn.connection.prepareStatement(SQL);
                            pstmt.setString(1, moviename);
                            int addrow = pstmt.executeUpdate();
                            System.out.println("추가된 행의 수 : " + addrow);
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
                }
	}
}