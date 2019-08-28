<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Votos</title>
</head>
<body>
	<a href="novo">Novo Voto</a>
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
			<c:forEach items="${votos}" var="voto">
				<tr>
					<td>
						<a href="/voto/visualizar/${voto.codigo}">${candidato.codigo}</a>
					</td>
					<td>${voto.codigo}</td>
					<td>${candidato.cpf}</td>
					<td>${candidato.partido.nome}</td>
					<td>${candidato.cargo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>