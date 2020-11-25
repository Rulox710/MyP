package constructora.coche.partes.blindaje;

/**
 * Clase que modela el blindaje simple de un <code>Coche</code>
 */
public class BlindajeSimple extends Blindaje {
	
	/**
	 * Constructor de la clase
	 */
	public BlindajeSimple() {
		super(10,0,50);
	}
	
	/**
	 * Metodo para decidir si un <code>Componente</code> es igual al objeto que
	 * lo llama
	 * @param componente Un objeto <code>Componente</code> a comparar
	 * @return Un boleano, <code>true</code> si son iguales, <code>false</code>
	 * si no
	 */
	@Override
	public boolean equals(Object componente) {
		return (componente instanceof BlindajeSimple)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "blindaje simple";
	}
}
