package menu.hamburguesa;

import java.util.ArrayList;
import java.util.Iterator;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.hamburguesa.Hamburguesa;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuHamburguesa {
	
	/**
	 * <code>List</code> de <code>MenuItem</code>
	 */
	private ArrayList<MenuItem> menu;
	
	/**
	 * Contructor que crea un menu de hamburguesas
	 */
	public MenuHamburguesa() {
		menu = new ArrayList<MenuItem>();
	}
	
	/**
	 * Metodo para agregar una <code>Hamburguesa</code> al menu
	 * @param mi <code>ItemMenu</code> a agregar al menu. Si no es una 
	 * <code>Hamburguesa</code> o un <code>AdaptadorItemMenu</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	public boolean agregarHamburguesa(MenuItem mi) {
		if (mi instanceof AdaptadorMenuItem || mi instanceof Hamburguesa)
			return menu.add(mi);
		return false;
	}
	
	/**
	 * Metodo para obtener la lista del menu
	 * @return <code>List</code> con las hamburguesas
	 */
	public ArrayList<MenuItem> obtenerMenu() {
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
		return menu.iterator();
	}
	
}
