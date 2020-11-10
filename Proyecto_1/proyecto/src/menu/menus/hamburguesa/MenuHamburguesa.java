package menu.menus.hamburguesa;

import java.util.ArrayList;
import java.util.Iterator;
import menu.iteradores.IteradorCompuesto;
import menu.MenuComponente;
import menu.menus.Menu;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.hamburguesa.Hamburguesa;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuHamburguesa extends Menu {
	
	/**
	 * <code>List</code> de <code>MenuItem</code>
	 */
	private ArrayList<MenuComponente> menu;

	/**
	 * Contructor que crea un menu de hamburguesas
	 * @param str Una cadena cualquera, pero no afecta el nombre
	 */
	public MenuHamburguesa(String str) {
		super(str);
		this.nombre = "Menu Hamburguesa";
		menu = new ArrayList<MenuComponente>();
	}
	
	/**
	 * Metodo para agregar una <code>Hamburguesa</code> al menu
	 * @param mi <code>ItemMenu</code> a agregar al menu. Si no es una 
	 * <code>Hamburguesa</code> o un <code>AdaptadorItemMenu</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	public boolean agregar(MenuComponente mi) {
		if (mi instanceof AdaptadorMenuItem || mi instanceof Hamburguesa)
			return menu.add(mi);
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
	 * Metodo que obtiene la cantidad de elementos en el menu
	 * @return Un entero 
	 */
	@Override
	public int tamanio() {
		return menu.size();
	}
	
	/**
	 * Metodo que obtiene una cadena que representa el menu
	 * @return Una cadena
	 */
	@Override
	public String toString() {
		String str = obtenerNombre() + "\n--------------------\n";
		
		for(MenuComponente mc: menu) {
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
		return new IteradorCompuesto(menu.iterator());
	}
	
}
