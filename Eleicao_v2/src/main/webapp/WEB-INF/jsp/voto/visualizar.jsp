<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Candidato</title>
</head>
<body>
	<form action="/candidato/alterar" method="post">
		<input type="hidden" name="codigo" value="${candidato.codigoRegistro}">
		<c:import url="_campos.jsp"></c:import>
		<br/>
		<button type="submit">Salvar</button>

		<a href="/candidato/listar">Cancelar</a> 
		<a href="/candidato/deletar/${candidato.codigoRegistro}">Deletar</a>
	</form>
</body>
</html>