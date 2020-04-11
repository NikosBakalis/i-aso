package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{

    private JPanel mainPanel;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JPanel loginPanel;
    private JPanel headerPanel;
    private JPanel fooetrPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;

    public Login() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(550, 250);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Username: " + textField1.getText());
                System.out.println("Password: " + passwordField1.getText());
            }
        });
    }

//    public static void main(String[] args){
//        JFrame jFrame = new JFrame();
//        jFrame.setVisible(true);
//    }

}
