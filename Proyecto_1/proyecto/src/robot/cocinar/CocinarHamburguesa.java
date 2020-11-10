package robot.cocinar;

import utilidad.Impresor;
import menu.MenuComponente;
import robot.Robot;

/**
 * Clase para cocinar en el modulo de pizza
 */
public class CocinarHamburguesa implements Cocinar {
	
	/**
	 * Un <code>Robot</code>
	 */
	private Robot robot;
	
	/**
	 * Un <code>MenuComponente</code>
	 */
	private MenuComponente platillo;
	
	/**
	 * Contrucctor de la clase
	 * @param robot Un <code>Robot</code>
	 * @param platillo Un <code>MenuComponente</code> 
	 */
	public CocinarHamburguesa(Robot robot, MenuComponente platillo) {
		this.robot = robot;
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
		robot.asignarPlatillo(platillo);
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
