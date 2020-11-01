package robot.estados;

import utilidad.Impresor;
import robot.Robot;

/**
 * Clase que modela al <code>Robot</code> cuando esta <code>Caminando</code>
 */
public class Caminando implements EstadosRobot {
	
	/**
	 * <code>Robot</code> a asiganr este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor de la clase
	 * @param robot Un <code>Robot</code>
	 */
	public Caminando(Robot robot) {
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
		if(!robot.obtenerOrdenLista()) {
			Impresor.imprimirInfo("Voy al area para cocinar");
			robot.cambiarEstado(new Cocinando(robot));
		} else {
			Impresor.imprimirInfo("Voy al area para entregar el producto");
			robot.cambiarEstado(new Atendiendo(robot));
		}
		
	}
	
	/**
	 * Metodo para hacer que el <code>Robot</code> entregue el producto
	 */
	@Override
	public void entregarProducto() {
		if(robot.obtenerOrdenLista()){
			Impresor.imprimirInfo("Voy al area para entregar el producto");
			robot.cambiarEstado(new Atendiendo(robot));
		} else {
			Impresor.imprimirInfo("Voy al area para cocinar");
			robot.cambiarEstado(new Cocinando(robot));
		}
	}
	
	/**
	 * Metodo que deveuelve como cadena el estado actual
	 */
	@Override
	public String toString() {
		return "Caminando";
	}

}
