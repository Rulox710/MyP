package recursos.servicios.yutube.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.yutube.YuTubeStrategy;

/**
 * Clase que implementa YuTubeStrategy para los que contratan YuTube Normal
 * @author Raul Nunio
 * @version 1.1
 */
public class Normal implements YuTubeStrategy {
	
	/**
	 * Costo para todos lo que contraten YuTube Normal
	 */
	private double costo = 0;
	
	/**
	 * Notificaciones para los que contraten YuTube Normal
	 */
	private final String[] notificaciones = {"No se pierda los directos de" +
		" sus YuTubers favoritos", "Contrate YuTube Premium para disfrutar" +
		" sus videos sin anuncios", "Nuevo video de \"Hello Plata\"", 
		"\"Marquiplir\" esta transmitiendo en vivo, en YuTube", "Canal de" +
		" YuTube recomendado para usted, \"Nova BPS\"", "Compre productos" +
		" Liberpul. Traido por YuTube"};
	 
	/**
	 * Implementa cobrar de YuTubeStrategy
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
	 * Implementa sePuedeCobrar de YuTubenStrategy
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
	 * YuTube Normal
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
	
}
