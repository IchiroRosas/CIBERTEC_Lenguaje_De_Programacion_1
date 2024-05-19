package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// De esta manera se obtiene la data enviada a través del formulario de notas.jsp
		String codigo = request.getParameter("txtCodigo");
		String nombre = request.getParameter("txtNombre");
		String nivel = request.getParameter("cboNivel");
		String modalidad = request.getParameter("cboModalidad");
		String docente = request.getParameter("txtDocente");
		String valores[] = new String[5];

		valores[0] = codigo;
		valores[1] = nombre;
		valores[2] = nivel;
		valores[3] = modalidad;
		valores[4] = docente;
		
		//meidante la variable valores se hace el envío de la data a respuesta.jsp
		request.setAttribute("registerSubject", valores);
		request.getRequestDispatcher("respuesta.jsp").forward(request, response);

	}

}
