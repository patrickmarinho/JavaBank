package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    private JLabel Title;
    private JButton depósitoButton;
    private JButton saqueDeValoresButton;
    private JButton transferênciaButton;
    private JButton sobreAContaButton;
    private JPanel panel3;
    private JLabel title;
    private JLabel balance;
    private JLabel balancevalue;

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

        //Evento ao clicar nos botões
        depósitoButton.addActionListener(this);
        saqueDeValoresButton.addActionListener(this);
        transferênciaButton.addActionListener(this);
        sobreAContaButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depósitoButton){
            frame.dispose();
            new DepositoMenu();

        } else if (e.getSource() == saqueDeValoresButton) {
            frame.dispose();
            new SaqueMenu();

        } else if (e.getSource() == transferênciaButton) {

        } else{ //sobreAContaButton

        };

    }
}


