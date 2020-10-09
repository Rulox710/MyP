package recursos.servicios.hammazon;

import recursos.Contrato;
import recursos.servicios.MetodoPago;
import recursos.servicios.ServicioGeneral;

import java.util.ArrayList;

public class Hammazon extends ServicioGeneral {
	
	public Hammazon() {
		nombreSer = "Hammazon";
		directorioPermanente = new ArrayList<Contrato>();
		directorioActual = new ArrayList<Contrato>();
	}
	
	public void pago() {
		ArrayList<Contrato> ubicacion = new ArrayList<Contrato>();
		for(Contrato con: directorioActual) {
			if(con.obtenerTipo().sePuedeCobrar(con)) {
				con.obtenerTipo().cobrar(con);
			} else {
				ubicacion.add(con);
			}
		}
		
		for(Contrato sub: ubicacion)
			eliminarSuscriptor(sub);
	}

	public void notificar() {
		
	}
}
