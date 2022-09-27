package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOCompras;
import Model.ModelCompras;
import DAO.DAODestino;
import Model.ModelDestino;
import DAO.DAOClientes;
import Model.ModelClientes;
@WebServlet(urlPatterns = { "/compras", "/compras-create", "/compras-edit", "/compras-update", "/compras-delet" })
public class comprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	DAOCompras DAOCompras= new DAOCompras();
	ModelCompras compras = new ModelCompras();
	DAODestino DAODestino= new DAODestino();
	ModelDestino destino1 = new ModelDestino();
	DAOClientes DAOClientes= new DAOClientes();
	ModelClientes clientes = new ModelClientes();
	
	public comprasServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/compras":
			read(request, response);
			break;
		case "/compras-create":
			create(request, response);
			break;
		case "/compras-edit":
			edit(request, response);
			break;
		case "/compras-update":
			update(request, response);
			break;
		case "/compras-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ModelCompras> lista = DAOCompras.getCompras1();

		request.setAttribute("compras", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./Views/compras/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		compras.setValor_total(request.getParameter("valor_total"));
		compras.setForma_pagamento(request.getParameter("forma_pagamento"));
		compras.setValor(request.getParameter("valor"));
		compras.setData_compras(request.getParameter("data_compras"));
		compras.setClientes(request.getParameter("clientes"));
		compras.setDestino(request.getParameter("destino"));
		
		DAOCompras.save(compras);
		response.sendRedirect("compras");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		compras = DAOCompras.getComprasById(id);

		request.setAttribute("id", compras.getId_compras());
		request.setAttribute("valor_total", compras.getValor_total());
		request.setAttribute("forma_pagamento", compras.getForma_pagamento());
		request.setAttribute("valor", compras.getValor());
		request.setAttribute("data_compras", compras.getData_compras());
		request.setAttribute("clientes", compras.getClientes());
		request.setAttribute("destino", compras.getDestino());
		
		RequestDispatcher rd = request.getRequestDispatcher("./Views/compras/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		compras.setValor_total(request.getParameter("valor_total"));
		compras.setForma_pagamento(request.getParameter("forma_pagamento"));
		compras.setValor(request.getParameter("valor"));
		compras.setData_compras(request.getParameter("data_compras"));
		compras.setClientes(request.getParameter("clientes"));
		compras.setDestino(request.getParameter("destino"));
		
		DAOCompras.update(compras);
		response.sendRedirect("compras");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAOCompras.deleteById(id);
		response.sendRedirect("compras");
	}

}