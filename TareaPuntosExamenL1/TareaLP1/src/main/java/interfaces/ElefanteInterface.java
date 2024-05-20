package interfaces;

import java.util.List;

import entidades.Elefante;

public interface ElefanteInterface {
	public List<Elefante> listElefante();
	public int createElefante(Elefante elefante);
	public int updateElefante(Elefante elefante);
	public int deleteElefante(String id);
	public Elefante getElefante(String id);	
}
