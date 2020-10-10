package recursos.servicios.yutube.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.yutube.YuTubeStrategy;

/**
 * Clase que implementa YuTubeStrategy para los que contratan YuTube Premium
 * @author Raul Nunio
 * @version 1.1
 */
public class Premium implements YuTubeStrategy {
	
	/**
	 * Costo para todos lo que contraten YuTube Premium
	 */
	private double costo = 6;
	
	/**
	 * Notificaciones para los que contraten YuTube Premium
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
	 * Implementa sePuedeCobrar de YuTubeStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}
	
}
