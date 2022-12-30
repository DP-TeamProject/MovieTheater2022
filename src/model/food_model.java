
package model;
import model.decorator.*;
import java.sql.*;
import static java.time.LocalDate.now;
import static model.DBConnection.dbconnection;
import static model.UserSession.log;


public class food_model {
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    String SQL;
    String Description="";
    String user_id = log.session;
    
    food popcorn;
    Drink soda;
    String coupon_number;
    String menuname = "";
    int cost = 0;
    PreparedStatement pstmt = null;

    public food_model() {
        System.out.println("실행");
    }

    public String getName() {
        return this.menuname;
    }

    public int getCost() {
        return this.cost;
    }

    public String getPopcorntaste() {
        return popcorn.gettaste();
    }

    public String getSodataste() {
        return soda.gettaste();
    }
    
    public String getDescription(){
        //추가 메뉴정보를 반환한다.
        return Description;
    }
    public void addpopcorn(String taste) {
        //스트레티지 패턴 사용
        // 팝콘을 추가한다. 선택된 맛의 팝콘이 생성이 된다.
        if (taste == "sweet") {
            popcorn = new SweetPopcorn();
        } else {
            popcorn = new OriginalPopcorn();
        }
    }
    public void addsoda(String taste) {
        //스트레티지 패턴 사용
        // 팝콘을 추가한다. 선택한 탄산음료가 생성이 된다.
        if (taste == "coke") {
            soda = new Coke();
        } else if (taste == "sprite") {
            soda = new Sprite();
        } else {
            soda = new Fanta();
        }
    }

    public void addnacho(String salsasouce, String deepcheesesouce) {
        //데코레이터 패턴 사용
        // 나초를 추가한다. 선택된 소스 만큼 추가하여 생성된다.
        food f = new Nacho();
        salsasouce = salsasouce.substring(0, 1);
        deepcheesesouce = deepcheesesouce.substring(0, 1);
        for (int i = 0; i < Integer.parseInt(salsasouce); i++) {
            f = new Salsa(f);
        }
        for (int i = 0; i < Integer.parseInt(deepcheesesouce); i++) {
            f = new DipCheese(f);
        }
        this.Description=f.getDescription();
        cost=f.cost();
    }

    public void addcoffe(String milk, String ice, String shot, String coffecombo) {
        // 데코레이터 패턴 사용
        // 나초를 추가한다. 우유,샷,얼음을 추가한 만큼 생성된다.
        Drink drink = new Coffee();
        milk = milk.substring(0, 1);
        ice = ice.substring(0, 1);
        shot = shot.substring(0, 1);
        for (int i = 0; i < Integer.parseInt(milk); i++) {
            drink = new Milk(drink);
        }
        for (int i = 0; i < Integer.parseInt(ice); i++) {
            drink = new Ice(drink);
        }
        for (int i = 0; i < Integer.parseInt(shot); i++) {
            drink = new Shot(drink);
        }
        this.Description=drink.getDescription();
        cost=drink.cost();
    }
    public void addbubbletea(String suger, String pearl, String whitepeal, String coconat) {
        // 데코레이터 패턴 사용
        // 버블티를 추가한다. 설탕,펄,화이트펄, 코코넛을 추가한 만큼 생성된다.
        Drink  drink = new BubbleTea();
        suger = suger.substring(0, 1);
        pearl = pearl.substring(0, 1);
        whitepeal = whitepeal.substring(0, 1);
        coconat = coconat.substring(0, 1);
        for (int i = 0; i < Integer.parseInt(coconat); i++) {
            drink = new Coconut(drink);
        }
        for (int i = 0; i < Integer.parseInt(pearl); i++) {
            drink = new Pearl(drink);
        }
        for (int i = 0; i < Integer.parseInt(suger); i++) {
            drink = new Suger_Content(drink);
        }
        for (int i = 0; i < Integer.parseInt(whitepeal); i++) {
            drink = new White_Pearl(drink);
        }
        this.Description=drink.getDescription();
        cost=drink.cost();
        System.out.println(cost);
    }

    public void addhotdog(String sausage, String pickle, String onion, String souce) {
        // 데코레이터 패턴 사용
        // 핫도그를 추가한다. 소시지, 피클, 양파, 소스를 추가한 만큼 생성된다.
        food f = new HotDog();
        sausage = sausage.substring(0, 1);
        pickle = pickle.substring(0, 1);
        onion = onion.substring(0, 1);
        souce = souce.substring(0, 1);
        for (int i = 0; i < Integer.parseInt(souce); i++) {
            f = new Sauce(f);
        }
        for (int i = 0; i < Integer.parseInt(pickle); i++) {
            f = new Pickle(f);
        }
        for (int i = 0; i < Integer.parseInt(sausage); i++) {
            f = new Sausage(f);
        }
        for (int i = 0; i < Integer.parseInt(onion); i++) {
            f = new Onion(f);
        }
        this.Description=f.getDescription();
        cost=f.cost();
    }

    public void order(int cash) {
        //DB에 사용자가 주문한 금액과 구매한 시간을 저장한다.
        try {
            SQL = "insert into buy_product(user_id, total_price, date, state) values('" + user_id + "','" + cash + "','" + now()+"', 1)";
            con = dbconnection.getConnection();
            st = con.prepareStatement(SQL);
            st.executeUpdate(SQL);
        } catch (SQLException e) {
                System.out.println(e.getSQLState());
            System.out.println("[INSERT 쿼리 오류]\n" + SQL);
        }

    }


}