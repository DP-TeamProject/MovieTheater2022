package controller;

import model.DBConnection;
import model.Login_model;
import javax.swing.JFrame;

import view.Login;

public class MovieMainApp extends JFrame {
    // 프로그램 명 : 24/21 Cinema
    // 프로그램 목적 : 디자인 패턴을 활용하여 영화관 기능 구현
    // 프로그램 버전 : 1.01
    // 작성자 : 김성찬, 강상혁, 김민승, 송준섭
    // 최초 작성일 : 2022-05-20
    // 최종 작성일 : 2022-06-10
    // 변경 내용 : 2022-05-20 - 최초 장석
    //            2022-06-10 - 파일 입/출력 방식에서 MYSQL을 사용하는 방법으로 변경.
    // 주의할 점 : DB연결을 위해 mysql-connector-java-8.0.29를 Libraries에 추가해야한다. ID / PW가 DB에 저장이 되어있어야 로그인이 가능하다.
    // 설명 : 데코레이터, 스트레티지, 옵저버, 퍼사드, MVC 패턴을 이용하여 영화관 기능을 구현한다.
    //        -- 데코레이터 패턴 : 핫도그, 나초, 커피, 버블티 생성시 사용 (food_model.java) | 2022-05-18 검사
    //        -- 스트레티지 패턴 : 영화 장르 선택 및 탄산음료, 팝콘 맛 결정에 사용 (m_movie_info_regis_model, food_model) | 2022-05-25 검사
    //        -- 옵저버 패턴 : 매출정보에 사용 (m_main_view_model.java) | 2022-05-31 검사
    //        -- 퍼사드 패턴 : 영화관 내부 관리에 사용(m_main_view_model.java) | 2022-06-08 검사
    //        -- MVC 패턴 : 전체적인 구조를 설계하는데 사용
    public static void main(String[] args) {
        if (DBConnection.getInstance().Initailize()) {
            Login view = new Login(new javax.swing.JFrame(), true);
		Login_model model = new Login_model();
		Login_controller controller = new Login_controller(view, model);
		view.setVisible(true);
                view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
        }

    }
}
