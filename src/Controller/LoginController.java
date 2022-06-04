package Controller;

import Model.LoginModel;
import Model.m_main_view_model;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginController implements ActionListener{
    String userid;
    String password;
    String position;

    private Login log;
    private LoginModel loginmodel;
    private JButton jButton;

    public LoginController(JButton jButton) {
        this.jButton = jButton;
    }

    public void actionPerformed(ActionEvent e) {
        String buttonname = jButton.getText();
        switch (buttonname) {
            case "로그인":
                m_Movie_info_regis a = new m_Movie_info_regis();
                //a.isAlwaysOnTop();
                a.setModal(true);
                a.setVisible(true);
                break;
            case "회원가입":
                new Login().setVisible(false);
                new Sign_up().setVisible(true);
                break;
            case "비밀번호 찾기":
                 new Login().setVisible(false);
                new PW_search().setVisible(true);
                break;
        }
    }
}
