package interfaz;

import entidades.Users;

public interface AdminAuthInterface {
	
	public Users InicioSesion(String correo, String contraseña);

}
