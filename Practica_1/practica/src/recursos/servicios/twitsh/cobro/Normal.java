package recursos.servicios.twitsh.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.twitsh.TwitshStrategy;

/**
 * Clase que implementa TwitshStrategy para los que contratan Twitsh Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Normal implements TwitshStrategy {
	
	/**
	 * Costo para todos lo que contraten Twitsh Normal
	 */
	private double costo = 6;
	
	/**
	 * Notificaciones para los que contraten Twitsh Normal
	 */
	private final String[] notificaciones = {"\"El Hola Plata\" esta transmi" +
		"tiendo, ve a verlo en Twitsh","Se esta haciendo un raid a \"AshOnLo" +
		"L\" en Twitsh", "\"OmegaNMC\" esta transmitiendo \"Directus pal pech" +
		"us nuestro\" en Twitsh", "Contrata Twitsh Premium, hoy"};
	
	/**
	 * Implementa cobrar de TwitshStrategy
	 */ 
	@Override
	public void cobrar(Contrato con) {
		if(con.obtenerPrimer()){
			con.noEsPrimer();
			return;
		}
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	/**
	 * Implementa sePuedeCobrar de TwitshStrategy
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
	 * Twitsh Normal
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
}
