
package Model;

import java.sql.*;
import static Model.DBConnection.dbconnection;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author tjdck
 */
public class Login_model {
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;
    
    String auth = null;
    String pass = null;
    String SQL;
    String id;
    String pw;
    String type;
    String birthday;
    String phonenumber;
    String name;
    

    public Login_model() {
        System.out.println("tl");
    }

    public Login_model(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public Login_model(String id, String pw, String name, String birthday, String phonenumber) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phonenumber = phonenumber;
        this.birthday = birthday;
    }

    public Login_model(String id, String pw, String type) { //login
        this.id = id;
        this.pw = pw;
        this.type = type;
    }

    public void signup(String id, String pw, String name, String birth, String phone_num) {
        try {
            SQL = "insert into user(user_id,password,name,birth,phone_num) values('" + id + "','" + pw + "','" + name + "','" + birth + "','" + phone_num + "')";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            int addrow = st.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "회원가입 완료 되었습니다.");
        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
        }
    }

    public void findpw(String id, String name) {
        try {
            if (DBConnection.getInstance().Initailize()) {
            SQL = "select password FROM user WHERE user_id = '" + id + "' and name = '" +name+"'";
             //System.out.println(SQL);
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            System.out.println(rs.isBeforeFirst()+ "3");
            if (rs.next()) {
                pass = rs.getString("password");
            }
        }
           
            
            JOptionPane.showMessageDialog(null, "회원님의 비밀번호는"+pass+"입니다.");

        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
        }
    }

    public void login(String id, String pw) {

        try {
            if ("user".equals(type)) {
                SQL = "select * FROM user WHERE user_id = " + id;
                st = dbconnection.getInstance().getConnection().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("user_id");
                    pass = rs.getString("password");
                }
            }
            if ("manager".equals(type)) {
                SQL = "select * FROM manager WHERE manager_id = " + id;
                st = dbconnection.getInstance().getConnection().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("manager_id");
                    pass = rs.getString("password");
                }
            }

            if (id.equals(auth) && pw.equals(pass)) {
                showMessageDialog(null, "로그인 성공");
                //return true;
            } else if (!id.equals(auth)) {
                showMessageDialog(null, "등록되지 않은 정보입니다. 아이디를 확인해 주세요");
                //return false;
            } else {
                showMessageDialog(null, "암호가 틀렸습니다.   다시 확인해주세요");
                //return false;
            }
        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
        }
    }
}
