package constructora.coche.partes;

/**
 * Clase que modela los componentes de un <code>Coche</code>
 */
public abstract class Componente {
	protected int ataque;
	protected int defensa;
	protected int velocidad;
	protected int costo;
	
	/**
	 * Metodo que obtiene el ataque del <code>Componente</code>
	 * @return Un numero entero
	 */
	public int obtenerAtaque() {
		return ataque;
	}
	
	/**
	 * Metodo que obtiene la defensa del <code>Componente</code>
	 * @return Un numero entero
	 */
	public int obtenerDefensa() {
		return defensa;
	}
	
	/**
	 * Metodo que obtiene la velocidad del <code>Componente</code>
	 * @return Un numero entero
	 */
	public int obtenerVelocidad() {
		return velocidad;
	}
	
	/**
	 * Metodo que obtiene el costo del <code>Componente</code>
	 * @return Un numero entero
	 */
	public int obtenerCosto() {
		return costo; 
	}

	/**
	 * Metodo para decidir si un <code>Componente</code> es igual al objeto que
	 * lo llama
	 * @param componente Un objeto <code>Componente</code> a comparar
	 * @return Un boleano, <code>true</code> si son iguales, <code>false</code>
	 * si no
	 */
	@Override
	public abstract boolean equals(Object componente);
	
	/**
	 * Metodo para obtener una cadena del <code>Componente</code>
	 * @return Una cadena
	 */
	@Override
	public abstract String toString();
}
