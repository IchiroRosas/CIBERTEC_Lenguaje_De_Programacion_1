package interfaces;

import entidades.Usuario;

public interface UsuarioAuthInterface {
	public Usuario iniciarSesion(String correo, String clave);
}
