package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

/**
 * Clase para cocinar en el modulo de pizza
 */
public class CocinarHamburguesa implements Cocinar {
	
	/**
	 * Un <code>MenuItem</code>
	 */
	private MenuItem platillo;
	
	/**
	 * Contrucctor de la clase
	 * @param platillo Un <code>MenuItem</code> 
	 */
	public CocinarHamburguesa(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	/**
	 * Metodo para ejecutar todos los metodos necesarios para cocinar un burrito
	 */
	@Override
	public void cocinar() {
		calentarPan();
		cocinarCarne();
		ponerCondimentos();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar la hamburguesa");
	}
	
	/**
	 * Metodo para cocinar la carne en la plancha
	 */
	public void cocinarCarne() {
		String str = "Se esta cocinando la carne";
		str += (platillo.obtenerEsVegetariano())? " de tofu": "";
		Impresor.imprimirInfo(str);
	}
	
	/**
	 * Metodo para calentaar el bollo
	 */
	public void calentarPan() {
		Impresor.imprimirInfo("Se esta calentando el pan");
	}
	
	/**
	 * Metodo para poner condimentos
	 */
	public void ponerCondimentos() {
		 Impresor.imprimirInfo("Se esta poniendo la carne en el pan junto a l" +
			"os condimentos");
	}
	
	/**
	 * Metodo para empaquetar
	 */
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo la hamburguesa en un paquete");
	}
	
}
