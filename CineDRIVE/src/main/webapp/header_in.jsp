<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="auto">

<head>

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="assets/js/color-modes.js"></script>
	<!-- Custom styles for this template -->
	<link href="headers.css" rel="stylesheet">
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>HEADER LOGADO</title>

</head>

<body>
	<%!
	boolean[] navs = {true, false, false, false};
	public String aba(boolean nav){
		if (nav == true){
			return "nav-link px-2 link-secondary";
		} else {
			return "nav-link px-2 link-body-emphasis";
		}
	}
	%>
	
	<%
	int pos = Integer.parseInt(request.getParameter("pg"));
	for (int i = 0; i <=3; i++) {
		navs[i] = (i == pos) ? true : false;
	}
	%>

	<header class="p-3 mb-3 border-bottom">
		<div class="container">
			<div  class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<label  class="logo" >Cine<strong>DRIVE</strong></label>
				<a href="Find?pg=0" class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
					<img src="./icons/pipoca.png" alt="Pipoca" width="40" height="40" />
				</a>

				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="Find?pg=0" class="<%=aba( navs[0] )%>">Visão Geral</a></li>
					<li><a href="Find?pg=1" class="<%=aba( navs[1] )%>">Categorias</a></li>
					<li><a href="Find?pg=2" class="<%=aba( navs[2] )%>">TopFilmes</a></li>
					<li><a href="Find?pg=3" class="<%=aba( navs[3] )%>">TopUsuários</a></li>
				</ul>

				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
					<input name="pesquisa" type="search" class="form-control form-control-dark text-bg-dark" placeholder="Pesquisar filmes... " aria-label="Search">
				</form>

				<div class="dropdown text-end">
					<a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"> 
						<img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
					</a>
					<ul class="dropdown-menu text-small">
						<li><a class="dropdown-item" href="UploadFile">Fazer Upload</a></li>
						<li><a class="dropdown-item" href="#">Histórico</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Sair</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<script src="assets/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>