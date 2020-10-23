package robot.estados;

import escritura.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>Caminando</code>
 */
public class Trabajando implements EstadoRobot {

	/**
	 * El <code>Robot</code> que tiene este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor que toma al <code>Robot</code>
	 */
	public Trabajando(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo que hace que el <code>Robot</code> entre en estado 
	 * <code>Suspendido</code>. No hace nada en este estado
	 */
	public void suspender() {
		System.out.println("Estoy trabajando");
	}
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Activado</code>. No hace nada en este estado
	 */
	public void activar() {
		System.out.println("Ya estoy activado");
	}
	
	/**
	 * Metodo con el cual toma la orden el <code>Robot</code>, cambiando al 
	 * estado <code>RecibiendoOrden</code>. No hace nada en este estado
	 */
	public void tomarOrden() {
		System.out.println("Ya he tomado una orden");
	}
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar.
	 */
	public void trabajar() {
		System.out.println("Trabajando muy duro, como un esclavo");
		robot.obtenerCasa().construccion();
		robot.casaLista(robot.obtenerCasa());
		robot.asignarMaterial(false);
		robot.asignarCasa(null);
		robot.cambiarEstado(new Caminando(robot));
	}
	
	/**
	 * Metodo para que el <code>Robot</code> reuna los materiales para construir 
	 * una <code>Casa</code>. No hace nada en este estado
	 */
	public void reabastecer() {
		System.out.println("No tengo necesidad de reabastecer.");
	}
	
	/**
	 * Metodo para obtener el nombre del estado
	 * @return Cadena para obtener el nombre del estado en forma de cadena
	 */
	public String obtenerEstado() {
		return "Trabajando";
	}
}
