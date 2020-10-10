package recursos.servicios.netflis;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.netflis.cobro.UnDispositivo;
import recursos.servicios.netflis.cobro.DosDispositivos;
import recursos.servicios.netflis.cobro.CuatroDispositivos;

import java.util.ArrayList;

public class Netflis extends ServicioGeneral {
	
	public Netflis() {
		nombreSer = "Netflis";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
	public boolean agregarSuscriptor(Contrato con){
	String mensaje;
		boolean valor = false;
		Suscriptor s = con.obtenerCliente();
		NetflisStrategy est = determinarEstrategia(con);

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
	
	private NetflisStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new UnDispositivo();
		if(con.obtenerTipo() == 1) return new DosDispositivos();
		if(con.obtenerTipo() == 2) return new CuatroDispositivos();
		return null; 
	}
}
