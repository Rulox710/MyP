package constructora.coche.partes.carroceria;

/**
 * Clase que modela carroceria casual de un <code>Coche</code>
 */
public class CarroceriaCasual extends Carroceria {
	
	/**
	 * Constructor de la clase
	 */
	public CarroceriaCasual() {
		super(0,0,35);
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
		return (componente instanceof CarroceriaCasual)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "caroceria casual";
	}
}
