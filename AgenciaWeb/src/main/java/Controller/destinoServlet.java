package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODestino;
import Model.ModelDestino;
import DAO.DAOPacotes;
import Model.ModelPacotes;
@WebServlet(urlPatterns = { "/destino", "/destino-create", "/destino-edit", "/destino-update", "/destino-delet" })
public class destinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAODestino DAODestino= new DAODestino();
	ModelDestino destino1 = new ModelDestino();
	DAOPacotes DAOPacotes= new DAOPacotes();
	ModelPacotes pacotes = new ModelPacotes();
	
	public destinoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/destino":
			read(request, response);
			break;
		case "/destino-create":
			create(request, response);
			break;
		case "/destino-edit":
			edit(request, response);
			break;
		case "/destino-update":
			update(request, response);
			break;
		case "/destino-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ModelDestino> lista = DAODestino.getDestino();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./Views/destino/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		destino1.setPais(request.getParameter("destino"));
		destino1.setCidade(request.getParameter("destino"));
		destino1.setPacotes(request.getParameter("pacotes"));
		
		DAODestino.save(destino1);
		response.sendRedirect("destino");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		destino1 = DAODestino.getDestinoById(id);

		request.setAttribute("id", destino1.getId_destino());
		request.setAttribute("pais", destino1.getPais());
		request.setAttribute("cidade", destino1.getCidade());
		request.setAttribute("promocao", destino1.getPacotes());
		
		RequestDispatcher rd = request.getRequestDispatcher("./Views/login/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destino1.setId_destino(Integer.parseInt(request.getParameter("id")));
		destino1.setPais(request.getParameter("pais"));
		destino1.setCidade(request.getParameter("cidade"));
		destino1.setPacotes(request.getParameter("pacotes"));
		
		DAODestino.update(destino1);
		response.sendRedirect("destino");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAODestino.deleteById(id);
		response.sendRedirect("destino");
	}

}