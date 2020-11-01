package menu.burrito;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Collection;
import menu.Menu;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.burrito.Burrito;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuBurrito implements Menu {
	
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
	@Override
	public boolean agregar(MenuItem bu) {
		if (bu instanceof AdaptadorMenuItem || bu instanceof Burrito) {
			menu.put(claveActual++, bu);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve la cantidad de elementos en el <code>Menu</code>
	 * @return Un numero entero
	 */
	@Override
	public int obtenerElementos() {
		return menu.size();
	}
	
	/**
	 * Metodo para obtener un iterador del menu
	 * @return <code>Iterator</code> del menu
	 */
	@Override
	public Iterator<MenuItem> obtenerIterador() {
		return menu.values().iterator();
	}
}
