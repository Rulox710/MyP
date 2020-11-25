package constructora.coche.partes.blindaje;

/**
 * Clase que modela el blindaje reforzado de un <code>Coche</code>
 */
public class Tanque extends Blindaje {
	
	/**
	 * Constructor de la clase
	 */
	public Tanque() {
		super(155,-72,100);
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
		return (componente instanceof Tanque)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "blindaje de tanque";
	}
}
