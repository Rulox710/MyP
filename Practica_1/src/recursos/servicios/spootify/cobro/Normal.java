package recursos.servicios.spootify.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.spootify.SpootifyStrategy;

public class Normal implements SpootifyStrategy {
	
	private double costo = 0;
	
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}	
}
