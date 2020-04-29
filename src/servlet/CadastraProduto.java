package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/CadastraProduto.do")
public class CadastraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraProduto() {
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
		
		Produto produtocadastro = new Produto();
		
		produtocadastro.setCodigo(codigo);
		produtocadastro.setNome(nome);
		produtocadastro.setDescricao(descricao);
		produtocadastro.setValor(valor);
		produtocadastro.setEstoque(estoque);
		
		ProdutoService produtoservice = new ProdutoService();
		
		produtoservice.cadastrar(produtocadastro);
		
		response.sendRedirect("index.html");
	}

}
