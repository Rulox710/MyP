package main;

import java.util.ArrayList;
import escritura.Escritor;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;
 
public class Main{
	
	public static Robot robot = new Robot();
	
	public static void main(String[] args){
		
		String teclado;
		boolean ciclo = true;
		int opcion = 0;
		
		System.out.println("Bienvenido a la simulacion de la practica 2");
		
		System.out.println("Seleccione una de las opciones:\n");
		System.out.println("1. Simulacion guiada(la indicada en la practica)");
		System.out.println("3. Terminar el programa");
		
		do {
			teclado = Escritor.leerCadena();
			switch(teclado) {
				case "1":
				porDefecto();
				break;
				case "3": 
				System.out.println("Se acabo la simulacion");
				ciclo = false;
				break;
				default:
				System.out.println("No ingreso un numero en el rango especificado");
			}
		} while(ciclo);
	}
	
	public static void porDefecto() {
		robot.opcionesRobot();
	}
}
