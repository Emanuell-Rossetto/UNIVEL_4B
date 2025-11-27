package view;

import controller.UsuarioController;
import model.Usuario;
import util.Mensagem;
import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private final UsuarioController controller = new UsuarioController();
    private JTextField txtLogin; // Declare txtLogin
    private JPasswordField txtSenha; // Declare txtSenha
    private JButton btnEntrar; // Declare btnEntrar
    private JButton btnCadastrar; // Declare btnCadastrar

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Usuario:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha); // Corrected to add txtSenha

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");

        add(btnEntrar);
        add(btnCadastrar);

        btnEntrar.addActionListener(e -> {
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());

            if (controller.login(login, senha)) {
                Mensagem.info("Login realizado com sucesso!");
                Usuario usuario = new Usuario(); // Corrected variable name
                usuario.setLogin(login); // Corrected variable name
                dispose();
                new TelaMenu(usuario).setVisible(true);
            } else {
                Mensagem.info("Login ou senha incorretos."); // Changed to an existing method
            }   
        });

        btnCadastrar.addActionListener(e -> {
            TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario(); // Corrected variable name
            telaCadastro.setVisible(true); // Corrected variable name
        });
    }
}
