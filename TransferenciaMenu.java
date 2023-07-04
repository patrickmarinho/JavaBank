package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferenciaMenu implements ActionListener {
    private JPanel panel6;
    private JLabel saldo;
    private JFormattedTextField ag;
    private JFormattedTextField cc;
    private JFormattedTextField valor;
    private JButton transferirButton;
    private JButton voltarButton;
    private JLabel valueTransf;
    private JLabel valorLabel;
    private JFrame frame;

    public TransferenciaMenu(){
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270, 220));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel6);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Evento voltar para o menu principal
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new MainMenu();
    }
}
