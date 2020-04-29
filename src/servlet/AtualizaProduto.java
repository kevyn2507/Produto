package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class AtualizaProduto
 */
@WebServlet("/AtualizaProduto.do")
public class AtualizaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		String nome=request.getParameter("nome");
		String descricao=request.getParameter("descricao");
		double valor=Double.parseDouble(request.getParameter("valor"));
		int estoque=Integer.parseInt(request.getParameter("estoque"));
		
		Produto produtoatualizado = new Produto();
		
		produtoatualizado.setCodigo(codigo);
		produtoatualizado.setNome(nome);
		produtoatualizado.setDescricao(descricao);
		produtoatualizado.setValor(valor);
		produtoatualizado.setEstoque(estoque);
		
		ProdutoService produtoservice = new ProdutoService();
		
		produtoservice.Atualizar(produtoatualizado);
		
		response.sendRedirect("index.html");
	}

}
