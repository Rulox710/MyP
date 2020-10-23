package robot.estados;

import escritura.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>Suspendido</code>
 */
public class Suspendido implements EstadoRobot {
	
	/**
	 * El <code>Robot</code> que tiene este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor que toma al <code>Robot</code>
	 */
	public Suspendido(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo que no hace nada, pues el <code>Robot</code> ya esta 
	 * <code>Suspendido</code>
	 */
	public void suspender() {
		System.out.println("No puedo hacer eso. Ya estoy suspendido... 7_7");
	}
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>RecibiendoOrden</code>
	 */
	public void activar() {
		if(robot.obtenerCasa() == null) {
			System.out.println("Voy a activare");
			robot.cambiarEstado(new RecibiendoOrden(robot));
		} else {
			System.out.println("Ya tengo una orden en progreso. Ire a hacerla");
			robot.cambiarEstado(new Caminando(robot));
		}
		
	}
	
	/**
	 * Metodo con el cual toma la orden el <code>Robot</code>, pero no lo hara 
	 * en este estado. Preguntara si desea activarlo
	 */
	public void tomarOrden() {
		if(robot.obtenerCasa() == null){
			System.out.println("No te te atiendo ahora. Primero debo activarm" +
			"e.\n \u00BFDeseas que me active?(S/N)");
			boolean verdad = true;
			while(verdad) {
				String s = Escritor.leerCadena();
				s = s.toUpperCase();
				switch(s){
					case "S":
					System.out.println("Entonces me activare");
					robot.cambiarEstado(new RecibiendoOrden(robot));
					verdad = false;
					break;
					case "N":
					System.out.println("Entonces no me activare");
					verdad = false;
					break;
					default:
					System.out.println("No es la respuesta que esperaba. " +
					"\u00BFDeseas que me active?(S/N)");
				}
			}
		} else {
			System.out.println("Ya tengo una orden pendiente. Voy a hacerla");
			robot.cambiarEstado(new Caminando(robot));
		}
		
	}
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar. No hara nada 
	 * en este estado
	 */
	public void trabajar() {
		if(robot.obtenerCasa() == null){
			System.out.println("No voy a trabajar sin una orden. Primero dee" +
			"me una orden");	
		} else {
			System.out.println("Tengo una orden pendiente. Ire a completarla");
			robot.cambiarEstado(new Caminando (robot));
		}
		
	}
	
	/**
	 * Metodo para que el <code>Robot</code> reuna los materiales para construir 
	 * una <code>Casa</code>. No hara nada en este estado
	 */
	public void reabastecer() {
		System.out.println("No tengo necesidad de reabastecer.");
	}
	
	/**
	 * Metodo para obtener el nombre del estado
	 * @return Cadena para obtener el nombre del estado en forma de cadena
	 */
	public String obtenerEstado() {
		return "Suspendido";
	}
	
}
