package recursos;

import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

/**
 * Clase para intermediar entre un Suscriptor y un Servicio
 * @author Raul nunio
 * @version 1.1
 */
public class Contrato {
	
	private Suscriptor cliente;
	private Servicio ser;
	private int tipo;
	private boolean primer;
	
	/**
	 * Contructor de la clase para obtener un Contrato sin tipo de Servicio
	 * @param ser El servicio
	 * @param cliente El Suscriptor
	 */
	public Contrato(Servicio ser, Suscriptor cliente) {
		this.ser = ser;
		this.cliente = cliente;
	}
	
	/**
	 * Contructor de la clase para obtener un Contrato con tipo de Servicio
	 * @param ser El servicio
	 * @param cliente El Suscriptor
	 * @param tipo Un valor que representa el tipo de Servicio
	 */
	public Contrato(Servicio ser, Suscriptor cliente, int tipo) {
		this.ser = ser;
		this.cliente = cliente;
		this.tipo = tipo;
		primer = true;
	}
	
	/**
	 * Metodo para declarar que no es el primer dia del suscriptor en el 
	 * Servicio
	 */
	public void noEsPrimer(){
		primer = false;
	}
	
	/**
	 * Metodo para obtener el Servicio del Contrato
	 * @return El Servicio del Contrato
	 */
	public Servicio obtenerServicio() {
		return ser;
	}
	
	/**
	 * Metodo pata obtener el Cliente del Contrato
	 * @return El Suscriptor del Contrato
	 */
	public Suscriptor obtenerCliente() {
		return cliente;
	}
	
	/**
	 * Metodo para obtener si es el primer dia del Cliente en algun Servicio
	 * @return El valor del primer dia
	 */
	public boolean obtenerPrimer() {
		return primer;
	}
	
	/**
	 * Metodo para obtener un valor que representa el tipo de Servicio que se 
	 * contrato
	 * @return Un valor que representa el tipo de Servicio contratado
	 */
	public int obtenerTipo() {
		return tipo;
	}
	
	/**
	 * Metodo para asignar un valor que representa el tipo de Servicio que se 
	 * contrato
	 * @param Un valor que prepresenta un nuevo para el tipo de Servicio
	 */
	public void asignarTipo(int tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo para decidir si un Objeto es igual a un Contrato de acuerdo a si 
	 * tienen el mismo Suscriptor y el mismo Servicio
	 * @param obj El objeto a comparar
	 * @return true si son iguales, false si no 
	 */
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Contrato)) return false;
		Contrato con = (Contrato)obj;
		return (cliente.equals(con.obtenerCliente()) && ser.equals(con.obtenerServicio()));
	}
}
