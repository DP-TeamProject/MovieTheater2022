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
/**
 *
 * @author tjdck
 */
public class m_main_view_controller implements ActionListener {

    private m_Main_view mainview;
    private m_main_view_model model;
    private JButton jButton;

    public m_main_view_controller(JButton jButton) {
        this.jButton = jButton;
    }

    public void actionPerformed(ActionEvent e) {
        //  
        String buttonname = jButton.getText();
        switch (buttonname) {
            case "영화등록":
                m_Movie_info_regis a = new m_Movie_info_regis();
                //a.isAlwaysOnTop();
                a.setModal(true);
                a.setVisible(true);
                break;
            case "영화삭제":
                new m_Movie_info_regis().setVisible(true);
                break;
            case "새로고침":
                new m_Movie_info_regis().setVisible(true);
                break;
            case "로그아웃":
                new m_Movie_info_regis().setVisible(true);
                break;
        }
    }
}
