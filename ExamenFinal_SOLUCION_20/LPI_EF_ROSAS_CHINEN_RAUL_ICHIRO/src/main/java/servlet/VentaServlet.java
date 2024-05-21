package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Libro;
import entidades.Venta;
import interfaces.VentaInterface;
import listeners.ListenerRosas;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentaServlet")
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		switch (type) {
		case "list": break;
		case "register":registerVenta(request,response); break;
		case "delete": break;
		case "edit": break;
		case "info": break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("registroRosas.jsp").forward(request, response);
		
	}

}

	private void registerVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idProveedor =request.getParameter("cboProveedor");
		String idLibro =request.getParameter("cboLibro");
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		VentaInterface dao = daoFactory.getVenta();
		Venta ventaNueva = new Venta();
		ventaNueva.setIdProveedor(idProveedor);
		ventaNueva.setIdLibro(idLibro);
		
		for (Libro item : ListenerRosas.dataLibro) {
			System.out.println("idLibroAvender: " + item.getId());
			if(item.getId().equals(idLibro)) {
				if (item.getStock()>0) {
					int value  = dao.createVenta(ventaNueva);
					item.setStock((item.getStock())-1);
					request.setAttribute("mensajeBueno", "Venta registrada con éxito. LIBRO: " + item.getNombreLibro());
				}else {
					request.setAttribute("mensajeMalo", "No hay stock del libro "+item.getNombreLibro());
				}
				
			}
		}
		
		request.getRequestDispatcher("registroRosas.jsp").forward(request, response);
		
	}
}
