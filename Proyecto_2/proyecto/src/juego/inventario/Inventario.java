package juego.inventario;

import java.util.ArrayList;
import java.util.Iterator;

import juego.casa.cuarto.mueble.item.Item;

public class Inventario<E extends Item> {
	
	private ArrayList<E> inventario;
	private int limite;
	
	public Inventario(int limite) {
		inventario = new ArrayList<>(limite);
		this.limite = limite;
	}
	
	public boolean agregar(E item) {
		if(inventario.size() < limite && item != null) {
			inventario.add(item);
			return true;
		}
		return false;
	}
	
	public E retirar(int indice) {
		if(indice > -1 && inventario.size() > indice) {
			return inventario.remove(indice);
		}
		return null;
	}
	
	public int indicePorCadena(String cadena) {
		Iterator<E> it = inventario.iterator();
		Item item = null;
		while(it.hasNext()) {
			E ejemplar = it.next();
			if(ejemplar.validarItemCadena(cadena)) {
				item = ejemplar;
				break;
			}
		}
		return inventario.indexOf(item);
	}
	
	public Iterator<E> obtenerIterador() {
		return inventario.iterator();
	}
}
