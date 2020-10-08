package recursos.suscriptores;

import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

import java.util.ArrayList;

public class Persona implements Suscriptor{
	private String nombre;
	private double dinero;
	private ArrayList<String> notificaciones;
	
	public Persona(String nombre, double dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		notificaciones = new ArrayList<String>();
	}
	
	public String iniciarSuscripcion(Servicio ser){
		return ser.agregarSub(this);
	}
	
	public void renovarSuscripcion(Servicio ser){
		ser.cobrar(this);
		notificaciones.clear();
	}
	
	public String terminarSuscripcion(Servicio ser) {
		notificaciones.clear();
		String m = ser.quitarSub(this);
		return m;
	}
	
	public ArrayList<String> verNotificaciones() {
		return notificaciones;
	}
	
	public void recibirNotificaciones(String str){
		notificaciones.add(str);
	}
	
	public String obtenerNombre() {
		return nombre;
	}

	public double obtenerDinero() {
		return dinero;
	}
	
	public void asignarDinero(double dinero) {
		this.dinero = dinero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Persona)) return false;
		Persona per = (Persona)obj;
		return (nombre.equals(per.nombre));
	}
}
