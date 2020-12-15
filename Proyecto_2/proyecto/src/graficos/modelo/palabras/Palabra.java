package graficos.modelo.palabras;

import java.lang.Comparable;

public interface Palabra extends Comparable<Palabra> {
	
	public abstract String obtenerCadena();
	
	public abstract boolean equals(Object obj);
	
	public abstract int compareTo(Palabra p);
}
