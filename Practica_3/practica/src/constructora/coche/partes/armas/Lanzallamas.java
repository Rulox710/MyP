package constructora.coche.partes.armas;

import constructora.coche.partes.Componente;

/**
 * Clase que modela lanzallamas de un <code>Coche</code>
 */
public class Lanzallamas extends Armas {
	
	/**
	 * Constructor de la clase
	 */
	public Lanzallamas() {
		super(20,0,32);
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
		return (componente instanceof Lanzallamas)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "lanzallamas";
	}
}
