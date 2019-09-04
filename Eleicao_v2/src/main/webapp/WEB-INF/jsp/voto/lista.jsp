<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Total geral de votos por Candidato</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Código Registro</th>
				<th>Nome Candidato</th>
				<th>Partido</th>
				<th>Cargo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${votos}" var="voto">
				<tr>
					<td>
						<a href="/voto/listar/${voto.candidato.codigoRegistro}">${voto.candidato.codigoRegistro}</a>
					</td>
					<td>${voto.candidato.nome}</td>
					<td>${voto.candidato.partido.nome}</td>
					<td>${voto.candidato.cargo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>