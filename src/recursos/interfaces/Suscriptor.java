package recursos.interfaces;

public interface Suscriptor {

	public abstract String iniciarSuscripcion(Servicio ser);
	
	public abstract void renovarSuscripcion(Servicio ser);
	
	public abstract String terminarSuscripcion(Servicio ser);
	
	public abstract void recibirNotificaciones(String str);

	public abstract String obtenerNombre();
	
	public abstract double obtenerDinero();
	
	public abstract void asignarDinero(double dinero);
}
