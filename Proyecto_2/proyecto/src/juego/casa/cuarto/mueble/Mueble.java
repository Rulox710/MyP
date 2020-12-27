package juego.casa.cuarto.mueble; 

import java.util.ArrayList;

import juego.casa.cuarto.mueble.item.Item;
import juego.casa.cuarto.mueble.item.Llave;

/**
 * Clase que modela un mueble
 */
public abstract class Mueble {
	/**
	 * Clae interna que modela una cerradura para un <code>Mueble</code>
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
			if(llave.obtenerClave().equals(clave)) {
				estaAbierta = true;
			}
			return estaAbierta;
		}
	}
	
	protected String nombre, descripcion;
	protected Cerradura cerradura;
	protected ArrayList<Item> contenido;
	
	/**
	 * Contructor de la clase
	 * @param nombre Una cadena que identificara al <code>Mueble</code>
	 * @param descripcion Una cadena que describe al <code>Mueble</code>
	 */
	public Mueble(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	 * Metodo que indica si tiene o no <code>Cerradura</code>, la cual impide 
	 * que se vea el contenido del <code>Mueble</code>
	 * @return Un boleano  
	 */
	private boolean tieneCerradura() {
		return (cerradura != null);
	}
	
	/**
	 * Metodo para obtener una cadena con el contenido del <code>Mueble</code>
	 * @return Una cadena
	 */
	private String listarContenido() {
		String cadena = "";
		int i = 0;
		for(Item item: contenido) {
			if(item == null) {
				cadena = "Esta vacio";
			}
			if(i > 0) cadena += ", ";
			cadena += item.obtenerNombre();
			i++;
		}
		return cadena;
	}
	
	/**
	 * Metodo para saber si es un mueble que se puede abrir
	 * @return Un boleano
	 */
	public abstract boolean sePuedeAbrir();
	
	/**
	 * Metodo para abrir un <code>Mueble</code>
	 * @return Una cadena que dice informacion sobre el contenido del 
	 * <code>Mueble</code>
	 */
	public String abrir() {
		String cadena = "";
		if(tieneCerradura()) {
			if(cerradura.obtenerEstaAbierta()){
				cadena += "Este " + nombre.toLowerCase() + " tiene: " + 
					listarContenido().toLowerCase();
			} else {
				cadena += "Necesitare de una llave para abrir este " + 
					nombre.toLowerCase();
			}
		} else {
			cadena += "Este " + nombre.toLowerCase() + " tiene: " + 
				listarContenido().toLowerCase();
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
		if(tieneCerradura()) {
			if(cerradura.obtenerEstaAbierta()) {
				cadena += "Ya habia abierto este " +  nombre.toLowerCase() + 
				". Tiene: " + listarContenido().toLowerCase();
			} else {
				if(cerradura.abrirCerradura(llave)) {
					cadena += "Se ha abierto este " + nombre.toLowerCase() +
						". Tiene: " + listarContenido().toLowerCase();
				} else {
					cadena += "No parece ser la llave correcta";
				}
			}
		} else {
			cadena += "No necesito de una llave para abrir este " + 
				nombre.toLowerCase() + ". Tiene: " + 
				listarContenido().toLowerCase();
		}
		return cadena;
	}
	
	/**
	 * Metodo para ver si tiene contenido o no
	 * @return Un boleanos
	 */
	public abstract boolean tieneContenido();
}
