package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Advice;
import entidades.Subject;
import interfaces.AdviceInterface;
import interfaces.SubjectInterface;
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
		case "list": break;
		case "register":registerAdvice(request,response); break;
		case "delete": break;
		case "info": break;
		case "filterDate": filterDateSubject(request,response);break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("listEstudiante.jsp").forward(request, response);
		}
	}

	private void filterDateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dateStart =request.getParameter("dtStart");
		String dateEnd =request.getParameter("dtEnd");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		SubjectInterface dao = daoFactory.getSubject();
		List<Subject> subjects=dao.listSubjects(dateStart, dateEnd);
		

		request.setAttribute("dataSubject", subjects);
		request.getRequestDispatcher("filterDate.jsp").forward(request, response);
	}

	private void registerAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Entradas
		String codeStudent =request.getParameter("cboAlumno");
		String codeSubject =request.getParameter("cboCurso");
		
		//Procesos
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		AdviceInterface dao = daoFactory.getAdvice();
		Advice adviceobj = new Advice();
		adviceobj.setCodeStudent(codeStudent);
		adviceobj.setCodeSubject(codeSubject);
		
		int advice  = dao.createAdvice(adviceobj);
		
		for (Subject item : SessionListener.dataSubject) {
			System.out.println("id "+ item.getId());
			System.out.println("codeSubject "+codeSubject);
			if(item.getId().equals(codeSubject)) {
				if (item.getAvailable()>0) {
					item.setAvailable((item.getAvailable())-1);
				}else {
					request.setAttribute("mensaje", "no se encuentra asesoría disponible para el curso de "+item.getName());
				}
				
			}
		}
		
		request.getRequestDispatcher("listSubject.jsp").forward(request, response);;
		
	}


}
