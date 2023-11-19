package top.jonakls.cgmedic.app;

import javax.swing.JOptionPane;

public class CgMedic {

    /**
     * The main method for CgMedic app program
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String name = System.getProperty("user.dir");
        JOptionPane.showMessageDialog(null, "Directory: " + name);
    }
}
