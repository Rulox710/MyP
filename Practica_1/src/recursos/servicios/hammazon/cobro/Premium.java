package recursos.servicios.hammazon.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.hammazon.HammazonStrategy;

public class Premium implements HammazonStrategy{
	
	private double costo = 13;
	
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}
	

}
