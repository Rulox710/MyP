package juego.inventario;

import java.util.ArrayList;
import java.util.Iterator;

import juego.casa.cuarto.mueble.item.Item;

public class Inventario {
	
	private ArrayList<Item> inventario;
	private int limite;
	
	public Inventario(int limite) {
		inventario = new ArrayList<>(limite);
		this.limite = limite;
	}
	
	public boolean agregar(Item item) {
		if(inventario.size() < limite) {
			inventario.add(item);
			return true;
		}
		return false;
	}
	
	public Item retirar(Item item) {
		int indice = inventario.indexOf(item);
		if(indice != -1) {
			return inventario.remove(indice);
		}
		return null;
	}
	
	public Iterator<Item> obtenerIterador() {
		return inventario.iterator();
	}
}
