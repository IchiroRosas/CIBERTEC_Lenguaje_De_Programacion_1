package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Usuario;
import interfaces.AuthInterface;
import modelo.SessionModel;
import util.Constantes;

/**
 * Servlet implementation class LoginLEServlet3
 */
@WebServlet("/LoginLEServlet3")
public class LoginLEServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if(type.equals("login")) {
			String correo= request.getParameter("txtCorreo");
			String clave = request.getParameter("txtPass");
			
			DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			AuthInterface dao = daoFactory.getAuth();
			
			Usuario usuario = dao.verificarInicioSesion(correo, clave);
			if (usuario != null) {
				SessionModel sessionProject = new SessionModel();
				sessionProject.saveSessionTimeOut(request, 30);
				sessionProject.saveSessionString(request,Constantes.NAME, usuario.getNombre());
				sessionProject.saveSessionString(request,Constantes.LASTNAME, usuario.getApellidos());
				sessionProject.saveSessionString(request,Constantes.EMAIL, usuario.getEmail());
				sessionProject.saveSessionString(request,Constantes.ROL, usuario.getRol());
				response.sendRedirect("home.jsp");
			}else {
				request.setAttribute("mensaje", "Error en usuario y/clave");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if(type.equals("logout")) {
			SessionModel sessionProject = new SessionModel();
			sessionProject.invalidateSession(request);
			response.sendRedirect("index.jsp");
		}
		
	}

}
