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
import entidades.Mascota;
import entidades.Usuario;
import interfaces.MascotaInterface;
import interfaces.UsuarioAuthInterface;
import util.MySQLConnection;

/**
 * Servlet implementation class UsuarioAuthServlet
 */
@WebServlet("/UsuarioAuthServlet")
public class UsuarioAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		
		if(type.equals("login")) {
			String code = request.getParameter("txtCode");
			String pass = request.getParameter("txtPass");
			
			DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			UsuarioAuthInterface usuarioAuthInterface = daoFactory.getUsuario();
			Usuario usuario = usuarioAuthInterface.iniciarSesion(code, pass);
			
			if(usuario!=null) {
				System.out.println("cod: " + usuario.getCodigo() + "\nnombre : " + usuario.getNombre()+"\napellido: " + usuario.getApellido());

				System.out.println("Tenemos usuario!");
				HttpSession session = request.getSession(true);
				session.setAttribute("codigo", usuario.getCodigo());
				session.setAttribute("nombre", usuario.getNombre());
				session.setAttribute("apellido", usuario.getApellido());
				
				
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				MascotaInterface mascotaInterface = dao.getMascota();
				List<Mascota> listadoMascotas = mascotaInterface.listMascota();
				request.setAttribute("data", listadoMascotas);
				
				request.getRequestDispatcher("listadoMascotasPrincipal.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje","Error en usuario y/o clave");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}else if(type.equals("logout")){
			HttpSession session = request.getSession(true);
			session.removeAttribute("codigo");
			session.removeAttribute("nombre");
			session.removeAttribute("apellido");
			session.invalidate();
			
			response.sendRedirect("login.jsp");
		}
		
	}

}
