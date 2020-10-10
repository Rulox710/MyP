package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;
import recursos.servicios.hammazon.HammazonStrategy;

public class Normal implements HammazonStrategy{
	
	private double costo = 7;
	
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}

	private String[] notificaciones = {"Contrata un mejor plan, contrata" +
		"Hammazon Premium", ""};
	
	
}
