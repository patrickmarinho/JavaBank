package bank;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;


public class Loginscreen extends JFrame implements ActionListener {

    //variaveis, não modificar!!
    private JPanel panel1;
    private JFormattedTextField cpf;
    private JPasswordField senha;
    private JButton entrarButton;
    private JButton cadastreSeButton;
    private JLabel Title;
    private JFrame frame;
    private String url = "jdbc:mysql://localhost:3306/dbjavabank";
    private String user = "root";
    private String password = "";
    private static final int MAX_LENGTH = 6;


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

        //Evento de para ir para tela Main
        entrarButton.addActionListener(this);

        //Troca de Cursor ao selecionar os botões
        cadastreSeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        entrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Formatação do campo CPF
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.install(cpf);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "erro ao formatar");
        }

        // Limitação de quantidade de digitos no campo de senha
        PlainDocument passwordDocument = (PlainDocument) senha.getDocument();
        passwordDocument.setDocumentFilter(new DocumentFilter() {
            private static final int MAX_LENGTH = 6; // Número máximo de digitos

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                int currentLength = fb.getDocument().getLength(); //verifica o comprimento do campo
                int insertionLength = text != null ? text.length() : 0; //verifica o comprimento da inserção
                int replaceLength = length; //comprimento da substituição

                if (currentLength - replaceLength + insertionLength > MAX_LENGTH) {
                    // Ignorar a substituição se o número máximo de caracteres for excedido
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < text.length(); i++) { //loop de verificação se é digito ou letra
                    char c = text.charAt(i);
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }
                text = sb.toString();

                super.replace(fb, offset, length, text, attrs);
            }
        });
    }



    //Criação da tela de cadastro
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastreSeButton) {
            new Registerscreen();
            frame.dispose();

        } else if (e.getSource() == entrarButton) {

            String sql = "SELECT * FROM usuarios WHERE CPF = ? AND senha = ?";
            // Valor dos campos de registro
            String CPF = cpf.getText();
            String Senha = new String(senha.getPassword());

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, CPF);
                statement.setString(2, Senha);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    // Autenticação bem-sucedida
                    new MainMenu();
                    frame.dispose();

                } else {
                    // Autenticação falhou, o usuário ou senha estão incorretos
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                }

                rs.close();
                statement.close();
                conn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!");
            }
            }
        }

    }
