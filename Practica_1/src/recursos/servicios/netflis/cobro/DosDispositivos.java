package recursos.servicios.netflis.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.netflis.NetflisStrategy;

public class DosDispositivos implements NetflisStrategy {
	
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
