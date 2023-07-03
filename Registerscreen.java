package bank;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class Registerscreen implements ActionListener {
    //variaveis
    private JFrame frame;
    private JTextField nomecompleto;
    private JFormattedTextField CPFfield;
    private JTextField email;
    private JPasswordField senha;
    private JButton cadastreSeButton;
    private JButton voltarAoLoginButton;
    private JPanel panel2;
    private String url = "jdbc:mysql://localhost:3306/dbjavabank";
    private String user = "root";
    private String password = "";

    private static final int maxDigit = 6;


    //construtores
    public Registerscreen() {
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


        //Troca de Cursor ao selecionar os botões
        cadastreSeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarAoLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Evento para voltar a tela de login - EVENTO 1
        voltarAoLoginButton.addActionListener(this);

        //Evento para criação de usuário - EVENTO 2
        cadastreSeButton.addActionListener(this);

        //Formatação do campo CPF
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.install(CPFfield);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "erro ao formatar");
        }

        // Limitar a quantidade de caracteres no campo de senha
        PlainDocument passwordDocument = (PlainDocument) senha.getDocument();
        passwordDocument.setDocumentFilter(new DocumentFilter() {
            private static final int MAX_LENGTH = 6; // Defina o número máximo de caracteres aqui

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int insertionLength = text != null ? text.length() : 0;
                int replaceLength = length;

                if (currentLength - replaceLength + insertionLength > MAX_LENGTH) {
                    // Ignorar a substituição se o número máximo de caracteres for excedido
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < text.length(); i++) {
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


    //formatação senha
    public void checklengt(){
        if (password.length() > maxDigit){
            password = password.substring(0, maxDigit);
        }
    }


    //Criação da tela de login - EVENTO PT2
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento 1 - Volta a tela de login
        if (e.getSource() == voltarAoLoginButton) {
            new Loginscreen();
            frame.dispose();

            //Evento 2 - criação de usuário
        } else if (e.getSource() == cadastreSeButton){

            //Valor dos campos de registro
            String NomeCompleto = nomecompleto.getText();
            String CPF = CPFfield.getText();
            String Email = email.getText();
            String Senha = new String(senha.getPassword());

            //Comando SQL
            String sql = "Insert INTO usuarios (nome_completo, cpf, email, senha) VALUES (?, ?, ?, ?)";

            //Conexão com o BD
            try(Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

                //Preenchimento das colunas da tabela usuarios no BD
                statement.setString(1, NomeCompleto);
                statement.setString(2, CPF);
                statement.setString(3, Email);
                statement.setString(4, Senha);

                //Teste de
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário Criado com sucesso");

                //Mensagem caso ocorra algum erro
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Usuário não foi criado, verifique os campos e tente novamente...");
            }

        }
    }
}
