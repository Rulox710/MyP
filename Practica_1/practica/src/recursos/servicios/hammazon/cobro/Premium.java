package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.hammazon.HammazonStrategy;

import java.util.ArrayList;

/**
 * Clase que implementa HammazonStrategy para los que contratan Hammazon Premium
 * @author Raul Nunio
 * @version 1.2
 */
public class Premium implements HammazonStrategy{
	
	/**
	 * Costo para todos lo que contraten Hammazon Premium
	 */
	private double costo = 13;
	
	/**
	 * Notificaciones para los que contraten Hammazon Premium
	 */
	 private final String[] notificaciones = {"Vea los nuevos episodios de " +
		"\"The Kids\"", "No se pierda la nueva temporada de \"Abadia Upton\"",
		"Disfrute de nuestra nueva serie \"El hombre en el castillo alto\"",
		"En exclusividad para los miembros de Prime, vea los episodios piloto" +
		" de \"El motel Hashishin\""};
	 
	/**
	 * Implementa cobrar de HammazonStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		if(con.obtenerPrimer()){
			con.noEsPrimer();
			s.recibirNotificaciones(s.obtenerNombre() + ", es su primer dia" +
			" en Hammazon Premium, no se cobrara");
			return;
		}
		s.recibirNotificaciones(s.obtenerNombre() + ", se cobraran 13 pesos" + 
		" por Hammazon Premium");
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
	 * Hammazon Premium
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}

}
