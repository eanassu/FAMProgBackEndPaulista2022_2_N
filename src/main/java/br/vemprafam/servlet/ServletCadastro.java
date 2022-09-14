package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/cadastrarFuncionario")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int re = Integer.parseInt(request.getParameter("re"));
		String nome = request.getParameter("nome");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAdmissao;
		try {
			dataAdmissao = format.parse(request.getParameter("dataAdm"));
		} catch (ParseException e) {
			dataAdmissao = new Date();
		}
		double salario = Double.parseDouble(request.getParameter("salario"));
		DaoFuncionario dao = new DaoFuncionario();
		dao.inserirFuncionario(new Funcionario(re,nome,dataAdmissao,salario));
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Inserido!<br/>");
		out.println("<a href='/Projeto'>voltar</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
