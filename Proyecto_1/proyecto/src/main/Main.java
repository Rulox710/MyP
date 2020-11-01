package main;

import utilidad.Impresor;
import utilidad.Escritor;
import robot.Robot;

public class Main {
	public static void main(String[] args) {
		Valores.metodo();
		
		Impresor.imprimir("Esta es la simulaion del proyecto. \u00BFQuiere in" +
			"iciarlo?(S/N)");
			boolean verdad = true;
		do {
			switch(Escritor.leerCadena().toUpperCase()) {
				case "S":
				Valores.robot.ejectutar();
				break;
				case "N":
				Impresor.imprimir("Se termino la simulaion");
				verdad = false;
				break;
				default:
				Impresor.imprimirError("No dio una opcion valida (S/N)");
			}
		} while(verdad);
	}
}
