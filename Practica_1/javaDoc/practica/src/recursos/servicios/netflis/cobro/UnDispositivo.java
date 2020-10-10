package recursos.servicios.netflis.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.netflis.NetflisStrategy;

/**
 * Clase que implementa NetflisStrategy para los que contratan Netflis para un 
 * dispositivo
 * @author Raul Nunio
 * @version 1.1
 */
public class UnDispositivo implements NetflisStrategy {
	
	/**
	 * Costo para todos lo que contraten Netflis un dispositivo
	 */
	private double costo = 7;
	
	/**
	 * Notificaciones para los que contraten Netflis un dispositivo
	 */
	
	/**
	 * Implementa cobrar de NetflisStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de NetflisStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}	
}
