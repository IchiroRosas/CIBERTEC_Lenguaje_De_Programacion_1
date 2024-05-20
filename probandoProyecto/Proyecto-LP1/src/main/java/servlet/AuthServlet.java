package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import entidades.Users;
import entidades.Workers;
import interfaz.AdminAuthInterface;
import interfaz.WorkerInterface;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals("login")) {
			String correo = request.getParameter("txtCorreo");
			String contraseña = request.getParameter("txtContraseña");
			DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			AdminAuthInterface dao = daoFactory.getAuth();
			Users user = dao.InicioSesion(correo, contraseña);
			if(user != null) {
				HttpSession sesion = request.getSession(true);
				String nombre = user.getNombres();
				String apellidos = user.getApellidos();
				String rol = user.getRol();
				
				sesion.setAttribute("nombre", nombre);
				sesion.setAttribute("apellidos", apellidos);
				sesion.setAttribute("rol", rol);

				WorkerInterface model = daoFactory.getWorker();
				List<Workers> data = model.listadoObjeto();
				request.setAttribute("data", data);
				request.getRequestDispatcher("Listado.jsp").forward(request, response);
				
			} else {
				request.setAttribute("mensaje", "Error en la contraseña y/o correo");
				request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
			}
		} else if(type.equals("logout")) {
			HttpSession sesion = request.getSession(true);
			sesion.removeAttribute("nombre");
			sesion.removeAttribute("apellidos");
			sesion.removeAttribute("rol");
			sesion.invalidate();
			
			response.sendRedirect("IniciarSesion.jsp");
		}
	}
}