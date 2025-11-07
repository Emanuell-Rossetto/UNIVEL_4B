package view;

import model.Usuario;
import javax.swing.*;
import dao.UsuarioDAO;
import java.awt.*;
import java.security.MessageDigest;

public class UsuarioFormulario extends JDialog {
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JComboBox<String> cbTipo, cbAtivo;
    private JButton btnSalvar;
    private UsuarioDAO = new usuarioDAO();
    private Usuario usuario;
    private UsuarioCRUD parent;

    public UsuarioFormulario(UsuarioCRUD paret, Usuario usuario) {
        super(parent, "Formulario de Usuario", true);
        this.parent = parent;
        this.usuario = usuario;

        setTitle(usuario == null ? "Adicionar Usuario" : "Editar Usuario");
        setSize(300, usuario == null ? 300 : 200);
        setLayout(new GridLayout(usuario == null ? 5 : 4, 2, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        if (usuario == null) {
            add(new JLabel("Senha:"));
            txtSenha = new JPasswordField();
            add(txtSenha);
        }

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Usuario", "Administrador"});
        add(cbTipo);

        add(new JLabel("Ativo:"));
        cbAtivo = new JComboBox<>(new String[]{"Ativo", "Inativo"});
        add(cbAtivo);
        
        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        if (usuario != null) {
            txtNome.setText(usuario.getNome());
            cbTipo.setSelectedItem(usuario.getTipo().equals("A") ? "Administrador" : "Usuario");
            cbAtivo.setSelectedItem(usuario.getAtivo().equals("T") ? "Ativo" : "Inativo");
        }
        btnSalvar.addActionListener(e -> salvarUsuario());
        

    }
    
}