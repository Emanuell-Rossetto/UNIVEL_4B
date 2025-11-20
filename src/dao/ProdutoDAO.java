package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.ResultadoCadastro;

import java.sql.*;

public class ProdutoDAO {

    public ResultadoCadastro inserir(Produto produto){
        if (existeProduto(produto.getNome())) {
            return ResultadoCadastro.USUARIO_EXISTE; // manter a estrutura
        }

        String sql = "INSERT INTO produtos (nome, preco, marca) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getMarca());

            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }


    public boolean existeProduto(String nomeProduto){
        String sql = "SELECT id FROM produtos WHERE nome = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeProduto);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de produto: " + e.getMessage());
            return false;
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, preco, marca FROM produtos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setMarca(rs.getString("marca"));

                produtos.add(produto);
            }

            return produtos;

        } catch (SQLException e) {
            e.printStackTrace();
            return produtos;
        }
    }

    public boolean excluir (int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int r = stmt.executeUpdate();
            return r > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
            return false;
        }
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setMarca(rs.getString("marca"));
                return p;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto por ID: " + e.getMessage());
            return null;
        }
    }

    public boolean gravar(Produto u){
        String sql = "UPDATE produtos SET nome = ?, preco = ?, marca = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setDouble(2, u.getPreco());
            stmt.setString(3, u.getMarca());
            stmt.setInt(4, u.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

}
