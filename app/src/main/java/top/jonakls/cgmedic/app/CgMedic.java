package top.jonakls.cgmedic.app;

import top.jonakls.cgmedic.app.login.UserLogin;
import top.jonakls.cgmedic.app.manager.UsersManager;

import javax.swing.*;

public class CgMedic {

    private static final String STORAGE_PATH = System.getProperty("user.dir") + "/users";
    private static final UsersManager usersManager = new UsersManager(STORAGE_PATH);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLogin(usersManager.accountService())
                .setVisible(true));
    }
}
