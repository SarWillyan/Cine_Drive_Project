<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt-br" data-bs-theme="auto">

<head>
	<!-- <script src="assets/js/color-modes.js"></script> -->
	
	<meta charset="UTF-8">
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
	<link rel="icon" href="icons/pipoca.png">
	<title>CineDrive</title>
	
	<!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
	
	<!-- Custom styles for this template -->
	<link href="upload.css" rel="stylesheet">
</head>

<body class="bg-body-tertiary">

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

	<div class="container">
		<main>

			<div class="row g-5">
				<div class="col-md-7 col-lg-8">

					<h4 class="mb-3">Formulário de Upload</h4>

					<form action="UploadFile" method="post" enctype="multipart/form-data" class="needs-validation"  novalidate>
						<div class="row g-3">
							<div class="col-13">
								<label for="titulo" class="form-label">Titulo</label> 
								<input name="titulo" type="text" class="form-control" id="titulo" placeholder="Titulo do filme" required>
								<div class="invalid-feedback">O titulo é obrigatório.</div>
							</div>

							<div class="col-12">
								<label for="ano" class="form-label">Ano</label>
								<div class="input-group has-validation">
									<span class="input-group-text">📅</span> 
									<input name="ano" type="number" min="1900" max="2099" class="form-control" id="ano" placeholder="Ano de lançamento" required>
									<div class="invalid-feedback">O ano é obrigatório.</div>
								</div>
							</div>

							<div class="col-12">
								<label for="url" class="form-label">URL da capa do filme</label>
								<div class="input-group has-validation">
									<span class="input-group-text">🌐</span> 
									<input name="url_imagem" type="url" class="form-control" id="ano" placeholder="URL" required>
									<div class="invalid-feedback">O url é obrigatório.</div>
								</div>
							</div>

							<div class="col-12">
								<label for="tempo" class="form-label">Tempo</label>
								<div class="input-group has-validation">
									<span class="input-group-text">🕚</span> 
									<input name="tempo" type="number" min="0" max="600" class="form-control" id="tempo" placeholder="Tempo em minutos" required>
									<div class="invalid-feedback">O tempo é obrigatório.</div>
								</div>
							</div>

							<div class="col-12">
								<label for="sinopse" class="form-label">Sinópse</label>
								<div class="input-group has-validation">
									<textarea name="sinopse" class="form-control" maxlength="1500" id="sinopse" placeholder="Sinópse do filme" rows="4" required></textarea>
									<div class="invalid-feedback">A sinopse é obrigatório.</div>
								</div>
							</div>

						</div>

						<hr class="my-4">
						<!-- lista os generos existentes -->
						
						<c:forEach items="${generos }" var="genero">
							<div class="form-check form-check-inline">
								<input name="${genero.nome }" type="checkbox" class="form-check-input" id=${genero.nome }> 
								<label class="form-check-label" for="${genero.nome }" >${genero.nome }</label>
							</div>
						</c:forEach>

						<hr class="my-4">
						
						<!-- Imput de arquivos -->
						
						<div class="col-12">
							<label for="upload" class="form-label">Upload</label>
							<div class="input-group has-validation">
								<input name="file" type="file" class="form-control" id="upload"
									required>
								<div class="invalid-feedback">O arquivo é obrigatório.</div>
							</div>
						</div>

						<hr class="my-4">

						<button class="w-100 btn btn-primary btn-lg mb-3" type="submit">Fazer Upload</button>
					</form>
				</div>
			</div>
		</main>
		
	</div>
	<!-- <script src="assets/dist/js/bootstrap.bundle.min.js"></script> -->

	<script src="checkout.js"></script>
</body>

</html>