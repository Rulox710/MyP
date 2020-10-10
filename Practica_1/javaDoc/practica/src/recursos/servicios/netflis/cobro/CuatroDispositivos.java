package recursos.servicios.netflis.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.netflis.NetflisStrategy;

/**
 * Clase que implementa NetflisStrategy para los que contratan Netflis para 
 * cuatro dispositivos
 * @author Raul Nunio
 * @version 1.1
 */
public class CuatroDispositivos implements NetflisStrategy {
	
	/**
	 * Costo para todos lo que contraten Netflis cuatro dispositivos
	 */
	private double costo = 15;
	
	/**
	 * Notificaciones para los que contraten Netflis cuatro dispositivos
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
