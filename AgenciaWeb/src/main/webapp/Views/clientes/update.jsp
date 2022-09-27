<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Atualizar Clientes</title>
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

							<li><a class="dropdown-item" href="./Views/clientes/index.jsp">Clientes</a></li>
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
            <h1 class="container">Atualizar Clientes</h1>
        </header>

        <div class="container py-3">
            <form action="./clientes-update" >
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
                        <label for="cpf_cliente" class="form-label">
                            CPF
                        </label>
                        <input type="text" id="cpf_cliente" name="cpf_cliente" class="form-control"  
                        value="<%=request.getAttribute("cpf_cliente") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="nome_cliente" class="form-label">
                            Nome
                        </label>
                        <input type="text" id="nome_cliente" name="nome_cliente" class="form-control"  
                        value="<%=request.getAttribute("nome_cliente") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="email_cliente" class="form-label">
                            Email
                        </label>
                        <input type="text" id="email_cliente" name="email_cliente" class="form-control" 
                        value="<%=request.getAttribute("email_cliente") %>" />
                    </div>
                    
                    <div class="form-group mb-3">
                        <label for="login" class="form-label">
                            Login
                        </label>
                        <input type="text" id="login" name="login" class="form-control" 
                        value="<%=request.getAttribute("login") %>" />
                    </div>
                    
                   
                    

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./clientes" class="btn btn-danger" style="margin-left: 10px">
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
