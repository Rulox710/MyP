package robot.estados;

import escritura.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>Activado</code>
 */
public class Activado implements EstadoRobot {

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
	public Activado(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Constructor para retomar algunos valores de estados anteriores
	 */
	public Activado(EstadoRobot er) {
		robot = er.obtenerRobot();
		orden = er.obtenerOrden();
		material = er.obtenerMaerial();
		casa = er.obtenerCasa();
	}
	
	/**
	 * Metodo que hace que el <code>Robot</code> entre en estado 
	 * <code>Suspendido</code>
	 */
	public void suspender() {
		System.out.println("Entonces me suspendere. Activeme cuando lo desee");
		robot.cambiarEstado(new Suspendido(robot));
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
	 * estado <code>RecibiendoOrden</code>
	 */
	public void tomarOrden() {
		System.out.println("Bien. Me preparare para tomar su orden.\n Una vez" +
		" que comience a tomar su orden no hay marcha atras. ¿Quiere darme?" +
		" su orden?(S/N)");
		boolean verdad = true;
		while(verdad) {
			String s = Escritor.leerCadena();
			s = s.toUpperCase();
			if(s.length()!=1 && (!s.equals("S") || !s.equals("N"))){
				System.out.println("No es la respuesta que esperaba. ¿Deseas " +
				"darme una orden?(S/N)");
			} else if (s.equals("S")) {
				System.out.println("Etonces recibire su orden");
				robot.cambiarEstado(new RecibiendoOrden(this));
				verdad = false;
			} else {
				System.out.println("Etonces no recibire su orden");
				verdad = false;
			}
		}
	}
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar. No hara nada 
	 * en este estado
	 */
	public void trabajar() {
		if(!orden) {
			System.out.println("No voy a trabajar sin una orden.");
		} else {
			System.out.println("Tengo una orden pendiente. trabajare");
			robot.cambiarEstado(new Caminando(this));
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
		return "Activado";
	}
	
	/**
	 * Metodo para obtener el <code>Robot</code>
	 * @return Objeto que es el <code>Robot</code>
	 */
	public Robot obtenerRobot() {
		return robot;
	}
	
	/**
	 * Metodo para obtener si tiene una orden o no
	 * @return Boleano que indica si tiene o no una orden
	 */
	public boolean obtenerOrden() {
		return orden;
	}
	
	/**
	 * Metodo para obtener si tiene material o no
	 * @return Boleano que indica si tiene material o no
	 */
	public boolean obtenerMaerial() {
		return material;
	}
	
	/**
	 * Metodo para obtener la <code>Casa</code> en la que se trabaja
	 */
	public Casa obtenerCasa() {
		return casa;
	}
}
