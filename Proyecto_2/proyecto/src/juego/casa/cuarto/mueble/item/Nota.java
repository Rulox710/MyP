package juego.casa.cuarto.mueble.item;

public class Nota extends Item {
	
	public Nota(int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
	}
	
	@Override
	public boolean validarItemCadena(String cadena) {
		if(!super.validarItemCadena(cadena)) {
			return ((String)cadena).equalsIgnoreCase("nota");
		}
		return true;
	}
}
