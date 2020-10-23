package robot.estados;

import escritura.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;
import casa.esqueleto.reforzado.*;
import casa.esqueleto.reforzado.aislado.*;
import casa.esqueleto.concreto.*;
import casa.esqueleto.concreto.aislado.*;

/**
 * Clase que implementa <code>EstadoRobot</code>, cuando el <code>Robot</code>
 * esta <code>RecibiendoOrden</code>
 */
public class RecibiendoOrden implements EstadoRobot {
	
	/**
	 * El <code>Robot</code> que tiene este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor que toma al <code>Robot</code>
	 */
	public RecibiendoOrden(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo que hace que el <code>Robot</code> entre en estado 
	 * <code>Suspendido</code>. No hace nada en este estado.
	 */
	public void suspender() {
		System.out.println("Estoy tomando una orden, no puedes suspenderme :(");
	}
	
	/**
	 * Metodo que hace que <code>Robot</code> cambie al estado 
	 * <code>Activado</code>. No hace nada en este estado
	 */
	public void activar() {
		System.out.println("Ya estoy activado");
	}
	
	/**
	 * Metodo con el cual toma la orden el <code>Robot</code>, preguntando por 
	 * las especificaciones de la <code>Casa</code>
	 */
	public void tomarOrden() {
		System.out.println("Procedere a preguntar por las especificaciones de" +
		" la casa.\n \u00BFQue clase de esqueleto tendra? Escriba el numero");
		
		System.out.println("1. Esqueleto de concreto");
		System.out.println("2. Esqueleto reforzado");
		boolean verdad = true, esConcreto = true;
		while(verdad) {
			String s = Escritor.leerCadena();
			switch(s) {
				case "1":
				verdad = false;
				break;
				case "2":
				esConcreto = false;
				verdad = false;
				break;
				default:
				System.out.println("No es la respuesta que esperaba. Escriba " +
				"un numero en el rango(1/2)");
			}
		}
		verdad = true;
		System.out.println("\u00BFQue clase de aislamiento tendra? Escriba el nume" +
		"ro");
		System.out.println("1. Aislamiento de concreto");
		System.out.println("2. Aislamiento de vidiro");
		System.out.println("3. Aislamiento de madera");
		System.out.println("4. Aislamiento de reforzado");

		while(verdad) {
			String s = Escritor.leerCadena();
			switch(s) {
				case "1":
				if(esConcreto) {
					robot.asignarCasa(new ConcretoAisladoConcreto());
				} else {
					robot.asignarCasa(new ReforzadoAisladoConcreto());
				} 
				verdad = false;
				break;
				case "2":
				if(esConcreto) {
					robot.asignarCasa(new ConcretoAisladoVidrio());
				} else {
					robot.asignarCasa(new ReforzadoAisladoVidrio());
				} 
				verdad = false;
				break;
				case "3":
				if(esConcreto) {
					robot.asignarCasa(new ConcretoAisladoMadera());
				} else {
					robot.asignarCasa(new ReforzadoAisladoMadera());
				} 
				verdad = false;
				break;
				case "4":
				if(esConcreto) {
					robot.asignarCasa(new ConcretoAisladoReforzado());
				} else {
					robot.asignarCasa(new ReforzadoAisladoReforzado());
				} 
				verdad = false;
				break;
				default:
				System.out.println("No es la respuesta que esperaba. Escriba " +
				"un numero en el rango(1/2/3/4)");
			}
		}
		System.out.println("\nMe retiro para juntar los materiales.");
		robot.cambiarEstado(new Caminando(robot));
	}
	
	/**
	 * Metodo para que el <code>Robot</code> comience a trabajar. No hara nada 
	 * en este estado
	 */
	public void trabajar() {
		System.out.println("No voy a trabajar sin una orden clara.");
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
		return "Recibiendo Orden";
	}
}
