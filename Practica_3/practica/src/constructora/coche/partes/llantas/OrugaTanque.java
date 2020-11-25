package constructora.coche.partes.llantas;

/**
 * Clase que modela las orugas de tanque de un <code>Coche</code>
 */
public class OrugaTanque extends Llantas {
	
	/**
	 * Constructor de la clase
	 */
	public OrugaTanque() {
		super(25,-15,120);
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
		return (componente instanceof OrugaTanque)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "oruga de tanque";
	}
}
