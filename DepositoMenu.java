package bank;

import javax.swing.*;
import java.awt.*;

public class DepositoMenu {
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
        frame.setPreferredSize(new Dimension(270, 370));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel4);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


