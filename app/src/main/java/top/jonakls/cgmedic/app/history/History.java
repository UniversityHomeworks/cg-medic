package top.jonakls.cgmedic.app.history;

import top.jonakls.cgmedic.api.entity.user.UserEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History  extends JFrame{


    private JPanel panel1;
    private JTextPane historyUserTextPane;
    private JLabel userName;
    private JLabel textSecondName;
    private JTextField secondNameTextFile;
    private JLabel textLastName;
    private JTextField lastNameTextFiled;
    private JTextField userNameTextFile;
    private JPanel infoPanenl;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField secondLastNameTextFiled;
    private JTextField emailTextFiled;
    private JLabel textSecondLastName;
    private JLabel textEmail;
    private JTextField phoneTextFiled;
    private JLabel textPhone;
    private JTextField addressTextField;
    private JComboBox cityComBox;
    private JPanel history;
    private JTextArea description;
    private JTextArea diagnosis;
    private JLabel textDescription;
    private JLabel textDiagnosis;
    private JComboBox diseasses;
    private JTextArea tratment;
    private JComboBox medicines;
    private JLabel textTratment;
    private JLabel textDiseasses;

    private JButton infoHistory;

    private JButton stopOperation;
    private JTextField uuidTextField;


    public  History(){
        super("History");
        setContentPane(panel1);
        infoHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = uuidTextField.getText();
                String userName = userNameTextFile.getText();
                String userSecondName = secondNameTextFile.getText();
                String userLastName = lastNameTextFiled.getText();
                String usersecondLastName = secondLastNameTextFiled.getText();
                String userEmail = emailTextFiled.getText();
                String userphone = phoneTextFiled.getText();
                String userAddress = addressTextField.getText();
                String userCity = (String) cityComBox.getSelectedItem();


                UserEntity.createBasic(id,userName,userLastName,userEmail,userphone);
                showMessageDialog(userName);
                dispose();
            }
        });
    }
    private void showMessageDialog(String userName) {
        JOptionPane.showMessageDialog(this,"¡Informacion Guardada, " + userName + "!", "Gracias",JOptionPane.INFORMATION_MESSAGE);
        // TODO: place custom component creation code here




    }
}
