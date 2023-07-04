package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositoMenu implements ActionListener {
    private JPanel panel4;
    private JLabel titlelabel;
    private JLabel saldoValor;
    private JFormattedTextField valueDeposito;
    private JButton depositarButton;
    private JButton voltarButton;

    private JFrame frame;

    public DepositoMenu() {
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270, 200));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel4);
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


