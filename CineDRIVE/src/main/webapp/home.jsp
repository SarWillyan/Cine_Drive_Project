<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="home.css">
	<link rel="icon" href="icons/pipoca.png">
	<title>CineDRIVE</title>
	
</head>

<body>
	<%
	String pagina;
	if (request.getParameter("pg") == null){
		pagina = "0";
	} else {
		pagina = request.getParameter("pg");
		int pag = Integer.parseInt(pagina);
		if (pag > 3 || pag < 0) {
			pag = 0;
		}
		pagina = Integer.toString(pag);
	}
	
	String nome;
	if (session.getAttribute("logado") != null) {
		nome = "header_in.jsp";
	} else {
		nome = "header_out.jsp";
	}
	%>
	
	<jsp:include page="<%=nome %>">
    	<jsp:param name="pg" value="<%=pagina %>" />
	</jsp:include>
	
	<!-- Fazer um Radio de opções para as categorias de filmes -->
	

	
	<div class="movie-flex">

		<c:forEach items="${filmes }" var="filme" >
			<div class="movie">
				<a href="#">
					<img src="${filme.imagem_url}"
						alt="Filme 1">
					<div class="movie-title">${filme.titulo } (${filme.ano })</div>
					<div class="movie-nota"><strong>NOTA:</strong> ${filme.nota }</div>
				</a>
			</div>
		</c:forEach>

	</div>
	
	<p>${usuario.toString() }</p>
</body>

</html>