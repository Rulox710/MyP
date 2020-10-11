package recursos;

import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

/**
 * Clase para intermediar entre un <code>Suscriptor</code> y un 
 * <code>Servicio</code>
 * @author Raul nunio
 * @version 1.1
 */
public class Contrato {
	
	private Suscriptor cliente;
	private Servicio ser;
	private int tipo;
	private boolean primer;
	
	/**
	 * Contructor de la clase para obtener un <code>Contrato</code> sin 
	 * <code>tipo</code> de <code>Servicio</code>
	 * @param ser El <code>Servicio</code>
	 * @param cliente El <code>Suscriptor</code>
	 */
	public Contrato(Servicio ser, Suscriptor cliente) {
		this.ser = ser;
		this.cliente = cliente;
	}
	
	/**
	 * Contructor de la clase para obtener un <code>Contrato</code> con <code>tipo</code> de <code>Servicio</code>
	 * @param ser El <code>Servicio</code>
	 * @param cliente El <code>Suscriptor</code>
	 * @param tipo Un valor que representa el <code>tipo</code> de 
	 * <code>Servicio</code>
	 */
	public Contrato(Servicio ser, Suscriptor cliente, int tipo) {
		this.ser = ser;
		this.cliente = cliente;
		this.tipo = tipo;
		primer = true;
	}
	
	/**
	 * Metodo para declarar que no es el primer dia del <code>Suscriptor</code> 
	 * en el <code>Servicio</code>
	 */
	public void noEsPrimer(){
		primer = false;
	}
	
	/**
	 * Metodo para obtener el <code>Servicio</code> del <code>Contrato</code>
	 * @return El <code>Servicio</code> del <code>Contrato</code>
	 */
	public Servicio obtenerServicio() {
		return ser;
	}
	
	/**
	 * Metodo pata obtener el <code>Cliente</code> del <code>Contrato</code>
	 * @return El <code>Suscriptor</code> del Contrato
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
	 * Metodo para obtener un valor que representa el <code>tipo</code> de 
	 * <code>Servicio</code> que se contrato
	 * @return Un valor que representa el tipo de <code>Servicio</code> 
	 * contratado
	 */
	public int obtenerTipo() {
		return tipo;
	}
	
	/**
	 * Metodo para asignar un valor que representa el tipo de Servicio que se 
	 * contrato
	 * @param tipo Un valor que prepresenta un nuevo para el tipo de Servicio
	 */
	public void asignarTipo(int tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo para decidir si un <code>Object</code> es igual a un 
	 * <code>Contrato</code> de acuerdo a si tienen el mismo 
	 * <code>Suscriptor</code> y el mismo <code>Servicio</code>
	 * @param obj El objeto a comparar
	 * @return <code>true</code> si son iguales, <code>false</code> si no 
	 */
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Contrato)) return false;
		Contrato con = (Contrato)obj;
		return (cliente.equals(con.obtenerCliente()) && ser.equals(con.obtenerServicio()));
	}
}
