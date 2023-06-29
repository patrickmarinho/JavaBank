package bank;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JLabel Title;
    private JButton depósitoButton;
    private JButton saqueDeValoresButton;
    private JButton transferênciaButton;
    private JLabel Balanço;
    private JButton sobreAContaButton;
    private JPanel panel3;

    private JFrame frame;


    public MainMenu(){
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270, 370));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel3);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Troca de Cursor ao selecionar os botões
        depósitoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saqueDeValoresButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        transferênciaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sobreAContaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }
}


