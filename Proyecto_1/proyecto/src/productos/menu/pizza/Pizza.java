package productos.menu.pizza;

import productos.menu.MenuItem;

public class Pizza implements MenuItem {
	
	/**
	 * Cadenas que represantan el nombre y la descripcion del objeto
	 */
	protected String nombre, descripcion;
	
	/**
	 * Booleano que representa si es patillo vegetarino o no
	 */
	protected boolean esVegetariano;
	
	/**
	 * Valor <code>double</code> que representa el costo del platillo
	 */
	protected double costo;
	
	/**
	 * Constructor de la clase
	 * @param nombre Cadena con el nombre del platillo
 	 * @param descripcion Cadena con la descripcion del platillo
	 * @param esVegetariano Boleano que indica si es vegetariono o no
	 * @param costo El costo del platillo
	 */
	public Pizza(String nombre, String descripcion, boolean esVegetariano, 
		double costo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.esVegetariano = esVegetariano;
		this.costo = costo;
	}
	
	/**
	 * Metodo que obtiene <code>nombre</code>
	 * @return Una cadena
	 */
	@Override
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que obtiene <code>descripcion</code>
	 * @return Una cadena
	 */
	@Override
	public String obtenerDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo que obtiene <code>esVegetariano</code>
	 * @return Un boleano
	 */
	@Override
	public boolean obtenerEsVegetariano() {
		return esVegetariano;
	}
	
	/**
	 * Obtiene el costo del platillo
	 * @return Un <code>double</code>
	 */
	@Override
	public double obtenerCosto() {
		return costo;
	}
}
