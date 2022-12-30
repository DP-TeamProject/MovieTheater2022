
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Login_model;
import view.*;


public class PW_search_controller implements ActionListener{
    private PW_search view;
    private Login_model model;
    private String id;
    private String name;
    public PW_search_controller(PW_search view, Login_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.okbtn){
            // 확인 버튼 클릭시 실행이된다.findpw() 메소드를 통해 DB에 일치하는 정보가 있는지 확인을 한다.
            this.id = view.getId();
            this.name=view.getNamefiled();
            String value = model.findpw(id,name);
            if(value.equals("errorinformation")) JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다. 다시 시도해주세요"); 
            else JOptionPane.showMessageDialog(null, "회원님의 비밀번호는" + value + "입니다.");
        }
        else if (e.getSource() == view.cancel){
            this.view.dispose();
        }
    }
}
