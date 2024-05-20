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
import com.google.gson.JsonObject;

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
		
		JsonObject data = new Gson().fromJson(request.getReader(),JsonObject.class);
		String type = data.get("type").getAsString();
		
		if(type.equals("list")) {
			DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			SubjectInterface subject = daoFactory.getSubject();
			List<Subject> listSubjects = subject.listSubject();
			
			Gson gson = new Gson();
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(listSubjects));
			out.flush();
		}else if (type.equals("register")){
			String code = data.get("code").getAsString();
			String name = data.get("name").getAsString();
			String level = data.get("level").getAsString();
			String teacher = data.get("teacher").getAsString();
			
			Subject subject = new Subject();
			subject.setCode(code);
			subject.setName(name);
			subject.setLevel(level);
			subject.setTeacher(teacher);
			
			DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			SubjectInterface dao = daoFactory.getSubject();
			
			int value = dao.createSubject(subject);
			
			String mensaje="";
			
			if (value == 1) {
				mensaje = "Registro correcto";
			} else {
				mensaje = "Registro incorrecto";
			}
			
			PrintWriter out = response.getWriter();
			out.print(mensaje);
			out.flush();
			out.close();
		}
	}

}
