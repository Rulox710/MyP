package utilidad;

/**
 * Clase con caracteres espaciales que pueden ser usados en la consola con ANSI
 * 
 * @see <a href="https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIes
 * capecodes.html"> Haoyi s Programming Blog</a>
 */

public class CaracterEspecial {
	
	/**
	 * Mueve el cursor n espacios hacia arriba, y lo ubica al inicio de linea
	 */
	public static String arribaN(int n) {
		return "\u001b["+ n +"A";
	}
	
	/**
	 * Mueve el cursor n espacios hacia abajo, y lo ubica al inicio de linea
	 * @param n Un numero entero
	 * @return Una cadena en ANSI
	 */
	public static String abajoN(int n) {
		return "\u001b[" + n + "B";
	}
	
	/**
	 * Mueve el cursor n espacios hacia la derecha
	 * @param n Un numero entero
	 * @return Una cadena en ANSI
	 */
	public static String derechaN(int n) {
		return "\u001b[" + n + "C";
	}
	
	/**
	 * Mueve el cursor n espacios hacia la izquierda
	 * @param n Un numero entero
	 * @return Una cadena en ANSI
	 */
	public static String izquierdaN(int n) {
		return "\u001b[" + n + "D";
	}
	
	/**
	 * Mueve el cursor hacia el inicio de la linea n hacia abajo
	 * @param n Un numero entero
	 * @return Una cadena en ANSI
	 */
	public static String sigLineaN(int n) {
		return "\u001b[" + n + "E";
	}
	
	/**
	 * Mueve el cursor hacia el inicio de la linea n hacia arriba
	 * @param n Un numero entero
	 * @return Una cadena en ANSI
	 */
	public static String preLineaN(int n) {
		return "\u001b[" + n + "F";
	}
	
	/**
	 * Limpia la pantalla entera
	 * @return Una cadena en ANSI
	 */
	public static String limpiaPan() {
		return "\u001b[2J";
	}
	
	/**
	 * Limpia del cursos hasta el final de la pantalla
	 * @return Una cadena en ANSI
	 */
	public static String limpiaLinSig() {
		return "\u001b[0J";
	}
	
	/**
	 * Limpia la linea en donde esta el cursor
	 * @return Una cadena en ANSI
	 */
	public static String limpiaLin() {
		return "\u001b[2K";
	}
	
	/**
	 * Desplaza n lineas hacia abajo
	 * @param n Un numero entero
	 * @return Una cadena formada por "\n"
	 */
	public static String lineaAbajo(int n) {
		String str = "";
		for (int i = 0; i < n ;i++) {
			str += "\n";
		}
		return str;
	}
	
	/**
	 * Borra n caracteres de derecha a izquierda en la linea donde este el 
	 * cursor
	 * @param n Un numero entero
	 * @return Una cadena formada por "\b"
	 */
	public static String borraN(int n) {
		String str = "";
		for (int i = 0; i < n ;i++) {
			str += "\b";
		}
		return str;
	}
}
