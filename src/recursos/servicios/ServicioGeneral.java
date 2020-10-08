package recursos.servicios;

import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;

import java.util.ArrayList;

public abstract class ServicioGeneral implements Servicio {
	
	protected String nombreSer;
	
	protected ArrayList<Suscriptor> directorioPermanente;
	protected ArrayList<Suscriptor> directorioActual;
	
	public ServicioGeneral(String nombreSer) {
		this.nombreSer = nombreSer;
		directorioPermanente = new ArrayList<Suscriptor>();
		directorioActual = new ArrayList<Suscriptor>();
	}
	
	public String agregarSub(Suscriptor sub) {
		String mensaje = "";
		if(sePuedeCobrar(sub)){
			if(agregarNuevo(sub)){
				if(revisarPermanencia(sub)){
					mensaje += "Bienvenido de vuelta, " + sub.obtenerNombre() + ", a " + nombreSer;
				} else {
					mensaje += "Bienvenido a " + nombreSer + ", " + sub.obtenerNombre();
				}
			} else {
				mensaje += "Ya cuenta con el servicio de " + nombreSer;
			}
		} else {
			mensaje += "No cuenta con el fondo necesario para contratar el servicio unu";
		}
		return mensaje;
	}
	
	protected boolean agregarNuevo(Suscriptor sub) {
		if(directorioActual.indexOf(sub)==-1) return false;
		directorioActual.add(sub);
		return true;
	}
	
	protected boolean revisarPermanencia(Suscriptor sub) {
		return (directorioPermanente.indexOf(sub)==-1)? false: true;
	}
	
	public String quitarSub(Suscriptor sub) {
		boolean valor = quitarSubAux(sub);
		String mensaje = "";
		if(valor){
			mensaje += "Ya no cuenta con " + nombreSer + ". Vuelva pronto";
		} else {
			mensaje += "No contaba con " + nombreSer + " 7_7";
		}
		return mensaje;
	}
	
	protected boolean quitarSubAux(Suscriptor sub) {
		int valor = directorioActual.indexOf(sub);
		if(valor==-1) return false;
		directorioActual.remove(valor);
		return true;
	}
	
	public abstract String cobrar(Suscriptor sub);

	protected abstract boolean sePuedeCobrar(Suscriptor sub);
	
	public abstract String notificar();
	
	public void reiniciar() {
		directorioActual.clear();
		directorioPermanente.clear();
	}
}
