package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import model.Login_model;
import model.m_main_view_model;
import model.u_main_model;
import view.*;

public class Login_controller implements ActionListener {

    private Login view;
    private Login_model model;
    private String id;
    private String pw;
    private String logintype;

    public Login_controller(Login view, Login_model model) {
        this.model = model;
        this.view = view;
        this.view.setaddActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.signupbtn) {
            //회원가입버튼을 클릭시 실행이 된다.
            Sign_up login = new Sign_up(new javax.swing.JFrame(), true);
            Login_model model = new Login_model();
            Sign_up_controller controller = new Sign_up_controller(login, model);
            login.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent ae) {
                    login.dispose();
                }
            });
            login.setVisible(true);

        } else if (e.getSource() == view.loginbtn) {
            //로그인버튼 클릭시 실행이 된다.
            id = view.getid();
            pw = view.getpw();
            logintype = view.getButtonGroup2();
            boolean chekclogin = model.login(id, pw, logintype);
            if (chekclogin) {
                // 로그인 성공시 실행된다.
                showMessageDialog(null, "로그인 성공!");
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
                if (logintype.equals("user")) {
                    //사용자로 로그인 한 경우
                    u_Main_view view = new u_Main_view(new javax.swing.JFrame(), true);
                    u_main_model model = new u_main_model();
                    u_main_view_controller controller = new u_main_view_controller(view, model);
                    view.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    view.setVisible(true);
                } else {
                    // 관리자로 로그인 한 경우
                    m_Main_view view = new m_Main_view(new javax.swing.JFrame(), true);
                    m_main_view_model model = new m_main_view_model();
                    m_main_view_controller controller = new m_main_view_controller(view, model);
                    view.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    view.setVisible(true);
                }

            } else {
                // 로그인 실패시 실행이된다.
                showMessageDialog(null, "아이디 혹은 비밀번호를 확인해 주세요");
            }

        } else if (e.getSource() == view.findpwbtn) {
            //비밀번호 찾기 버튼 클릭시 실행이 된다.
            PW_search view = new PW_search(new javax.swing.JFrame(), true);
            Login_model model = new Login_model();
            PW_search_controller controller = new PW_search_controller(view, model);
            view.setVisible(true);
            view.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    view.dispose();
                }
            });
        }

    }
}
