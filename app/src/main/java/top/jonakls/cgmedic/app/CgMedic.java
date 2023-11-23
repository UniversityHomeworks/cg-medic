package top.jonakls.cgmedic.app;

import top.jonakls.cgmedic.app.history.History;
import top.jonakls.cgmedic.app.login.userLogin;

import javax.swing.*;

public class CgMedic {

    /**
     * The main method for CgMedic app program
     *
     * @param args the arguments
     */
    public static void main(String[] args) {




        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new userLogin().setVisible(true);


            }
        });




/*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new History();
                frame.setSize(300,300);
                frame.setVisible(true);



            }
        });

 */
    }
}
