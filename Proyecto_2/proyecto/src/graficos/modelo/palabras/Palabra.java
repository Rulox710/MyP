package graficos.modelo.palabras;

import java.lang.Comparable;

public interface Palabra extends Comparable<Palabra> {
	
	public abstract String obtenerCadena();
	
	public abstract void asignarRelativas(Palabra p);
	
	public abstract boolean esRelativa(Palabra p);
	
	public abstract boolean equals(Object obj);
	
	public abstract int compareTo(Palabra p);
}
