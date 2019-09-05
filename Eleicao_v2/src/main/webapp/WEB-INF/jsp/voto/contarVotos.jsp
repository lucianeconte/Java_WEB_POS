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
				<th>Total de Votos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${votosCandidatos}" var="votoTotal">
				<tr>
					<td>${votoTotal.candidato.codigoRegistro}</td>
					<td>${votoTotal.candidato.nome}</td>
					<td>${votoTotal.candidato.partido.nome}</td>
					<td>${votoTotal.candidato.cargo}</td>
					<td>${votoTotal.total}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>