package menu.burrito;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Collection;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.burrito.Burrito;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuBurrito {
	
	/**
	 * <code>Hashtable</code> de <code>MenuItem</code>
	 */
	private Hashtable<Integer, MenuItem> menu;
	
	/**
	 * Llave para introducir y recuperar <code>MenuItem</code> del 
	 * <code>menu</code>
	 */
	private int claveActual; 
	 
	/**
	 * Contructor que crea un menu de burritos
	 */
	public MenuBurrito() {
		menu = new Hashtable<Integer, MenuItem>();
		claveActual = 123;
	}
	
	/**
	 * Metodo para agregar un <code>Burrito</code> al menu
	 * @param bu <code>ItemMenu</code> a agregar al menu. Si no es un 
	 * <code>Burrito</code> o un <code>AdaptadorItemMenu</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	public boolean agregarBurrito(MenuItem bu) {
		if (bu instanceof AdaptadorMenuItem || bu instanceof Burrito) {
			menu.put(claveActual++, bu);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para obtener la tabla hash del menu
	 * @return <code>Hashtable</code> con los burritos
	 */
	public Hashtable<Integer, MenuItem> obtenerMenu() {
		return menu;
	}
	
	public int obtenerElementos() {
		return menu.size();
	}
	
	/**
	 * Metodo para obtener un iterador del menu
	 * @return <code>Iterator</code> del menu
	 */
	public Iterator obtenerIterador() {
		return menu.values().iterator();
	}
}
