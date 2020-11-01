package utilidad;

import java.util.Scanner;
import utilidad.consola.CaracterEspecial;


/**
 * Clase para leer cadenas o validarlas bajo ciertas condiciones
 * @author Raul Nunio
 */
public final class Escritor{

	/**
	 * Lee una cadena de caracteres
     * @return cadena que se ha sido leido
     */
    public static String leerCadena(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(CaracterEspecial.arribaN(1) + 
			CaracterEspecial.limpiaLin());
        return s;
    }

	/**
	 * Regresa si una cadena está formada de sólo carácteres alfabéticos, 
	 * incluyendo la 'ñ', pero no acentos
	 * @param cadena Una cadena con la palabra a comprobar
	 * @return boleano que dice si se trata de una cadena con sólo letras o no
	 * @see <a href="https://www.lawebdelprogramador.com/foros/Java/1680183-ingresar-solo-letras-y-no-numeros.html">La</a>
	 */
	public static boolean validarAlfabetico(String cadena) {		
		if(cadena.length()==0) return false;
		int valorASCII;
		char caracter;
		for(int i = 0; i < cadena.length(); i++){
			caracter = cadena.toUpperCase().charAt(i);
			valorASCII = (int)caracter;
			if(valorASCII == 165 || valorASCII == 164) continue;
			if (valorASCII < 65 || valorASCII > 90)
				return false;
		}
 		return true;
	}
	
	/**
	 * Regresa si una cadena está formada por sólo carácteres numéricos
	 * @param cadena La cadana a comprobar
	 * @return boleano que indica si se trata de una cadena con sólo números o no
	 */
	public static boolean validarNumericoEntero(String cadena) {
		if(cadena.length()==0) return false;
		int valorASCII;
		char caracter;
		for(int i = 0; i < cadena.length(); i++){
			caracter = cadena.charAt(i);
			valorASCII = (int)caracter;
			if(valorASCII < 48 || valorASCII > 57)
				return false;
		}
		return true;
	}
	
	/**
	 * Regresa si una cadena está formada por sólo carácteres numéricos, 
	 * incluye el punto para decimales, pero sólo puede usarse una vez
	 * @param cadena La cadana a comprobar
	 * @return boleano que indica si se trata de una cadena con sólo números o no
	 */
	public static boolean validarNumericoReal(String cadena) {
		int punto = 1;	
		if(cadena.length()==0) return false;
		int valorASCII;
		char caracter;
		for(int i = 0; i < cadena.length(); i++){
			caracter = cadena.charAt(i);
			valorASCII = (int)caracter;
			if(cadena.charAt(i)=='.') {
				if(--punto < 0) return false;
				continue;
			}
			if(valorASCII < 48 || valorASCII > 57)
				return false;
		}
		return true;
	}
}
