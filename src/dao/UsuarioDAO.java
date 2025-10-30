package dao;

import model.Usuario;
import util.Funcoes;
import util.ResultadoCadastro;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean autenticar(Usuario usuario) {
        String sql= "SELECT nome_usuario, senha_hash FROM usuarios WHERE nome_usuario = ? AND senha_hash = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));

            ResultSet rs = stmt.executeQuery();
            return rs.next(); 


             } catch (SQLException e) {
                System.out.println("Erro ao autenticar: " + e.getMessage());
                return false;
             }
    }

    public boolean existeUsuario(String nome_usuario){
        String sql = "SELECT id FROM usuarios WHERE nome_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome_usuario);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de usuário: " + e.getMessage());
            return false;
        }
    }

    public ResultadoCadastro inserir(Usuario usuario){
        if (existeUsuario(usuario.getLogin())) {
            return ResultadoCadastro.USUARIO_EXISTE;
        }

        String sql = "INSERT INTO usuarios (nome_usuario, senha_hash, data_criacao, tipo, ativo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(4, "U");
            stmt.setString(5, "T");
            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }

    public List<Usuario> listarTodos(){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("nome_usuario"));
                u.setDataCriacao(rs.getString("data_criacao"));
                u.setTipo(rs.getString("tipo"));
                u.setAtivo(rs.getString("ativo"));
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return lista;
    }

    public boolean excluir (int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int r = stmt.executeUpdate();
            return r > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("nome_usuario"));
                u.setDataCriacao(rs.getString("data_criacao"));
                u.setTipo(rs.getString("tipo"));
                u.setAtivo(rs.getString("ativo"));
                return u;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
            return null;
        }
    }

    public boolean gravar(Usuario u){
        String sql = "UPDATE usuarios SET nome_usuario = ?, tipo = ?, ativo = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getTipo());
            stmt.setString(3, u.getAtivo());
            stmt.setInt(4, u.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        }
    }

    public void atualizar(){
        listarTodos();
    }
    // Atençao: este metodo deve existir
    // public boolean inserir(Usuario usuario) {
    //     String sql = "INSERT INTO usuarios (nome_usuario, senha_hash, data_criacao) VALUES (?, ?, ?)";
    //     try (Connection conn = Conexao.conectar();
    //          PreparedStatement stmt = conn.prepareStatement(sql)) {

    //         stmt.setString(1, usuario.getLogin());
    //         stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));
    //         stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

    //         stmt.executeUpdate();
    //         System.out.println("Usuário inserido com sucesso.");
    //         return true;

    //     } catch (SQLException e) {
    //         System.out.println("Erro ao inserir usuário: " + e.getMessage());
    //         return false;
    //     }

    // }
    
}
