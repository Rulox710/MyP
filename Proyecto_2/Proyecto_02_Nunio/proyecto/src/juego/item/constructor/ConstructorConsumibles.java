package juego.item.constructor;

import lectorRecursos.LectorRecursos;
import juego.item.Item;
import juego.item.Consumible;

/**
 * Usa los ID de los objetos para combinarlos. Solo tiene recetas para obtener 
 * consumibles
 */
public class ConstructorConsumibles implements Constructor {
	
	protected int primero = -1, segundo = -1;
	
	/**
	 * Metodo para asignar los objetos a combinar
	 * @param primero Un <code>Item</code>
	 * @param segundo Otro <codeItem</code>
	 */
	public void asignarElementos(Item primero, Item segundo) {
		if(primero instanceof Consumible) this.primero = primero.obtenerId();
		if(segundo instanceof Consumible) this.segundo = segundo.obtenerId();
	}
	
	/**
	 * Metodo para validar que sean objetos combinables
	 * @return Un boleano
	 */
	public boolean sePuedeCombinar() {
		if(primero == -1 || segundo == -1) return false;
		boolean t1 = (primero == 1 || primero == 2);
		boolean t2 = (segundo == 1 || segundo == 2);
		return (t1 && t2);
	}
	
	/**
	 * Metodo para combinar los objetos
	 * @return Un <code>Item</code>, pero <code>null</code> si no se pudo 
	 * obtener un objeto
	 */
	public Item combinar() {
		Item devolver = null;
		switch(primero) {
			case 1:
			switch(segundo) {
				case 1:
				devolver = LectorRecursos.obtenerItems().get(3);
				break;
				case 2:
				devolver = LectorRecursos.obtenerItems().get(2);
				break;
			}
			break;
			case 2:
			switch(segundo) {
				case 1:
				devolver = LectorRecursos.obtenerItems().get(2);
				break;
				case 2:
				devolver = LectorRecursos.obtenerItems().get(4);
				break;
			}
			break;
		}
		return devolver;
	}
}
