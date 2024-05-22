package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Advice;
import entidades.Subject;
import interfaces.AdviceInterface;
import listeners.SessionListener;

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
		case "register": registerAdvice(request,response);break;
		default:
			request.setAttribute("mensaje", "ocurrio un problema");
			request.getRequestDispatcher("listEstudiante.jsp").forward(request, response);
		}
	}

	private void registerAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Entradas
		String codeStudent = request.getParameter("cboAlumno");
		String codeSubject = request.getParameter("cboCurso");
		
		DAOFactory daoFactory=DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		AdviceInterface dao = daoFactory.getAdvice();
		Advice adviceobj = new Advice();
		adviceobj.setCodeStudent(codeStudent);
		adviceobj.setCodeSubject(codeSubject);
		
		int advice = dao.createAdvice(adviceobj);
		for(Subject item:SessionListener.dataSubject) {
			System.out.println("id "+item.getId());
			if(item.getId().equals(codeSubject)) {
				if(item.getAvailable()>0) {
					int cantidadActual=item.getAvailable();
					item.setAvailable(cantidadActual-1);
					request.setAttribute("mensajeCorrecto", "asesoria registrada para el curso de "+item.getName());
				}else {
					request.setAttribute("mensaje", "asesoria no disponible para el curso de "+item.getName());
				}
			}
			
		}
		
		
		request.getRequestDispatcher("listSubject.jsp").forward(request, response);
		
	}

}
