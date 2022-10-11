<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="fam" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet" 
     href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
<form action="cadastrarFuncionario">
RE:<input type='text' name='re'/><br/>
Nome:<input type='text' name='nome'/><br/>
Data de Admissão (dd/mm/aaaa):<fam:campoData id='dataAdm'/><br/>
Salário:<input type="text" name='salario'/><br/>
e-mail:<input type="text" name='email'/><br/>
<input type='submit' value='enviar'>
</form>
<br/>
<a href="/Projeto">voltar</a>
</body>
</html>