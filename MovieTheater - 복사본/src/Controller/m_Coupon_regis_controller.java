/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.m_Main_view;
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
import Model.m_Coupon_model;
import Model.m_main_view_model;
import Model.Login_model;
import Model.m_movie_info_regis_model;
import View.m_Coupon_regis;
import View.m_Movie_info_regis;

/**
 *
 * @author tjdck
 */
public class m_Coupon_regis_controller implements ActionListener{
    private m_Coupon_model model;
    private m_Coupon_regis view;
    private String couphon_number;
    public m_Coupon_regis_controller(m_Coupon_regis view, m_Coupon_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }

        public void actionPerformed(ActionEvent e) {
          //  
            if(e.getSource() == view.okbtn){
            this.couphon_number = view.getCouponnumber();
            //model.addcoupon(couphon_number);
            }
                    
        }
}
