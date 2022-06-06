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
import View.m_Coupon_regis;

/**
 *
 * @author tjdck
 */
public class Sign_up_controller implements ActionListener{
    private Sign_up view;
    private String id;
    private String pw;
    private String name;
    private String birthday;
    private String phonenumber;
    private Login_model model;
    public Sign_up_controller(JButton jButton, JTextField id, JTextField pw,JTextField name,JTextField birthday,JTextField phonenumber) {//only ok
      //  this.jButton = jButton;
        this.id=id.getText();
        this.pw=pw.getText();
        this.name=name.getText();
        this.birthday=birthday.getText();
        this.phonenumber=phonenumber.getText();
    }
    public Sign_up_controller(Sign_up view, Login_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

          if(e.getSource() == view.okbtn){
            this.id = view.getId();
            this.name=view.getNamefiled();
            this.pw=view.getPw();
            this.birthday=view.getBirthday();
            this.phonenumber=view.getPhonenumber();
            model.signup( id,  pw,  name,  birthday,  phonenumber);
        }
          else if (e.getSource() == view.cancel){
              this.view.dispose();
          }
    }
}
