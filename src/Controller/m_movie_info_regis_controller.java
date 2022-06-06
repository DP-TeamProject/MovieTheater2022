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
import Model.m_main_view_model;
import Model.Login_model;
import Model.m_movie_info_regis_model;
import View.m_Movie_info_regis;

/**
 *
 * @author tjdck
 */
public class m_movie_info_regis_controller implements ActionListener{
    private m_movie_info_regis_model model;
    private m_Movie_info_regis view;
    private String movie_name;
    private String time;
    private String dirctor;
    private String actor;
    private String releasedate;
    private JButton button;
    private String age;
    private String category;
    /*public m_movie_info_regis_controller(JButton button,JTextField movie_name,JTextField time,JTextField dirctor,JTextField actor,JTextField releasedate,JComboBox age,JComboBox category) {
        this.button = button;
        this.movie_name = movie_name;
        this.time = time;
        this.dirctor = dirctor;
        this.actor = actor;
        this.releasedate = releasedate;
        this.age = age;
        this.category = category;        
    }*/
    public m_movie_info_regis_controller(JButton button) {
      this.button=button;
    }
    public m_movie_info_regis_controller(m_Movie_info_regis view, m_movie_info_regis_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.appendmovie){
            this.movie_name = view.getMoviename();
            this.time = view.getTime();
            this.dirctor = view.getDirctor();
            this.actor = view.getActor();
            this.releasedate = view.getReleasedate();
            this.age = view.getAge();
            this.category = view.getCategory();
            //model.appendMovie(movie_name,time,age,dirctor,actor,category,releasedate);
            }
        }
}
