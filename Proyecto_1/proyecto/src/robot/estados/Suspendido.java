package robot.estados;

import utilidad.Impresor;
import utilidad.Escritor;
import robot.Robot;

/**
 * Clase que modela al <code>Robot</code> cuando esta <code>Suspendido</code>
 */
public class Suspendido implements EstadosRobot {
	
	/**
	 * <code>Robot</code> a asiganr este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor de la clase
	 * @param robot Un <code>Robot</code>
	 */
	public Suspendido(Robot robot) {
		this.robot = robot;
	}
	
	/**
	 * Metodo para que el <code>Robot</code> se active y atienda
	 */
	@Override
	public void activar() {
		boolean verdad = true;
		Impresor.imprimirInfo("Salutaciones, humano. \u00BFPuedo tomar su ord" +
			"en?(S/N)");
		do {
			switch(Escritor.leerCadena().toUpperCase()) {
				case "S":
				Impresor.imprimirBien("Entonces la tomare");
				robot.cambiarEstado(new Atendiendo(robot));
				verdad = false;
				break;
				case "N":
				Impresor.imprimirBien("Vuelva pronto");
				verdad = false;
				break;
				default:
				Impresor.imprimirError("No ha seleccionado una opcion valida," +
					" intente de nuevo(S/N)");
			}
		} while(verdad);
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
		Impresor.imprimirAlerta("No puedo hacer eso ahora");
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
		return "Suspendido";
	}
}
