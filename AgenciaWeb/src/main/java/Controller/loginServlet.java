package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOLogin;
import Model.ModelLogin;

@WebServlet(urlPatterns = { "/login", "/login-create", "/login-edit", "/login-update", "/login-delet" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAOLogin DAOLogin = new DAOLogin();
	ModelLogin login = new ModelLogin();
	
	public loginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/login":
			read(request, response);
			break;
		case "/login-create":
			create(request, response);
			break;
		case "/login-edit":
			edit(request, response);
			break;
		case "/login-update":
			update(request, response);
			break;
		case "/login-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ModelLogin> lista = DAOLogin.getLogin();

		request.setAttribute("login", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./Views/login/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		login.setTipo_login(request.getParameter("login"));
		
		DAOLogin.save(login);
		response.sendRedirect("login");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		login = DAOLogin.getLoginById(id);

		request.setAttribute("id", login.getId_login());
		request.setAttribute("tipo_login", login.getTipo_login());
		
		RequestDispatcher rd = request.getRequestDispatcher("./Views/login/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login.setId_login(Integer.parseInt(request.getParameter("id")));
		login.setTipo_login(request.getParameter("tipo_login"));
		
		DAOLogin.update(login);
		response.sendRedirect("login");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAOLogin.deleteById(id);
		response.sendRedirect("login");
	}

}