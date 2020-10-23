package robot;

import casa.Casa;

/**
 * Interfaz que modela los posibles estados de <code>Robot<\code>
 */
public interface EstadoRobot {
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Suspendido</code>
	 */
	public abstract void suspender();
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Activado</code>
	 */
	public abstract void activar();
	
	/**
	 * Metodo con el cual toma la orden el <code>Robot</code>
	 */
	public abstract void tomarOrden();
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar
	 */
	public abstract void trabajar();
	
	/**
	 * Metodo para que el <code>Robot</code> reuna los materiales para construir 
	 * una <code>Casa</code>
	 */
	public abstract void reabastecer();
	
	/**
	 * Metodo que devuelve una cadena con el nombre del estado
	 * @return Cadena con el nombre del estado actual
	 */
	public abstract String obtenerEstado();
	
}
