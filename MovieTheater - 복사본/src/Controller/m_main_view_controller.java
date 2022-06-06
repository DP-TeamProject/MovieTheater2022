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
import Model.m_movie_info_regis_model;
import View.Login;
/**
 *
 * @author tjdck
 */
public class m_main_view_controller implements ActionListener, ChangeListener{
    private m_Main_view view;
    private m_main_view_model model;
    private JButton jButton;
    private JTabbedPane jTabbedPane ;
    private JTable jTable;
    private m_movie_info_regis_model m_movie_info_regis_model;
    public m_main_view_controller(JButton jButton) {
        this.jButton = jButton;
    }
    public m_main_view_controller(JTabbedPane jTabbedPane, JTable jTable) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        this.jTabbedPane  = jTabbedPane;
        this.jTable=jTable;
    }

    public m_main_view_controller(m_Main_view view, m_main_view_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
       this.view.setstateChanged(this);
       this.jTabbedPane=this.view.getjTabbedPane2();
    }
    public void actionPerformed(ActionEvent e) {
          if(e.getSource() == view.addmovie){
            //model.usecoupon(couphon_number);
                m_Movie_info_regis view = new m_Movie_info_regis(new javax.swing.JFrame(), true);
		m_movie_info_regis_model model = new m_movie_info_regis_model();
		m_movie_info_regis_controller controller = new m_movie_info_regis_controller(view, model);
                view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        view.dispose();
                    }
                });
                view.setVisible(true);               
            }
           else if ((e.getSource() == view.removemovie)){
              
           }
          else if ((e.getSource() == view.deleteuser)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          //새로고침
          else if ((e.getSource() == view.refreshuser)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.refreshiner)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.foodrefresh)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.refreshsale)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.refreshmovie)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          ////로그아웃
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
          else if ((e.getSource() == view.logout5)){
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          
  

     }
    
    public void stateChanged(ChangeEvent arg) {  //PANE 버튼 클릭으로 변경 될 때 0 ==영화 1==음식 2== 회원관리 3==네부관리 4==매출관리 5==할인권 관리
        if(jTabbedPane.getSelectedIndex()==0){
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("번호");
            dfmodel.addColumn("영화제목");
            dfmodel.addColumn("상영시간");
            dfmodel.addColumn("연령등급");
            dfmodel.addColumn("영화감독");
            dfmodel.addColumn("영화배우");
            dfmodel.addColumn("영화장르");
            dfmodel.addColumn("개봉일");
            //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
            dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
            this.view.movietable.setModel(dfmodel);
        }
        else if(jTabbedPane.getSelectedIndex()==1){
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("메뉴");
            dfmodel.addColumn("가격");
            dfmodel.addColumn("수량");
            //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
            dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
            this.view.foodtable.setModel(dfmodel);
        }
        else if(jTabbedPane.getSelectedIndex()==2){
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("아이디");
            dfmodel.addColumn("비밀번호");
            dfmodel.addColumn("이름");
            dfmodel.addColumn("출새일");
            dfmodel.addColumn("휴대폰번호");
            //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
            dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
            this.view.usertable.setModel(dfmodel);
        }
        else if(jTabbedPane.getSelectedIndex()==3){
            DefaultTableModel dfmodel = new DefaultTableModel();
            //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
            dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
           // this.view.inertable.setModel(dfmodel);
        }
        else if(jTabbedPane.getSelectedIndex()==4){
            DefaultTableModel dfmodel = new DefaultTableModel();
            //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기
            dfmodel.addRow(new Object[]{"v1", "v2","v1", "v2","v1", "v2","v1", "v2"});
            //this.view.saletable.setModel(dfmodel);
        }
    }
}
