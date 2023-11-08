package top.jonakls.cgmedic.frontend;

import javax.swing.*;

public class CgMedic {

    /**
     * The main method for CgMedic frontend program
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String name = System.getProperty("user.dir");
        JOptionPane.showMessageDialog(null, "Directory: " + name);
    }
}
