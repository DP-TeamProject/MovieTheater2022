package model;

import static java.time.LocalDate.now;
import java.sql.*;
import java.text.*;
import java.util.Random;
import static model.DBConnection.dbconnection;
import static model.UserSession.log;

public class u_main_model {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    String SQL = null;
    String ID = log.session; //사용자의 로그인 세션을 받아와 ID값에 저장
    boolean[] seatformation = new boolean[13];

    public u_main_model() {
        System.out.println("1");
    }

    //영화 목록을 불러오는 메소드
    public String[][] searchMovie() {
        String[][] movieinfo = new String[100][8];
        int number = 0;

        try {
            //데이터베이스 movie테이블에서 영화 정보를 모두 검색
            SQL = "select * from movie";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            while (rs.next()) { //영화 정보들을 movieinfo 배열에 저장
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

    //영화 예약하는 메소드
    public void getMoviePay(String seat, String title) {

        Random random = new Random();
        int rand = random.nextInt(300) + 100;
        int movienum = 0;

        try {
            //사용자가 예약한 영화 제목을  contorller로부터 받아와 영화등록번호 검색하는 SQL문
            SQL = "select movie_num from movie where title = '" + title + "'";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                movienum = rs.getInt("movie_num"); //영화등록번호를 받아와 movienum에 저장
            }

            rs.close();
            st.close();
            //같은 예약번호가 존재하는지 확인하는 SQL문
            SQL = "select * from reser_movie where reser_num  = " + rand;
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (true) {
                //같은 예약번호가 존재할 시 랜덤값 다시 부여
                if (rs.isBeforeFirst() == true) {
                    rand = random.nextInt(300) + 100;
                } else {
                    break;
                }
            }

            rs.close();
            st.close();

            //영화 예매 내역을 데이터베이스에 저장하는 SQL문
            SQL = "insert into reser_movie values(" + rand + "," + movienum + ",'" + ID + "','" + seat + "','" + 10000 + "','" + now() + "', 1)";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);

            rs.close();
            st.close();

            //예매 완료시 다른 사용자가 해당 좌석을 예매 못하도록 하는 SQL문
            SQL = " update seat set " + seat + "=0 where movie_num=" + movienum;
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);

        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + SQL);
        }
    }

    //좌석정보를 받아오는 메소드
    public boolean[] getSeatinformation(String moviename) {
        boolean[] seatformation = new boolean[13];
        int movienum = 0;
        try {
            //영화 이름을 통해 영화 등록 번호를 검색하는 SQL문
            SQL = "select movie_num from movie where title = '" + moviename + "'";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                movienum = rs.getInt("movie_num");
            }

            rs.close();
            st.close();

            //영화 등록번호로 남은 좌석정보 조회하는 SQL문
            SQL = "select * from seat where movie_num = " + movienum;
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);

            /*영화 좌석이 남아있는지 확인하는 부분
                            좌석이 남아있을시 값이 1이므로 true 리턴 없을시 false리턴*/
            if (rs.next()) {
                if (rs.getString("seat1").equals("1")) {
                    seatformation[0] = true;
                } else {
                    seatformation[0] = false;
                }
                if (rs.getString("seat2").equals("1")) {
                    seatformation[1] = true;
                } else {
                    seatformation[1] = false;
                }
                if (rs.getString("seat3").equals("1")) {
                    seatformation[2] = true;
                } else {
                    seatformation[2] = false;
                }
                if (rs.getString("seat4").equals("1")) {
                    seatformation[3] = true;
                } else {
                    seatformation[3] = false;
                }
                if (rs.getString("seat5").equals("1")) {
                    seatformation[4] = true;
                } else {
                    seatformation[4] = false;
                }
                if (rs.getString("seat6").equals("1")) {
                    seatformation[5] = true;
                } else {
                    seatformation[5] = false;
                }
                if (rs.getString("seat7").equals("1")) {
                    seatformation[6] = true;
                } else {
                    seatformation[6] = false;
                }
                if (rs.getString("seat8").equals("1")) {
                    seatformation[7] = true;
                } else {
                    seatformation[7] = false;
                }
                if (rs.getString("seat9").equals("1")) {
                    seatformation[8] = true;
                } else {
                    seatformation[8] = false;
                }
                if (rs.getString("seat10").equals("1")) {
                    seatformation[9] = true;
                } else {
                    seatformation[9] = false;
                }
                if (rs.getString("seat11").equals("1")) {
                    seatformation[10] = true;
                } else {
                    seatformation[10] = false;
                }
                if (rs.getString("seat12").equals("1")) {
                    seatformation[11] = true;
                } else {
                    seatformation[11] = false;
                }
            }

        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + SQL);
        }
        return seatformation;
    }

    //사용자가 예매한 영화 가격과 매점 이용 가격을 출력하는 메소드
    public int[] getPay() {
        int movie_price = 0;
        int store_price = 0;
        int[] value = new int[2];
        value[0] = 0;
        value[1] = 0;
        try {
            //영화 예매 가격을 불러오는 SQL문
            SQL = "select price from reser_movie where user_id = '" + ID + "' and state =1";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                value[1] += rs.getInt("price");
                System.out.println(value[0]);
            }

            rs.close();
            st.close();
            
            //매점 이용 가격을 불러오는 SQL문
            SQL = "select total_price from buy_product where user_id = '" + ID + "'and state=1";
            System.out.println(SQL);
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                value[0] += rs.getInt("total_price");
                System.out.println(value[1]);
            }
        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + e.getCause());

        }
        return value;
    }

    //결제 완료되었을 시 호출되는 함수
    public void paycp() {

        try {
            //영화 예매 결제가 완료되어 결제 상태 값을 바꿔주는 SQL문
            SQL = " update reser_movie set state = 0 where user_id='" + ID + "'";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);

            rs.close();
            st.close();
            
             //매장 결제가 완료되어 결제 상태 값을 바꿔주는 SQL문
            SQL = " update buy_product set state = 0 where user_id='" + ID + "'";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
            System.out.println(SQL);

        } catch (SQLException e) {
            System.out.println("paycp SQL 오류 : " + SQL);
        }

    }
}
