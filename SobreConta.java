package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SobreConta implements ActionListener {
    private JPanel panel7;
    private JFormattedTextField ncomptxt;
    private JFormattedTextField cpftxt;
    private JFormattedTextField agtxt;
    private JFormattedTextField cctxt;
    private JFormattedTextField dtcriatxt;
    private JFormattedTextField ultactxt;
    private JButton voltarButton;
    private JLabel sobretitle;
    private JFrame frame;

    public SobreConta(){
        //Config da Tela
        frame = new JFrame("Javabank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(370, 250));
        frame.setResizable(false);

        //Config da Tela
        frame.add(panel7);
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
