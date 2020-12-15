package utilidad;

import utilidad.consola.Color;

/**
 * Clase para imprimir cadenas con colores
 */
public final class Impresor {
	
	/**
	 * Imprime en consola, de color rojo las letras y fondo negro. Da un salto 
	 * de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimirError(String str) {
		System.out.println(Color.ROJO.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	/**
	 * Imprime en consola, de color rojo las letras y fondo negro. Da un salto 
	 * de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimirAlerta(String str) {
		System.out.println(Color.AMARILLO.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	/**
	 * Imprime en consola, de color verde las letras y fondo negro. Da un salto 
	 * de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimirBien(String str) {
		System.out.println(Color.VERDE.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	/**
	 * Imprime en consola, de color azul las letras y fondo negro. Da un salto 
	 * de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimirInfo(String str) {
		System.out.println(Color.CIAN.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	/**
	 * Imprime en consola, de color magenta las letras y fondo negro. Da un 
	 * salto de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimirExtra(String str) {
		System.out.println(Color.MAGENTA.toString() + Color.NEGRO_FONDO  + str 
		+ Color.RESET);
	}
	
	/**
	 * Imprime en consola. Da un salto de linea al terminar la cadena
	 * @param str Una cadena a ser impresa
	 */
	public static void imprimir(String str) {
		System.out.println(str);
	}
	
}
