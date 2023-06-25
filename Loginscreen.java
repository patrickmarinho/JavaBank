package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Loginscreen extends JFrame implements ActionListener {

    //variaveis, não modificar!!
    private JPanel panel1;
    private JTextField CPF;
    private JPasswordField senha;
    private JButton entrarButton;
    private JButton cadastreSeButton;
    private JLabel Title;
    private JFrame frame;


//Construtor
    public Loginscreen() {
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250, 300));
        frame.setResizable(false);

        //GUI Form
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Evento para ir a tela de cadastro
        cadastreSeButton.addActionListener(this);

        //Troca de Cursor ao selecionar os botões
        cadastreSeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        entrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



    }
    //Criação da tela de cadastro
    @Override
    public void actionPerformed(ActionEvent e) {
        new Registerscreen();
        frame.dispose();
    }


}
