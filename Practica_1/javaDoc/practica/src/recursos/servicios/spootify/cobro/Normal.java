package recursos.servicios.spootify.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.spootify.SpootifyStrategy;

/**
 * Clase que implementa SpootifyStrategy para los que contratan Spootify Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Normal implements SpootifyStrategy {
	
	/**
	 * Costo para todos lo que contraten Spootify Normal
	 */
	private double costo = 0;
	
	/**
	 * Notificaciones para los que contraten Spootify Normal
	 */
	 
	/**
	 * Implementa cobrar de SpootifyStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de SpootifyStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}	
}
