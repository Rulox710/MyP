package recursos.suscriptores;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

import java.util.ArrayList;

public class Persona implements Suscriptor{
	private String nombre;
	private double dinero;
	private ArrayList<Contrato> servicios;
	private ArrayList<String> notificaciones;
	
	public Persona(String nombre, double dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		servicios = new ArrayList<Contrato>();
		notificaciones = new ArrayList<String>();
	}
	
	@Override
	public boolean iniciarSuscripcion(Servicio ser, int i) {
		Contrato con = new Contrato(ser, this, i);
		servicios.add(con);
		return ser.agregarSuscriptor(con);
	}
	
	@Override
	public boolean cambiarSuscripcion(Servicio ser, int i) {
		Contrato con = new Contrato (ser, this);
		int j = servicios.indexOf(con);
		if(j == -1 || servicios.get(j).obtenerTipo() == i) return false;
		servicios.get(j).asignarTipo(i);
		return ser.cambiarSuscriptor(con, i);
	}
	
	@Override
	public boolean terminarSuscripcion(Servicio ser) {
		Contrato con = new Contrato (ser, this);
		notificaciones.clear();
		boolean m = ser.eliminarSuscriptor(con);
		servicios.remove(servicios.indexOf(con));
		return m;
	}
	
	@Override
	public void recibirNotificaciones(){
		
	}
	
	public ArrayList<String> verNotificaciones() {
		return notificaciones;
	}
	
	@Override
	public String obtenerNombre() {
		return nombre;
	}

	@Override
	public double obtenerDinero() {
		return dinero;
	}
	
	@Override
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
