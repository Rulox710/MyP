package recursos.interfaces;

import java.util.ArrayList;

/**
 * Interfaz que modela el patron Observer junto con <code>Servicio</code> (esta 
 * es el observador) 
 * @author Raul Nunio
 * @version 1.1
 */
public interface Suscriptor {

	/**
	 * Metodo para iniciar la suscripcion del <code>Suscripor</code> a un 
	 * <code>Servicio</code>
	 * @param ser El <code>Servicio</code> a contratar
	 * @param i Un valor que representa el tipo de suscripcion
	 * @return <code>true</code> si se suscribio, <code>false</code> si no
	 */
	public abstract boolean iniciarSuscripcion(Servicio ser, int i);
	
	/**
	 * Metodo que cambia el tipo de suscripcion del Suscriptor a un Servicio
	 * @param ser ser El Servicio a cambiar el tipo
	 * @param i Valor que representa el nuevo tipo
	 * @return true si se ha cambiado, false si no
	 */
	public abstract boolean cambiarSuscripcion(Servicio ser, int i);
	
	/**
	 * Metodo que termina la suscripcion del <code>Suscriptor</code>
	 * @param ser <code>Servicio</code> a terminar
	 * @return <code>true</code> si se a terminado, <code>false</code> si no 
	 */
	public abstract boolean terminarSuscripcion(Servicio ser);
	
	/**
	 * Metodo para recibir las notificaciones de los servicios contratados
	 * @param str El <code>String</code> con informacion de un 
	 * <code>Servicio</code>
	 */
	public abstract void recibirNotificaciones(String str);
	
	/**
	 * Metodo para obtener un <code>ArrayList</code> con todas las 
	 * notificaciones no vistas anteriormente
	 * @return Un <code>ArrayList</code> con las notificaciones de los servicios
	 */
	public abstract ArrayList<String> verNotificaciones();
	
	/**
	 * Metodo para obtener el nombre del <code>Suscriptor</code>
	 * @return El <code>String</code> con el nombre del <code>Suscriptor</code>
	 */
	public abstract String obtenerNombre();
	
	/**
	 * Metodo para obtener los fondos del <code>Sucriptor</code>
	 * @return Los fondos
	 */
	public abstract double obtenerDinero();
	
	/**
	 * Metodo para asignar los fondos del <code>Suscriptor</code>
	 * @param dinero Nuevos fondos a asignar
	 */
	public abstract void asignarDinero(double dinero);
	
	/**
	 * Metodo que compara al <code>Suscriptor</code> con un <code>Object</code>
	 * @param obj El objeto a comparar
	 * @return <code>true</code> si son iguales, <code>false</code> si no
	 */
	public abstract boolean equals(Object obj);

}
