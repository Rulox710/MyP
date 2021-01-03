package juego.casa.cuarto.mueble.item;

public abstract class Item {
	
	protected String nombre, descripcion;
	protected int id;
	
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
		} else if(obj instanceof String) {
			return ((String)obj).equals(this.nombre);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
