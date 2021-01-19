package juego.item;

public class Nota extends Item {
	
	private String lectura;
	
	public Nota(int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
	}
	
	public void asignarLectura(String lectura) {
		this.lectura = lectura;
	}
	
	public String obtenerLectura(){
		return lectura;
	}
	
	@Override
	public boolean validarItemCadena(String cadena) {
		if(!super.validarItemCadena(cadena)) {
			return cadena.equalsIgnoreCase("nota");
		}
		return true;
	}
}
