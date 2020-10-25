package robot.estados;

import utilidad.Escritor;
import utilidad.Color;
import utilidad.CaracterEspecial;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>Caminando</code>
 */
public class Caminando implements EstadoRobot {

	/**
	 * El <code>Robot</code> que tiene este estado
	 */
	private Robot robot;
	
	/**
	 * Valores boleanos que representan si tiene una orden y material para 
	 * trabajar
	 */
	private boolean orden, material;
	
	/**
	 * <code>Casa</code> en la que se trabaja
	 */
	private Casa casa;
	
	/**
	 * Contructor que toma al <code>Robot</code>
	 */
	public Caminando(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo que hace que el <code>Robot</code> entre en estado 
	 * <code>Suspendido</code>
	 */
	public void suspender() {
		if(robot.obtenerCasa() ==  null) {
			System.out.println("Trabajo listo. Camino para suspenderme en mi " +
			"area de descanzo\n");
			robot.cambiarEstado(new Suspendido(robot));
		} else {
			System.out.println("\u00BFSeguro que quieres suspenderme? Aun ten" +
			"go trabajo que hacer(S/N)");
			boolean verdad = true;
			while(verdad) {
				String s = Escritor.leerCadena().toUpperCase();
				System.out.print(CaracterEspecial.arribaN(1) + 
					CaracterEspecial.limpiaLin());
				switch(s){
					case "S":
					System.out.println("\u00BFGuardo su orden?(S/N)");
					boolean v2 = true;
					while(v2){
						s = Escritor.leerCadena().toUpperCase();
						System.out.print(CaracterEspecial.arribaN(1) + 
							CaracterEspecial.limpiaLin());
						switch(s){
							case "S":
							System.out.println("Me suspendere y guardare la " +
							"orden\n");
							v2 = false;
							break;
							case "N":
							System.out.println("Me suspendere y no guardare l" +
							"a orden\n");
							robot.asignarMaterial(false);
							robot.asignarCasa(null);
							v2 = false;
							break;
							default:
							System.out.print("No es la respuesta que espera" +
							"ba. \u00BFDeseas que guarde?(S/N)");
						}
					}
					robot.cambiarEstado(new Suspendido(robot));
					verdad = false;
					break;
					case "N":
					System.out.println("Entonces no me suspendere\n");
					verdad = false;
					break;
					default:
					System.out.print("No es la respuesta que esperaba. " +
					"\u00BFDeseas que me suspenda?(S/N)");
				}
			}
		}
	}
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Activado</code>. No hace nada en este estado
	 */
	public void activar() {
		System.out.println("Ya estoy activado\n");
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
		if(robot.obtenerMaerial() && robot.obtenerCasa() != null) {
			System.out.println("Ya que tengo material, ire a trabajar\n");
			robot.cambiarEstado(new Trabajando(robot));
		} else if(robot.obtenerCasa() != null){
			System.out.println("No puedo trabajar sin material. Ire a reabast" +
				"ecerme\n");
			robot.cambiarEstado(new Reabasteciendo(robot));
		} else {
			System.out.println("Ya temine mi trabajo, voy al area de descanz" +
				"o\n");
			robot.cambiarEstado(new Suspendido(robot));
		}
	}
	
	/**
	 * Metodo para que el <code>Robot</code> reuna los materiales para construir 
	 * una <code>Casa</code>
	 */
	public void reabastecer() {
		if(robot.obtenerMaerial() && robot.obtenerCasa() != null) {
			System.out.println("No tengo necesidad de reabastecer. Ire a trab" + 
			"ajar\n");
			robot.cambiarEstado(new Trabajando(robot));
		} else if (robot.obtenerCasa() != null) {
			System.out.println("Conseguire materiales en el area correspondie" +
			"nte\n");
			robot.cambiarEstado(new Reabasteciendo(robot));
		} else {
			System.out.println("Ya temine mi trabajo, voy al area de descanzo" +
			"\n");
			robot.cambiarEstado(new Suspendido(robot));
		}
	}
	
	/**
	 * Metodo para obtener el nombre del estado
	 * @return Cadena para obtener el nombre del estado en forma de cadena
	 */
	public String obtenerEstado() {
		return "Caminando";
	}
}
