package menu;

import java.util.Iterator;
import java.lang.UnsupportedOperationException;

/**
 * Clase para hacer Composite con los menus y los items en ellos
 */
public abstract class MenuComponente {
	
	/**
	 * Agrega un componente al menu
	 */
	public boolean agregar(MenuComponente mc) {
		throw new UnsupportedOperationException();
	}

	public String obtenerNombre() {
		throw new UnsupportedOperationException();
	}

	public String obtenerDescripcion() {
		throw new UnsupportedOperationException();
	}

	public boolean obtenerEsVegetariano() {
		throw new UnsupportedOperationException();
	}

	public double obtenerCosto() {
		throw new UnsupportedOperationException();
	}
	
	public int tamanio() {
		return 1;
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}

	public Iterator<MenuComponente> obtenerIterador() {
		throw new UnsupportedOperationException();
	}
}
