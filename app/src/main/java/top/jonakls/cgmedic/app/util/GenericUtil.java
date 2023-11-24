package top.jonakls.cgmedic.app.util;

import javax.swing.JOptionPane;
import java.awt.Component;

public final class GenericUtil {

    private GenericUtil() {
    }


    public static void showWelcomeMessage(Component component, String userName) {
        JOptionPane.showMessageDialog(
                component,
                "¡Inicio de Sesión Exitoso! Bienvenido, " + userName + "!",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    public static void showErrorMessage(Component component, String message) {
        JOptionPane.showMessageDialog(
                component,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void showInfoMessage(Component component, String message) {
        JOptionPane.showMessageDialog(
                component,
                message,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
