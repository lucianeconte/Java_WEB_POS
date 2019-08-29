<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<label for="data">Data: </label>
<input type="text" name="data" id="data" value="${voto.data}">
<form:errors path="voto.data" />
<br/>
<label for="urna">Urna: </label>
<input type="text" name="urna" id="urna" value="${voto.urna}">
<form:errors path="voto.urna" />
<br/>
<label for="candidato">Candidato</label>
<select id="candidato" name="candidato.codigoRegistro">
	<c:forEach items="${candidatos}" var="candidato">
		<c:set var="selecionado" value="" />
		<c:if test="${candidato.codigoRegistro eq voto.candidato.codigoRegistro}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${candidato.codigoRegistro}" ${selecionado}>${candidato.nome} - ${candidato.cargo}
	</c:forEach>
</select>
<br/>
<label for="eleitor">Eleitor</label>
<select id="eleitor" name="eleitor.numeroTitulo">
 <c:forEach items="${eleitores}" var="eleitor">
		<c:set var="selecionado" value="" />
		<c:if test="${eleitor.numeroTitulo eq voto.eleitor.numeroTitulo}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${eleitor.numeroTitulo}" ${selecionado}>${eleitor.nome}
	</c:forEach> 
</select>
<!--  <label for="cargo">Cargo</label>
<select id="cargo" name="cargo">
	<c:forEach items="${cargos}" var="cargo">
		<c:set var="selecionado" value="" />
		<c:if test="${cargo eq candidato.cargo}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${cargo}" ${selecionado}>${cargo}
	</c:forEach>
</select>-->