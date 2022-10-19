package br.vemprafam.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String executar(HttpServletRequest request, 
			HttpServletResponse response);
}
