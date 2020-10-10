package recursos.servicios.yutube.cobro;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.servicios.yutube.YuTubeStrategy;

public class Normal implements YuTubeStrategy {
	
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
