package productos;

import productos.menu.MenuItem;

/**
 * Clase que modela un ticket de compra de un producto
 */
public class Ticket {
	
	MenuItem mi;
	
	/**
	 * Contructor de la clase
	 * @param mi Un item 
	 */
	public Ticket(MenuItem mi) {
		this.mi = mi;
	}
	
	/**
	 * Hace el <code>Tiket</code> en una cadena
	 * @param Una cadena
	 */
	@Override
	public String toString() {
		String str = "-\t-\t-\t-\t-\t-\n" +
					 "| Nombre: " + mi.obtenerNombre() + "\n" + 
					 "| " + mi.obtenerDescripcion() + "\n| ";
		str+=(mi.obtenerEsVegetariano())? "Es vegetariano":" No es Vegetariano";
		str += "\n| Costo: $" + mi.obtenerCosto();
		return str + "\n-\t-\t-\t-\t-\t-\n"; 
	}
}
