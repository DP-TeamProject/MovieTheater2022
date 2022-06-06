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
public class PW_search_controller implements ActionListener{
    private PW_search view;
    private Login_model model;
    private String id;
    private String name;
    private Login_model m_movie_info_regis_model;
    public PW_search_controller(JButton jButton, JTextField id, JTextField name) {
        this.id=id.getText();
        this.name=name.getText();
        
    }

    public PW_search_controller(PW_search view, Login_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.okbtn){
            this.id = view.getId();
            this.name=view.getNamefiled();
            model.findpw(id,name);
        }
        else if (e.getSource() == view.cancel){
            this.view.dispose();
        }
    }
}
