package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOPacotes;
import Model.ModelPacotes;

@WebServlet(urlPatterns = { "/pacotes", "/pacotes-create", "/pacotes-edit", "/pacotes-update", "/pacotes-delet" })
public class pacotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAOPacotes DAOPacotes = new DAOPacotes();
	ModelPacotes pacotes = new ModelPacotes();

	public pacotesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/pacotes":
			read(request, response);
			break;
		case "/pacotes-create":
			create(request, response);
			break;
		case "/pacotes-edit":
			edit(request, response);
			break;
		case "/pacotes-update":
			update(request, response);
			break;
		case "/pacotes-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ModelPacotes> lista = new ArrayList< ModelPacotes>();
		lista =	DAOPacotes.getPacotespromocionais(); 

		request.setAttribute("pacotes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./Views/pacotes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pacotes.setOrigem(request.getParameter("pacotes"));

		DAOPacotes DAOPacotes = new DAOPacotes();
		DAOPacotes.save(pacotes);
		response.sendRedirect("pacotes");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		pacotes = DAOPacotes.getPacotesById(id);

		request.setAttribute("id", pacotes.getId_pacote());
		request.setAttribute("origem", pacotes.getOrigem());
		request.setAttribute("promocao", pacotes.getPromocao());

		RequestDispatcher rd = request.getRequestDispatcher("./Views/pacotes/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pacotes.setId_pacote(Integer.parseInt(request.getParameter("id")));
		pacotes.setOrigem(request.getParameter("origem"));
		pacotes.setPromocao(Double.parseDouble(request.getParameter("promocao")));

		DAOPacotes DAOPacotes = new DAOPacotes();
		DAOPacotes.update(pacotes);
		response.sendRedirect("pacotes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAOPacotes daoPacotes2 = new DAOPacotes();
		daoPacotes2.deleteById(id);
		response.sendRedirect("pacotes");
	}

}