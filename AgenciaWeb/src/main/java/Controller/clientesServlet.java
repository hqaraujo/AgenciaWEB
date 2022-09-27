package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOClientes;
import Model.ModelClientes;
import DAO.DAOLogin;
import Model.ModelLogin;
@WebServlet(urlPatterns = { "/cliente", "/cliente-create", "/cliente-edit", "/cliente-update", "/cliente-delet" })
public class clientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAOClientes DAOClientes= new DAOClientes();
	ModelClientes clientes = new ModelClientes();
	DAOLogin DAOLogin= new DAOLogin();
	ModelLogin login = new ModelLogin();
	
	public clientesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/cliente":
			read(request, response);
			break;
		case "/clientedestino-create":
			create(request, response);
			break;
		case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
		case "/cliente-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ModelClientes> lista = DAOClientes.getClientes();

		request.setAttribute("clientes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./Views/clientes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		clientes.setCpf_cliente(request.getParameter("cpf_cliente"));
		clientes.setNome_cliente(request.getParameter("nome_cliente"));
		clientes.setEmail_cliente(request.getParameter("email_cliente"));
		clientes.setLogin(request.getParameter("login"));
		
		DAOClientes.save(clientes);
		response.sendRedirect("clientes");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		clientes = DAOClientes.getClientesById(id);

		request.setAttribute("id", clientes.getId_cliente());
		request.setAttribute("cpf_cliente", clientes.getCpf_cliente());
		request.setAttribute("email_cliente", clientes.getEmail_cliente());
		request.setAttribute("login", clientes.getLogin());
		
		RequestDispatcher rd = request.getRequestDispatcher("./Views/clientes/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clientes.setId_cliente(Integer.parseInt(request.getParameter("id")));
		clientes.setCpf_cliente(request.getParameter("cpf_cliente"));
		clientes.setNome_cliente(request.getParameter("nome_cliente"));
		clientes.setLogin(request.getParameter("login"));
		
		DAOClientes.update(clientes);
		response.sendRedirect("clientes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAOClientes.deleteById(id);
		response.sendRedirect("clientes");
	}

}