package recursos.servicios.hammazon;

import recursos.Contrato;

/**
 * Interfaz para modelar los costos. Patron Strategy
 * @author Raul Nunio
 * @version 1.1
 */
public interface HammazonStrategy {
	
	/**
	 * Metodo para cobrar a un Suscriptor por medio de su Contrato
	 * @param con El Contrato del Suscriptor
	 */ 
	public abstract void cobrar(Contrato con);

	/**
	 * Metodo para verificar que el Suscriptor pueda pagar el Servicio por medio
	 * de su Contrato
	 * @param con El Contrato del Suscriptor
	 * @return true si puede pagar, false si no
	 */ 
	public abstract boolean sePuedeCobrar(Contrato con);
	
	/**
	 * Metodo para notificar a todos los suscriptores sobre las actividades de 
	 * Hammazon
	 */
	public abstract String[] obtenerNotificaciones();
}
