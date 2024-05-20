package interfaces;

import java.util.List;

import entidades.Estudiante;
import entidades.TipoDocumento;

public interface EstudianteInterface {
	public List<TipoDocumento> listTipoDocumentos();
	public List<Estudiante> listEstudiantes();
}
