package robot.estados;

import utilidad.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>Reabasteciendo</code>
 */
public class Reabasteciendo implements EstadoRobot {

	/**
	 * El <code>Robot</code> que tiene este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor que toma al <code>Robot</code>
	 */
	public Reabasteciendo(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo que hace que el <code>Robot</code> entre en estado 
	 * <code>Suspendido</code>. No hace nada en este estado
	 */
	public void suspender() {
		System.out.println("Estoy en el area de reabastecimiento, no me puedo" +
			" suspender,\n");
	}
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Activado</code>. No hace nada en este estado
	 */
	public void activar() {
		System.out.println("Ya estoy activado, no necesita activarme de nuevo" +
		"\n");
	}
	
	/**
	 * Metodo con el cual toma la orden el <code>Robot</code>, cambiando al 
	 * estado <code>RecibiendoOrden</code>. No hace nada en este estado
	 */
	public void tomarOrden() {
		System.out.println("Ya he tomado una orden\n");
	}
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar.
	 */
	public void trabajar() {
		System.out.println("No es el lugar indicado para contruir\n");
	}
	
	/**
	 * Metodo para que el <code>Robot</code> reuna los materiales para construir 
	 * una <code>Casa</code>. No hace nada en este estado
	 */
	public void reabastecer() {
		if(robot.obtenerMaerial()){
			System.out.println("Ya tengo material, asi que ire a trabajar\n");
		} else {
			System.out.println("Recolectando materiales. Ahora ire a trabaja" +
			"r\n");
			robot.asignarMaterial(true);
		}
		robot.cambiarEstado(new Caminando(robot));
	}
	
	/**
	 * Metodo para obtener el nombre del estado
	 * @return Cadena para obtener el nombre del estado en forma de cadena
	 */
	public String obtenerEstado() {
		return "Reabasteciendo";
	}
}
