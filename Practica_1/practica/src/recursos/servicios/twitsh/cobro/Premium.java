package recursos.servicios.twitsh.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.twitsh.TwitshStrategy;

/**
 * Clase que implementa TwitshStrategy para los que contratan Twitsh Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Premium implements TwitshStrategy {
	
	/**
	 * Costo para todos lo que contraten Twitsh Premium
	 */
	private double costo = 10;
	
	/**
	 * Notificaciones para los que contraten Twitsh Premium
	 */
	private final String[] notificaciones = {"\"El Hola Plata\" esta transmi" +
		"tiendo, ve a verlo en Twitsh","Se esta haciendo un raid a \"AshOnLo" +
		"L\" en Twitsh", "\"OmegaNMC\" esta transmitiendo \"Directus pal pech" +
		"us nuestro\" en Twitsh", "\"LoLESports\" transmite en vivo solo por Twitsh"};
	
	/**
	 * Implementa cobrar de TwitshStrategy
	 */
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		if(con.obtenerPrimer()){
			con.noEsPrimer();
			s.recibirNotificaciones(s.obtenerNombre() + ", es su primer dia" +
			" en Twitsh Premium, no se cobrara");
			return;
		}
		s.recibirNotificaciones(s.obtenerNombre() + ", se cobraran " + costo + 
		" pesos por Twitsh Premium");
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de TwitshStrategy
	 * @return true si puede, false si no
	 */
	public boolean sePuedeCobrar(Contrato con) {
		if(con.obtenerPrimer()) return true;
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}
	
	/**
	 * Metodo para obtener el arreglo con las posibles notificaciones de 
	 * Twitsh Premium
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
}
