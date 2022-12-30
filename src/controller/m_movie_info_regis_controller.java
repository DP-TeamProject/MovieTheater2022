
package controller;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.m_movie_info_regis_model;
import static view.m_Main_view.movietable;
import view.m_Movie_info_regis;


public class m_movie_info_regis_controller implements ActionListener{
    private m_movie_info_regis_model model;
    private m_Movie_info_regis view;

        public m_movie_info_regis_controller(m_Movie_info_regis view, m_movie_info_regis_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.appendmovie){
                //"영화등록" 버튼 클릭 시 실행이 된다.
                //입력된 값들을 받아와서 DB에 저장한다.
             int check = model.appendMovie(view.getMoviename(),view.getTime(),view.getAge(),view.getDirctor(),view.getActor(),view.getCategory(),view.getReleasedate());
                if (check==1){
                    JOptionPane.showMessageDialog(null, "영화등록이 완료되었습니다.");
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
                    movietable.setModel(dfmodel);
                    movietable.updateUI();            
                    view.dispose();
                }
                else if ( check ==0)JOptionPane.showMessageDialog(null, "영화 등록에 실패하였습니다. 정보 다시 입력해주세요.");
                else if (check ==2 )JOptionPane.showMessageDialog(null, "동일한 영화명이 존재합니다. 다시 시도해주세요");
             }
            else{
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
                }   
            }
}
