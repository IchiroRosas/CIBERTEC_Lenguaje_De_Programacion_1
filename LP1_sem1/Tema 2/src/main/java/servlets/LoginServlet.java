package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "ingreso", urlPatterns = { "/ingreso" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Con este método redirije al jsp ejemplo 01 y se visualiza la uri /ingreso*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("ejemplo 01.jsp");
		
		
		/*Este código redirije al jsp ejemplo 02 y se visualiza la uri /ingreso */
		//RequestDispatcher dispatcher = request.getRequestDispatcher("ejemplo 02.jsp");
		dispatcher.forward(request, response);
	}
}
