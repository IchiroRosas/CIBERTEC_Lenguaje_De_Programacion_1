package interfaz;

import java.util.List;

import entidades.Candidato;

public interface CandidatosInterface {
	
	public List<Candidato> ListadoObjeto();
	public int crearObjeto(Candidato candidato);
	public int eliminarObjeto(String id);
	public int editarObjeto(Candidato candidato);
	public Candidato infoObjeto(String id);
	public List<Candidato> listadoObjetoFiltrado(String carrera);

}
