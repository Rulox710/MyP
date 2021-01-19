package juego.mueble; 

import java.util.ArrayList;
import java.util.Iterator;

import juego.item.Item;
import juego.item.Llave;

/**
 * Clase que modela un mueble
 */
public class Mueble {
	
	/**
	 * Clase interna que modela una cerradura para un <code>Mueble</code>
	 */
	protected class Cerradura {
		private String clave;
		private boolean estaAbierta = false;
		
		/**
		 * Conctructor de la clase interna
		 */
		public Cerradura(String clave) {
			this.clave = clave;
		}
		
		/**
		 * Metodo para saber si la cerradura esta o no abierta
		 * @return Un boleano que indica si esta abierta o no
		 */
		public boolean obtenerEstaAbierta() {
			return estaAbierta;
		}
		
		/**
		 * Metodo para abrir la <code>Cerradura</code>
		 * @param llave Un objeto <code>Llave</code> que puede o no abrir la 
		 * <code>Cerradura</code>
		 * @return <code>true</code> si se abrio, <code>false</code> si no
		 */
		public boolean abrirCerradura(Llave llave) {
			if(llave == null) return false;
			if(llave.obtenerClave().equalsIgnoreCase(clave)) {
				estaAbierta = true;
			}
			return estaAbierta;
		}
	}
	
	private String nombre;
	private Cerradura cerradura;
	private ArrayList<Item> contenido = new ArrayList<>();
	private boolean abierto;
	
	/**
	 * Contructor de la clase
	 * @param nombre Una cadena que identificara al <code>Mueble</code>
	 * @param descripcion Una cadena que describe al <code>Mueble</code>
	 */
	public Mueble(String nombre) {
		this.nombre = nombre;
		abierto = false;
	}
	
	/**
	 * Contructor de la clase
	 * @param nombre Una cadena que identificara al <code>Mueble</code>
	 * @param descripcion Una cadena que describe al <code>Mueble</code>
	 * @param clave La clave de la cerradura
	 */
	public Mueble(String nombre, String clave) {
		this.nombre = nombre;
		cerradura = new Cerradura(clave);
		abierto = false;
	}
	
	/**
	 * Metodo para obtener el nombre
	 * @return Una cadena que representa el nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que devuelve si un mueble ya habia sido abierto con anterioridad
	 * @return Un boleano
	 */
	public boolean obtenerAbierto() {
		return abierto;
	}
	
	/**
	 * Metodo para saber si es un mueble que se puede abrir
	 * @return Un boleano
	 */
	private boolean sePuedeAbrir() {
		if(cerradura != null)
			return cerradura.obtenerEstaAbierta();
		return true;
	}
	
	/**
	 * Metodo para abrir un <code>Mueble</code>
	 * @return Un boleano que indica si se abrio el mueble
	 */
	public boolean abrir() {
		if(sePuedeAbrir()) {
			abierto = true;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para abrir un <code>Mueble</code> con una <code>Llave</code>
	 * @param llave Una llave
	 * @return Un boleano que indica si se abrio
	 */
	public boolean abrir(Llave llave) {
		if(cerradura != null && cerradura.abrirCerradura(llave)) {
			abierto = true;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve un iterador con los objetos del mueble. Si el mueble 
	 * esta cerrado devulve un iterador con una unica entrada que es nula
	 * @return Un iterador 
	 */
	public Iterator<Item> verContenido() {
		if(!abierto) {
			ArrayList<Item> ar = new ArrayList<>(1);
			ar.add(null);
			return ar.iterator();
		}
		return contenido.iterator();
	}
	
	private String listarContenido() {
		String cadena = "";
		if(!contenido.isEmpty()) {
			Iterator<Item> it = contenido.iterator();
			while(it.hasNext()) {
				cadena += it.next().toString().toLowerCase();
				if(it.hasNext()) cadena += ", ";
			}
		} else {
			cadena = "nada";
		}
		return cadena;
	}
	
	/**
	 * Metodo para verificar que el mueble tiene un objeto que se identifica con
	 * la cadena dada
	 * @param objeto Una cadena
	 * @return <code>true</code> si si lo hay, <code>false</code> si no
	 */
	public boolean tieneObjeto(String objeto) {
		if(!contenido.isEmpty()) {
			Iterator<Item> it = contenido.iterator();
			while(it.hasNext()) {
				if(it.next().validarItemCadena(objeto)) return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que obtiene el item del mueble si hay alguno que se identifique 
	 * con la cadena dada
	 * @param cadena Una cadena
	 * @return Un <code>Item</code>, <code>null</code> si no lo encontro
	 */
	public Item tomarObjeto(String objeto) {
		Item item = null;
		if(abierto) {
			Iterator<Item> it = contenido.iterator();
			while(it.hasNext()) {
				Item temp = it.next();
				if(temp.validarItemCadena(objeto)) {
					item = temp;
					contenido.remove(item);
					break;
				}				
			}
		}
		return item;
		/*Object[] regreso = new Object[2];
		String cadena = "No encuentro ningun objeto como ese aqui";
		Item item = null;
		if(!abierto) {
			cadena = "Aun no he abierto este mueble";
		} else if(!contenido.isEmpty()) {
			Iterator<Item> it = contenido.iterator();
			while(it.hasNext()) {
				Item temp = it.next();
				if(temp.validarItemCadena(objeto)){
					cadena = "He tomado: " + temp.toString().toLowerCase();
					item = temp;
					break;
				}
			}
		} else {
			cadena = "No habia nada para tomar";
		}
		contenido.remove(item);
		regreso[0] = item;
		regreso[1] = cadena;
		return regreso;*/
	}
	
	public void agregarObjeto(Item item) {
		if(item != null) contenido.add(item);
	}
	
	public String toString() {
		return nombre + "/ tiene: " + listarContenido();
	}
	
	public boolean validarMuebleCadena(String cadena) {
		if(!cadena.equalsIgnoreCase("mueble")) {
			if(!cadena.equalsIgnoreCase(nombre.split(" ")[0])) {
				if(!cadena.equalsIgnoreCase(nombre)) {
					return false;
				}
			}
		}
		return true;
	}
}
