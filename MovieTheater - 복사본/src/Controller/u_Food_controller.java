/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
import Model.food_model;
import View.u_Food_view;

/**
 *
 * @author tjdck
 */
public class u_Food_controller implements ActionListener{
    private food_model model;
    private u_Food_view view;
    private String type;
    private JTable jTable;
    private DefaultTableModel dtmodel = new DefaultTableModel();

    public u_Food_controller(u_Food_view view, food_model model) {
        this.model=model;
        this.view=view;
        this.view.setaddActionListener(this);
        dtmodel.addColumn("메뉴");
        dtmodel.addColumn("수량");
        dtmodel.addColumn("가격");
        dtmodel.addColumn("추가항목");
    }
    //menutable
    public void actionPerformed(ActionEvent e) {
        System.out.println(view.getTastepopcorn());
        if(e.getSource() == view.addpopcorn){
            String number = view.getPopcorncombo();
            number = number.substring(0, 1);
            int cost = Integer.parseInt(number) * 5000;
            
            //model.addpopcorn(view.tastepopcorn.getSelection().getActionCommand());
            dtmodel.addRow(new Object[]{"v1", "v2",Integer.toString(cost), "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addnacho){
            String number = view.getNachocombo();
            number = number.substring(0, 1);int cost = Integer.parseInt(number) * 5000;
            
            //model.addpopcorn(view.tastepopcorn.getSelection().getActionCommand());
            dtmodel.addRow(new Object[]{"v1", "v2",Integer.toString(cost), "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addhotdog){
            String number = view.getHotdogcombo();
            number = number.substring(0, 1);
            
            dtmodel.addRow(new Object[]{"v1", "v2",number, "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addsoda){
            String number = view.getSodacombo();
            number = number.substring(0, 1);
            int cost = Integer.parseInt(number) * 2000;
            
            //model.addpopcorn(view.tastepopcorn.getSelection().getActionCommand());
            dtmodel.addRow(new Object[]{"v1", "v2",Integer.toString(cost), "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addbubbletea){
            String number = view.getBubbleteacombo();
            number = number.substring(0, 1);
            
            dtmodel.addRow(new Object[]{"v1", "v2",number, "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addcoffe){
            String number = view.getCoffecombo();
            number = number.substring(0, 1);
            
            dtmodel.addRow(new Object[]{"v1", "v2",number, "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.orderbtn){
            
        }
        else if (e.getSource() == view.deletebtn){
            dtmodel.removeRow(this.view.menutable.getSelectedColumn());
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.exitbtn){
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
     }
}