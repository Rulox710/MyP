package recursos.servicios.netflis;

import recursos.Contrato;

/**
 * Interfaz para modelar los costos. Patron Strategy
 * @author Raul Nunio
 * @version 1.0
 */
public interface NetflisStrategy {
	
	/**
	 * Metodo para cobrar a un <code>Suscriptor</code> por medio de su 
	 * <code>Contrato</code>
	 * @param con El <code>Contrato</code> del Suscriptor
	 */ 
	public abstract void cobrar(Contrato con);

	/**
	 * Metodo para verificar que el <code>Suscriptor</code> pueda pagar el 
	 * <code>Servicio</code> por medio de su <code>Contrato</code>
	 * @param con El <code>Contrato</code> del <code>Suscriptor</code>
	 * @return <code>true</code> si puede pagar, <code>false</code> si no
	 */ 
	public abstract boolean sePuedeCobrar(Contrato con);

	/**
	 * Metodo para notificar a todos los suscriptores sobre las actividades de 
	 * <code>Netflis</code>
	 * @return Un arreglo con las notificaciones de <code>Netflis</code>
	 */
	public abstract String[] obtenerNotificaciones();
}
