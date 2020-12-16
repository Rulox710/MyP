package graficos.modelo.palabras;

import java.util.ArrayList;

import utilidad.Escritor;

/**
 * Clase que modela un sustantivo
 */
public class Sustantivo implements Palabra {
	
	private ArrayList<Palabra> relativas;
	
	private String sustantivo;
	private String genero;
	
	/**
	 * Constructor de la clase
	 * @param sustantivo Una cadena
	 */
	private Sustantivo(String sustantivo) {
		this.sustantivo = sustantivo;
		genero = "";
	}
	
	/**
	 * Constructor de la clase
	 * @param sustantivo Una cadena
	 * @param esMasculino Un boleano
	 */
	private Sustantivo(String sustantivo, boolean esMasculino) {
		this.sustantivo = sustantivo;
		genero = (esMasculino)? "el": "la";
	}
	
	public static Sustantivo nuevo(String sustantivo) throws PalabraException {
		int n = sustantivo.length();
		if(!Escritor.validarAlfabetico(sustantivo)) {
			throw new PalabraException(2);
		}
		for(int i = 0; i < n; i++) {
			if(sustantivo.charAt(i) == ' ') {
				throw new PalabraException(2);
			}
		}
		return new Sustantivo(Escritor.limpiar(sustantivo).toLowerCase());
	}
	
	/**
	 * Metodo para crear un <code>Sustantivo</code> masculino
	 * @param sustantivo Una cadena que se identificara como masculino
	 * @return Un objeto de tipo <code>Sustantivo</code>
	 * @throws PalabraException Si no puede crearse
	 */
	public static Sustantivo nuevoM(String sustantivo) throws PalabraException {
		int n = sustantivo.length();
		if(!Escritor.validarAlfabetico(sustantivo)) {
			throw new PalabraException(2);
		}
		for(int i = 0; i < n; i++) {
			if(sustantivo.charAt(i) == ' ') {
				throw new PalabraException(2);
			}
		}
		return new Sustantivo(Escritor.limpiar(sustantivo).toLowerCase(), true);
	}
	
	/**
	 * Metodo para crear un <code>Sustantivo</code> femenino
	 * @param sustantivo Una cadena que se identificara como femenino
	 * @return Un objeto de tipo <code>Sustantivo</code>
	 * @throws PalabraException Si no puede crearse
	 */
	public static Sustantivo nuevoF(String sustantivo) throws PalabraException {
		int n = sustantivo.length();
		if(!Escritor.validarAlfabetico(sustantivo)) {
			throw new PalabraException(2);
		}
		for(int i = 0; i < n; i++) {
			if(sustantivo.charAt(i) == ' ') {
				throw new PalabraException(2);
			}
		}
		return new Sustantivo(Escritor.limpiar(sustantivo).toLowerCase(),false);
	}
	
	@Override
	public String obtenerCadena() {
		return sustantivo;
	}
	
	@Override
	public void asignarRelativas(Palabra p) {
		relativas.add(p);
	}
	
	@Override
	public boolean esRelativa(Palabra p) {
		return relativas.contains(p);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sustantivo) {
			return (((Sustantivo)obj).obtenerCadena().equals(this.obtenerCadena()));
		}
		return false;
	}
	
	@Override
	public int compareTo(Palabra s) {
		return (this.obtenerCadena().compareTo(s.obtenerCadena()));
	}
}
