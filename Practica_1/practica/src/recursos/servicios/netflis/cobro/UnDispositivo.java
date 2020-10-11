package recursos.servicios.netflis.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.netflis.NetflisStrategy;

/**
 * Clase que implementa NetflisStrategy para los que contratan Netflis para un 
 * dispositivo
 * @author Raul Nunio
 * @version 1.1
 */
public class UnDispositivo implements NetflisStrategy {
	
	/**
	 * Costo para todos lo que contraten Netflis un dispositivo
	 */
	private double costo = 7;
	
	/**
	 * Notificaciones para los que contraten Netflis un dispositivo
	 */
	public String[] notificaciones = {"Ahora puedes ver \"Cuando lloran\"" +
		" en Netflis", "No te pierdas la quinta temporada de \"Muchas" +
		" razones porque\" en Netflis", "Ve el ultimo episodio de \"Casa de" + 
		" carton\" en Netflis", "La pelicula \"Buscando a Lunes\" ya esta" +
		" disponible en Netflis", "Conoce la historia de \"Claus\" solo aqui," +
		" en Netflis", "Ve Netflis en mas de un dispositivo, contrata Netflis" +
		" para cuatro dispositivos"};
	
	/**
	 * Implementa cobrar de NetflisStrategy
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
	 * Implementa sePuedeCobrar de NetflisStrategy
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
	 * Netflis para un dispositivo
	 * @return El arreglo con String
	 */
	@Override
	public String[] obtenerNotificaciones(){
		return notificaciones;
	}
}
