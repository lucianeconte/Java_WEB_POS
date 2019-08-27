<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Eleição - Spring Framework</title>
</head>
<body>
	TESTE DO SPRINGFRAMEWORK
	
	<h1>${nome}</h1>
	
	<form action="/variavelpost/" method="post">
		<input type="text" name="nome"/>
		<button type="submit">Enviar</button>
	</form>	
	
	
	<!--  imprimindo a lista de nomes -->
	<c:forEach items="${nomes}" var="nome">
			${nome}
	</c:forEach>
	
</body>
</html>