package top.jonakls.cgmedic.app.register;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import top.jonakls.cgmedic.api.entity.account.UserAccountEntity;
import top.jonakls.cgmedic.app.login.UserLogin;
import top.jonakls.cgmedic.app.util.GenericUtil;
import top.jonakls.cgmedic.core.service.entity.account.SimpleAccountService;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class UserRegister extends JFrame {
    private JLabel usernameLabel;
    private JTextField userName;
    private JTextField firstName;
    private JTextField secondName;
    private JTextField email;
    private JTextField phone;
    private JButton cancelButton;
    private JButton registerButton;
    private JPasswordField passwordField1;
    private JPanel panel;
    private final SimpleAccountService accountService;

    public UserRegister(SimpleAccountService simpleAccountService) {
        super("CgMedic | Registro de Usuario");
        this.accountService = simpleAccountService;
        super.setContentPane(this.panel);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(600, 400);
        super.setLocationRelativeTo(null);

        this.registerButton.addActionListener(e -> this.registerProcess());
        this.cancelButton.addActionListener(e -> this.backToLogin());
    }

    private void registerProcess() {
        String username = userName.getText();
        String first = firstName.getText();
        String second = secondName.getText();
        String email = this.email.getText();
        String phone = this.phone.getText();
        String password = String.valueOf(passwordField1.getPassword());

        if (username.isEmpty() || first.isEmpty() || second.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            GenericUtil.showErrorMessage(this, "Por favor, rellene todos los campos");
            return;
        }

        UserAccountEntity userAccountEntity = UserAccountEntity.createUser(username, email, password, first, second, phone);

        this.accountService.add(userAccountEntity);
        GenericUtil.showWelcomeMessage(this, username);
    }

    private void backToLogin() {
        UserLogin userLogin = new UserLogin(this.accountService);
        userLogin.setVisible(true);
        this.dispose();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBackground(new Color(-3479560));
        panel.setEnabled(true);
        usernameLabel = new JLabel();
        usernameLabel.setBackground(new Color(-16777216));
        Font usernameLabelFont = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, usernameLabel.getFont());
        if (usernameLabelFont != null) usernameLabel.setFont(usernameLabelFont);
        usernameLabel.setForeground(new Color(-16777216));
        usernameLabel.setText("Usuario");
        panel.add(usernameLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        userName = new JTextField();
        userName.setBackground(new Color(-1));
        userName.setColumns(35);
        Font userNameFont = this.$$$getFont$$$("Century Gothic", -1, 14, userName.getFont());
        if (userNameFont != null) userName.setFont(userNameFont);
        userName.setForeground(new Color(-16777216));
        userName.setToolTipText("Usuario");
        panel.add(userName, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-16777216));
        Font label1Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16777216));
        label1.setText("Contraseña");
        panel.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-16777216));
        Font label2Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-16777216));
        label2.setText("Apellidos");
        panel.add(label2, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        firstName = new JTextField();
        firstName.setBackground(new Color(-1));
        firstName.setColumns(35);
        Font firstNameFont = this.$$$getFont$$$("Century Gothic", -1, 14, firstName.getFont());
        if (firstNameFont != null) firstName.setFont(firstNameFont);
        firstName.setForeground(new Color(-16777216));
        firstName.setToolTipText("Usuario");
        panel.add(firstName, new GridConstraints(4, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        secondName = new JTextField();
        secondName.setBackground(new Color(-1));
        secondName.setColumns(35);
        Font secondNameFont = this.$$$getFont$$$("Century Gothic", -1, 14, secondName.getFont());
        if (secondNameFont != null) secondName.setFont(secondNameFont);
        secondName.setForeground(new Color(-16777216));
        secondName.setToolTipText("Usuario");
        panel.add(secondName, new GridConstraints(5, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-16777216));
        Font label3Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-16777216));
        label3.setText("Correo");
        panel.add(label3, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        phone = new JTextField();
        phone.setBackground(new Color(-1));
        phone.setColumns(35);
        Font phoneFont = this.$$$getFont$$$("Century Gothic", -1, 14, phone.getFont());
        if (phoneFont != null) phone.setFont(phoneFont);
        phone.setForeground(new Color(-16777216));
        phone.setToolTipText("Usuario");
        panel.add(phone, new GridConstraints(7, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        email = new JTextField();
        email.setBackground(new Color(-1));
        email.setColumns(35);
        Font emailFont = this.$$$getFont$$$("Century Gothic", -1, 14, email.getFont());
        if (emailFont != null) email.setFont(emailFont);
        email.setForeground(new Color(-16777216));
        email.setToolTipText("Usuario");
        panel.add(email, new GridConstraints(6, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setBackground(new Color(-16777216));
        Font label4Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-16777216));
        label4.setText("Telefono");
        panel.add(label4, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setBackground(new Color(-16777216));
        Font label5Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-16777216));
        label5.setText("Nombres");
        panel.add(label5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Century Gothic", Font.BOLD, 24, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-16777216));
        label6.setText("Registro Usuario");
        panel.add(label6, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(1, 4, 7, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel.add(spacer2, new GridConstraints(1, 0, 7, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel.add(spacer3, new GridConstraints(8, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel.add(spacer4, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel.add(spacer5, new GridConstraints(10, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        registerButton = new JButton();
        registerButton.setBackground(new Color(-14918244));
        Font registerButtonFont = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, registerButton.getFont());
        if (registerButtonFont != null) registerButton.setFont(registerButtonFont);
        registerButton.setForeground(new Color(-1));
        registerButton.setText("Registrarse");
        panel.add(registerButton, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setBackground(new Color(-14918244));
        Font cancelButtonFont = this.$$$getFont$$$("Century Gothic", Font.BOLD, 14, cancelButton.getFont());
        if (cancelButtonFont != null) cancelButton.setFont(cancelButtonFont);
        cancelButton.setForeground(new Color(-1));
        cancelButton.setText("Cancelar");
        panel.add(cancelButton, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        passwordField1.setBackground(new Color(-1));
        passwordField1.setForeground(new Color(-16777216));
        panel.add(passwordField1, new GridConstraints(3, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
