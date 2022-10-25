package br.vemprafam.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

public class Alterar implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
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
		String email = request.getParameter("email");
		DaoFuncionario dao = new DaoFuncionario();
		dao.alterarFuncionario(new Funcionario(re,nome,dataAdmissao,salario,email));
		return "funcionario-alterado.jsp";
	}

}
