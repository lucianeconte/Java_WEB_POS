<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Votos por Candidato</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Código Registro</th>
				<th>Candidato</th>
				<th>Cargo</th>
				<th>Partido</th>
				<th>Total de Votos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${votos}" var="voto">
				<tr>
					<td>${voto.codigoRegistro}</td>
					<td>${voto.candidato.nome}</td>
					<td>${voto.candidato.cargo}</td>
					<td>${voto.candidato.partido}</td>
					<td>${voto.urna}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>