package menu.menus.burrito;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import menu.MenuComponente;
import menu.menus.Menu;
import menu.iteradores.IteradorCompuesto;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.burrito.Burrito;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuBurrito extends Menu {
	
	/**
	 * <code>Hashtable</code> de <code>MenuItem</code>
	 */
	private Hashtable<Integer, MenuComponente> menu;
	
	/**
	 * Llave para introducir y recuperar <code>MenuItem</code> del 
	 * <code>menu</code>
	 */
	private int claveActual; 
	 
	/**
	 * Contructor que crea un menu de burritos
	 * @param str Una cadena cualquera, pero no afecta el nombre
	 */
	public MenuBurrito(String str) {
		super(str);
		this.nombre = "Menu Burrito";
		menu = new Hashtable<Integer, MenuComponente>();
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
	public boolean agregar(MenuComponente bu) {
		if (bu instanceof AdaptadorMenuItem || bu instanceof Burrito) {
			menu.put(claveActual++, bu);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para obtener el nombre del menu
	 * @return String
	 */
	@Override
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para obtener la cantidad de elementos en el menu
	 * @return Un entero
	 */
	@Override
	public int tamanio() {
		return claveActual-123;
	}
	
	/**
	 * Metodo que obtiene una cadena que representa el menu
	 * @return Una cadena
	 */
	@Override
	public String toString() {
		String str = obtenerNombre() + "\n--------------------\n";
		
		for(MenuComponente mc: menu.values()) {
			str += "(" + obtenerI() +") " + mc.toString() + "\n";
		}
		return str;
	}
	
	/**
	 * Metodo para obtener un iterador del menu
	 * @return <code>Iterator</code> del menu
	 */
	@Override
	public Iterator<MenuComponente> obtenerIterador() {
		return new IteradorCompuesto(menu.values().iterator());
	}
}
