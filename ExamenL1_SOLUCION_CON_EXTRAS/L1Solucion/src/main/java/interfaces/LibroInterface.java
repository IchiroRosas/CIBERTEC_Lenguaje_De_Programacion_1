package interfaces;

import java.util.List;

import entidades.Libro;

public interface LibroInterface {
	public List<Libro> listLibro();
	public int createLibro(Libro libro);
	public int updateLibro(Libro libro);
	public int deleteLibro(String id);
	public Libro getLibro(String id);
	
}
