package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletLista
 */
@WebServlet("/ServletLista")
public class ServletLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		PrintWriter out = response.getWriter();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>IMC</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n");
		out.println("<table border='1'>");
		out.println("<tr>\r\n"
		+ "<th>RE</th><th>nome</th><th>data adm</th><th>salário</th><th>e-mail</th>\r\n"
		+ "</tr>");
		for(Funcionario f: lista) {
			out.println("<tr>\r\n"
					+ "<td>"+ f.getRe() + "</td>"
					+ "<td>"+ f.getNome() + "</td>"
					+ "<td>"+ dateFormat.format(f.getDataAdmissao()) + "</td>"
					+ "<td>"+ currencyFormat.format(f.getSalario())+"</td>\r\n"
					+ "<td>"+ f.getEmail() + "</td>"
					+ "</tr>");
		}
		out.println("</table>");	
		out.println("<br/>\r\n"
				+ "<a href=\"/Projeto\">voltar</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
