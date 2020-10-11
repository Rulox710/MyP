package recursos.suscriptores;

import recursos.Contrato;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

import java.util.ArrayList;

/**
 * Clase que implementa <code>Suscriptor</code>
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
	 * @param nombre Un <code>String</code> con el <code>nombre</code> de la 
	 * <code>Persona</code>
	 * @param dinero Los fondos de la <code>Persona</code>
	 */
	public Persona(String nombre, double dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		servicios = new ArrayList<Contrato>();
		notificaciones = new ArrayList<String>();
	}
	
	/**
	 * Metodo que comienza la suscripcionde la <code>Persona</code> con un 
	 * <code>Servicio</code>
	 * @param ser El <code>Servicio</code> a contratar
	 * @param i Un valor que representa el <code>tipo</code> de suscripcion
	 * @return <code>true</code> si se inicio, <code>false</code> si no
	 */
	@Override
	public boolean iniciarSuscripcion(Servicio ser, int i) {
		Contrato con = new Contrato(ser, this, i);
		Contrato cons = new Contrato(ser, this);
		servicios.add(cons);
		return ser.agregarSuscriptor(con);
	}
	
	/**
	 * Metodo para cambiar el <code>tipo</code> de suscripcion de la 
	 * <code>Persona</code>
	 * @param ser El <code>Servicio</code> de que se cambiara el 
	 * <code>tipo</code> de suscripcion
	 * @param i Un valor que representa el <code>tipo</code> de suscripcion
	 * @return <code>true</code> si se ha cambiado, <code>false</code> si no
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
	 * Metodo para terminar la suscripcion de la <code>Persona</code> con algun 
	 * <code>Servicio</code>
	 * @param ser El <code>Servicio</code> a terminar
	 * @return <code>true</code> si se ha terminado, <code>false</code> si no 
	 */
	@Override
	public boolean terminarSuscripcion(Servicio ser) {
		Contrato con = new Contrato (ser, this);
		boolean m = ser.eliminarSuscriptor(con);
		if(m == true)servicios.remove(servicios.indexOf(con));
		return m;
	}
	
	/**
	 * Metodo para recibir las <code>notificaciones</code> de los servicios contratados
	 * @param str Un <code>String</code> con informacion de algun 
	 * <code>Servicio</code>
	 */
	@Override
	public void recibirNotificaciones(String str){
		notificaciones.add(str);
	}
	
	/**
	 * Metodo para obtener el <code>ArrayList</code> con las 
	 * <code>notificaciones</code> de los servicios que contrato la 
	 * <code>Persona</code>
	 * @return Un <code>ArrayList</code> con <code>String</code>
	 */
	public ArrayList<String> verNotificaciones() {
		ArrayList<String> str = new ArrayList<String>(notificaciones);
		notificaciones.clear();
		return str;
	}
	
	/**
	 * Metodo para obtener el <code>nombre</code> de la <code>Persona</code>
	 * @return El <code>nombre</code> de la <code>Persona</code>
	 */
	@Override
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Metodo para obtener los fondos de la <code>Persona</code>
	 * @return Los fondos de la <code>Persona</code>
	 */
	@Override
	public double obtenerDinero() {
		return dinero;
	}
	
	/**
	 * Metodo para asignar los fondos de la <code>Persona</code>
	 * @param dinero El nuevo fondo de la <code>Persona</code>
	 */
	@Override
	public void asignarDinero(double dinero) {
		this.dinero = dinero;
	}
	
	/**
	 * Metodo que compara una <code>Persona</code> con un <code>Objeto</code>
	 * @param obj Un <code>Objeto</code>
	 * @return <code>true</code> si son iguales en cuanto <code>nombre</code>, 
	 * <code>false</code> si no  
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Persona)) return false;
		Persona per = (Persona)obj;
		return (nombre.equals(per.nombre));
	}
}
