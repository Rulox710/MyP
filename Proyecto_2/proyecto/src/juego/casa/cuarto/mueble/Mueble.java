package juego.casa.cuarto.mueble; 

import java.util.ArrayList;
import java.util.Iterator;

import juego.casa.cuarto.mueble.item.Item;
import juego.casa.cuarto.mueble.item.Llave;

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
			if(llave.obtenerClave().equals(clave)) {
				estaAbierta = true;
			}
			return estaAbierta;
		}
	}
	
	private String nombre, descripcion;
	private Cerradura cerradura;
	private ArrayList<Item> contenido = new ArrayList<>();
	
	/**
	 * Contructor de la clase
	 * @param nombre Una cadena que identificara al <code>Mueble</code>
	 * @param descripcion Una cadena que describe al <code>Mueble</code>
	 */
	public Mueble(String nombre) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * Contructor de la clase
	 * @param nombre Una cadena que identificara al <code>Mueble</code>
	 * @param descripcion Una cadena que describe al <code>Mueble</code>
	 * @param clave La clave de la cerradura
	 */
	public Mueble(String nombre, String clave) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		cerradura = new Cerradura(clave);
	}
	
	/**
	 * Metodo para obtener el nombre
	 * @return Una cadena que representa el nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para obtener la descripcion
	 * @return Una cadena que representa la descripcion
	 */
	public String obtenerDescripcion() {
		return descripcion;
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
	 * @return Una cadena que dice informacion sobre el contenido del 
	 * <code>Mueble</code>
	 */
	public String abrir() {
		String cadena = "";
		if(sePuedeAbrir()) {
			cadena += "Este " + nombre.toLowerCase() + " tiene: " + 
				listarContenido();
		} else {
			cadena += "Necesitare de una llave para abrir este " + 
				nombre.toLowerCase();
		}
		return cadena;
	}
	
	/**
	 * Metodo para abrir un <code>Mueble</code> con una <code>Llave</code>
	 * @param llave Una llave
	 * @return Una cadena que dice informacion sobre el contenido del 
	 * <code>Mueble</code>
	 */
	public String abrir(Llave llave) {
		String cadena = "";
		if(sePuedeAbrir()) {
			if(cerradura != null) {
				cadena += "Ya habia abierto este " +  nombre.toLowerCase() + 
					". Tiene: " + listarContenido();
			} else {
				cadena += "No necesito de una llave para abrir este " + 
				nombre.toLowerCase() + ". Tiene: " + listarContenido();
			}
				cadena += "No parece ser la llave correcta";
		} else {
			if(cerradura.abrirCerradura(llave)) {
				cadena = "He abierto el " + nombre.toLowerCase();
			} else {
				cadena = "No parece ser la lleve correcta";
			}
		}
		return cadena;
	}
	
	public String verContenido() {
		String cadena = "";
		if(sePuedeAbrir()) {
			cadena = "Este " + nombre.toLowerCase() + "tiene: " + 
				listarContenido();
		} else {
			cadena = "Esta cerrado y no puedo ver su contenido";
		}
		return cadena;
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
	
	public Object[] tomarObjeto(String objeto) {
		Object[] regreso = new Object[2];
		String cadena = "No encuentro ningun objeto como ese aqui";
		Item item = null;
		if(!sePuedeAbrir()) {
			cadena = "No puedo abrir este mueble";
		} else if(!contenido.isEmpty()) {
			Iterator<Item> it = contenido.iterator();
			while(it.hasNext()) {
				Item temp = it.next();
				if(temp.equals(objeto)){
					cadena = "He tomado: " + objeto.toLowerCase();
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
		return regreso;
	}
	
	public void agregarObjeto(Item item) {
		if(item != null) contenido.add(item);
	}
}
