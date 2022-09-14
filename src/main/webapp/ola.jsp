<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira página JSP</title>
</head>
<%-- Comentário --%>
<%
String mensagem = "Olá de novo";

%>

<body>
Teste JSP <br/>

<%=mensagem %> <br/>

<%  out.println("Escrito pelo out.println"); 

  System.out.println("Tudo foi executado!");

%>
</body>
</html>