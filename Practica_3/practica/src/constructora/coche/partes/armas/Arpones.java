package constructora.coche.partes.armas;

import constructora.coche.partes.Componente;

/**
 * Clase que modela arpones de un <code>Coche</code>
 */
public class Arpones extends Armas {
	
	/**
	 * Constructor de la clase
	 */
	public Arpones() {
		super(12,0,20);
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
		return (componente instanceof Arpones)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "arpones";
	}
}
