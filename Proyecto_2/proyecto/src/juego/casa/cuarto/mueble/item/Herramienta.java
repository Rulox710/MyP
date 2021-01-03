package juego.casa.cuarto.mueble.item;

public class Herramienta extends Item {
	
	private int danio;
	
	public Herramienta(int id, String nombre, String descripcion) {
		super(id,nombre,descripcion);
	}

	public void asignarDanio(int danio) {
		this.danio = danio;
	}
	
	public int obtenerDanio(){
		return danio;
	}
}
