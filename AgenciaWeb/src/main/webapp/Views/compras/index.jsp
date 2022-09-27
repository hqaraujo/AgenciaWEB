<%@page import="Model.ModelCompras"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Model.ModelCompras" import="DAO.DAOCompras"
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
@SuppressWarnings("unchecked")
List<ModelCompras> lista = (List<ModelCompras>) request.getAttribute("compras");
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
							Login </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">

							<li><a class="dropdown-item" href="./Views/compras/index.jsp">compras</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>

						</ul></li>
				</ul>


			</div>
		</div>
	</nav>
	<br><br><br><br>
	<header class="tag">
		<h1 class="container">Compras</h1>
	</header>

	<div class="container py-3">
		<a href="./Views/compras/create.html" class="btn btn-primary mb-2">
			Criar Compras </a>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						
						<th>Valor Total</th>
						<th>Forma de Pagamento</th>
						<th>Valor</th>
						<th>Data Compras</th>
						<th>Id Compras</th>
						<th>Clientes</th>
						<th>Destino</th>

					</tr>
				</thead>
				<tbody>

					<%
					for (ModelCompras c : lista) {
					%>
					<tr>
						<td><%=c.getValor_total()%></td>
						<td><%=c.getForma_pagamento()%></td>
						<td><%=c.getValor()%></td>
						<td><%=c.getData_compras()%></td>
						<td><%=c.getId_compras()%></td>
						<td><%=c.getClientes()%></td>
						<td><%=c.getDestino()%></td>

						<td class="d-flex"><a
							href="/compras-edit?id=<%=c.getId_compras()%>" class="btn btn-info">
								Editar </a> <a href="/compras-delet?id=<%=c.getId_compras()%>"
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
</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
