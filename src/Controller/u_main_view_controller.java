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
import Model.food_model;
import Model.m_movie_info_regis_model;
import Model.u_main_model;
import View.Login;
import View.u_Food_view;
import View.u_Main_view;

/**
 *
 * @author tjdck
 */
public class u_main_view_controller implements ActionListener, ChangeListener{
    private u_Main_view view;
    private u_main_model model;
    private JTabbedPane jTabbedPane ;
    private JTable jTable;
    private ButtonGroup buttonGroup;

    public u_main_view_controller(u_Main_view view, u_main_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
       this.view.setstateChanged(this);
       this.jTabbedPane=this.view.getjTabbedPane2();
       this.buttonGroup=this.view.getsetnumbergroup();
    }
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == view.reservation)){
              
           }          
          else if ((e.getSource() == view.select)){
               //db연결
           }
          else if ((e.getSource() == view.setbeforebtn)){
               jTabbedPane.setSelectedIndex(0);
           }
          //새로고침
          
          else if ((e.getSource() == view.nofood)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.foodbeforebtn)){
               jTabbedPane.setSelectedIndex(1);
           }
          
          else if ((e.getSource() == view.checkout)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          ////로그아웃
          else if ((e.getSource() == view.checkoutbefore)){
               jTabbedPane.setSelectedIndex(2);
           }
          else if ((e.getSource() == view.logout)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout2)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout3)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout4)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.selectmenu)){
                u_Food_view view = new u_Food_view(new javax.swing.JFrame(), true);
                food_model model = new food_model();
		u_Food_controller controller = new u_Food_controller(view, model);
                view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                view.setVisible(true);
           }
          else if (e.getActionCommand() == view.setnumbergroup.getSelection().toString()){
              System.out.println("실행");
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          
     }
    
    public void stateChanged(ChangeEvent arg) {  //PANE 버튼 클릭으로 변경 될 때 0 ==영화 1==음식 2== 회원관리 3==네부관리 4==매출관리 5==할인권 관리
        switch (jTabbedPane.getSelectedIndex()) {
            case 0:
                {
                    DefaultTableModel dfmodel = new DefaultTableModel();
                    dfmodel.addColumn("영화제목");
                    dfmodel.addColumn("상영시간");
                    dfmodel.addColumn("연령등급");
                    dfmodel.addColumn("영화감독");
                    dfmodel.addColumn("영화배우");
                    dfmodel.addColumn("영화장르");
                    dfmodel.addColumn("개봉일");
                    dfmodel.addColumn("시작시간");
                    //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
                    dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
                    this.view.movietable.setModel(dfmodel);
                    break;
                }
            case 1:
                break;
            case 2:
                {
                    DefaultTableModel dfmodel = new DefaultTableModel();
                    dfmodel.addColumn("아이디");
                    dfmodel.addColumn("비밀번호");
                    dfmodel.addColumn("이름");
                    dfmodel.addColumn("출새일");
                    dfmodel.addColumn("휴대폰번호");
                    //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
                    dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
                    //this.view.usertable.setModel(dfmodel);
                    break;
                }
            case 3:
                {
                    DefaultTableModel dfmodel = new DefaultTableModel();
                    //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
                    dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
                    // this.view.inertable.setModel(dfmodel);
                    break;
                }
            default:
                break;
        }
        
    }
}
