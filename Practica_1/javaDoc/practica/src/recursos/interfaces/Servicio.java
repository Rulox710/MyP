package recursos.interfaces;

import recursos.Contrato;

/**
 * Interfaz que modela el patron Observer junto con Suscriptor (esta es el 
 * sujeto)
 * @author Raul Nunio
 * @version 1.1
 */
public interface Servicio {

	/**
	 * metodo para agragar a un Suscriptor al Servicio
	 * @param con El Contrato del Sujeto y el Servicio
	 * @return true si se agrago, false si no
	 */
	public abstract boolean agregarSuscriptor(Contrato con);
	
	/**
	 * Metodo para cambiar el tipo de Suscripcion de un Suscriptor
	 * @param con El contrato
	 * @param i Nuevo tipo de suscripcion
	 * @return true si se cambio exitosamenta al Suscriptor, false si no
	 */
	public abstract boolean cambiarSuscriptor(Contrato con, int i);

	/**
	 * Metodo para eliminar a un Suscriptor del Servicio
	 * @param con El contrato
	 * @return true si se elimino, false si no  
	 */
	public abstract boolean eliminarSuscriptor(Contrato con);
	
	/**
	 * Metodo para cobrar a todos los Suscriptores en el servicio. Si no pueden 
	 * pagar, se realizaran distintas acciones dependiendo del Servicio 
	 */
	public abstract void pago();
	
	/**
	 * Metodo para notificar a los Suscriptores dsobre cosas del Servicio. 
	 * Cambia dependiendo del Servicio y la estrategia usada 
	 */
	public abstract void notificar();
	
	/**
	 * Metodo para comparar un Servicio con un Objeto
	 * @param obj El objeto a comparar
	 * @return true si el objeto es igual al Servicio 
	 */
	public abstract boolean equals(Object obj);
	
}
