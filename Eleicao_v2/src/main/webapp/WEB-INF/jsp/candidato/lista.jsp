<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Candidatos</title>
</head>
<body>
	<a href="novo">Novo Candidato</a>
	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Partido</th>
				<th>Cargo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${candidatos}" var="candidato">
				<tr>
					<td>
						<a href="/candidato/visualizar/${candidato.codigoRegistro}">${candidato.codigoRegistro}</a>
					</td>
					<td>${candidato.nome}</td>
					<td>${candidato.cpf}</td>
					<td>${candidato.partido.nome}</td>
					<td>${candidato.cargo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>