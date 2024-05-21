package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Mascota;
import interfaces.MascotaInterface;

/**
 * Servlet implementation class MascotaServlet
 */
@WebServlet("/MascotaServlet")
public class MascotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		switch(type) {
		case "register": registerMascota(request,response); break;
		case "list": listMascota(request,response); break;
		case "edit": editMascota(request,response); break;
		case "info": getMascota(request,response); break;
		case "delete": deleteMascota(request,response); break;
		default:
			request.setAttribute("mensaje", "Ocurrió un error");
			request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
		}
		
	}

	private void registerMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		String nombre = request.getParameter("txtNombre");
		String mascota = request.getParameter("txtMascota");
		String raza = request.getParameter("txtRaza");
		String duenio = request.getParameter("txtDuenio");
		
		Mascota mascotaNueva = new Mascota();
		mascotaNueva.setCodigo(codigo);
		mascotaNueva.setNombre(nombre);
		mascotaNueva.setMascota(mascota);
		mascotaNueva.setRaza(raza);
		mascotaNueva.setDuenio(duenio);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		MascotaInterface mascotaInterface = daoFactory.getMascota();
		int value = mascotaInterface.createMascota(mascotaNueva);
		
		if(value==0) {
			listMascota(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
		}
	}

	private void listMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		MascotaInterface mascotaInterface = daoFactory.getMascota();
		List<Mascota> listadoMascota = mascotaInterface.listMascota();
		
		request.setAttribute("data", listadoMascota);
		request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
	}

	private void editMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String codigo = request.getParameter("txtCodigo");
		String nombre = request.getParameter("txtNombre");
		String mascota = request.getParameter("txtMascota");
		String raza = request.getParameter("txtRaza");
		String duenio = request.getParameter("txtDuenio");
		
		Mascota mascotaEdicion = new Mascota();
		mascotaEdicion.setId(id);
		mascotaEdicion.setCodigo(codigo);
		mascotaEdicion.setNombre(nombre);
		mascotaEdicion.setMascota(mascota);
		mascotaEdicion.setRaza(raza);
		mascotaEdicion.setDuenio(duenio);
	
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		MascotaInterface mascotaInterface = daoFactory.getMascota();
		int value = mascotaInterface.updateMascota(mascotaEdicion);
		
		if(value==0) {
			listMascota(request,response);
		}else {
			request.setAttribute("mensaje", "Ocurrió un error");
			request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
		}
		
	}

	private void getMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		MascotaInterface mascotaInterface = daoFactory.getMascota();
		Mascota mascota = mascotaInterface.getMascota(id);
		
		request.setAttribute("data", mascota);
		request.getRequestDispatcher("infoMascota.jsp").forward(request, response);
	}

	private void deleteMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		MascotaInterface mascotaInterface = daoFactory.getMascota();
		int value = mascotaInterface.deleteMascota(id);
		if(value==0) {
			listMascota(request,response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un Error");
			request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
		}
	}

}
