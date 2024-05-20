package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DAOFactory;
import entidades.Candidato;
import entidades.Workers;
import interfaz.CandidatosInterface;
import interfaz.WorkerInterface;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/CandidatoServlet")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		switch(type) {
		case "listar": listarObjeto(request, response); break;
		case "registrar": registrarObjeto(request, response); break;
		case "editar": editarObjeto(request, response); break;
		case "eliminar": eliminarObjeto(request, response); break;
		case "infoModal": infoObjetoModal(request, response); break;
		case "info": infoObjeto(request, response); break;
		case "listarObjetoFiltrado": listarObjetoFiltrado(request, response); break;
		default: {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("Listado.jsp").forward(request, response);
			}
		}
	}

	private void listarObjetoFiltrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("cboCarrera");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		
		List<Candidato> dataFiltrada = dao.listadoObjetoFiltrado(tipo);
		
		request.setAttribute("dataFiltrada", dataFiltrada);
		request.getRequestDispatcher("FiltradoCandidatos.jsp").forward(request, response);		
	}

	private void infoObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCandidato");
		
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		
		Candidato candi = dao.infoObjeto(id);
		request.setAttribute("data", candi);
		request.getRequestDispatcher("EditadoCandidatos.jsp").forward(request, response);
	}

	private void infoObjetoModal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idCandidato");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		
		Candidato candi = dao.infoObjeto(id);
		
		Gson gson = new Gson();
	    String jsonCandidato = gson.toJson(candi);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonCandidato);		
	}

	private void eliminarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCandidato");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		
		int value = dao.eliminarObjeto(id);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("ListadoCandidatos.jsp").forward(request, response);
		}		
	}

	private void editarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCandidato = request.getParameter("txtIdCandidato");
		String nombres = request.getParameter("txtNombres");
		String apellidoP = request.getParameter("txtApellidoP");
		String apellidoM = request.getParameter("txtApellidoM");
		String dni = request.getParameter("txtDni");
		String telefono = request.getParameter("txtTelefono");
		String nacimiento = request.getParameter("txtNacimiento");
		String correo = request.getParameter("txtCorreo");
		String carrera = request.getParameter("txtCarrera");
		Candidato candi = new Candidato();
		
		candi.setIdEmpleado(idCandidato);
		candi.setNombres(nombres);
		candi.setApellidoP(apellidoP);
		candi.setApellidoM(apellidoM);
		candi.setDni(dni);
		candi.setTelefono(telefono);
		candi.setFechaNacimiento(nacimiento);
		candi.setCorreo(correo);
		candi.setCarrera(carrera);
		
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		int value = dao.editarObjeto(candi);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("ListadoCandidatos.jsp").forward(request, response);
		}		
	}

	private void registrarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombres = request.getParameter("txtNombres");
		String apellidoP = request.getParameter("txtApellidoP");
		String apellidoM = request.getParameter("txtApellidoM");
		String dni = request.getParameter("txtDni");
		String telefono = request.getParameter("txtTelefono");
		String nacimiento = request.getParameter("txtNacimiento");
		String correo = request.getParameter("txtCorreo");
		String carrera = request.getParameter("txtCarrera");
		Candidato candi = new Candidato();
		
		candi.setNombres(nombres);
		candi.setApellidoP(apellidoP);
		candi.setApellidoM(apellidoM);
		candi.setDni(dni);
		candi.setCarrera(carrera);
		candi.setTelefono(telefono);
		candi.setCorreo(correo);
		candi.setFechaNacimiento(nacimiento);

		
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		int value = dao.crearObjeto(candi);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("ListadoCandidatos.jsp").forward(request, response);
		}			
	}

	private void listarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CandidatosInterface dao = daofactory.getCandidato();
		List<Candidato> data = dao.ListadoObjeto();
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("ListadoCandidatos.jsp").forward(request, response);
	}

}
