package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Estudiante;
import entidades.TipoDocumento;
import interfaces.EstudianteInterface;

/**
 * Servlet implementation class EstudianteServlet2
 */
@WebServlet("/EstudianteServlet")
public class EstudianteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EstudianteServlet2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		switch (type) {
		case "load": configuracionInicial(request,response); break;
		case "register":{
			String idEstudiante = request.getParameter("idEstudiante");
			if (idEstudiante.isEmpty()) {
				registrarEstudiante(request,response);
			}else {
				editarEstudiante(request,response);
			}
		}
		case "delete": eliminarEstudiante(request,response);break;
		case "info": obtenerEstudiante(request,response);break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("listEstudiante.jsp").forward(request, response);
		}
	}

	private void obtenerEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editarEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrarEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void configuracionInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		EstudianteInterface dao = daoFactory.getEstudiante();
		List<TipoDocumento> data = dao.listTipoDocumentos();
		List<Estudiante> dataEstudiante = dao.listEstudiantes();
		
		request.setAttribute("data", data);
		request.setAttribute("dataEstudiantes", dataEstudiante);
		request.getRequestDispatcher("listEstudiante.jsp").forward(request, response);
		
	}

}
