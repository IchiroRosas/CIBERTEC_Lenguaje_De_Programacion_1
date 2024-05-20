package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Subject;
import interfaces.SubjectInterface;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		switch (type) {
		case "list": listSubject(request,response); break;
		case "register":break;
		case "delete": break;
		case "info": break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("listEstudiante.jsp").forward(request, response);
		}
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		SubjectInterface dao = daoFactory.getSubject();
		List<Subject> dataSubject = dao.listSubjects();
		
		request.setAttribute("data", dataSubject);
		request.getRequestDispatcher("listSubject.jsp").forward(request, response);
		
	}

}
