package recursos.servicios.twitsh;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.twitsh.cobro.Normal;
import recursos.servicios.twitsh.cobro.Premium;

import java.util.ArrayList;

public class Twitsh extends ServicioGeneral {
	
	public Twitsh() {
		nombreSer = "Twitsh";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
	public boolean agregarSuscriptor(Contrato con){
	String mensaje;
		boolean valor = false;
		Suscriptor s = con.obtenerCliente();
		TwitshStrategy est = determinarEstrategia(con);

		if(est.sePuedeCobrar(con)){
			if(agregarNuevo(con)){
				valor = true;
				if(revisarPermanencia(con)){
					mensaje = "Bienvenido de vuelta, " +
						s.obtenerNombre() + ", a Twitsh";
				} else {
					mensaje = "Bienvenido a Twitsh, " + 
						s.obtenerNombre();
				}
			} else {
				mensaje = "Ya cuenta con el servicio de Twitsh";
			}
		} else {
			mensaje = "No cuenta con el fondo necesario para" +
				" contratar el servicio unu";
		}
		System.out.println(mensaje);
		return valor;
	}
	
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
			eliminarSuscriptor(sub);
		}
	}

	public void notificar() {
		
	}
	
	private TwitshStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new Normal();
		if(con.obtenerTipo() == 1) return new Premium();
		return null; 
	}
}
