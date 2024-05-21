package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Libro;
import modelos.LibroModel;

/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		switch(type) {
		case "register": registerLibro(request,response); break;
		case "list": listLibro(request,response); break;
		case "edit": editLibro(request,response); break;
		case "delete": deleteLibro(request,response); break;
		case "info": infoLibro(request,response); break;
		default:
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaRosas.jsp").forward(request, response);
		}
	}

	private void infoLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		LibroModel libroModel = new LibroModel();
		Libro libro = libroModel.getLibro(id);
		request.setAttribute("data", libro);
		request.getRequestDispatcher("infoRosas.jsp").forward(request, response);
	}

	private void deleteLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("Se tiene idLibro: " + id);
		LibroModel libroModel = new LibroModel();
		int value = libroModel.deleteLibro(id);
		if(value==0) {
			System.out.println("Se ejecutó delete en Servlet");
			listLibro(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaRosas.jsp").forward(request, response);
		}
	}

	private void editLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idLibro = request.getParameter("idLibro");
		String codigo = request.getParameter("txtCodigo");
		String nombreLibro = request.getParameter("txtNombreLibro");
		String edicion = request.getParameter("txtEdicion");
		String tipo = request.getParameter("txtTipo");
		String precio = request.getParameter("txtPrecio");
		String stock = request.getParameter("txtStock");
		String fechaCompra = request.getParameter("txtFechaCompra");
		
		System.out.println("codigo: " + idLibro);
		System.out.println("codigo: " + codigo);
		System.out.println("nombreLibro: " + nombreLibro);
		System.out.println("edicion: " + edicion);
		System.out.println("tipo: " + tipo);
		System.out.println("precio: " + precio);
		System.out.println("stock: " + stock);
		System.out.println("fechaCompra: " + fechaCompra);
		
		Libro libro = new Libro();
		libro.setIdLibro(idLibro);
		libro.setCodigo(codigo);
		libro.setNombreLibro(nombreLibro);
		libro.setEdicion(edicion);
		libro.setTipo(tipo);
		libro.setPrecio(precio);
		libro.setStock(stock);
		libro.setFechaCompra(fechaCompra);
		
		LibroModel libroModel = new LibroModel();
		int value = libroModel.updateLibro(libro);
		
		if(value==0) {
			System.out.println("Se ejecuto edicion Servlet");
			listLibro(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaRosas.jsp").forward(request, response);
		}
	}

	private void listLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibroModel libroModel = new LibroModel();
		List<Libro> data = libroModel.listLibro();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaRosas.jsp").forward(request, response);
	}

	private void registerLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		String nombreLibro = request.getParameter("txtNombreLibro");
		String edicion = request.getParameter("txtEdicion");
		String tipo = request.getParameter("txtTipo");
		String precio = request.getParameter("txtPrecio");
		String stock = request.getParameter("txtStock");
		String fechaCompra = request.getParameter("txtFechaCompra");
		
		Libro libro = new Libro();
		libro.setCodigo(codigo);
		libro.setNombreLibro(nombreLibro);
		libro.setEdicion(edicion);
		libro.setTipo(tipo);
		libro.setPrecio(precio);
		libro.setStock(stock);
		libro.setFechaCompra(fechaCompra);
		
		LibroModel libroModel = new LibroModel();
		int value = libroModel.createLibro(libro);
		
		if(value==0) {
			System.out.println("Se ejecutó registro Servlet");
			listLibro(request, response);
		} else {
			System.out.println("ERROR de registro");
			request.getRequestDispatcher("listaRosas.jsp").forward(request, response);
		}
	}

}
