<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="home.css">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css"
	rel="stylesheet" />

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="icons/pipoca.png">
<title>CineDRIVE</title>
</head>
<body>

	<div class="container py-5">

		<div class="row p-3">
			<!-- Imagem de Perfil -->
			<div class="col-lg-4">
				<div class="card mb-4">
					<div class="card-body text-center">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
							alt="avatar" class="rounded-circle img-fluid"
							style="width: 150px;">
						<h5 class="my-3">${usuario.getNome() }</h5>
					</div>
				</div>
			</div>
			<!-- Informações -->
			<div class="col-lg-8">
				<!-- Largura da coluna -->
				<!-- Informações do Usuário -->
				<div class="card mb-4">
					<div class="card-header">Informações do Usuário</div>
					<div class="card-body">
						<!-- NOME -->
						<div class="row">
							<div class="col-sm-3">
								<p class="mb-0">Nome</p>
							</div>
							<div class="col-sm-9">
								<p class="text-muted mb-0">${usuario.getNome() }</p>
							</div>
						</div>
						<hr>
						<!-- EMAIL -->
						<div class="row">
							<div class="col-sm-3">
								<p class="mb-0">E-mail</p>
							</div>
							<div class="col-sm-9">
								<p class="text-muted mb-0">${usuario.getEmail() }</p>
							</div>
						</div>
						<hr>
						<!-- RANKING -->
						<div class="row">
							<div class="col-sm-3">
								<p class="mb-0">Ranking</p>
							</div>
							<div class="col-sm-9">
								<p class="text-muted mb-0">1º Lugar</p>
							</div>
						</div>
					</div>
				</div>

				<!-- Tabela de Upload e Downloads -->
				<div class="row">
					<div class="card mb-4">
						<div class="card-body">
							<!-- Tabs navs -->
							<ul class="nav nav-tabs mb-3 justify-content-center" id="tabelas"
								role="tablist">
								<li class="nav-item" role="presentation"><a
									class="nav-link active" id="tab-uploads" data-mdb-toggle="tab"
									href="#tab-upload" role="tab" aria-controls="tab-upload"
									aria-selected="true"> <i
										class="fas fa-cloud-arrow-up fa-fw me-2"></i>Uploads
								</a></li>
								<li class="nav-item" role="presentation"><a
									class="nav-link" id="tab-downloads" data-mdb-toggle="tab"
									href="#tab-download" role="tab" aria-controls="tab-download"
									aria-selected="false"> <i
										class="fas fa-cloud-arrow-down fa-fw me-2"></i>Downloads
								</a></li>
							</ul>
							<!-- Tabs navs -->

							<!-- Tabs content -->
							<div class="tab-content w-100 table-responsive"
								id="ex-with-icons-content">
								<div class="tab-pane fade show active" id="tab-upload"
									role="tabpanel" aria-labelledby="tab-uploads">
									
									<table
										class="table align-middle mb-0 bg-white justify-content-center">
										<thead class="bg-light">
											<tr>
												<th></th>
												<th>Titulo</th>
												<th>Ano</th>
												<th>Nota</th>
												<th>Tempo</th>
												<th>Data-Up</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${uploads }" var="upload">
												<c:set value="${filmeDao.findById(upload.getId_filme()) }"
													var="filme" scope="request" />
												<tr>
													<td>
														<div class="d-flex align-items-center">
															<img src="${filme.getImagem_url() }" alt
																style="max-width: 45px; height: auto;" />
														</div>
													</td>
													<td>
														<p class="fw-normal mb-1">${filme.getTitulo()}</p>
													</td>
													<td>
														<p class="fw-normal mb-1">${filme.getAno()}</p>
													</td>
													<td>${filme.getNota()}</td>
													<td>${filme.getTempo()} min</td>
													<td>
														<p class="fw-normal mb-1">${upload.data_registro }</p>
													</td>
													<td><a href="#"><i class="far fa-trash-can"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- CONTEUDO DA GUIA DOWNLOADS -->
								<div class="tab-pane fade" id="tab-download" role="tabpanel"
									aria-labelledby="tab-downloads">
									<table
										class="table align-middle mb-0 bg-white justify-content-center">
										<thead class="bg-light">
											<tr>
												<th></th>
												<th>Titulo</th>
												<th>Ano</th>
												<th>Nota</th>
												<th>Tempo</th>
												<th>Data-Download</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
													<div class="d-flex align-items-center">
														<img
															src="https://i.pinimg.com/originals/2b/c7/69/2bc769af019f122e8edaf7a8e13d5eee.jpg"
															alt style="max-width: 45px; height: auto;" />
													</div>
												</td>
												<td>
													<p class="fw-normal mb-1">Filme 1</p>
												</td>
												<td>
													<p class="fw-normal mb-1">2020</p>
												</td>
												<td>5.0</td>
												<td>160 min</td>
												<td>
													<p class="fw-normal mb-1">01/01/2021</p>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- Tabs content -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
</body>
</html>