package constructora.coche.partes.llantas;

/**
 * Clase que modela las llantas simples de un <code>Coche</code>
 */
public class LlantasSimples extends Llantas {
	
	/**
	 * Constructor de la clase
	 */
	public LlantasSimples() {
		super(0,0,50);
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
		return (componente instanceof LlantasSimples)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "llantas simples";
	}
}
