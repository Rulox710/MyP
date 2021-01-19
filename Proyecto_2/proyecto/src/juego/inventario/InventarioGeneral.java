package juego.inventario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;

import juego.item.*;

/**
 * Clase que modela un inventario con todos los posibles objetos que se puedan 
 * guardar. Solo pueden guardrse diez llaves, dos herramientas, seis consumibles
 * y diez notas 
 */
public class InventarioGeneral {
	
	/**
	 * Clase para crear un iterador del <code>InventarioGeneral</code>. 
	 * Implementa <code>Iterator</code>
	 */
	private class IteradorCompuesto implements Iterator { 
		private final Stack<Iterator> fila; 
		private Iterator siguiente;
		
		/**
		 * Constructor de la clase
		 * @param iterators Todos los iteradores a los cuales se combinaran en 
		 * uno
		 */
		public IteradorCompuesto(final Iterator<Item>... iterators) { 
			this.fila = new Stack<Iterator>(); 
			for (final Iterator iterator : iterators) { 
				fila.push(iterator); 
			} 
			siguiente = fila.pop(); 
		}
		
		/**
		 * Metodo para seber si tiene un siguiente elemento el iterador
		 * @return Si tiene un siguiente elemento
		 */
		public boolean hasNext() { 
			final boolean actualSiguiente = siguiente.hasNext(); 
			if (!actualSiguiente && !fila.isEmpty()) { 
				siguiente = fila.pop();
				return hasNext(); 
			} else { 
				return actualSiguiente; 
			} 
		} 
		
		/**
		 * Metodo para devolver el siguiente elemento en el iterador
		 * @return Un objeto que es el siguiente en el iterador
		 */
		public Item next() {
			return (Item)siguiente.next(); 
		} 
		
		/**
		 * Metodo para remover un elemento. No fue implementado, asi que 
		 * devuelve <code>UnsupportedOperationException</code>
		 */
		public void remove() { 
			throw new UnsupportedOperationException("Sin implementar"); 
		} 
	} 
	
	private ArrayList<Inventario> ig = new ArrayList(4);
	
	/**
	 * Constructor de la clase
	 */
	public InventarioGeneral() {
		ig.add(new Inventario<Llave>(10));
		ig.add(new Inventario<Herramienta>(2));
		ig.add(new Inventario<Consumible>(6));
		ig.add(new Inventario<Nota>(10));
	}
	
	/**
	 * Metodo para agregar un <code>Item</code> al inventario
	 * @param item El objeto a agregar
	 * @return <code>true</code> si se agrego, <code>false</code> si no
	 */
	public boolean agregar(Item item) {
		if(item instanceof Llave) {
			return ig.get(0).agregar(item);
		} else if(item instanceof Herramienta) {
			return ig.get(1).agregar(item);
		} else if(item instanceof Consumible) {
			return ig.get(2).agregar(item);
		} else if(item instanceof Nota) {
			return ig.get(3).agregar(item);
		}
		return false;
	}
	
	/**
	 * Metodo que retira un objeto en el indice dado y lo devuelve. Debe usarse 
	 * {@link indicePorCadena(String, boolean) metodo} para saber el indice del 
	 * objeto
	 * @param indice Un numero entero
	 * @return Un <code>Item</code>, <code>null</null> si no se encuentra un 
	 * objeto en la posicion indicada
	 */
	public Item retirar(int indice) {	
		Item item = null;
		if(indice < 0 || indice > ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio() + ig.get(2).obtenerTamanio() + 
			ig.get(3).obtenerTamanio()) return item;
		if(indice < ig.get(0).obtenerTamanio()) {
			item = ig.get(0).retirar(indice);
		} else if(indice < ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio()) {
			item = ig.get(1).retirar(indice - (ig.get(0).obtenerTamanio()));
		} else if(indice < ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio() + ig.get(2).obtenerTamanio()) {
			item = ig.get(2).retirar(indice - (ig.get(0).obtenerTamanio() + 
				ig.get(1).obtenerTamanio()));
		} else if(indice < ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio() + ig.get(2).obtenerTamanio() + 
			ig.get(3).obtenerTamanio()) {
			item = ig.get(3).retirar(indice - (ig.get(0).obtenerTamanio() + 
				ig.get(1).obtenerTamanio() + ig.get(2).obtenerTamanio()));
		}
		return item;
	}
	
	/**
	 * Metodo que devuelve el indice de un objeto que se identifica con la 
	 * cadena dada, ademas si se pide que sea exacto, entonces solo lo valida si
	 * la cadena es exactaqmente igual al nombre del objeto
	 * @param cadena Una cadena
	 * @return exacto <code>true</code> si se quiere ser estricto al momento de 
	 * buscar el objeto que se identifica con la cadena
	 * @return Un numero entero
	 */
	public int indicePorCadena(String cadena, boolean exacto) {
		int i = -1;
		i = ig.get(0).indicePorCadena(cadena,exacto);
		if(i != -1) return i;
		i = ig.get(1).indicePorCadena(cadena,exacto);
		if(i != -1) return i + ig.get(0).obtenerTamanio();
		i = ig.get(2).indicePorCadena(cadena,exacto);
		if(i != -1) return i + ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio();
		i = ig.get(3).indicePorCadena(cadena,exacto);
		if(i != -1) return i + ig.get(0).obtenerTamanio() + 
			ig.get(1).obtenerTamanio() + ig.get(2).obtenerTamanio();
		return i;
	}
	
	/**
	 * Metodo para obtener un iterador con los objetos en el inventario
	 * @return Un iterador
	 */
	public Iterator obtenerIterador() {
		return new IteradorCompuesto(ig.get(0).obtenerIterador(),
			ig.get(1).obtenerIterador(),ig.get(2).obtenerIterador(),
			ig.get(3).obtenerIterador());
	}
	
	/**
	 * Metodo para obtener un iterador de los items de ciertos objetos.
	 * @param c Si el caracter es 'L' entonces solo se dan llaves, si es 'H' 
	 * entonces son herramientas, si es 'C' entonces son consumibles, si es 'N'
	 * entonces son notas y si es cualquier otro caracter, devuelve un iterador 
	 * de todo {@link obtenerIterador() metodo}
	 * @return Un iterador
	 */
	public Iterator obtenerIterador(char c) {
		switch(c) {
			case 'L': return ig.get(0).obtenerIterador();
			case 'H': return ig.get(1).obtenerIterador();
			case 'C': return ig.get(2).obtenerIterador();
			case 'N': return ig.get(3).obtenerIterador();
		}
		return obtenerIterador();
	}
}
