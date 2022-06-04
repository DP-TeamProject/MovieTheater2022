/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.sun.org.apache.bcel.internal.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import View.*;
import java.awt.Dimension; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import Model.m_main_view_model;
import View.m_Main_view;

/**
 *
 * @author tjdck
 */
public class m_movie_info_regis_controller implements ActionListener{
    private m_main_view_model model;
    private m_Main_view mainview;
    private JTextField movie_name;
    private JTextField time;
    private JTextField dirctor;
    private JTextField actor;
    private JTextField releasedate;
    private JButton button;
    private JComboBox age;
    private JComboBox category;
    private m_main_view_model mainmodel;
    public m_movie_info_regis_controller(JButton button,JTextField movie_name,JTextField time,JTextField dirctor,JTextField actor,JTextField releasedate,JComboBox age,JComboBox category) {
        this.button = button;
        this.movie_name = movie_name;
        this.time = time;
        this.dirctor = dirctor;
        this.actor = actor;
        this.releasedate = releasedate;
        this.age = age;
        this.category = category;        
    }
        public void actionPerformed(ActionEvent e) {
          //  
            String buttonname = button.getText();
            switch (buttonname) {
            case "영화등록": 
        }
        }
}
