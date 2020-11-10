package menu.menus.pizza;

import java.util.Arrays;
import java.util.Iterator;
import menu.iteradores.IteradorCompuesto;
import menu.MenuComponente;
import menu.menus.Menu;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.menu.pizza.Pizza;

/**
 * Clase que modela el menu de los burritos
 */
public class MenuPizza extends Menu {
	
	/**
	 * Arreglo de <code>ItemMenu</code>
	 */
	private MenuComponente[] menu;
	
	/**
	 * Ubicacion actual del ultimo elemento 
	 */
	private int posicion;
	
	/**
	 * Contructor que crea un menu de pizza
	 * @param str Una cadena cualquera, pero no afecta el nombre
	 */
	public MenuPizza(String str) {
		super(str);
		this.nombre = "Menu Pizza";
		menu = new MenuComponente[1];
		posicion = 0;
	}
	
	/**
	 * Metodo para agregar una <code>Pizza</code> al menu
	 * @param pi <code>MenuComponente</code> a agregar al menu. Si no es una 
	 * <code>Pizza</code> o un <code>AdaptadorItemMenu</code>, no es 
	 * agregado
	 * @return <code>true</code> si es agregado, <code>false</code> si no
	 */
	@Override
	public boolean agregar(MenuComponente pi) {
		if (pi instanceof AdaptadorMenuItem || pi instanceof Pizza) {
			if(posicion == menu.length) {
				MenuComponente[] nuevo = new MenuComponente[menu.length+1];
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
	 * Obtiene la cantidad de elementos en el menu
	 * @return Un entero
	 */
	@Override
	public int tamanio() {
		return posicion + 1;
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
		return new IteradorCompuesto(Arrays.asList(menu).iterator());
	}
}
