package Model;

import Model.Strategy.Adult;
import Model.Strategy.SF_movie;
import Model.Strategy.Comedy_movie;
import Model.Strategy.Romance_movie;
import Model.Strategy.All;
import Model.Strategy.movie;
import Model.Strategy.Action_movie;
import Model.Strategy.Scary_movie;
import Model.Strategy.Youth;
import static Model.DBConnection.dbconnection;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class m_movie_info_regis_model {

    movie m = new movie();
    String title;
    String runtime;
    String director;
    String actor;
    String genre;
    String openingdate;
    String age;
    int number;
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

    public void appendMovie(String title, String runtime, String age, String director, String actor, String genre, String openingdate) {
        Random random = new Random();
        this.actor = actor;
        this.age = age;
        this.genre = genre;
        this.director = director;
        this.runtime = runtime;
        this.openingdate = openingdate;
        int rand = random.nextInt(300) + 100;

        try {
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
        
        SQL = "select * from movie where movie_num = " + rand;
        st = dbconnection.getInstance().getConnection().createStatement();
        rs = st.executeQuery(SQL);
        while (true) {
            if (rs.isBeforeFirst() == true) {
                rand = random.nextInt(300) + 100;
            } else {
                break;
            }
        }
        SQL = "insert into movie values('" + rand + "','" + director + "','" + actor + "','" +  m.getcategory() + "','" + m.getAge_Limit() + "','" + title + "','" + runtime + "','" + openingdate + "')";
        con = dbconnection.getConnection();
        st = con.prepareStatement(SQL);
        st.executeUpdate(SQL);
        JOptionPane.showMessageDialog(null, "영화등록이 완료되었습니다.");

    }
    catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
    }
}

public void deleteMovie(String movienum) {
        this.movienum = Integer.parseInt(movienum);
        try {
            SQL = "DELETE FROM movie WHERE movie_num =" + movienum;
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "영화삭제 완료하였습니다.");

        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
        }
    }
}
