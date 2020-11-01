package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

/**
 * Clase para cocinar en el modulo de pizza
 */
public class CocinarBurrito implements Cocinar {
	
	/**
	 * Un <code>MenuItem</code>
	 */
	private MenuItem platillo;
	
	/**
	 * Contrucctor de la clase
	 * @param platillo Un <code>MenuItem</code> 
	 */
	public CocinarBurrito(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	/**
	 * Metodo para ejecutar todos los metodos necesarios para cocinar un burrito
	 */
	@Override
	public void cocinar() {
		calentarTortilla();
		if(platillo.obtenerEsVegetariano()) {
			ponerIngredientesVegetarianos();
		} else {
			ponerIngredientesNormales();
		}
		doblarTortilla();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar el burrito");
	}
	
	/**
	 * MEtodo para calentar la tortilla en el comal
	 */
	public void calentarTortilla() {
		Impresor.imprimirInfo("Se esta calentando la tortilla en el comal");
	}
	
	/**
	 * Metodo para poner los ingredientes vegetarianos de un burrito 
	 */
	public void ponerIngredientesVegetarianos() {
		Impresor.imprimirInfo("Se esta poniendo ingredientes excluyendo produ" +
			"ctos de origen animal");
	}
	
	/**
	 * Metodo para poner los ingredientes no vegetarianos de un burrito 
	 */
	public void ponerIngredientesNormales() {
		Impresor.imprimirInfo("Se esta poniendo ingredientes como carne y fri" +
			"joles");
	}
	
	/**
	 * Metodo para doblar la tortilla
	 */
	public void doblarTortilla() {
		Impresor.imprimirInfo("Se esta doblando la tortilla para dar forma de" +
			" burrito ");
	}
	
	/**
	 * Metodo para empaquetar
	 */
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo el burrito en un trozo de pap" +
			"el metalico");
	}
}
