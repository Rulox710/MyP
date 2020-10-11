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
	private final String[] notificaciones = {"Conoce la nueva pista de \"PSY" +
		"QUI\", en Spootify", "\"Negro\" de \"Oracu Sutivu\" en Spootify",
		"Escuche la nueva mezcla de canciones que hicimos para usted en" +
		" Spootify", "Escucha \"\u7A32\u8449\u66C7" + 
		"\u300E\u3072\u307F\u3064\u306E\u5C0F\u5B66\u751F\u300FVo. " +
		"\u6B4C\u611B\u30E6\u30AD\", en Spootify", "Contrate Spootify Premim" +
		"hoy"};
	 
	/**
	 * Implementa cobrar de SpootifyStrategy
	 */
	@Override
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		if(con.obtenerPrimer()){
			con.noEsPrimer();
			s.recibirNotificaciones(s.obtenerNombre() + ", es su primer dia" +
			" en Spootify Normal, no se cobrara");
			return;
		}
		s.recibirNotificaciones(s.obtenerNombre() + ", se cobraran " + costo + 
		" pesos por Spootify Normal");
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de SpootifyStrategy
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
	 * Spootify normal
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
}
