package menu.menus;

import java.util.Iterator;
import java.util.ArrayList;
import menu.MenuComponente;
import menu.iteradores.IteradorCompuesto;
import menu.menus.burrito.MenuBurrito;
import menu.menus.pizza.MenuPizza;
import menu.menus.hamburguesa.MenuHamburguesa;
import productos.menu.MenuItem;

/**
 * Interfaz para modelar a los menus
 */
public class Menu extends MenuComponente {
	
	protected String nombre;
	
	private static int i = 1;
	
	private ArrayList<MenuComponente> menu;
	
	public Menu(String nombre) {
		this.nombre = nombre;
		this.menu = new ArrayList<MenuComponente>();
	}
	
	/**
	 * Metodo para agregar un <code>MenuItem</code> al menu
	 * @param item <code>MenuComponente</code> a agregar al menu. Si no es un 
	 * algu´n tipo de menu no es agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	@Override
	public boolean agregar(MenuComponente item) {
		if (item instanceof MenuBurrito || item instanceof MenuHamburguesa || 
			item instanceof MenuPizza) {
			return menu.add(item);
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
	 * Metodo para obtener la cantidad de componentes en el menu
	 * @return Un entero
	 */
	@Override
	public int tamanio() {
		int num = 0;
		for(MenuComponente mc: menu) {
			num += mc.tamanio(); 
		}
		return num;
	}
	
	/**
	 * Metodo que obtiene una cadena que representa el menu
	 * @return Una cadena
	 */
	@Override
	public String toString() {		
		String str = obtenerNombre() + "----------------\n";
		for(MenuComponente mc: menu) {
			str += mc.toString(); 
		}
		i = 1;
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
	
	/**
	 * Metodo que obtiene un entero para numera los menus
	 * @return Un entero 
	 */
	protected static int obtenerI(){
		return i++;
	}
}
