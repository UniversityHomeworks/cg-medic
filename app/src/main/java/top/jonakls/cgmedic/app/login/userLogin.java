package top.jonakls.cgmedic.app.login;


import top.jonakls.cgmedic.app.history.History;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class userLogin extends JFrame {

    private static Map<String, String>users = new HashMap<>();


    private JPanel panel1;

    private JLabel usernameLabel;

    private JTextField userNameFile;

    private JLabel passwordLabel;

    private JPasswordField passwordField;

    private JButton loginButton;

    private JButton exitButton;

    private JButton registerButton;


    public  userLogin()  {
        super("Login");
        // Usuarios registrados (simulados)
        users.put("hola", "12345");// Usuario de ejemplo (simulado)

        setContentPane(panel1);
        // TODO: place custom component creation code here
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameFile.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (!users.containsKey(userName)){
                    // Agregar nuevo usuario al registro (simulado)
                    users.put(userName, password);
                    JOptionPane.showMessageDialog(userLogin.this, "Usuario registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(userLogin.this, "El usuario ya existe", "Error de Registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameFile.getText();
                String password = String.valueOf(passwordField.getPassword());
                if(users.containsKey(userName) && users.get(userName).equals(password)){
                    dispose();// Cerrar ventana de inicio de sesión
                    showWelcomeMessage(userName);// Mostrar mensaje de bienvenida en nueva ventana

                    History historyWindow = new History();
                    historyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ajusta la operación de cierre según tu lógica
                    historyWindow.pack(); // Ajusta el tamaño de la ventana automáticamente
                    historyWindow.setVisible(true); // Muestra la ventana History
                } else {
                    JOptionPane.showMessageDialog(userLogin.this, "Credenciales incorrectas", "Error de Inicio de Sesión",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    private void showWelcomeMessage(String userName) {
        JOptionPane.showMessageDialog(this,"¡Inicio de Sesión Exitoso! Bienvenido, " + userName + "!", "Bienvenido",JOptionPane.INFORMATION_MESSAGE);
        /*
        JFrame welcomeFrame = new JFrame("Bienvenido");
        JLabel welcomeLabel = new JLabel("¡Inicio de Sesión Exitoso! Bienvenido, " + userName + "!");
        welcomeFrame.add(welcomeLabel);
        welcomeFrame.setSize(400, 100);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);

         */
    }


}


