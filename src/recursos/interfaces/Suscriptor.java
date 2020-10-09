package recursos.interfaces;

import recursos.servicios.MetodoPago;

public interface Suscriptor {

	public abstract boolean iniciarSuscripcion(Servicio ser, MetodoPago mp);
	
	public abstract boolean terminarSuscripcion(Servicio ser);
	
	public abstract void recibirNotificaciones();
	
	public abstract String obtenerNombre();

	public abstract double obtenerDinero();
	
	public abstract void asignarDinero(double dinero);
	
	public abstract boolean equals(Object obj);

}
