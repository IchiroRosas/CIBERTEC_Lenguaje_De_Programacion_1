package interfaces;

import java.util.List;

import entidades.Mascota;

public interface MascotaInterface {
	public int createMascota(Mascota mascota);
	public List<Mascota> listMascota();
	public int updateMascota(Mascota mascota);
	public Mascota getMascota(String id);
	public int deleteMascota(String id);
}
