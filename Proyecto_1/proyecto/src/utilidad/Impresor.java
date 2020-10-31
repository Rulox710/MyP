package utilidad;

import utilidad.consola.Color;

/**
 * Clase para imprimer cadenas con colores
 * @author Raul Nunio
 * @version 1.2
 */
public final class Impresor {
	
	public static void imprimirError(String str) {
		System.out.println(Color.ROJO.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	public static void imprimirAlerta(String str) {
		System.out.println(Color.AMARILLO.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	public static void imprimirBien(String str) {
		System.out.println(Color.VERDE.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	public static void imprimirInfo(String str) {
		System.out.println(Color.AZUL.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	public static void imprimir(String str) {
		System.out.println(str);
	}
	
}
