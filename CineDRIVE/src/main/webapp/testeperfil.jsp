<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
	<table class="table align-middle mb-0 bg-white justify-content-center">
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
					var="filme" />
				<tr>
					<td>
						<div class="d-flex align-items-center">
							<img src="${filme.getImagem_url() }" alt
								style="max-width: 45px; height: auto;" />
						</div>
					</td>
					<td>
						<p class="fw-normal mb-1">o ${filme.getTitulo() }</p>
					</td>
					<td>
						<p class="fw-normal mb-1">${filme.getAno() }</p>
					</td>
					<td>${filme.getNota()) }</td>
					<td>${filme.getTempo() }min</td>
					<td>
						<p class="fw-normal mb-1">${upload.data_registro }</p>
					</td>
					<td><a href="#"><i class="far fa-trash-can"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>