package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Elefante;
import modelos.ElefanteModel;

/**
 * Servlet implementation class ElefanteServlet
 */
@WebServlet("/ElefanteServlet")
public class ElefanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		switch(type) {
		case "register": registerElefante(request,response); break;
		case "list": listElefante(request,response); break;
		case "edit": editElefante(request,response); break;
		case "delete": deleteElefante(request,response); break;
		case "info": infoElefante(request,response); break;
		default:
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaElefante.jsp").forward(request, response);
		
	}

}

	private void infoElefante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		ElefanteModel elefanteModel = new ElefanteModel();
		Elefante elefante = elefanteModel.getElefante(id);
		request.setAttribute("data", elefante);
		request.getRequestDispatcher("infoElefante.jsp").forward(request, response);
	}

	private void deleteElefante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("Se tiene idElefante: " + id);
		ElefanteModel elefanteModel = new ElefanteModel();
		int value = elefanteModel.deleteElefante(id);
		if(value==0) {
			System.out.println("Se ejecutó delete en Servlet");
			listElefante(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaElefante.jsp").forward(request, response);
		}
	}

	private void editElefante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idElefante = request.getParameter("idElefante");
		String nombre = request.getParameter("txtNombre");
		String origen = request.getParameter("txtOrigen");
		String patas = request.getParameter("txtPatas");
		String orejas = request.getParameter("txtOrejas");
		String trompa = request.getParameter("txtTrompa");
		String peso = request.getParameter("txtPeso");
		String fechaNacimiento = request.getParameter("txtFechaNacimiento");
		
		Elefante elefante = new Elefante();
		elefante.setIdElefante(idElefante);
		elefante.setNombre(nombre);
		elefante.setOrigen(origen);
		elefante.setPatas(patas);
		elefante.setOrejas(orejas);
		elefante.setTrompa(trompa);
		elefante.setPeso(peso);
		elefante.setFechaNacimiento(fechaNacimiento);
		
		ElefanteModel elefanteModel = new ElefanteModel();
		int value = elefanteModel.updateElefante(elefante);
		
		if(value==0) {
			System.out.println("Se ejecuto edicion Servlet");
			listElefante(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un error");
			request.getRequestDispatcher("listaElefante.jsp").forward(request, response);
		}
	}

	private void listElefante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ElefanteModel elefanteModel = new ElefanteModel();
		List<Elefante> data = elefanteModel.listElefante();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaElefante.jsp").forward(request, response);
	}

	private void registerElefante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("txtNombre");
		String origen = request.getParameter("txtOrigen");
		String patas = request.getParameter("txtPatas");
		String orejas = request.getParameter("txtOrejas");
		String trompa = request.getParameter("txtTrompa");
		String peso = request.getParameter("txtPeso");
		String fechaNacimiento = request.getParameter("txtFechaNacimiento");
		
		Elefante elefante = new Elefante();
		elefante.setNombre(nombre);
		elefante.setOrigen(origen);
		elefante.setPatas(patas);
		elefante.setOrejas(orejas);
		elefante.setTrompa(trompa);
		elefante.setPeso(peso);
		elefante.setFechaNacimiento(fechaNacimiento);
		
		ElefanteModel elefanteModel = new ElefanteModel();
		int value = elefanteModel.createElefante(elefante);
		
		if(value==0) {
			System.out.println("Se ejecutó registro Servlet");
			listElefante(request, response);
		} else {
			System.out.println("ERROR de registro");
			request.getRequestDispatcher("listaElefante.jsp").forward(request, response);
		}
	}
}
