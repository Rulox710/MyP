package robot.estados;

import utilidad.Impresor;
import robot.Robot;
import productos.menu.MenuItem;
import productos.menu.burrito.Burrito;
import productos.menu.hamburguesa.Hamburguesa;
import productos.menu.pizza.Pizza;
import robot.cocinar.Cocinar;
import robot.cocinar.CocinarBurrito;
import robot.cocinar.CocinarHamburguesa;
import robot.cocinar.CocinarPizza;

public class Cocinando implements EstadosRobot {

	/**
	 * <code>Robot</code> a asiganr este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor de la clase
	 * @param robot Un <code>Robot</code>
	 */
	public Cocinando(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo para suspender al <code>Robot</code>
	 */
	@Override
	public void suspender() {
		Impresor.imprimirAlerta("No puedo hacer eso ahora");
	}
	
	/**
	 * Metodo para que el <code>Robot</code> se active y atienda
	 */
	@Override
	public void activar() {
		Impresor.imprimirAlerta("No puedo hacer eso ahora");
	}
	
	/**
	 * Metodo para que el <code>Robot</code> muestre los menus
	 */
	@Override
	public void mostrarMenu() {
		Impresor.imprimirAlerta("No puedo hacer eso ahora");
	}
	
	/**
	 * Metodo para hacer que el <code>Robot</code> cocine el producto
	 */
	@Override
	public void cocinar() {
		Cocinar cocina = null;
		if(robot.obtenerPlatillo() instanceof Hamburguesa) {
			cocina = new CocinarHamburguesa(robot.obtenerPlatillo());
		}
		
		if(robot.obtenerPlatillo() instanceof Pizza) {
			cocina = new CocinarPizza(robot.obtenerPlatillo());
		}
		
		if(robot.obtenerPlatillo() instanceof Burrito) {
			cocina = new CocinarBurrito(robot.obtenerPlatillo());
		}
		
		cocina.cocinar();
	}
	
	/**
	 * Metodo para hacer que el <code>Robot</code> entregue el producto
	 */
	@Override
	public void entregarProducto() {
		Impresor.imprimirAlerta("No puedo hacer eso ahora");
	}
	
	/**
	 * Metodo que deveuelve como cadena el estado actual
	 */
	@Override
	public String toString() {
		return "Cocinando";
	}
	
}
