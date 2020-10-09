package recursos.servicios.spootify;

import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;
import recursos.servicios.ServicioGeneral;

public class SpootifyPremium extends ServicioGeneral{
	
	private final double costo = 4;
	
	public SpootifyPremium() {
		super("SpootifyPremium");
	}
	
	public String cobrar(Suscriptor sub) {
		if(sePuedeCobrar(sub)) {
			sub.asignarDinero(sub.obtenerDinero() - costo);
		} else {
			return quitarSub(sub);
		}
		return "Se ha renovado su suscripcion en " + nombreSer + ", " + sub.obtenerNombre();
	}
	
	protected boolean sePuedeCobrar(Suscriptor sub) {
		return(sub.obtenerDinero() >= costo)? true: false;
	}
	
	public String notificar() {
		return "casa";
	}
}
