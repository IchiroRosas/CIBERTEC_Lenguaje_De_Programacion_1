package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DAOFactory;
import entidades.Workers;
import interfaz.WorkerInterface;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/WorkServlet")
public class WorkServlet extends HttpServlet {
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
		String tipo = request.getParameter("cboTipo");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		
		WorkerInterface dao = daofactory.getWorker();
		List<Workers> dataFiltrada = dao.listadoObjetoFiltrado(tipo);
		
		request.setAttribute("dataFiltrada", dataFiltrada);
		request.getRequestDispatcher("FiltradoEmpleados.jsp").forward(request, response);
		
	}

	private void infoObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idWorker");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		
		Workers work = dao.infoObjeto(id);
		request.setAttribute("data", work);
		request.getRequestDispatcher("Editado.jsp").forward(request, response);
		
	}

	private void infoObjetoModal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idWorker");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		
		Workers work = dao.infoObjeto(id);
		
		Gson gson = new Gson();
	    String jsonWorker = gson.toJson(work);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonWorker);
	}

	private void eliminarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idWorker");
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		
		int value = dao.eliminarObjeto(id);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("Listado.jsp").forward(request, response);
		}
	}

	private void editarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idWorker = request.getParameter("txtIdWorker");
		String nombres = request.getParameter("txtNombres");
		String apellidoP = request.getParameter("txtApellidoP");
		String apellidoM = request.getParameter("txtApellidoM");
		String dni = request.getParameter("txtDni");
		String direccion = request.getParameter("txtDireccion");
		String telefono = request.getParameter("txtTelefono");
		String nacimiento = request.getParameter("txtNacimiento");
		String correo = request.getParameter("txtCorreo");
		String salario = request.getParameter("txtSalario");
		String jornada = request.getParameter("txtJornada");
		String cargo = request.getParameter("txtCargo");
		String inicioContrato = request.getParameter("txtInicioContrato");
		String finContrato = request.getParameter("txtFinContrato");
		String tipoContrato = request.getParameter("txtTipoContrato");
		Workers work = new Workers();
		
		work.setIdWorkers(idWorker);
		work.setNombres(nombres);
		work.setApellidoP(apellidoP);
		work.setApellidoM(apellidoM);
		work.setDni(dni);
		work.setDireccion(direccion);
		work.setTelefono(telefono);
		work.setFechaNacimiento(nacimiento);
		work.setCorreo(correo);
		work.setSalario(salario);
		work.setJornadaDiaria(jornada);
		work.setCargo(cargo);
		work.setInicioContrato(inicioContrato);;
		work.setFinContrato(finContrato);
		work.setTipoContrato(tipoContrato);
		
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		int value = dao.editarObejto(work);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("Listado.jsp").forward(request, response);
		}
		
	}

	private void registrarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombres = request.getParameter("txtNombres");
		String apellidoP = request.getParameter("txtApellidoP");
		String apellidoM = request.getParameter("txtApellidoM");
		String dni = request.getParameter("txtDni");
		String direccion = request.getParameter("txtDireccion");
		String telefono = request.getParameter("txtTelefono");
		String nacimiento = request.getParameter("txtNacimiento");
		String correo = request.getParameter("txtCorreo");
		String salario = request.getParameter("txtSalario");
		String jornada = request.getParameter("txtJornada");
		String cargo = request.getParameter("txtCargo");
		String inicioContrato = request.getParameter("txtInicioContrato");
		String finContrato = request.getParameter("txtFinContrato");
		String tipoContrato = request.getParameter("txtTipoContrato");
		Workers work = new Workers();
		
		work.setNombres(nombres);
		work.setApellidoP(apellidoP);
		work.setApellidoM(apellidoM);
		work.setDni(dni);
		work.setDireccion(direccion);
		work.setTelefono(telefono);
		work.setFechaNacimiento(nacimiento);
		work.setCorreo(correo);
		work.setSalario(salario);
		work.setJornadaDiaria(jornada);
		work.setCargo(cargo);
		work.setInicioContrato(inicioContrato);;
		work.setFinContrato(finContrato);
		work.setTipoContrato(tipoContrato);
		
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		int value = dao.crearObjeto(work);
		
		if(value == 0) {
			listarObjeto(request, response);
		} else {
			request.setAttribute("mensaje", "Ha ocurrido un problema");
			request.getRequestDispatcher("Listado.jsp").forward(request, response);
		}
	}

	private void listarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daofactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		WorkerInterface dao = daofactory.getWorker();
		List<Workers> data = dao.listadoObjeto();
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("Listado.jsp").forward(request, response);
	}

}
