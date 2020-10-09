package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;
import recursos.servicios.MetodoPago;
import recursos.servicios.ServicioGeneral;

public class HammazonPremium implements MetodoPago {
	
	private double costo = 13;
	
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		if(sePuedeCobrar(con)){
			s.asignarDinero(s.obtenerDinero() - costo);
		} else {
			con.obtenerServicio().eliminarSuscriptor(con);
		}
	}
	
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}

}
