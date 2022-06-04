/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Seongchan
 */
public class DBConnection {
        Connection connection;
    public DBConnection(){
        
    }
    public void connect() {
    String url = "jdbc:mysql://211.213.95.123/dp?serverTimezone=UTC";
    String user = "20183109";
    String password = "1q2w3e4r";
    String driverName = "com.mysql.cj.jdbc.Driver";
    try {
	Class.forName(driverName);
	this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
                // `com.mysql.cj.jdbc.Driver` 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
		System.out.println("[DB로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[DB연결 오류]\n" + e.getStackTrace());
		}
	}
}
