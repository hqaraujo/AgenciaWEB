<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Atualizar Compras</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="./css/style.css">
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
	<br><br><br><br><br>
        <header class="tag">
            <h1 class="container">Atualizar Compras</h1>
        </header>

        <div class="container py-3">
            <form action="./compras-update" >
                <fieldset>
                    <legend>Criar
                    </legend>
                    <div class="form-group mb-3">
                        <label for="id" class="form-label">
                            Id
                        </label>
                        <input type="text" id="id" name="id" class="form-control" placeholder="id" 
                        value="<%=request.getAttribute("id") %>" readonly />
                    </div>
                    
                  
                     <div class="form-group mb-3">
                        <label for="valor_total" class="form-label">
                            Valor Total
                        </label>
                        <input type="text" id="valor_total" name="valor_total" class="form-control"  
                        value="<%=request.getAttribute("valor_total") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="forma_pagamento" class="form-label">
                            Forma de pagamento
                        </label>
                        <input type="text" id="forma_pagamento" name="forma_pagamento" class="form-control"  
                        value="<%=request.getAttribute("forma_pagamento") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="valor" class="form-label">
                            Valor
                        </label>
                        <input type="text" id="valor" name="valor" class="form-control" 
                        value="<%=request.getAttribute("valor") %>" />
                    </div>
                    
                     <div class="form-group mb-3">
                        <label for="data_compra" class="form-label">
                            Data Compras
                        </label>
                        <input type="text" id="data_compras" name="data_compras" class="form-control" 
                        value="<%=request.getAttribute("data_compras") %>" />
                    </div>
                    
                     <div class="form-group mb-3">
                        <label for="clientes" class="form-label">
                            Clientes
                        </label>
                        <input type="text" id="clientes" name="clientes" class="form-control" 
                        value="<%=request.getAttribute("clientes") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="clientes" class="form-label">
                            Clientes
                        </label>
                        <input type="text" id="destino" name="destino" class="form-control" 
                        value="<%=request.getAttribute("destino") %>" />
                    </div>
                   
                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./compras" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
                </fieldset>
            </form>
        </div>


        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
</body>

</html>