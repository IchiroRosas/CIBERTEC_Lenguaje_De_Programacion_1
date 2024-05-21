package entidades;

public class Proveedor {
	public String id,ruc,nombre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", ruc=" + ruc + ", nombre=" + nombre + "]";
	}
	
	
}
