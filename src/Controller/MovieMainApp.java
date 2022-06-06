package Controller;

import Controller.Login_controller;
import Model.DBConnection;
import Model.Login_model;
import javax.swing.JFrame;
import View.Login;

public class MovieMainApp extends JFrame {

    public static void main(String[] args) {
        if (DBConnection.getInstance().Initailize()) {
            Login view = new Login(new javax.swing.JFrame(), true);
		Login_model model = new Login_model();
		Login_controller controller = new Login_controller(view, model);
		view.setVisible(true);
                view.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
        }

    }
}
