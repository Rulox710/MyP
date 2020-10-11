package recursos.interfaces;

import java.util.ArrayList;

/**
 * Interfaz que modela el patron Observer junto con Servicio (esta es el 
 * observador) 
 * @author Raul Nunio
 * @version 1.1
 */
public interface Suscriptor {

	/**
	 * Metodo para iniciar la suscripcion del Suscripor a un Servicio
	 * @param ser El Servicio a contratar
	 * @param i Un valor que representa el tipo de suscripcion
	 * @return true si se suscribio, false si no
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
	 * Metodo que termina la suscripcion del Suscriptor
	 * @param ser Servicio a terminar
	 * @return true si se a terminado, false si no 
	 */
	public abstract boolean terminarSuscripcion(Servicio ser);
	
	/**
	 * Metodo para recibir las notificaciones de los servicios contratados
	 * @param str El String con informacion de un servicio
	 */
	public abstract void recibirNotificaciones(String str);
	
	/**
	 * Metodo para obtener un ArrayList con todas las notificaciones no vistas 
	 * anteriormente
	 * @return Un ArrayList con las notificaciones de los servicios
	 */
	public abstract ArrayList<String> verNotificaciones();
	
	/**
	 * Metodo para obtener el nmbre del Suscriptor
	 * @return El String con el nombre del Suscriptor
	 */
	public abstract String obtenerNombre();
	
	/**
	 * Metodo para obtener los fondos del Sucriptor
	 * @return Los fondos
	 */
	public abstract double obtenerDinero();
	
	/**
	 * Metodo para asignar los fondos del Suscriptor
	 * @param dinero Nuevos fondos a asignar
	 */
	public abstract void asignarDinero(double dinero);
	
	/**
	 * Metodo que compara al Suscriptor con un Objeto
	 * @param El objeto a comparar
	 * @return true si son iguales, false si no
	 */
	public abstract boolean equals(Object obj);

}
