package graficos.modelo.palabras;

import java.util.ArrayList;

import utilidad.Escritor;

/**
 * Clase que modela a un verbo
 */
public class Verbo implements Palabra {
	
	private String verbo;
	private ArrayList<Palabra> relativas;
	
	/**
	 * Constructor de la clase
	 * @param verbo Una cadena que termine en r
	 */
	private Verbo(String verbo) {
		this.verbo = verbo;
		relativas = new ArrayList<>();
	}
	
	/**
	 * Metodo para crear un <code>Verbo</code>
	 * @param verbo Una cadena que termina en r
	 * @return Un objeto de tipo <code>Verbo</code>
	 */
	public static Verbo nuevo(String verbo) throws PalabraException {
		int n = verbo.length();
		if(!Escritor.validarAlfabetico(verbo) || Character.toLowerCase(verbo.charAt(n - 1)) != 'r') {
			System.out.print(verbo);
			throw new PalabraException(1);
		}
		for(int i = 0; i < n; i++) {
			if(verbo.charAt(i) == ' ') {
				throw new PalabraException(1);
			}
		}
		return new Verbo(Escritor.limpiar(verbo).toLowerCase());
	}
	
	@Override
	public void asignarRelativas(Palabra p) {
		relativas.add(p);
	}
	
	@Override
	public boolean esRelativa(Palabra p) {
		for(Palabra pa: relativas)System.out.print(pa.obtenerCadena()+",");
		return relativas.contains(p);
	}
	
	@Override
	public String obtenerCadena() {
		return verbo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Verbo) {
			 return (((Verbo)obj).obtenerCadena().equals(this.obtenerCadena()));
		}
		return false;
	}
	
	@Override
	public int compareTo(Palabra v) {
		return (this.obtenerCadena().compareTo(v.obtenerCadena()));
	}
}
