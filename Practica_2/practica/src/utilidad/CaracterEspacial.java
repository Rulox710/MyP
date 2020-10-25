package utilidad;

/**
 * Clase con caracteres espaciales que pueden ser usados en la consola con ANSI
 * 
 * @see <a href="https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIes
 * capecodes.html"> Haoyi s Programming Blog</a>
 */

public class CaracterEspecial {
	
	public static String arribaN(int n) {
		return "\u001b[{"+ n +"}A";
	}
	
}
