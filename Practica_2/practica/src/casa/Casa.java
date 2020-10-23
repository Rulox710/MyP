package casa;

/**
 * Clase abstracta que modela el proceso de creacion de una <code>casa</code>
 */
public abstract class Casa {
	
	/**
	 * Un numero que representa el el dinero que costara de la <code>Casa</code>
	 */
	protected double costo;
	
	/**
	 * Constructor de la clase
	 */
	public Casa() {
		costo = 1000;
	}
	
	/**
	 * Inicia la contruccion de la <code>Casa<code>
	 */
	public void construccion() {
		System.out.println("Se empezara a construir la casa.");
		prepararTerreno();
		colocarCimientos();
		construirEsqueleto();
		instalarElectricidad();
		aislarCasa();
		acabados();
	}
	
	/**
	 * Metodo para preparar el terreno
	 */
	protected void prepararTerreno() {
		System.out.println("Estoy preparando el terreno.");
	}
	
	/**
	 * Metodo para colocar los cimientos
	 */
	protected void colocarCimientos() {
			System.out.println("Estoy colocando los cimientos.");
	}
	
	/**
	 * Metodo para construir el esqueleto de la casa
	 */
	protected abstract void construirEsqueleto();
	
	/**
	 * Metodo para instalar la electricidad y la plomeria
	 */
	protected void instalarElectricidad() {
		System.out.println("Estoy instalando la electricidad y la plomeria.");
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected abstract void aislarCasa();
	
	/**
	 * Metodo para poner los acabados
	 */
	protected void acabados() {
		System.out.println("Estoy poniendo los acabados.");
	}
	
	/**
	 * Metodo que devuelve el <code>costo</code> de la <code>Casa</code>
	 */
	public double obtenerCosto(){
		return costo;
	}
	
	public String toString() {
		return "Casa de costo: " + costo;
	}
}
