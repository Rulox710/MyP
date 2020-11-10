package menu;

import java.util.Iterator;
import java.lang.UnsupportedOperationException;

/**
 * Clase para hacer Composite con los menus y los items en ellos
 */
public abstract class MenuComponente {
	
	/**
	 * Agrega un componente al menu. Devuelve <code>true</code> si fue agregado,
	 * <code>false</code> si no
	 * @param mc Un <code>MenuComponente</code>
	 * @return Un boleano
	 */
	public boolean agregar(MenuComponente mc) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Metodo para obtener el nombre de los componentes
	 * @return Una cadena
	 */
	public String obtenerNombre() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo para obtener la descripcion del componente
	 * @return Una cadena
	 */
	public String obtenerDescripcion() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Metodo para obtener si el componente es vegetariano
	 * @return Un boleano
	 */
	public boolean obtenerEsVegetariano() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Metodo para obtener el costo del componente
	 * @return un numero <code>double</code>
	 */
	public double obtenerCosto() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Metodo para obtener el el numero de elementos en el componente
	 * @return Un entero
	 */
	public int tamanio() {
		return 1;
	}

	/**
	 * Metodo que devuelve el componente como una cadena
	 * @return Una cadena
	 */
	public String toString() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo que devuelve el iterador del componente
	 * @return Un iterador
	 */
	public Iterator<MenuComponente> obtenerIterador() {
		throw new UnsupportedOperationException();
	}
}
