package recursos.servicios.twitsh.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.twitsh.TwitshStrategy;

/**
 * Clase que implementa TwitshStrategy para los que contratan Twitsh Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Normal implements TwitshStrategy {
	
	/**
	 * Costo para todos lo que contraten Twitsh Normal
	 */
	private double costo = 6;
	
	/**
	 * Notificaciones para los que contraten Twitsh Normal
	 */
	
	/**
	 * Implementa cobrar de TwitshStrategy
	 */ 
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de TwitshStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}	
}
