package menu.pizza;

import java.util.Arrays;
import java.util.Iterator;
import menu.Menu;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.pizza.Pizza;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuPizza implements Menu{
	
	/**
	 * Arreglo de <code>ItemMenu</code>
	 */
	private MenuItem[] menu;
	
	/**
	 * Ubicacion actual del ultimo elemento 
	 */
	private int posicion;
	
	/**
	 * Contructor que crea un menu de pizza
	 */
	public MenuPizza() {
		menu = new MenuItem[1];
		posicion = 0;
	}
	
	/**
	 * Metodo para agregar una <code>Pizza</code> al menu
	 * @param pi <code>ItemMenu</code> a agregar al menu. Si no es una 
	 * <code>Pizza</code> o un <code>AdaptadorItemMenu</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	public boolean agregar(MenuItem pi) {
		if (pi instanceof AdaptadorMenuItem || pi instanceof Pizza) {
			if(posicion == menu.length) {
				MenuItem[] nuevo = new MenuItem[menu.length+1];
				System.arraycopy(menu,0,nuevo,0,menu.length);
				menu = nuevo;
			}
			menu[posicion] = pi;
			posicion++;
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
		return menu.length;
	}
	
	/**
	 * Metodo para obtener un iterador del menu
	 * @return <code>Iterator</code> del menu
	 */
	@Override
	public Iterator<MenuItem> obtenerIterador() {
		return Arrays.asList(menu).iterator();
	}
}
