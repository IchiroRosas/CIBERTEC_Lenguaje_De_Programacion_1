package interfaz;

import java.util.List;

import entidades.Users;
import entidades.Workers;

public interface WorkerInterface {
	
	public List<Workers> listadoObjeto();
	public int crearObjeto(Workers worker);
	public int eliminarObjeto(String id);
	public int editarObejto(Workers worker);
	public Workers infoObjeto(String id);
	public List<Workers> listadoObjetoFiltrado(String tipoCargo);
}
