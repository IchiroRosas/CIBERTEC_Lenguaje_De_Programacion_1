package listeners;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.DAOFactory;
import entidades.Libro;
import entidades.Proveedor;
import interfaces.LibroInterface;
import interfaces.ProveedorInterface;

/**
 * Application Lifecycle Listener implementation class ListenerRosas
 *
 */
@WebListener
public class ListenerRosas implements HttpSessionListener {
	public static List<Libro> dataLibro;
    /**
     * Default constructor. 
     */
    public ListenerRosas() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("hola mundo");
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	
		ProveedorInterface dao1 = daoFactory.getProveedor();
		LibroInterface dao2 = daoFactory.getLibro();
		
		List<Proveedor> dataProveedor = dao1.listProveedores();
		dataLibro = dao2.listLibros();
		
		System.out.println(dataLibro);
		System.out.println(dataProveedor);
		se.getSession().setAttribute("listProveedor", dataProveedor);
		se.getSession().setAttribute("listLibro", dataLibro);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
      	se.getSession().invalidate();
    }
	
}
