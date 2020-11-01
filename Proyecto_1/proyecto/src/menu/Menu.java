package menu;

import java.util.Iterator;
import productos.menu.MenuItem;

/**
 * Interfaz para modelar a los menus
 */
public interface Menu {
	
	/**
	 * Metodo para agregar un <code>MenuItem</code> al menu
	 * @param bu <code>MenuItem</code> a agregar al menu. Si no es un 
	 * <code>Burrito</code> o un <code>AdaptadorMenuItem</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	public abstract boolean agregar(MenuItem bu);
	
	/**
	 * Metodo que devuelve la cantidad de elementos en el <code>Menu</code>
	 * @return Un entero
	 */
	public abstract int obtenerElementos();
	
	/**
	 * Metodo para obtener un iterador del menu
	 * @return <code>Iterator</code> del menu
	 */
	public abstract Iterator<MenuItem> obtenerIterador();
}
