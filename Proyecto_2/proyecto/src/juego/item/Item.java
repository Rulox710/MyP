package juego.item;

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
	 * Metodo para validar identificar un item como una cadena
	 * @param obj Una cadena cualquiera
	 * @return <code>true</code> si se identifica, <code>false</code> si no 
	 */
	public boolean validarItemCadena(String obj) {
		return (obj.equalsIgnoreCase(nombre) || obj.equalsIgnoreCase("objeto") 
			|| obj.equalsIgnoreCase(nombre.split(" ")[0]));
	}
	
	/**
	 * Metodo para validar identificar un item como una cadena. Esta debe ser 
	 * exactamente igual a su nombre
	 * @param obj Una cadena cualquiera
	 * @return <code>true</code> si se identifica, <code>false</code> si no 
	 */
	public boolean validarItemCadenaExacto(String obj) {
		return obj.equalsIgnoreCase(nombre);
	}
	
	/**
	 * Metodo para obtener el id del item
	 * @return un numero entero
	 */
	public int obtenerId() {
		return id;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
