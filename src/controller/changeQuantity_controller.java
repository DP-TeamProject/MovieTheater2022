
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.changeQuantity_model;
import view.*;
import static view.m_Main_view.foodtable;


public class changeQuantity_controller implements ActionListener{
    private changeQuantity view;
    private changeQuantity_model model;
    private String id;
    private String name;
    public changeQuantity_controller(changeQuantity view, changeQuantity_model model) {
       this.view=view;
       this.model=model;
       this.view.setaddActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
            // 확인을 누르면 해당 하는 메뉴의 수량을 입력한 값으로 변경한다.
            // DB에 값을 변경하고 GUI를 업데이트 한다.
            String menuname=view.getFoodname().getText();
            String changequantity = view.getQuantity().getText();
            boolean check = model.changeQuantity(menuname,changequantity);
            DefaultTableModel dfmodel = new DefaultTableModel();
            dfmodel.addColumn("메뉴");
            dfmodel.addColumn("수량");
            String [][] foodlist = new String[8][8];
            foodlist = model.getfoodlist();
            for (int i = 0; i < foodlist.length; i++) {
             dfmodel.addRow(new Object[]{foodlist[i][0], foodlist[i][1]});
            }
            if (check) JOptionPane.showMessageDialog(null, "수량변경 완료하였습니다."); // 정상적으로 DB에 값이 들어가면 실행이 된다.
            else JOptionPane.showMessageDialog(null, "수량을 다시 입력해주세요."); // DB에 값이 들어가지 않으면 실행이 된다.
            this.view.dispose();
            foodtable.setModel(dfmodel);
    }
}
