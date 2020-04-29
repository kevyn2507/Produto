package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ListarProdutos
 */
@WebServlet("/ListarProdutos.do")
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ProdutoService produtoservice = new ProdutoService();
		ArrayList<Produto> lista = produtoservice.listaProdutos();
		
		PrintWriter saida = response.getWriter();
		
		saida.println("<h1>Listagem de Produtos</h1>");
		
		lista.forEach(p->{
			saida.println("Codigo: "+p.getCodigo()+"<br>");
			saida.println("Nome: "+p.getNome()+"<br>");
			saida.println("Descrição: "+p.getDescricao()+"<br>");
			saida.println("Valor: "+p.getValor()+"<br>");
			saida.println("Estoque: "+p.getEstoque()+" unidades<br><br>");
		});
		saida.println("<form action=\"index.html\">\n" + 
				"    <input type=\"submit\" value=\"Inicio\" />\n" + 
				"</form>");
	}

}
