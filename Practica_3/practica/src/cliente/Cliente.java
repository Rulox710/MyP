package cliente;

import java.util.ArrayList;
import constructora.coche.Coche;
/**
 * Clase que modela a un comprador de <code>Coche</code>
 */
public class Cliente {
	private int presupuesto; 
	private ArrayList<Coche> comprados;
	/**
	 * Constructor de la clase
	 * @param presupuesto Un numero entero
	 */
	public Cliente(int presupuesto) {
		this.presupuesto = presupuesto;
		comprados = new ArrayList<Coche>();
	}
	
	/**
	 * Metodo que regresa el presupuesto
	 * @return Un numero entero
	 */
	public int obtenerPresupuesto() {
		return presupuesto;
	}
	
	/**
	 * Metodo que asigna un nuevo presupuesto
	 * @param presupuesto Un numer entero
	 */
	 public void asignarPresupuesto(int presupuesto) {
		 this.presupuesto = presupuesto;
	 }
	 
	 /**
	  * Metodo para agregar un coche a la lista de los que ha comprado
	  * @param coche Un objeto <code>Coche</code>
	  */
	 public void agregarCoche(Coche coche) {
		 comprados.add(coche);
	 }
	 
	 /**
	  * Metodo que devuelve la lista con los coches comprados
	  * @return Una lista
	  */
	 public ArrayList<Coche> obtenerCoche() {
		 return comprados;
	 }
	 
	 /**
	  * Metodo que devuelve al cliente en forma de cadena. Indica su presupuesto
	  * @return Una cadena
	  */
	 @Override
	 public String toString() {
		 return "Usted tiene " + obtenerPresupuesto() + " madpesos";
	 }
}
