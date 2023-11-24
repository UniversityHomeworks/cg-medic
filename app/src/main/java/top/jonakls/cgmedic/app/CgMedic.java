package top.jonakls.cgmedic.app;

import top.jonakls.cgmedic.app.login.UserLogin;

import javax.swing.SwingUtilities;

public class CgMedic {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLogin().setVisible(true));
    }
}
