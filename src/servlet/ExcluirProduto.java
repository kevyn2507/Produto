package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;

/**
 * Servlet implementation class ExcluirProduto
 */
@WebServlet("/ExcluirProduto.do")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		
		ProdutoService produtoexcluido = new ProdutoService();
		
		produtoexcluido.Excluir(codigo);
		
		response.sendRedirect("index.html");
	}

}
