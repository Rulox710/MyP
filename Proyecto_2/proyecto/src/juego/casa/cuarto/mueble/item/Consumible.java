package juego.casa.cuarto.mueble.item;

public class Consumible extends Item {

	private int cura;
	
	public Consumible(int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
	}
	
	public void asignarCura(int cura) {
		this.cura = cura;
	}
	
	public int obtenerCura(){
		return cura;
	}
}
