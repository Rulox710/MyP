package recursos.servicios;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;

import java.util.ArrayList;

/**
 * Clase abstracta que implementa Servicio
 * @author Raul Nunio
 * @version 1.1
 */
public abstract class ServicioGeneral implements Servicio {
	
	/**
	 * String con el nombre del Servicio
	 */
	protected String nombreSer;
	
	/**
	 * ArrayList con los Contratos de los que se han unido y estan unidos al 
	 * Servicio
	 */
	protected ArrayList<Contrato> directorioPermanente;
	/**
	 * ArrayList con los Contratos de los que estan unidos al Servici 
	 * actualmente
	 */
	protected ArrayList<Contrato> directorioActual;
	
	/**
	 * Metodo para agregar a un Suscriptor al Servicio
	 * @param con El contrato
	 * @return <code>true<\code> si se ha unido, false si no
	 */
	@Override
	public abstract boolean agregarSuscriptor(Contrato con);
	
	/**
	 * Metodo auxiliar para agregar un nuevo Suscriptor al Servicio
	 * @param con El contrato
	 * @return true si se ha agragado, false si no 
	 */
	protected boolean agregarNuevo(Contrato con) {
		if(directorioActual.indexOf(con) != -1) return false;
		directorioActual.add(con);
		return true;
	}
	
	/**
	 * Metodo para revisar si un Suscriptor ya habia estado en el Servicio
	 * @param con El contrato
	 * @return true si ya lo habia contratado alguna vez, false si no
	 */
	protected boolean revisarPermanencia(Contrato con) {
		boolean verdad = (directorioPermanente.indexOf(con) == -1)? false: true;
		if(!verdad) directorioPermanente.add(con);
		return verdad;
	}
	
	/**
	 * Metodo para combiar el tipo de Suscripcion de un Suscriptor
	 * @param con El contrato
	 * @param i Un valor que representa el tipo de suscripcion a cambiar
	 * @return true si se ha cambiado el tipo, false si no
	 */
	@Override 
	public boolean cambiarSuscriptor(Contrato con, int i) {
		directorioActual.get(directorioActual.indexOf(con)).asignarTipo(i);
		
		return true;
	}
	
	/**
	 * Metodo para eliminar a un Suscriptor del Servico
	 * @param con El contrato
	 * @return true si se elimino, false si no
	 */
	@Override
	public boolean eliminarSuscriptor(Contrato con) {
		boolean valor = quitarSub(con);
		String mensaje;
		if(valor){
			mensaje = "Ya no cuenta con " + nombreSer + ", " +
				con.obtenerCliente().obtenerNombre() + ". Vuelva pronto";
		} else {
			mensaje = "No contaba con " + nombreSer + " 7_7";
		}
		System.out.println(mensaje);
		return valor;
	}
	
	/**
	 * Metod auxiliar para returar a un Contrato del ArrayLista de miembros 
	 * actuales
	 * @param con El Contrato
	 * @return true si se ha eliminado, false si no
	 */
	protected boolean quitarSub(Contrato con) {
		int valor = directorioActual.indexOf(con);
		if(valor==-1) return false;
		directorioActual.remove(valor);
		return true;
	}
	
	/**
	 * Metodo para cobrar a todos los miembros actuales del servicio. Si no 
	 * pueden pagar, se comporta de cierta manera dependiendo de la clase que le
	 * extienda
	 */
	@Override
	public abstract void pago();
	
	/**
	 * Metodo para notificar a los Suscriptores de informacion acerca del 
	 * Servicio
	 */
	@Override
	public abstract void notificar();
	
	/**
	 * Metodo para borrar ambos ArrayList 
	 */
	public void reiniciar() {
		directorioActual.clear();
		directorioPermanente.clear();
	}
	
	/**
	 * Metodo para comprobar si un ServicioGeneral es igual a un Objeto en 
	 * cuanto a su nombre
	 * @return true si son iguales, false si no
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ServicioGeneral)) return false;
		ServicioGeneral ser = (ServicioGeneral)obj;
		return (nombreSer.equals(ser.nombreSer));
	}
}
