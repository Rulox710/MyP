package juego.comandosValidos.comandos;

import java.util.ArrayList;

/**
 * Clase para guardar una cadena que representa a un comando y posibles palabras
 * alternativas a este
 */
public class Comando {
	
	private String comando;
	private ArrayList<String> similares;
	
	/**
	 * Constructor de la clase
	 * @param comando Una cadena
	 */
	public Comando(String comando) {
		this.comando = comando;
		similares = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public boolean noProcesable() {
		return (comando == null)? true: false;
	}
	
	/**
	 * Asigna una cadena que puede ser equivalente a <code>comando</code>
	 * @param cadena una cadena
	 */
	public void comandoSimilar(String cadena) {
		similares.add(cadena);
	}
	
	/**
	 * Dada una cadena, devuelve si esta es similar al comando o no
	 * @return Un boleano
	 */
	public boolean igual(String cadena) {
		if(cadena.equalsIgnoreCase(comando)) return true;
		for(String str: similares) {
			if(cadena.equalsIgnoreCase(str)) return true;
		}
		return false;
	}
	
	/**
	 * Metodo para hacer una cadena al comando
	 */
	@Override
	public String toString(){
		return comando;
	}
}
