<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="assets/js/color-modes.js"></script>
<!-- Custom styles for this template -->
<link href="headers.css" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="telaFilme.css">
<link rel="icon" href="icons/pipoca.png">
<title>CineDRIVE</title>

</head>
<body>

	<div class="container mt-5" data-bs-theme="light">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-3">
						<img
							src="${filme.getImagem_url() }"
							alt="Poster do Filme" class="img-fluid">
					</div>
					<div class="col-md-5">
						<h2 class="card-title">${filme.getTitulo() }</h2>
						<p>
							<strong>Ano:</strong> ${filme.getAno() }
						</p>
						<p>
							<strong>Votos:</strong> ${votos }
						</p>
						<p>
							<strong>Nota:</strong> ${filme.getNota() }
						</p>
						<p>
							<strong>Tempo:</strong> ${filme.getTempo() } min
						</p>
						<p>
							<strong>Genero:</strong> Ação, Aventura, Ficção Científica
						</p>
						<p>
							<strong>Postado por:</strong> Nome do Usuário
						</p>
						<p>
							<strong>Vote</strong>
						</p>
						<div class="star-wrapper">
							<a href="#" class="fas fa-star s1"></a> <a href="#"
								class="fas fa-star s2"></a> <a href="#" class="fas fa-star s3"></a>
							<a href="#" class="fas fa-star s4"></a> <a href="#"
								class="fas fa-star s5"></a>
						</div>
						<script src="https://kit.fontawesome.com/5ea815c1d0.js"></script>
						<p>
							<strong>Sinopse:</strong> ${filme.getSinopse() }
						</p>
					</div>
				</div>
				<div class="mt-4 text-center">
					<a href="#" class="btn btn-primary btn-lg">Download</a>
				</div>
			</div>
		</div>

		<div class="mt-4">
			<div class="card mt-3">
				<div class="card-body">
					<h4>Postar Comentário</h4>
					<form>
						<div class="mb-3">
							<label for="comentario">Comentário</label>
							<textarea class="form-control" id="comentario" rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Enviar
							Comentário</button>
					</form>
				</div>
			</div>
			<h3>Comentários</h3>
			<div class="card mt-3">
				<div class="card-body">
					<div class="row">
						<div class="col-auto">
							<img src="https://github.com/mdo.png" width="32" height="32"
								class="rounded-circle" alt="Usuário 1">
							<!-- Imagem de perfil do Usuário 1 -->
						</div>
						<div class="col-auto">
							<p>Nome do Usuário 1</p>
						</div>
					</div>
					<div class="row mt-1">
						<p>Comentário do Usuário 1 sobre o filme. Lorem ipsum dolor
							sit amet, consectetur adipiscing elit.</p>
						<small>Data de Publicação: 01/02/2023</small>
					</div>
				</div>
			</div>
			<div class="card mt-3">
				<div class="card-body">
					<div class="row">
						<div class="col-auto">
							<img src="https://github.com/mdo.png" width="32" height="32"
								class="rounded-circle" alt="Usuário 1">
							<!-- Imagem de perfil do Usuário 1 -->
						</div>
						<div class="col-auto">
							<p>Nome do Usuário 1</p>
						</div>
					</div>
					<div class="row mt-1">
						<p>Comentário do Usuário 1 sobre o filme. Lorem ipsum dolor
							sit amet, consectetur adipiscing elit.</p>
						<small>Data de Publicação: 01/02/2023</small>
					</div>
				</div>
			</div>
			<!-- Adicione mais comentários aqui -->
		</div>
	</div>

</body>
</html>