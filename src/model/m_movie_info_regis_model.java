package model;

import model.movie.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.sql.Statement;
import static model.DBConnection.dbconnection;

public class m_movie_info_regis_model {

    movie m = new movie();
    String title;
    String runtime;
    String director;
    String actor;
    String genre;
    String openingdate;
    String age;
    int movienum;

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    String SQL = null;

    public m_movie_info_regis_model(String title) {
        this.title = title;
    }

    public m_movie_info_regis_model() {

    }

    public String[][] getmovielist() {
        String[][] movieinfo = new String[100][8];
        int number = 0;

        try {
            SQL = "select * from movie";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                movieinfo[number][0] = rs.getString("movie_num");
                movieinfo[number][1] = rs.getString("title");
                movieinfo[number][2] = rs.getString("director");
                movieinfo[number][3] = rs.getString("actor");
                movieinfo[number][4] = rs.getString("genre");
                movieinfo[number][5] = rs.getString("age");
                movieinfo[number][6] = rs.getString("run_time");
                movieinfo[number][7] = rs.getString("opening_date");
                number++;
            }
        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
        }
        return movieinfo;
    }
    //관리자가 입력한 영화 정보를 controller로부터 받아와 영화등록하는 메소드

    public int appendMovie(String title, String runtime, String age, String director, String actor, String genre, String openingdate) {
        Random random = new Random();
        this.actor = actor;
        this.age = age;
        this.genre = genre;
        this.director = director;
        this.runtime = runtime;
        this.openingdate = openingdate;
         // 랜덤값을 100부터 300사이로 지정 나중에 영화등록번호 지정할때 사용
        int rand = random.nextInt(300) + 100;

        try {
            //각 장르별로 그에 해당하는 mdel.movie의 메소드 호출
            switch (genre) {
                case "액션":
                    m = new Action_movie();
                    break;
                case "SF":
                    m = new SF_movie();
                    break;
                case "로맨스":
                    m = new Romance_movie();
                    break;
                case "공포":
                    m = new Scary_movie();
                    break;
                case "코미디":
                    m = new Comedy_movie();
                    break;
            }
            //각 연령별로 그에 해당하는 mdel.movie의 메소드 호출
            switch (age) {
                case "ALL":
                    m.setAge_Limit(new All());
                    break;
                case "Youth":
                    m.setAge_Limit(new Youth());
                    break;
                case "Adult":
                    m.setAge_Limit(new Adult());
                    break;
            }
            
            //똑같은 영화등록번호가 있는지 체크하는 SQL문
            SQL = "select * from movie where movie_num = " + rand;
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (true) {
                if (rs.isBeforeFirst() == true) { //같은 영화등록번호가 있을경우 다른 랜덤값 생성
                    rand = random.nextInt(300) + 100;
                } else {
                    break;
                }
            }
            //같은 영화 제목이 존재하는지 검사하는 SQL문
            SQL = "select * from movie where title = '" + title + "'";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) { 
                return 2;
            } else { //같은 영화 제목이 존재하지 않을 시 영화 정보를 데이터베이스에 저장하고 영화 등록 완료.
                SQL = "insert into movie values('" + rand + "','" + director + "','" + actor + "','" + m.getcategory() + "','" + m.getAge_Limit() + "','" + title + "','" + runtime + "','" + openingdate + "')";
                con = DBConnection.getConnection();
                st = con.prepareStatement(SQL);
                st.executeUpdate(SQL);
                rs.close();
                st.close();
                //해당 영화번호에 좌석을 1로 초기화 해줌으로써 예약가능한 좌석을 생성
                SQL = "insert into seat values(" + rand + ", 1,1,1,1,1,1,1,1,1,1,1,1)"; 
                st = con.prepareStatement(SQL);
                st.executeUpdate(SQL);
            }
            return 1;
        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
            return 0;
        }
    }
}
