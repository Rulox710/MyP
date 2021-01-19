package juego.item;

public class Herramienta extends Item {
	
	private int danio;
	private int usos;
	
	public Herramienta(int id, String nombre, String descripcion) {
		super(id,nombre,descripcion);
	}

	public void asignarDanio(int danio) {
		this.danio = danio;
	}
	
	public int obtenerDanio(){
		return danio;
	}
	
	@Override
	public boolean validarItemCadenaExacto(String obj) {
		return validarItemCadena(obj);
	}
	
	@Override
	public boolean validarItemCadena(String cadena) {
		if(!super.validarItemCadena(cadena)) {
			return cadena.equalsIgnoreCase("herramienta");
		}
		return true;
	}
}
