package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ConsultaProduto
 */
@WebServlet("/ConsultaProduto.do")
public class ConsultaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		
		ProdutoService consultaservice = new ProdutoService();
		
		Produto p = consultaservice.consulta(codigo);
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		saida.println("<h1>Consulta de Produto</h1>");
		saida.println("Codigo: "+p.getCodigo()+"<br>");
		saida.println("Nome: "+p.getNome()+"<br>");
		saida.println("Descrição: "+p.getDescricao()+"<br>");
		saida.println("Valor: "+p.getValor()+"<br>");
		saida.println("Estoque: "+p.getEstoque()+" unidades");
	}

}
