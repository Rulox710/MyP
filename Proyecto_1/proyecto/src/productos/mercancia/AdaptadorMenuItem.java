package productos.mercancia;

import productos.menu.MenuItem;

/**
 * Clase que adapta a <code>Mercancia</code> para que pueda ser usada como 
 * <code>MenuItem</code>
 */
public class AdaptadorMenuItem extends MenuItem {
	
	/**
	 * Constructor de la clase
	 * @param mercancia Un objeto <code>Mercancia</code> que se adaptara
	 */
	public AdaptadorMenuItem(Mercancia mercancia) {
		super(mercancia);
	}
	
	/**
	 * Metodo para obtener una cadena de la clase
	 * @return Una cadena
	 */
	@Override
	public String toString() {
		String str = obtenerNombre() + ": " + obtenerDescripcion() + " de cos" +
			"to " + obtenerCosto() + ". ";
		return str;
	}
}
