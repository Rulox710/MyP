package robot.estados;

import java.util.Iterator;
import utilidad.Impresor;
import robot.Robot;
import menu.MenuComponente;
import productos.menu.burrito.Burrito;
import productos.menu.hamburguesa.Hamburguesa;
import productos.menu.pizza.Pizza;
import robot.cocinar.Cocinar;
import robot.cocinar.CocinarBurrito;
import robot.cocinar.CocinarHamburguesa;
import robot.cocinar.CocinarPizza;

/**
 * Clase que modela al <code>Robot</code> cuando esta <code>Cocinando</code>
 */
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
		MenuComponente mi = null;
		Iterator<MenuComponente> iterador = robot.obtenerIteradorMenu();
		int num = robot.obtenerNumeroPlatillo(); 
		int contador = 1;
		while(iterador.hasNext() && contador++ <= num){
			mi = iterador.next();
		}
		robot.asignarNumeroPlatillo(-1);
		if(mi instanceof Hamburguesa) {
			cocina = new CocinarHamburguesa(robot, mi);
		}
		
		if(mi instanceof Pizza) {
			cocina = new CocinarPizza(robot, mi);
		}
		
		if(mi instanceof Burrito) {
			cocina = new CocinarBurrito(robot, mi);
		}
		
		cocina.cocinar();
		robot.cambiarEstado(new Caminando(robot));
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
