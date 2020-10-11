package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.hammazon.HammazonStrategy;

import java.util.ArrayList;

/**
 * Clase que implementa HammazonStrategy para los que contratan Hammazon Normal
 * @author Raul Nunio
 * @version 1.3
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
		"Hammazon Premium", "Vea los nuevos episodios de \"The Kids\"",
		"No se pierda la nueva temporada de \"Abadia Upton\"",
		"Disfrute de nuestra nueva serie \"El hombre en el castillo alto\""};
	
	/**
	 * Implementa cobrar de HammazonStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		if(con.obtenerPrimer()){
			con.noEsPrimer();
			s.recibirNotificaciones(s.obtenerNombre() + ", es su primer dia" +
			" en Hammazon Normal, no se cobrara");
			return;
		}
		s.recibirNotificaciones(s.obtenerNombre() + ", se cobraran 7 pesos" + 
		" por Hammazon Normal");
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de HammazonStrategy
	 * @return true si puede, false si no
	 */
	@Override
	public boolean sePuedeCobrar(Contrato con) {
		if(con.obtenerPrimer()) return true;
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}

	/**
	 * Metodo para obtener el arreglo con las posibles notificaciones de 
	 * Hammazon Normal
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
	
}
