package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        //Config da formatação do CPF

        //Troca de Cursor ao selecionar os botões
        cadastreSeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarAoLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Evento para voltar a tela de login - EVENTO 1
        voltarAoLoginButton.addActionListener(this);

        //Evento para criação de usuário - EVENTO 2
        cadastreSeButton.addActionListener(this);
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
            String sql = "Insert INTO usuarios (ncompleto, cpf, email, senha) VALUES (?, ?, ?, ?)";

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
