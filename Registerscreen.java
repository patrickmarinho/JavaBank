package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registerscreen implements ActionListener {
    //variaveis


    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JButton cadastreSeButton;
    private JButton voltarAoLoginButton;
    private JPanel panel2;


    //construtores
    public Registerscreen(){
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270, 370));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel2);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Evento para voltar a tela de login
        voltarAoLoginButton.addActionListener(this);

        //Troca de Cursor ao selecionar os botões
        cadastreSeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarAoLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }
    //Criação da tela de login
    @Override
    public void actionPerformed(ActionEvent e) {
        new Loginscreen();
        frame.dispose();
    }
}
