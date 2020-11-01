package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

/**
 * Clase para cocinar en el modulo de pizza
 */
public class CocinarPizza implements Cocinar {
	
	/**
	 * Un <code>MenuItem</code>
	 */
	private MenuItem platillo;
	
	/**
	 * Contrucctor de la clase
	 * @param platillo Un <code>MenuItem</code> 
	 */
	public CocinarPizza(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	/**
	 * Metodo para ejecutar todos los metodos necesarios para cocinar un burrito
	 */
	@Override
	public void cocinar() {
		amasarMasa();
		ponerSalsa();
		ponerQueso();
		ponerIngredientes();
		hornear();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar la pizza");
	}
	
	/**
	 * Metodo para amasar la masa
	 */
	public void amasarMasa() {
		Impresor.imprimirInfo("Se esta amasando la masa y se la da forma");
	}
	
	/**
	 * Metodo para poner salsa
	 */
	public void ponerSalsa() {
		Impresor.imprimirInfo("Se esta poniendo la salsa");
	}
	
	/**
	 * Metodo para poner queso
	 */
	public void ponerQueso() {
		String str = "Se esta poniendo el queso";
		str += (platillo.obtenerEsVegetariano())? " vegano": "";
		Impresor.imprimirInfo(str);
	}
	
	/**
	 * Metodo para poner ingredientes
	 */
	public void ponerIngredientes() {
		Impresor.imprimirInfo("Se esta poniendo los ingredientes");
	}
	
	/**
	 * MEtodo para hornear la pizza
	 */
	public void hornear() {
		Impresor.imprimirInfo("Se esta honeando la pizza");
	}
	
	/**
	 * Metodo para empaquetar
	 */
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo la pizza en una caja");
	}
}
