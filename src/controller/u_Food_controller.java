
package controller;

import model.decorator.Drink;
import model.decorator.food;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Window;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import model.food_model;
import view.u_Food_view;

public class u_Food_controller implements ActionListener{
    private food_model model;
    private u_Food_view view;
    private String type;
    private JTable jTable;
    private DefaultTableModel dtmodel = new DefaultTableModel();
    private Drink drink;
    private food eat;

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
        if(e.getSource() == view.addpopcorn){
            //스트레티지패턴 사용
            //팝콘을 추가하는 버튼이다. 선택한 값을 모델로 보내 선택한 맛을 불러온다.
            String number = view.getPopcorncombo();
            number = number.substring(0, 1);//수량
            model.addpopcorn(view.getTastepopcorn());
            System.out.println(view.tastepopcorn.getSelection().getActionCommand());
            int cost = Integer.parseInt(number) * 5000;
            
            dtmodel.addRow(new Object[]{model.getPopcorntaste(), String.valueOf(view.getPopcorncombo()),Integer.toString(cost), "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addsoda){
            //스트레티지패턴 사용
            //탄산음료을 추가하는 버튼이다. 선택한 값을 모델로 선택한 맛을 불러온다.
            String number = view.getSodacombo().substring(0, 1);
            int cost = Integer.parseInt(number) * 2000;
            model.addsoda(view.getTastesoda());
            System.out.println(view.getTastesoda());
            dtmodel.addRow(new Object[]{model.getSodataste(), String.valueOf(view.getSodacombo()),Integer.toString(cost), "-"});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addnacho){
            //데코레이터 사용
            //나초를 추가하는 버튼이다. 선택한 값을 모델로 보내 가격과 추가한 메뉴를 불러온다.
            String number = view.getNachocombo().substring(0, 1);
            int cost = Integer.parseInt(number) * 4000;
            model.addnacho(view.getSalsasouce(),view.getDeepcheesesouce());
            dtmodel.addRow(new Object[]{"나쵸", String.valueOf(view.getNachocombo()),model.getCost()*Integer.parseInt(number), model.getDescription()});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addhotdog){
            //데코레이터 사용
            //핫도그를 추가하는 버튼이다. 선택한 값을 모델로 보내 가격과 추가한 메뉴를 불러온다.
            String number = view.getHotdogcombo().substring(0, 1);
            int cost = Integer.parseInt(number) * 3000;
            model.addhotdog(view.getSosege(),view.getPick(),view.getOnean(),view.getSouce());
            dtmodel.addRow(new Object[]{"핫도그", String.valueOf(view.getHotdogcombo()),model.getCost()*Integer.parseInt(number), model.getDescription()});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        
        else if (e.getSource() == view.addbubbletea){
            //데코레이터 사용
            //버블티를 추가하는 버튼이다. 선택한 값을 모델로 보내 가격과 추가한 메뉴를 불러온다.
            String number = view.getBubbleteacombo().substring(0, 1);
            model.addbubbletea(view.getSuger(),view.getPeal(),view.getWhitepeal(),view.getCoconat());
            dtmodel.addRow(new Object[]{"버블티", String.valueOf(view.getBubbleteacombo()),model.getCost()*Integer.parseInt(number), model.getDescription()});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.addcoffe){
            //데코레이터 사용
            //커피를 추가하는 버튼이다. 선택한 값을 모델로 보내 가격과 추가한 메뉴를 불러온다.
            String number = view.getCoffecombo().substring(0, 1);
            model.addcoffe(view.getMilk(),view.getIce(),view.getShot(),view.getCoffecombo());
            dtmodel.addRow(new Object[]{"커피",  String.valueOf(view.getCoffecombo()),model.getCost()*Integer.parseInt(number), model.getDescription()});
            this.view.menutable.setModel(dtmodel);
            this.view.menutable.updateUI();
        }
        else if (e.getSource() == view.orderbtn){
            //"order"버튼을 클릭하면 실행이된다. 구매가격이 DB에 저장이 된다.
            view.getMenutable().rowAtPoint(new Point(0,2));
            int cost = 0;
            for (int i = 0; i < view.getMenutable().getRowCount(); i++) cost+=Integer.parseInt(view.getMenutable().getValueAt(i, 2).toString());
            model.order(cost);
             showMessageDialog(null, "구매하였습니다!");
            this.view.dispose();
        }
        else if (e.getSource() == view.deletebtn){
            //"delete"버튼을 클릭하면 실행이된다. 구매목록이 삭제된다.
            dtmodel.removeRow(this.view.getMenutable().getSelectedRow());
            this.view.getMenutable().setModel(dtmodel);
            this.view.getMenutable().updateUI();
           
        }
        else if (e.getSource() == view.exitbtn){
            //"exit"버튼을 클릭하면 실행이된다. 구매하지 않고 나가게된다. 해당 GUI가 종료된다.
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
     }
}