<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Slide Navbar</title>
	<link rel="stylesheet" type="text/css" href="index.css">
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">

			<div class="signup">
				<form>
					<label for="chk" aria-hidden="true">Cadastro</label>
					<input type="text" name="nome" placeholder="Nome de usuário" required="">
					<input type="email" name="email" placeholder="Email" required="">
					<input type="password" name="senha" placeholder="Senha" required="">
					<button>Cadatrar</button>
				</form>
			</div>

			<div class="login">
				<form>
					<label for="chk" aria-hidden="true">Login</label>
					<input type="email" name="email" placeholder="Email" required="">
					<input type="password" name="senha" placeholder="Senha" required="">
					<button>Login</button>
				</form>
			</div>
	</div>
</body>
</html>