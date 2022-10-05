<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.pojo.Funcionario"%>
<%@page import="br.vemprafam.dao.DaoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração</title>
</head>
<body>
<%
int re = Integer.parseInt(request.getParameter("re"));
DaoFuncionario dao = new DaoFuncionario();
Funcionario f = dao.buscarPeloRe( re );
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
String dataAdmStr = format.format(f.getDataAdmissao());
%>
<form action="alterarFuncionario">
RE:<input type='text' name='re' value='<%=f.getRe()%>'/><br/>
Nome:<input type='text' name='nome' value='<%=f.getNome()%>'/><br/>
Data de Admissão (dd/mm/aaaa):<input type='text' name='dataAdm' 
  value='<%=dataAdmStr%>'/><br/>
Salário:<input type="text" name='salario' value='<%=f.getSalario()%>'/><br/>
e-mail:<input type='text' name='email' value='<%=f.getEmail()%>'/><br/>
<input type='submit' value='enviar'>
</form>
<br/>
<a href="/Projeto">voltar</a>
</body>
</html>