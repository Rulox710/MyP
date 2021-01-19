package juego.item.constructor;

import lectorRecursos.LectorRecursos;
import juego.item.Item;
import juego.item.Llave;

/**
 * Usa los ID de los objetos para combinarlos. Solo tiene recetas para obtener 
 * llaves
 */
public class ConstructorLlaves implements Constructor {
	
	protected int primero = -1, segundo = -1;
	
	/**
	 * Metodo para asignar los objetos a combinar
	 * @param primero Un <code>Item</code>
	 * @param segundo Otro <codeItem</code>
	 */
	public void asignarElementos(Item primero, Item segundo) {
		if(primero instanceof Llave) this.primero = primero.obtenerId();
		if(segundo instanceof Llave) this.segundo = segundo.obtenerId();
	}
	
	/**
	 * Metodo para validar que sean objetos combinables
	 * @return Un boleano
	 */
	public boolean sePuedeCombinar() {
		if(primero == -1 || segundo == -1) return false;
		boolean t1 = (primero == 8 || primero == 10 || primero == 11);
		boolean t2 = (segundo == 8 || segundo == 10 || segundo == 11);
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
			case 8:
			if(segundo == 8) devolver = LectorRecursos.obtenerItems().get(8);
			break;
			case 10:
			switch(segundo) {
				case 10: devolver = LectorRecursos.obtenerItems().get(10);
				break;
				case 11: devolver = LectorRecursos.obtenerItems().get(12);
				break;
			}
			break;
			case 11:
			if(segundo == 10) devolver = LectorRecursos.obtenerItems().get(12);
			break;
		}
		return devolver;
	}
}
