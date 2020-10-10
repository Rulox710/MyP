package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.hammazon.HammazonStrategy;

/**
 * Clase que implementa HammazonStrategy para los que contratan Hammazon Normal
 * @author Raul Nunio
 * @version 1.2
 */
public class Normal implements HammazonStrategy{
	
	/**
	 * Costo para todos lo que contraten Hammazon Normal
	 */
	private final double costo = 7;
	
	/**
	 * Notificaciones para los que contraten Hammazon Normal
	 */
	private final String[] notificaciones = {"Contrata un mejor plan, contrata" +
		"Hammazon Premium", ""};
	
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
