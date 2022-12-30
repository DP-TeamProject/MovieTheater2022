package model;

import java.sql.*;
import static model.DBConnection.dbconnection;
import static model.UserSession.log;

public class Login_model {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    String auth = null;
    String pass = null;
    String SQL;
    String id;
    String pw;
    String logintype;
    String birthday;
    String phonenumber;
    String name;

    public Login_model() {

    }

    //회원가입 이벤트 발생시 실행
    public boolean signup(String id, String pw, String name, String birth, String phone_num) {
        try {
            //Login_controller에서 사용자가 입력한 값을 넘겨 받아 user테이블에 값을 넘겨준다.
            SQL = "insert into user(user_id,password,name,birth,phone_num) values('" + id + "','" + pw + "','" + name + "','" + birth + "','" + phone_num + "')";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            int addrow = st.executeUpdate(SQL);
            return true;
        } catch (SQLException e) {

            return false;

        }
    }

    //비밀번호 이벤트 발생시 실행
    public String findpw(String id, String name) {
        try {
            //Login_controller에서 사용자가 입력한 값을 넘겨 받아 사용자 아이디로 user테이블에서 검색한다.
            SQL = "select password FROM user WHERE user_id = '" + id + "' and name = '" + name + "'";
            //System.out.println(SQL);
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);

            if (rs.next()) {
                pass = rs.getString("password");
                return pass;
            } else {
                return "errorinformation";
            }
        } catch (SQLException e) {
            return "errorinformation";

        }
    }

    //로그인 이벤트 발생시 실행
    public boolean login(String id, String pw, String logintype) {
        this.id = id;
        this.pw = pw;
        this.logintype = logintype;
        try {
            if ("user".equals(logintype)) {//로그인 타입이 사용자일 경우
                //Login_controller에서 사용자가 입력한 아이디로 user테이블에서 정보 검색
                SQL = "SELECT * FROM user WHERE user_id = '" + id + "'";
                st = dbconnection.getInstance().getConnection().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("user_id"); //user테이블에 조건에 맞는 결과 아이디 값을 auth에 저장
                    pass = rs.getString("password"); //user테이블에 조건에 맞는 결과 패스워드 값을 pass에 저장   
                }
            }
            if ("root".equals(logintype)) {//로그인 타입이 매니저일 경우
                //Login_controller에서 관리자가 입력한 아이디로 manager테이블에서 정보 검색
                SQL = "select * FROM manager WHERE manager_id = '" + id + "'";
                st = dbconnection.getInstance().getConnection().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    auth = rs.getString("manager_id");//manager테이블에 조건에 맞는 결과 아이디 값을 auth에 저장
                    pass = rs.getString("password");//manager테이블에 조건에 맞는 결과 패스워드 값을 pass에 저장   

                }
            }

        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
        }
        if (id.equals(auth) && pw.equals(pass)) { //사용자가 입력한 아이디와 패스워드가 데이터베이스에 저장되어있는 값과 일치할시
            log.setSession(auth);//사용자 로그인 정보를 세션으로 저장
            System.out.println("세션 생성 : " + log.session);
            return true;
        } else if (!id.equals(auth)) { //사용자가 입력한 아이디가 데이터베이스에 저장되어있는 값과 일치 하지 않을시
            return false;
        } else {
            return false;
        }
    }
}
