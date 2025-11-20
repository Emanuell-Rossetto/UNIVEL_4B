package controller;

import dao.ProdutoDAO;
import model.Produto;
import util.ResultadoCadastro;


public class ProdutoController {
    private final ProdutoDAO pDAO = new ProdutoDAO();
    public ResultadoCadastro cadastrar(String nome, double preco, String marca) {
    Produto produto = new Produto();
    produto.setNome(nome);
    produto.setPreco(preco);
    produto.setMarca(marca);
    return pDAO.inserir(produto);
    }
}
