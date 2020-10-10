package recursos.servicios.yutube.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.yutube.YuTubeStrategy;

/**
 * Clase que implementa YuTubeStrategy para los que contratan YuTube Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Normal implements YuTubeStrategy {
	
	/**
	 * Costo para todos lo que contraten YuTube Normal
	 */
	private double costo = 0;
	
	/**
	 * Notificaciones para los que contraten YuTube Normal
	 */
	 
	/**
	 * Implementa cobrar de YuTubeStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de YuTubenStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}
	
}
