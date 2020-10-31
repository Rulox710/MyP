package productos.menu;

public interface MenuItem {
	
	/**
	 * Metodo que obtiene <code>nombre</code>
	 * @return Una cadena
	 */
	public abstract String obtenerNombre();
	
	/**
	 * Metodo que obtiene <code>descripcion</code>
	 * @return Una cadena
	 */
	public abstract String obtenerDescripcion();
	
	/**
	 * Metodo que obtiene <code>esVegetariano</code>
	 * @return Un boleano
	 */
	public abstract boolean obtenerEsVegetariano();
	
	/**
	 * Obtiene el costo del platillo
	 * @return Un <code>double</code>
	 */
	public abstract double obtenerCosto();
}
