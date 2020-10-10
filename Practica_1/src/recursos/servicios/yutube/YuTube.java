package recursos.servicios.yutube;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.yutube.cobro.Normal;
import recursos.servicios.yutube.cobro.Premium;

import java.util.ArrayList;

public class YuTube extends ServicioGeneral {
	
	public YuTube() {
		nombreSer = "YuTube";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
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

	public void notificar() {
		
	}
	
	private YuTubeStrategy determinarEstrategia(Contrato con) {
		if(con.obtenerTipo() == 0) return new Normal();
		if(con.obtenerTipo() == 1) return new Premium();
		return null; 
	}
}
