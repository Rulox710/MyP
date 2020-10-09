package recursos.suscriptores;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;
import recursos.servicios.MetodoPago;

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
	public boolean iniciarSuscripcion(Servicio ser, MetodoPago mp){
		Contrato con = new Contrato(ser, this, mp);
		servicios.add(con);
		return ser.agregarSuscriptor(con);
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
