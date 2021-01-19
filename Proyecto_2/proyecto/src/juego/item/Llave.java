package juego.item;

public class Llave extends Item {
	
	private String clave;
	
	public Llave(int id, String nombre, String descripcion) {
		super(id,nombre,descripcion);
	}
	
	public void asignarClave(String clave) {
		this.clave = clave;
	}
	
	public String obtenerClave(){
		return clave;
	}
	
	@Override
	public boolean validarItemCadena(String cadena) {
		if(!super.validarItemCadena(cadena)) {
			return cadena.equalsIgnoreCase("llave");
		}
		return true;
	}
}
