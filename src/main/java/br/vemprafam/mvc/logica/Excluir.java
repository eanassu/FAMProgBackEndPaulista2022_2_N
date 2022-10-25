package br.vemprafam.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

public class Excluir implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int re = Integer.parseInt(request.getParameter("re"));
		DaoFuncionario dao = new DaoFuncionario();
		dao.excluirFuncionario(new Funcionario(re,"",null,0.0,""));
		return "funcionario-excluido.jsp";
	}

}
