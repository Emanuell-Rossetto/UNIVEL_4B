package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO; // Assuming a similar DAO for Produto
import java.awt.*;
import java.util.List;
import model.Produto; // Assuming a similar model for Produto
import dao.ProdutoDAO; // Ensure ProdutoDAO is correctly imported
import model.Produto; // Ensure Produto is correctly imported
import view.ProdutoFormulario; // Import ProdutoFormulario

public class ProdutoCRUD extends JFrame {
    private JTable tabelaProdutos;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoCRUD(){
        setTitle("Gerenciamento de Produtos");
        setSize(700, 400);
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo", "Situação", "Data Criação"}, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabelaProdutos = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        btnNovo = new JButton("Novo");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);

        btnNovo.addActionListener(e -> abrirFormulario(null));
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());

        carregarProdutos();
        setVisible(true);
    }

    private void carregarProdutos(){
        model.setRowCount(0);
        List<Produto> produtos = produtoDAO.listarTodos(); // Ensure listarTodos() is defined in ProdutoDAO
        for (Produto p : produtos){
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getTipo(), // Ensure getTipo() is defined in Produto
                p.getSituacao(), // Ensure getSituacao() is defined in Produto
                p.getDataCriacao() // Ensure getDataCriacao() is defined in Produto
            });
        }
    }

    private void abrirFormulario(Produto produto){
        ProdutoFormulario formulario = new ProdutoFormulario(this, produto); // Ensure ProdutoFormulario is defined
        formulario.setVisible(true);
    }

    private void editarProduto(){
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0){
            int id = (int) model.getValueAt(linha, 0);
            Produto produto = produtoDAO.buscarPorId(id);
            abrirFormulario(produto);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
        }
    }

    private void excluirProduto(){
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0){
            int id = (int) model.getValueAt(linha, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este produto?");
            if (confirm == JOptionPane.YES_OPTION){
                boolean sucesso = produtoDAO.excluir(id);
                if (sucesso){
                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.");
                    carregarProdutos();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir produto.");
                }
            }
        }
    }


    public void atualizarTabela(){
        carregarProdutos();
    }
}
        
