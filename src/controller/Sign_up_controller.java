
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Login_model;
import view.*;


public class Sign_up_controller implements ActionListener{
    private Sign_up view;
    private String id;
    private String pw;
    private String name;
    private String birthday;
    private String phonenumber;
    private Login_model model;

    public Sign_up_controller(Sign_up view, Login_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

          if(e.getSource() == view.okbtn){
            // 확인 버튼 클릭시 실행이된다.signup() 메소드를 통해 DB에 사용자의 정보를 저장한다.  
            this.id = view.getId();
            this.name=view.getNamefiled();
            this.pw=view.getPw();
            this.birthday=view.getBirthday();
            this.phonenumber=view.getPhonenumber();
            boolean check = model.signup(id, pw, name, birthday, phonenumber);
              if (check)  JOptionPane.showMessageDialog(null, "회원가입 완료 되었습니다.");
              else JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다 모든 정보를 입력해주세요.");
        }
          else if (e.getSource() == view.cancel){
              this.view.dispose();
          }
    }
}
