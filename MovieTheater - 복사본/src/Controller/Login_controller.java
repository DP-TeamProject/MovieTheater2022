/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.m_Main_view;
import View.m_Movie_info_regis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension; 
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Model.m_main_view_model;
import Model.Login_model;
import View.*;
import View.Sign_up;
import View.m_Coupon_regis;

/**
 *
 * @author tjdck
 */
public class Login_controller implements ActionListener{
    private Login view;
    private JButton jButton;
    private Login_model m_movie_info_regis_model;
    private Login_model model;
    private String id;
    private String pw;
    private String logintype;
    public Login_controller() {
        
    }
    public Login_controller(JButton jButton) {
        this.jButton = jButton;
    }
    public Login_controller(Login view ,Login_model model) {
        this.model=model;
        this.view=view;
        this.view.setaddActionListener(this);
    }
    public Login_controller(JButton jButton,JTextField id,JTextField pw,String radioreturn) {
        this.id=id.getText();
        this.pw=pw.getText();
        this.jButton=jButton;
        this.logintype=radioreturn;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.signupbtn){
            Sign_up view = new Sign_up(new javax.swing.JFrame(), true);
            Login_model model = new Login_model();
            Sign_up_controller controller = new Sign_up_controller(view, model);
            view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent ae) {
                        view.dispose();
                    }
                });
            view.setVisible(true);
        }
        else if(e.getSource() == view.loginbtn){
            id= view.getid();
            pw=view.getpw();
           // boolean chekclogin = model.login(id,pw);
        }
        else if(e.getSource() == view.findpwbtn){
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
