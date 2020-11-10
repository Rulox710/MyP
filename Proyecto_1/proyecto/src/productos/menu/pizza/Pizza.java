package productos.menu.pizza;

import productos.menu.MenuItem;

public class Pizza extends MenuItem {
	
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
		super(nombre, descripcion, esVegetariano, costo);
	}
}
