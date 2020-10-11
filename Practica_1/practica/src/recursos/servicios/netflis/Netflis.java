package recursos.servicios.netflis;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.netflis.cobro.UnDispositivo;
import recursos.servicios.netflis.cobro.DosDispositivos;
import recursos.servicios.netflis.cobro.CuatroDispositivos;

import java.util.ArrayList;

/**
 * Esta clase modela el comportamiento que tendra el servicio Netflis
 * @author Raul Nunio
 * @version 1.2
 */
public class Netflis extends ServicioGeneral {
	
	/**
     * Constructor para la clase. Sus ArrayList inician vacios y su nombre será 
     * Netflis
     */
	public Netflis() {
		nombreSer = "Netflis";
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
		NetflisStrategy est = determinarEstrategia(con);
		if(rePerAux(con)) con.noEsPrimer();

		if(est.sePuedeCobrar(con)){
			if(agregarNuevo(con)){
				valor = true;
				if(revisarPermanencia(con)){
					mensaje = "Bienvenido de vuelta, " +
						s.obtenerNombre() + ", a Netflis";
				} else {
					mensaje = "Bienvenido a Netflis, " + 
						s.obtenerNombre();
				}
			} else {
				mensaje = "Ya cuenta con el servicio de Netflis";
			}
		} else {
			mensaje = "No cuenta con el fondo necesario para" +
				" contratar Netflis unu";
		}
		s.recibirNotificaciones(mensaje);
		return valor;
	}
	
	/**
	 * Metodo para cobrar a todos los Suscriptores que tengan el servicio.
	 * Si no pueden pagar, el contrato termina y se elimina al Suscriptor del
	 * Servicio
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
			sub.obtenerCliente().terminarSuscripcion(sub.obtenerServicio());
		}
	}
	
	/**
	 * Metodo para notificar a todos los Suscriptores de actividades del 
	 * servicio
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
	 * Suscriptor
	 * @param Contrato El contrato del Sscriptor con el Servicio
	 */
	private NetflisStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new UnDispositivo();
		if(con.obtenerTipo() == 1) return new DosDispositivos();
		if(con.obtenerTipo() == 2) return new CuatroDispositivos();
		return null; 
	}
}
