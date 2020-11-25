package constructora.coche.partes.armas;

/**
 * Clase que modela caniones de un <code>Coche</code>
 */
public class Caniones extends Armas {
	
	/**
	 * Constructor de la clase
	 */
	public Caniones() {
		super(60,-30,80);
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
		return (componente instanceof Caniones)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "caniones";
	}
}
