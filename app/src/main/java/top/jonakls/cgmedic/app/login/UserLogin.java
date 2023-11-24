package top.jonakls.cgmedic.app.login;


import top.jonakls.cgmedic.app.history.History;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class UserLogin extends JFrame {

    private static final Map<String, String> USERS = new HashMap<>();


    private JPanel panel1;

    private JLabel usernameLabel;

    private JTextField userNameFile;

    private JLabel passwordLabel;

    private JPasswordField passwordField;

    private JButton loginButton;

    private JButton exitButton;

    private JButton registerButton;


    public UserLogin() {
        super("Login");
        // Usuarios registrados (simulados)
        USERS.put("hola", "12345");// Usuario de ejemplo (simulado)

        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        registerButton.addActionListener(e -> {
            String userName = userNameFile.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (!USERS.containsKey(userName)) {
                // Agregar nuevo usuario al registro (simulado)
                USERS.put(userName, password);
                JOptionPane.showMessageDialog(UserLogin.this, "Usuario registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(UserLogin.this, "El usuario ya existe", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginButton.addActionListener(e -> {
            String userName = userNameFile.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (USERS.containsKey(userName) && USERS.get(userName).equals(password)) {
                dispose();// Cerrar ventana de inicio de sesión
                showWelcomeMessage(userName);// Mostrar mensaje de bienvenida en nueva ventana

                History historyWindow = new History();
                historyWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Ajusta la operación de cierre según tu lógica
                historyWindow.setLocationRelativeTo(null);
                historyWindow.setVisible(true); // Muestra la ventana History
            } else {
                JOptionPane.showMessageDialog(UserLogin.this, "Credenciales incorrectas", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        });

        exitButton.addActionListener(e -> this.dispose());
    }


    private void showWelcomeMessage(String userName) {
        JOptionPane.showMessageDialog(
                this,
                "¡Inicio de Sesión Exitoso! Bienvenido, " + userName + "!",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


}


