package recursos.servicios.yutube.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.yutube.YuTubeStrategy;

/**
 * Clase que implementa YuTubeStrategy para los que contratan YuTube Premium
 * @author Raul Nunio
 * @version 1.1
 */
public class Premium implements YuTubeStrategy {
	
	/**
	 * Costo para todos lo que contraten YuTube Premium
	 */
	private double costo = 6;
	
	/**
	 * Notificaciones para los que contraten YuTube Premium
	 */
	 private final String[] notificaciones = {"No se pierda los directos de" +
		" sus YuTubers favoritos", "Nuevo episodio de \"Impulso\", original" +
		" de  YuTube ", "Nuevo video de \"Hello Plata\"", "\"Marquiplir\"" + 
		" esta transmitiendo en vivo, en YuTube", "Canal de YuTube" +
		" recomendado para usted, \"Nova BPS\"", "Compre productos" +
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
	 * Implementa sePuedeCobrar de YuTubeStrategy
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
	 * YuTube Premium
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
	
}
