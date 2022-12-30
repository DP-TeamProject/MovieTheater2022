
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Window;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.food_model;
import model.u_main_model;

import view.u_Food_view;
import view.u_Main_view;


public class u_main_view_controller implements ActionListener, ChangeListener{
    private u_Main_view view;
    private u_main_model model;
    private JTabbedPane jTabbedPane ;
    private JTable jTable;
    private ButtonGroup buttonGroup;
    private int selectmovie = 0;
    public u_main_view_controller(u_Main_view view, u_main_model model) {
        //컨트롤러에 뷰와 모델을 연결시키고 ,처음 GUI 생성시 보이는 영화목록을 불러옵니다.
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
       this.view.setstateChanged(this);
       this.jTabbedPane=this.view.getjTabbedPane2();
       this.buttonGroup=this.view.getsetnumbergroup();
       DefaultTableModel dfmodel = new DefaultTableModel();
                    dfmodel.addColumn("영화제목");
                    dfmodel.addColumn("영화감독");
                    dfmodel.addColumn("영화배우");
                    dfmodel.addColumn("영화장르");
                    dfmodel.addColumn("연령등급");
                    dfmodel.addColumn("러닝타임");
                    dfmodel.addColumn("개봉일");
                    String[][] movielist = new String[100][8];
                    movielist = model.searchMovie();
                    for (int i = 0; i < movielist.length; i++) {
                     dfmodel.addRow(new Object[]{ movielist[i][1],movielist[i][2], movielist[i][3],movielist[i][4], movielist[i][5],movielist[i][6], movielist[i][7]});
                    }
                     this.view.movietable.setModel(dfmodel);
    }
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == view.reservation)){
            // "예매버튼" 클릭 시 실행되는 메소드
            // 해당 영화에 대한 좌석 정보를 불러와 구매 불 가능한 좌석은 선택이 불가능하도록 한다.
            // selectmovie를 통해 영화가 선택되었는지 확인 한다.
              selectmovie+=1;
              view.jTabbedPane2.setSelectedIndex(1);
              boolean [] cheeckset= new boolean[14];
              int row = view.movietable.getSelectedRow();
              String moviename = view.movietable.getValueAt(row, 0).toString();
              cheeckset= model.getSeatinformation(moviename);
              for (int i = 1; i < 13; i++) {
                view.setBtn1(cheeckset[0]);
                view.setBtn2(cheeckset[1]);
                view.setBtn3(cheeckset[2]);
                view.setBtn4(cheeckset[3]);
                view.setBtn5(cheeckset[4]);
                view.setBtn6(cheeckset[5]);
                view.setBtn7(cheeckset[6]);
                view.setBtn8(cheeckset[7]);
                view.setBtn9(cheeckset[8]);
                view.setBtn10(cheeckset[9]);
                view.setBtn11(cheeckset[10]);
                view.setBtn12(cheeckset[11]);                
            }
              
           }          
          else if ((e.getSource() == view.select&&view.getsetnumbergroup().getSelection().isSelected()&&view.getsetnumbergroup().getSelection().isEnabled())){
               //영화를 선택하였고 구매가능한 좌석을 선택하였으면 예매가 실행이 된다.
               System.out.println(view.getSetnumbergroup().getSelection().getActionCommand().toString());
               int row = view.movietable.getSelectedRow();
               String moviename = view.movietable.getValueAt(row, 0).toString();
               model.getMoviePay(view.getSetnumbergroup().getSelection().getActionCommand().toString(),moviename);
               showMessageDialog(null, "예매 성공");
               jTabbedPane.setSelectedIndex(2);
               selectmovie=0;
           }
          else if ((e.getSource() == view.select && (view.getsetnumbergroup().getSelection().isSelected()==false || view.getsetnumbergroup().getSelection().isEnabled()==false))){
               //좌석을 선택 안 하고 "선택"버튼을 누흐면 안 하면 경고창을 출력한다,
               showMessageDialog(null, "좌석을 선택하세요");

           }
          else if ((e.getSource() == view.nofood)){
              //"넘어가기" 버튼을 클릭하면 음식 선택 없이 결제 창으로 이동한다.
               jTabbedPane.setSelectedIndex(3);
           }
          else if ((e.getSource() == view.checkout)){
              //"결제" 버튼을 누르면 지금까지 구매한 항목을 결제한다.
              model.paycp();
               jTabbedPane.setSelectedIndex(0);
               showMessageDialog(null, "결제 완료 하였습니다!");
               
           }
          else if ((e.getSource() == view.selectmenu)){
              // "메뉴 고르러 가기" 버튼을 클릭하면 음식을 주문할 수 있는 gui가 열린다.
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
          else if ((e.getSource() == view.setbeforebtn)){
              //"이전" 버튼을 누르면 이전단계 탭으로 이동을한다.
               jTabbedPane.setSelectedIndex(0);
           }
          else if ((e.getSource() == view.foodbeforebtn)){
              //"이전" 버튼을 누르면 이전단계 탭으로 이동을한다.
               jTabbedPane.setSelectedIndex(1);
           }
          else if ((e.getSource() == view.checkoutbefore)){
              //"이전" 버튼을 누르면 이전단계 탭으로 이동을한다.
               jTabbedPane.setSelectedIndex(2);
           }
          else if ((e.getSource() == view.logout)){
              //로그아웃한다. 해당하는 창이 꺼진다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout2)){
              //로그아웃한다. 해당하는 창이 꺼진다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout3)){
              //로그아웃한다. 해당하는 창이 꺼진다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout4)){
              //로그아웃한다. 해당하는 창이 꺼진다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          
     }
    
    public void stateChanged(ChangeEvent arg) {  
        //PANE 버튼 클릭으로 변경 될 때 실행되는 부분
        switch (view.getjTabbedPane2().getSelectedIndex()) {
            case 0: // 0 = 영화 탭
                {
                    DefaultTableModel dfmodel = new DefaultTableModel();
                    dfmodel.addColumn("영화제목");
                    dfmodel.addColumn("영화감독");
                    dfmodel.addColumn("영화배우");
                    dfmodel.addColumn("영화장르");
                    dfmodel.addColumn("연령등급");
                    dfmodel.addColumn("러닝타임");
                    dfmodel.addColumn("개봉일");
                    String[][] movielist = new String[100][8];
                    movielist = model.searchMovie();
                    for (int i = 0; i < movielist.length; i++) {
                     dfmodel.addRow(new Object[]{ movielist[i][1],movielist[i][2], movielist[i][3],movielist[i][4], movielist[i][5],movielist[i][6], movielist[i][7]});
                    }
                    this.view.movietable.setModel(dfmodel);
                    break;
                }
                case 1: //좌석 탭
                {
                    if(selectmovie==0){ 
                        System.out.println(selectmovie);
                        showMessageDialog(null, "영화를 먼저 선택해주세요!");
                        jTabbedPane.setSelectedIndex(0);
                    }
                }
            case 3: //결제 탭
                {
                    DefaultTableModel dfmodel = new DefaultTableModel();
                    dfmodel.addColumn("결제 목록");
                    dfmodel.addColumn("결제 금액");
                    int[] pay = new int[2];
                    pay = model.getPay();
                     dfmodel.addRow(new Object[]{ "매점",pay[0]});
                     dfmodel.addRow(new Object[]{ "영화",pay[1]});
                    //dfmodel.addRow(new Object[]{model.getPay()});
                     this.view.getSaletable().setModel(dfmodel);
                    break;
                }
        }
        
    }
}
