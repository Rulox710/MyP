package principal;

import java.lang.NullPointerException;
import utilidad.Escritor;
import utilidad.Impresor;
import cliente.Cliente;
import constructora.coche.Coche;
import constructora.creadores.Creador;
import constructora.director.Director;

public class Principal {
	public static void main (String[] args) {
		
		boolean verdad = true;
		int numero = 0;
		while(verdad) {
			Impresor.imprimir("Esta es la practica 3, \u00BFQue deberia hace" +
				"r?\t(1)Iniciar la simulacion\t(2)Terminar el programa");
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) {
				numero = Integer.parseInt(str);
			}
			switch(numero) {
				case 1:
					iniciarSimulacion();
					break;
				case 2:
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado[1-2]");
			}
		}
		Impresor.imprimir("Ha salido del programa");
	}
	
	/**
	 * Metodo para iniciar la simulacion de un clinete comprando algun coche
	 */
	private static void iniciarSimulacion() {
		Impresor.imprimir("Bienvenido, cliente.\nIngrese el monto con el cual" +
			" cuenta. Recuerde que son madpesos, no madcentavos.\n(Si es meno" +
			"r a 275 madpesos, no podra comprar nuestro coche mas economico)");
		boolean verdad = true;
		int numero = 0;
		while(verdad) {
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) {
				numero = Integer.parseInt(str);
				verdad = false;
			} else {
				Impresor.imprimirError("No ingrso un numero entero, vuelva a " +
					"intentar");
			}
		}
		Cliente cliente = new Cliente(numero);
		Director director = new Director(new Creador(cliente));
		Coche coche = null;
		verdad = true;
		numero = 0;
		while(verdad) {
		Impresor.imprimir("\u00BFQue quiere hacer?(Escriba el numero)\n(1)Com" +
			"prar un coche a mi gusto\n(2)Comprar un coche, tomando como mold" +
			"e un tanque\n(3)Comprar un coche, tomando como molde uno deporti" +
			"vo\n(4)Comprar un coche, tomando como modelo el coche mas econom" +
			"ico\n(5)Termine de comprar, quiero salir");
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) {
				numero = Integer.parseInt(str);
			}
			switch(numero) {
				case 1:
					coche = director.crearNuevo();
					try {
						Impresor.imprimirExtra(coche.toString());
					} catch(NullPointerException e) {
						Impresor.imprimirExtra("Su coche no pudo ser construido");
					}
					break;
				case 2:
					coche = director.crearTanque();
					try {
						Impresor.imprimirExtra(coche.toString());
					} catch(NullPointerException e) {
						Impresor.imprimirExtra("Su coche no pudo ser construido");
					}
					break;
				case 3:
					coche = director.crearDeportivo();
					try {
						Impresor.imprimirExtra(coche.toString());
					} catch(NullPointerException e) {
						Impresor.imprimirExtra("Su coche no pudo ser construido");
					}
					break;
				case 4:
					coche = director.crearEconomico();
					try {
						Impresor.imprimirExtra(coche.toString());
					} catch(NullPointerException e) {
						Impresor.imprimirExtra("Su coche no pudo ser construido");
					}
					break;
				case 5:
					Impresor.imprimirBien("Estos son los autos que compro:");
					for(Coche c: cliente.obtenerCoche()) {
						Impresor.imprimirExtra(c + "\n-----------------------");
					}
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No ingreso un numero entero, vuel" +
					"va a intentar[1-5]");
			}
		}
	}
}
