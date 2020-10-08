package recursos.interfaces;

public interface Servicio {

	public abstract String agregarSub(Suscriptor sub);

	public abstract String quitarSub(Suscriptor sub);
	
	//public abstract boolean sePuedeCobrar(Suscriptor sub);
		
	public abstract String cobrar(Suscriptor sub);
	
	public abstract String notificar();
	
}
