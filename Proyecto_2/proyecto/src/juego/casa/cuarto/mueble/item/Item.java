package juego.casa.cuarto.mueble.item;

public abstract class Item {
	
	private String nombre, descripcion;
	private boolean tomado = false;
	private int id;
	
	/**
	 * Constructor de a clase
	 * @param nombre El nombre de este
	 * @param descripcion La descripcion de este
	 */
	public Item(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * Metodo para obtener el nombre
	 * @return Una cadena que represente el nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para obtener la descripcion
	 * @return Una cadena que representa la descripcion
	 */
	public String obtenerDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo para determinar si un <code>Item</code> es igual a un Objeto
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			return (((Item)obj).id == this.id);
		}
		return false;
	}
}
