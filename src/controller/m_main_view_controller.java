
package controller;


import view.m_Main_view;
import view.m_Movie_info_regis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Window;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.changeQuantity_model;
import model.m_main_view_model;
import model.m_movie_info_regis_model;
import view.changeQuantity;

public class m_main_view_controller implements ActionListener, ChangeListener{
    private m_Main_view view;
    private m_main_view_model model;

    public m_main_view_controller(m_Main_view view, m_main_view_model model) {
        // 관리자 메인화면 컨트롤러 생성시 호출된다.
        // 영화탭의 정보를 불러와서 GUI에 보여준다.
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
       this.view.setstateChanged(this);
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("번호");
                dfmodel.addColumn("영화제목");
                dfmodel.addColumn("감독");
                dfmodel.addColumn("출연배우");
                dfmodel.addColumn("영화장르");
                dfmodel.addColumn("연령제한");
                dfmodel.addColumn("러닝타임(분)");
                dfmodel.addColumn("개봉일");
                String [][] movielist = new String[100][8]; //배열로 값 받아오기
                movielist = model.getmovielist();
                for (int i = 0; i < movielist.length; i++) {
                 dfmodel.addRow(new Object[]{movielist[i][0], movielist[i][1],movielist[i][2], movielist[i][3],movielist[i][4], movielist[i][5],movielist[i][6], movielist[i][7]});
            }
            this.view.movietable.setModel(dfmodel);
    }
            public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.addmovie){
                //"영화등록"버튼 클릭 시 실행이된다.
                //영화를 추가할수있는 모델과 뷰를 불러와서 컨트롤러와 연결시켜준다.
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
               //"영화 삭제" 버튼 클릭시 실행이 된다.
               //선택된 열의 영화의 번호를 가져와서 deleteMovie() 메소드를 통해 DB에서 제거한다.
              int selectrow = view.getMovietable().getSelectedRow();
              boolean check = model.deleteMovie(view.getMovietable().getValueAt(selectrow,0).toString());
                DefaultTableModel dfmodel = new DefaultTableModel();
                dfmodel.addColumn("번호");
                dfmodel.addColumn("영화제목");
                dfmodel.addColumn("감독");
                dfmodel.addColumn("출연배우");
                dfmodel.addColumn("영화장르");
                dfmodel.addColumn("연령제한");
                dfmodel.addColumn("러닝타임(분)");
                dfmodel.addColumn("개봉일");
                String [][] movielist = new String[100][8]; //배열로 값 받아오기
                movielist = model.getmovielist();
                for (int i = 0; i < movielist.length; i++) {
                 dfmodel.addRow(new Object[]{movielist[i][0], movielist[i][1],movielist[i][2], movielist[i][3],movielist[i][4], movielist[i][5],movielist[i][6], movielist[i][7]});
                }
                //model에서 값을 찾아서 for문으로 아래라인 수정해서 추가하기

                this.view.movietable.setModel(dfmodel);
              if (check)  JOptionPane.showMessageDialog(null, "영화삭제 완료하였습니다.");
              else JOptionPane.showMessageDialog(null, "영화삭제에 실패하였습니다. 삭제하실 영화를 선택해주세요.");
           }
          else if ((e.getSource() == view.refreshsale)){
              //새로고침 버튼을 누르면 모델의 updatevalue()를 호출시켜 매출정보를 새로 불러온다.
               model.updatevalue();
               this.view.totalprocess.setValue(model.getManagerdisplay());
                this.view.foodprocess.setValue(model.getFsaledisplay());
                this.view.movieprocess.setValue(model.getMsaledisplay());
           }
          else if ((e.getSource() == view.logout)){
              // 로그아웃이 실행된다. 해당 창이 종료된다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout2)){
              // 로그아웃이 실행된다. 해당 창이 종료된다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout4)){
              // 로그아웃이 실행된다. 해당 창이 종료된다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.logout5)){
              // 로그아웃이 실행된다. 해당 창이 종료된다.
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }
          else if ((e.getSource() == view.onbtn)){
              //퍼사드 패턴 사용
              //"ON" 버튼이 클릭하면 on()메소드가 실행이 된다.
              // 전등, 스피커, 빔프로젝터, 에어컨이 켜진다.
               model.on();
               view.light.setText(String.valueOf(model.getLight()));
               view.sound.setText(String.valueOf(model.getSound()));
               view.temp.setText(Integer.toString(model.getTemp()));
               view.tempstate.setText(String.valueOf(model.getTempstate()));
               view.beem.setText(String.valueOf(model.getBeam_Projector()));
           }
          else if ((e.getSource() == view.offbtn)){
              //퍼사드 패턴 사용
              //"OFF" 버튼이 클릭하면 off()메소드가 실행이 된다.
              // 전등, 스피커, 빔프로젝터, 에어컨이 꺼진다.
               model.off();
               view.light.setText(String.valueOf(model.getLight()));
               view.sound.setText(String.valueOf(model.getSound()));
               view.tempstate.setText(String.valueOf(model.getTempstate()));
               view.beem.setText(String.valueOf(model.getBeam_Projector()));
           }
          else if ((e.getSource() == view.settempbtn&&view.tempstate.getText()=="ON")){
              //희망온도 변경은 tempstate가 ON인 상태에서만 변경이 된다.
              //tempstate가 OFF인 상태에서 "ON" 버튼이 클릭하면 온도변경은 실행되지 않는다.              
              System.out.println(Integer.parseInt(view.getHopetemp().getValue().toString()));
               view.temp.setText(view.getHopetemp().getValue().toString());               
           }
          else if ((e.getSource() == view.changevalue)){
              //수량변경을 누르면 해당 물품의 수량을 변경할 수있는 창이 열린다.
                String menuname = view.getFoodtable().getValueAt(view.getFoodtable().getSelectedRow(), 0).toString();
                changeQuantity view = new changeQuantity(new javax.swing.JFrame(), true);
                view.getFoodname().setText(menuname);
                changeQuantity_model model = new changeQuantity_model();
      changeQuantity_controller controller = new changeQuantity_controller(view, model);
                view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                view.setVisible(true);
           }
    }
    
    public void stateChanged(ChangeEvent arg) {  
        //탭이 바뀔 때 실행이 된다.
        if(view.jTabbedPane2.getSelectedIndex()==0){
            // 영화탭을 클릭하면 DB에서 영화 정보를 불러온다.
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("번호");
            dfmodel.addColumn("영화제목");
            dfmodel.addColumn("감독");
            dfmodel.addColumn("출연배우");
            dfmodel.addColumn("영화장르");
            dfmodel.addColumn("연령제한");
            dfmodel.addColumn("러닝타임(분)");
            dfmodel.addColumn("개봉일");
            String [][] movielist = new String[100][8]; //배열로 값 받아오기
            movielist = model.getmovielist();
            for (int i = 0; i < movielist.length; i++) {
             dfmodel.addRow(new Object[]{movielist[i][0], movielist[i][1],movielist[i][2], movielist[i][3],movielist[i][4], movielist[i][5],movielist[i][6], movielist[i][7]});
            }this.view.movietable.setModel(dfmodel);
        }
        else if(view.jTabbedPane2.getSelectedIndex()==1){
            // 음식 탭을 클릭하면 DB에서 메뉴 정보를 불러온다.
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("메뉴");
            dfmodel.addColumn("수량");
            String [][] foodlist = new String[8][8];//배열로 값 받아오기
            foodlist = model.getfoodlist();
            for (int i = 0; i < foodlist.length; i++) {
             dfmodel.addRow(new Object[]{foodlist[i][0], foodlist[i][1]});
            }
            this.view.foodtable.setModel(dfmodel);
        }
        else if(view.jTabbedPane2.getSelectedIndex()==3){
            //매출관리 탭을 클릭하면 실행이 된다.
            model.updatevalue();
            this.view.movieprocess.setMinimum(0); // 최소
            this.view.movieprocess.setMaximum(1000000); // 최대
            this.view.movieprocess.setStringPainted(true);
            this.view.totalprocess.setMinimum(0); // 최소
            this.view.totalprocess.setMaximum(1000000); // 최대
            this.view.totalprocess.setStringPainted(true);
            this.view.foodprocess.setMinimum(0); // 최소
            this.view.foodprocess.setMaximum(200000); // 최대
            this.view.foodprocess.setStringPainted(true);
            this.view.totalprocess.setValue(model.getManagerdisplay());
            this.view.foodprocess.setValue(model.getFsaledisplay());
            this.view.movieprocess.setValue(model.getMsaledisplay());
            System.out.println(view.totalprocess.getValue()+"value");
        }
    }

}