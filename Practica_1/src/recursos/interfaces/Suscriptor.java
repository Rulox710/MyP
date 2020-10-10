package recursos.interfaces;

public interface Suscriptor {

	public abstract boolean iniciarSuscripcion(Servicio ser, int i);
	
	public abstract boolean cambiarSuscripcion(Servicio ser, int i);
	
	public abstract boolean terminarSuscripcion(Servicio ser);
	
	public abstract void recibirNotificaciones();
	
	public abstract String obtenerNombre();

	public abstract double obtenerDinero();
	
	public abstract void asignarDinero(double dinero);
	
	public abstract boolean equals(Object obj);

}
