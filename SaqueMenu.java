package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaqueMenu implements ActionListener {
    private JPanel panel5;
    private JFormattedTextField valueSaque;
    private JButton sacarButton;
    private JButton voltarButton;
    private JLabel saldoValue;
    private JLabel saldoSaque;
    private JLabel titleSaque;
    private JFrame frame;

    public SaqueMenu() {
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270, 200));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel5);
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
