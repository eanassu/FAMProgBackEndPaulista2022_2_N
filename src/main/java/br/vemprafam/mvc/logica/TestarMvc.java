package br.vemprafam.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestarMvc implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Executando a l�gica...");
		
		return "teste-mvc.jsp";
	}

}
