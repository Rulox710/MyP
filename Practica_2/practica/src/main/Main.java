package main;

import java.util.ArrayList;
import utilidad.Escritor;
import utilidad.Color;
import utilidad.CaracterEspecial;
import robot.Robot;
import robot.EstadoRobot;
import casa.Casa;
 
public class Main{
	
	public static Robot robot = new Robot();
	
	public static void main(String[] args){

		String teclado;
		boolean ciclo = true;
		int opcion = 0;
		
		System.out.println("Bienvenido a la simulacion de la practica 2\n");
		
		do {
			System.out.println("Seleccione una de las opciones:");
			System.out.println("1. Simulacion guiada(la indicada en la practica)");
			System.out.println("3. Terminar el programa");
			teclado = Escritor.leerCadena();
			System.out.print(CaracterEspecial.arribaN(4) + 
				CaracterEspecial.limpiaLinSig());
			
			switch(teclado) {
				case "1":
				System.out.print(CaracterEspecial.arribaN(1) + 
					CaracterEspecial.limpiaLinSig());
				System.out.println("Se inicia la simulacion\n");
				porDefecto();
				break;
				case "3": 
				System.out.print(CaracterEspecial.arribaN(1) + 
					CaracterEspecial.limpiaLinSig());
				System.out.println("Se acabo la simulacion\n");
				ciclo = false;
				break;
				default:
				System.out.print(CaracterEspecial.arribaN(1) + 
					CaracterEspecial.limpiaLinSig());
				System.out.println("No ingreso un numero en el rango especifi" +
				"cado, vuelva a intentar");
			}
		} while(ciclo);
	}
	
	public static void porDefecto() {
		robot.opcionesRobot();
	}
}
