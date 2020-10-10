package recursos.servicios.netflis.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.netflis.NetflisStrategy;

/**
 * Clase que implementa NetflisStrategy para los que contratan Netflis para dos 
 * dispositivos
 * @author Raul Nunio
 * @version 1.1
 */
public class DosDispositivos implements NetflisStrategy {
	
	/**
	 * Costo para todos lo que contraten Netflis dos dispositivos
	 */
	private double costo = 10;
	
	/**
	 * Notificaciones para los que contraten Netflis dos dispositivos
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
