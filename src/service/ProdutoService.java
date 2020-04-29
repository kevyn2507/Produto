package service;

import java.util.ArrayList;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoService()
	{
		produtoDAO = new ProdutoDAO();
	}
	public void cadastrar(Produto produto)
	{
		produtoDAO.cadastrar(produto);
		System.out.println("Produto Cadastrado!");
	}
	public Produto consulta(int codigo)
	{
		Produto p=produtoDAO.consultar(codigo);
		return p;
	}
	public void Excluir(int codigo)
	{
		produtoDAO.excluir(codigo);
		System.out.println("Produto excluido!");
	}
	public void Atualizar(Produto produto)
	{
		produtoDAO.alterar(produto);
		
	}
	public ArrayList<Produto> listaProdutos()
	{
		return produtoDAO.listarProdutos();
	}
}