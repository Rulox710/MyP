package recursos.servicios.yutube;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.yutube.cobro.Normal;
import recursos.servicios.yutube.cobro.Premium;

import java.util.ArrayList;

/**
 * Esta clase modela el comportamiento que tendra el servicio YuTube
 * @author Raul Nunio
 * @version 1.2
 */
public class YuTube extends ServicioGeneral {
	
	/**
     * Constructor para la clase. Sus ArrayList inician vacios y su nombre será 
     * YuTube
     */
	public YuTube() {
		nombreSer = "YuTube";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
	/**
	 * Metodo para agregar a un Contrato a los ArrayList de para bindar el 
	 * servicio a un Suscriptor. Si el Suscriptor ya tenia el servicio, no se 
	 * permite. Si el suscriptor no puede pagar la suscripcion, no se permite
	 * @param con El Contrato
	 * @return true si se permite la suscripcion, false si no
	 */
	@Override
	public boolean agregarSuscriptor(Contrato con){
	String mensaje;
		boolean valor = false;
		Suscriptor s = con.obtenerCliente();
		YuTubeStrategy est = determinarEstrategia(con);

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
				" contratar el servicio unu";
		}
		System.out.println(mensaje);
		return valor;
	}
	
	/**
	 * Metodo para cobrar a todos los Suscriptores que tengan el servicio.
	 * Si no pueden pagar, el contrato cambia a una estrategia de pago acorde a
	 * su presupuesto
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
			cambiarSuscriptor(sub, 0);
			System.out.println("Su cuenta se ha cambiado a YuTube" +
				" Gratis. Recargue su cuenta y vuelva a contratar" +
				" YuTube Premium si asi lo desea");
		}
	}

	/**
	 * Metodo para notificar a todos los Suscriptores de actividades del 
	 * servicio
	 */
	@Override
	public void notificar() {
		
	}
	
	/**
	 * Metodo para determinar la estrategia que se usara con determinado 
	 * Suscriptor
	 * @param Contrato El contrato del Sscriptor con el Servicio
	 */
	private YuTubeStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new Normal();
		if(con.obtenerTipo() == 1) return new Premium();
		return null; 
	}
}
