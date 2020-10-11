package recursos.servicios.yutube;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.yutube.cobro.Normal;
import recursos.servicios.yutube.cobro.Premium;

import java.util.ArrayList;

/**
 * Esta clase modela el comportamiento que tendra el <code>Servicio</code> de
 * <code>YuTube</code>
 * @author Raul Nunio
 * @version 1.2
 */
public class YuTube extends ServicioGeneral {
	
	/**
     * Constructor para la clase. Sus <code>ArrayList</code> inician vacios y 
     * su nombre será <code>YuTube</code>
     */
	public YuTube() {
		nombreSer = "YuTube";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
	/**
	 * Metodo para agregar a un <code>Contrato</code> a los 
	 * <code>ArrayList</code> de para bindar el <code>Servicio</code> a un 
	 * <code>Suscriptor</code>. Si el <code>Suscriptor</code> ya tenia el 
	 * <code>Servicio</code>, no se permite. Si el <code>Suscriptor</code> no 
	 * puede pagar la suscripcion, no se permite
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si se permite la suscripcion, 
	 * <code>false</code> si no
	 */
	@Override
	public boolean agregarSuscriptor(Contrato con){
		String mensaje;
		boolean valor = false;
		Suscriptor s = con.obtenerCliente();
		YuTubeStrategy est = determinarEstrategia(con);
		if(rePerAux(con)) con.noEsPrimer();
		
		if(est.sePuedeCobrar(con)){
			if(agregarNuevo(con)){
				valor = true;
				if(revisarPermanencia(con)){
					mensaje = "Bienvenido de vuelta, " +
						s.obtenerNombre() + ", a " + nombreSer;
				} else {
					mensaje = "Bienvenido a " + nombreSer + ", " + 
						s.obtenerNombre();
				}
			} else {
				mensaje = "Ya cuenta con el servicio de " + nombreSer;
			}
		} else {
			mensaje = "No cuenta con el fondo necesario para" +
				" contratar Yutube Premium unu";
		}
		s.recibirNotificaciones(mensaje);
		return valor;
	}
	
	/**
	 * Metodo para cobrar a todos los suscriptores que tengan el 
	 * <code>Servicio</code>. Si no pueden pagar, el contrato cambia a una 
	 * estrategia de pago acorde a su presupuesto
	 */
	@Override
	public void pago() {
		ArrayList<Contrato> ubicacion = new ArrayList<Contrato>();
		for(Contrato con: directorioActual) {
			if(determinarEstrategia(con).sePuedeCobrar(con)) {
				determinarEstrategia(con).cobrar(con);
			} else {
				ubicacion.add(con);
			}
		}
		for(Contrato sub: ubicacion) {
			sub.obtenerCliente().cambiarSuscripcion(sub.obtenerServicio(),0);
			sub.obtenerCliente().recibirNotificaciones("Su cuenta se ha" +
				" cambiado a YuTube Gratis. Recargue su cuenta y vuelva a" +
				" contratar YuTube Premium si asi lo desea");
		}
	}

	/**
	 * Metodo para notificar a todos los suscriptores de actividades del 
	 * <code>Servicio</code>
	 */
	@Override
	public void notificar() {
		for(Contrato con: directorioActual) {
			String[] not = determinarEstrategia(con).obtenerNotificaciones();
			int i = (int)Math.floor(Math.random() * (not.length));
			con.obtenerCliente().recibirNotificaciones(not[i]);
		}
	}
	
	/**
	 * Metodo para determinar la estrategia que se usara con determinado 
	 * <code>Suscriptor</code>
	 * @param con El <code>Contrato</code> del <code>Sucriptor</code> con el 
	 * <code>Servicio</code>
	 */
	private YuTubeStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new Normal();
		if(con.obtenerTipo() == 1) return new Premium();
		return null; 
	}
}
