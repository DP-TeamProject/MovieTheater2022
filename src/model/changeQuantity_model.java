
package model;
import java.sql.*;
import static model.DBConnection.dbconnection;

public class changeQuantity_model {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    String auth = null;
    String pass = null;
    String SQL;

    
    public changeQuantity_model() {

    }
    public boolean changeQuantity(String menuname , String quantity) {
        try {
            //수량 변경 이벤트 발생시 store테이블에 해당 메뉴의 수량을 변경
            SQL = "update store set count="+quantity+" where product_name = '"+menuname+"'"; 
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
            return true;
        } catch (SQLException e) {
            System.out.println("수량 변경 오류 :" + SQL);
            return false;
        }
    }
    public String[][] getfoodlist() {
       String[][] countIformation = new String[8][2];
        int number = 0;
        try {
            //데이터베이스의 store에 저장되어있는 정보들을 불러온다.
            SQL = "select * from store";
            st = dbconnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                countIformation[number][0] = rs.getString("product_name"); //데이터베이스에 저장된 물품명을 저장
                countIformation[number][1] = rs.getString("count");//데이터베이스에 저장된 물품 수량을 저장
                number++;
            }
        } catch (SQLException e) {
            System.out.println("[쿼리 오류]\n" + SQL);
        }
        return countIformation;
    }

    
}