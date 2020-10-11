package recursos.servicios;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;

import java.util.ArrayList;

/**
 * Clase abstracta que implementa <code>Servicio</code>
 * @author Raul Nunio
 * @version 1.2
 */
public abstract class ServicioGeneral implements Servicio {
	
	/**
	 * String con el nombre del <code>Servicio</code>
	 */
	protected String nombreSer;
	
	/**
	 * ArrayList con los <code>Contratos</code> de los que se han unido y estan 
	 * unidos al <code>Servicio</code>
	 */
	protected ArrayList<Contrato> directorioPermanente;
	
	/**
	 * <code>ArrayList</code> con los <code>Contratos</code> de los que estan 
	 * unidos al <code>Servicio</code> actualmente
	 */
	protected ArrayList<Contrato> directorioActual;
	
	/**
	 * Metodo para agregar a un <code>Suscriptor</code> al <code>Servicio</code>
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si se ha unido, <code>false</code> si no
	 */
	@Override
	public abstract boolean agregarSuscriptor(Contrato con);
	
	/**
	 * Metodo auxiliar para agregar un nuevo <code>Suscriptor</code> al 
	 * <code>Servicio</code>
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si se ha agragado, <code>false</code> si no 
	 */
	protected boolean agregarNuevo(Contrato con) {
		if(directorioActual.indexOf(con) != -1) return false;
		directorioActual.add(con);
		return true;
	}
	
	/**
	 * Metodo auxiliar de <code>revisarPermanencia()</code>
	 * @param con El <code>Contrato</code> a buscar
	 * @return <code>true</code> si habia estado suscrito, <code>false</code> si
	 * no 
	 */
	protected boolean rePerAux(Contrato con){
		return(directorioPermanente.indexOf(con) == -1)? false: true;
	}
	
	/**
	 * Metodo para revisar si un <code>Suscriptor</code> ya habia estado en el 
	 * <code>Servicio</code>
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si ya lo habia contratado alguna vez, 
	 * <code>false</code> si no
	 */
	protected boolean revisarPermanencia(Contrato con) {
		boolean verdad = rePerAux(con);
		if(!verdad) directorioPermanente.add(con);
		return verdad;
	}
	
	/**
	 * Metodo para cambiar el tipo de suscripcion de un <code>Suscriptor</code>
	 * @param con El <code>Contrato</code>
	 * @param i Un valor que representa el tipo de suscripcion a cambiar
	 * @return <code>true</code>
	 */
	@Override 
	public boolean cambiarSuscriptor(Contrato con, int i) {
		directorioActual.get(directorioActual.indexOf(con)).asignarTipo(i);
		con.obtenerCliente().recibirNotificaciones("Se ha cambiado el tipo" + 
		" de suscripcion de " + nombreSer);
		return true;
	}
	
	/**
	 * Metodo para eliminar a un <code>Suscriptor</code> del 
	 * <code>Servico</code>
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si se elimino, <code>false</code> si no
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
		con.obtenerCliente().recibirNotificaciones(mensaje);
		return valor;
	}
	
	/**
	 * Metod auxiliar para retirar a un <code>Contrato</code> del 
	 * <code>ArrayList</code> de miembros actuales
	 * @param con El <code>Contrato</code>
	 * @return <code>true</code> si se ha eliminado, <code>false</code> si no
	 */
	protected boolean quitarSub(Contrato con) {
		int valor = directorioActual.indexOf(con);
		if(valor==-1) return false;
		directorioActual.remove(valor);
		return true;
	}
	
	/**
	 * Metodo para cobrar a todos los miembros actuales del 
	 * <code>Servicio</code>. 
	 * Si no pueden pagar, se comporta de cierta manera dependiendo de la clase 
	 * que le extienda
	 */
	@Override
	public abstract void pago();
	
	/**
	 * Metodo para notificar a los suscriptores de informacion acerca del 
	 * <code>Servicio</code>
	 */
	@Override
	public abstract void notificar();
	
	/**
	 * Metodo para borrar ambos <code>ArrayList</code> 
	 */
	public void reiniciar() {
		directorioActual.clear();
		directorioPermanente.clear();
	}
	
	/**
	 * Metodo para comprobar si un <code>ServicioGeneral</code> es igual a un 
	 * <code>Objeto</code> en cuanto a su nombre
	 * @return <code>true</code> si son iguales, <code>false</code> si no
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ServicioGeneral)) return false;
		ServicioGeneral ser = (ServicioGeneral)obj;
		return (nombreSer.equals(ser.nombreSer));
	}
}
