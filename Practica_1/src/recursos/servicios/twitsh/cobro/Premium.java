package recursos.servicios.twitsh.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.twitsh.TwitshStrategy;

public class Premium implements TwitshStrategy {
	
	private double costo = 10;
	
	public void cobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		s.asignarDinero(s.obtenerDinero() - costo);
	}
	
	public boolean sePuedeCobrar(Contrato con) {
		Suscriptor s = con.obtenerCliente();
		return(s.obtenerDinero() >= costo)? true: false;
	}	
}
