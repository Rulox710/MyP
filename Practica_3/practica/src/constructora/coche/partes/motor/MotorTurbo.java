package constructora.coche.partes.motor;

/**
 * Clase que modela el motor turbo de un <code>Coche</code>
 */
public class MotorTurbo extends Motor {
	
	/**
	 * Constructor de la clase
	 */
	public MotorTurbo() {
		super(50,202);
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
		return (componente instanceof MotorTurbo)? true: false;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 */
	@Override
	public String toString() {
		return "motor turbo";
	}
}
