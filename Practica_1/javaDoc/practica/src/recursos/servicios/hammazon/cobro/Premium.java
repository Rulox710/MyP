package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.hammazon.HammazonStrategy;

/**
 * Clase que implementa HammazonStrategy para los que contratan Hammazon Premium
 * @author Raul Nunio
 * @version 1.1
 */
public class Premium implements HammazonStrategy{
	
	/**
	 * Costo para todos lo que contraten Hammazon Premium
	 */
	private double costo = 13;
	
	/**
	 * Notificaciones para los que contraten Hammazon Premium
	 */
	 
	/**
	 * Implementa cobrar de HammazonStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de HammazonStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}
	

}
