package model;

import static model.DBConnection.dbconnection;
import model.observer.*;
import java.sql.*;
import model.facade.*;
import model.movie.movie;


public class m_main_view_model {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    movie m = new movie();
    String title;
    String runtime;
    String director;
    String actor;
    String genre;
    String openingdate;
    String age;
    int movienum;
    String SQL;
    int store_price=0;
    int movie_price=0;
    int total_price=0;
    SalesData salesData;
    ManagerDisplay managerdisplay;
    MovieSalesDisplay msaledisplay;
    FoodSalesDisplay fsaledisplay;
    Internal_Management facade;

    public m_main_view_model() {
	facade = new Internal_Management (new Sound(), new Beam_Projector(), new Light(), new Temp());
    }

    public int getManagerdisplay() {
        return managerdisplay.Currentprice;
    }

    public int getMsaledisplay() {
        return msaledisplay.Movieprice;
    }

    public int getFsaledisplay() {
        return fsaledisplay.Foodprice;
    }

    public void updatevalue() {
         salesData = new SalesData();
        managerdisplay = new ManagerDisplay(salesData);
        msaledisplay = new MovieSalesDisplay(salesData);
        fsaledisplay = new FoodSalesDisplay(salesData);

        movie_price=0;
        store_price=0;
        total_price=0;
        managerdisplay = new ManagerDisplay(salesData);
        msaledisplay = new MovieSalesDisplay(salesData);
        fsaledisplay = new FoodSalesDisplay(salesData);
        try {
            //매점 총 매출 값 불러오기
            SQL = "select total_price FROM buy_product";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                store_price += rs.getInt("total_price");
                System.out.println(store_price);
            }            
            rs.close();
            st.close();            
            //영화 총 매출 값 불러오기
            SQL = "select price FROM reser_movie";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                movie_price += rs.getInt("price");
                System.out.println(movie_price);
            }            
            total_price = movie_price + store_price;
        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + SQL);
        }
        //영화표 총 매출 값 불러오기
        salesData.settotalChanged(movie_price, 1, "영화");
        salesData.settotalChanged(store_price, 1, "매점");
        salesData.settotalChanged(total_price, 1, "총합");
    }

    public void ON() {
        //영화 시작시 Internal_Management의 on메소드 호출; 
        facade.on();
    }

    public void OFF() {
        //영화 종료시 Internal_Management의 off메소드 호출; 
        facade.off();
    }
    
    //영화목록을 불러오는 메소드
    public String[][] getmovielist() {
        String[][] movieinfo = new String[100][8];
        int number = 0;

        try {
            //데이터베이스로부터 영화 정보를 불러오는 SQL문
            SQL = "select * from movie";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                movieinfo[number][0] = rs.getString("movie_num"); //영화 등록번호를 불러와 movieinfo배열에 저장
                movieinfo[number][1] = rs.getString("title");//영화 제목을 불러와 movieinfo배열에 저장
                movieinfo[number][2] = rs.getString("director");//영화 감독을 불러와 movieinfo배열에 저장
                movieinfo[number][3] = rs.getString("actor");//영화 배우를 불러와 movieinfo배열에 저장
                movieinfo[number][4] = rs.getString("genre");//영화 장르를 불러와 movieinfo배열에 저장
                movieinfo[number][5] = rs.getString("age");//영화 연령을 불러와 movieinfo배열에 저장
                movieinfo[number][6] = rs.getString("run_time");//영화 상영시간을 불러와 movieinfo배열에 저장
                movieinfo[number][7] = rs.getString("opening_date");//영화 개봉일을 불러와 movieinfo배열에 저장
                number++;
            }
        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
        }
        return movieinfo;
    }
    //물품 목록을 불러오는 메소드
    public String[][] getfoodlist() {
       String[][] countIformation = new String[8][2];
        int number = 0;
        try {
            //데이터베이스  store 테이블로부터 물품 목록 검색
            SQL = "select * from store";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                countIformation[number][0] = rs.getString("product_name"); //물품 번호를 불러와 countIformation배열에 저장
                countIformation[number][1] = rs.getString("count");//물품 수량을 불러와 countIformation배열에 저장
                number++;
            }
        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + SQL);
        }
        return countIformation;
    }
       public void on() {
        //퍼사드 패턴 사용
        //퍼사드(스피커, 빔프로젝터, 전등, 에어컨)를  on 시킨다.
        facade.on();
    }

    public void off() {
        //퍼사드 패턴 사용
        //퍼사드(스피커, 빔프로젝터, 전등, 에어컨)를  off 시킨다.
        facade.off();
    }
    public String getSound(){
        //퍼사드패턴 사용
        //스피커의 상태를 반환한다.
        if(facade.sound.state) return "ON";
        else return "OFF";
    }
    public String getBeam_Projector(){
        //퍼사드패턴 사용
        //빔프로젝터의 상태를 반환한다.
        if(facade.beam_Projector.state) return "ON";
        else return "OFF";
    }
    public String getLight(){
        //퍼사드패턴 사용
        //전등의 상태를 반환한다.
        if(facade.light.state) return "ON";
        else return "OFF";
    }
    public String getTempstate() {
        //퍼사드패턴 사용
        //에어컨의 상태를 반환한다.
        if(facade.temp.state) return "ON"; 
        else return "OFF";
    }
    public int getTemp(){
        //퍼사드패턴 사용
        //에어컨의 온도를 반환한다.(초기 설정온도 : 30'C)
        return facade.temp.temp;
    }
    public void setTemp(int temp){
        //퍼사드패턴 사용
        //에어컨의 온도를 설정한다.
        facade.temp.temp=temp;
    }
    //등록된 영화를 삭제하는 메소드
    public boolean deleteMovie(String movienum) {
        
        /*영화등록 번호가 외래키로 설정되어 있어 
            등록된 영화를 삭제하기 위해서는 자식 테이블인 예약 목록과 좌석 정보들을 삭제해야한다.*/
        try {
            SQL = "DELETE FROM reser_movie WHERE movie_num =" + Integer.parseInt(movienum);
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
            
            st.close();
            
            SQL = "DELETE FROM seat WHERE movie_num =" + Integer.parseInt(movienum);
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
             
            st.close();
            
            SQL = "DELETE FROM movie WHERE movie_num =" + Integer.parseInt(movienum);
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
           
            return true;

        } catch (SQLException e) {
            System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
            return false;
            
        }
    }

}