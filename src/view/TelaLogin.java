package view;

import controller.UsuarioController;
import model.Usuario;
import util.Mensagem;
import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private final UsuarioController controller = new UsuarioController();

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
        add(txtLogin);

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");

        add(btnEntrar);
        add(btnCadastrar);

        btnEntrar.addActionListener(e -> {
        
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());

            if (controller.login(login, senha)) {
                Mensagem.info("Login realizado com sucesso!");
                Usuario Usuario = new Usuario();
                usuario.setLogin(login);
                dispose();
                new TelaMenu(usuario).setVisible(true);
            } else {
                Mensagem.showError("Login ou senha incorretos.");
            }   
        });

        btnCadastrar.addActionListener(e -> {
            TelaCadastroUsuario cadastro = new TelaCadastroUsuario();
            telaCadastro.setVisible(true);
        });
    }
}
