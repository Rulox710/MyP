package recursos.suscriptores;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

import java.util.ArrayList;

/**
 * Clase que implementa Suscriptor
 * @author Raul Nunio
 * @version 1.1
 */
public class Persona implements Suscriptor{
	private String nombre;
	private double dinero;
	private ArrayList<Contrato> servicios;
	private ArrayList<String> notificaciones;
	
	/**
	 * Constructor de la clase
	 * @param nombre Un String con el nombre de la Persona
	 * @param dinero Los fondos de la Persona 
	 */
	public Persona(String nombre, double dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		servicios = new ArrayList<Contrato>();
		notificaciones = new ArrayList<String>();
	}
	
	/**
	 * Metodo que comienza la suscripcionde la Persona con un Servicio
	 * @param ser El servicio a contratar
	 * @param i Un valor que representa el tipo de suscripcion
	 * @return true si se inicio, false si no
	 */
	@Override
	public boolean iniciarSuscripcion(Servicio ser, int i) {
		Contrato con = new Contrato(ser, this, i);
		servicios.add(con);
		return ser.agregarSuscriptor(con);
	}
	
	/**
	 * Metodo para cambiar el tipo de suscripcion de la Persona
	 * @param ser El SErvicio de que se cambiara el tipo de suscripcion
	 * @param i Un valor que representa el tipo de suscripcion
	 * @return true si se ha cambiado, false si no
	 */
	@Override
	public boolean cambiarSuscripcion(Servicio ser, int i) {
		Contrato con = new Contrato (ser, this);
		int j = servicios.indexOf(con);
		if(j == -1 || servicios.get(j).obtenerTipo() == i) return false;
		servicios.get(j).asignarTipo(i);
		return ser.cambiarSuscriptor(con, i);
	}
	
	/**
	 * Metodo para terminar la suscripcion de la Persona con algun Servicio
	 * @param ser El servicio a terminar
	 * @return true si se ha terminado, false si no 
	 */
	@Override
	public boolean terminarSuscripcion(Servicio ser) {
		Contrato con = new Contrato (ser, this);
		notificaciones.clear();
		boolean m = ser.eliminarSuscriptor(con);
		servicios.remove(servicios.indexOf(con));
		return m;
	}
	
	/**
	 * Metodo para recibir las notificaciones de los Servicios contratados
	 */
	@Override
	public void recibirNotificaciones(){
		
	}
	
	/**
	 * Metodo para obtener el ArrayList con las notificaciones de los Servicios 
	 * que contrato la Persona
	 * @return Un ArrayList con String
	 */
	public ArrayList<String> verNotificaciones() {
		return notificaciones;
	}
	
	/**
	 * Metodo para obtener el nombre de la Persona
	 * @return El nombre de la Persona 
	 */
	@Override
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Metodo para obtener los fondos de la Persona 
	 * @return Los fondos de la persona
	 */
	@Override
	public double obtenerDinero() {
		return dinero;
	}
	
	/**
	 * Metodo para asignar los fondos de la Persona
	 * @param El nuevo fondo de la persona
	 */
	@Override
	public void asignarDinero(double dinero) {
		this.dinero = dinero;
	}
	
	/**
	 * Metodo que compara una <code>Persona</code> con un <code>Objeto</code>
	 * @param obj Un <code>Objeto</code>
	 * @return true si son iguales en cuanto nombre, false si no  
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Persona)) return false;
		Persona per = (Persona)obj;
		return (nombre.equals(per.nombre));
	}
}
