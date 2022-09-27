
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Model.ModelPacotes" 
	import="java.util.List"%>
<% 
@SuppressWarnings("unchecked")
List<ModelPacotes> lista = (List<ModelPacotes>) request.getAttribute("pacotes");
%>


<!doctype html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inicio</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>


	<nav
		class="navbar navbar-expand-lg navbar-light position-fixed col-12 "
		style="z-index: 999; background-color: #00bbf0">
		<br> <br> <br>
		<div class="container-fluid col-11 m-auto">
			<a class="navbar-brand" href="#">Bon Voyage</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./home.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./Views/destino/index.jsp">Destino</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./Views/pacotes/index.jsp">Promoções</a></li>
					<li class="nav-item"><a class="nav-link "
						href="./Views/clientes/index.jsp">Clientes</a></li>
					<li class="nav-item"><a class="nav-link "
						href="./Views/compras/index.jsp">Compras</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Pacotes </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">

							<li><a class="dropdown-item" href="./Views/pacotes/index.jsp">Pacotes Promocionais</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>

						</ul></li>
				</ul>


			</div>
		</div>
	</nav>
	
	<br><br><br><br><br>
	<header class="tag">
		<h1 class="container">Pacotes Promocionais</h1>
	</header>

	<div class="container py-3">
		<a href="./Views/pacotes/create.html" class="btn btn-primary mb-2">
			Criar Pacote </a>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Id Pacote</th>
						<th>Origem</th>
						<th>Promocao</th>

					</tr>
				</thead>
				<tbody>

					<%
					for (ModelPacotes c : lista) {
					%>
					<tr>
						<td><%=c.getId_pacote()%></td>
						<td><%=c.getOrigem()%></td>
						<td><%=c.getPromocao()%></td>

						<td class="d-flex"><a
							href="../pacotes-edit?id=<%=c.getId_pacote()%>" class="btn btn-info">
								Editar </a> <a href="../pacotes-delet?id=<%=c.getId_pacote()%>"
							class="btn btn-danger" style="margin-left: 10px;"> Deletar </a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>



	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>


</body>
</html>