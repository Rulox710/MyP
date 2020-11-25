package constructora.coche.partes.armas;

/**
 * Clase que modela una cierra de un <code>Coche</code>
 */
public class Cierra extends Armas {
	
	/**
	 * Constructor de la clase
	 */
	public Cierra() {
		super(18,5,50);
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
		return (componente instanceof Cierra)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "una cierra";
	}
}
