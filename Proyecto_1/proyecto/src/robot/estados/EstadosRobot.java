package robot.estados;

/**
 * Clase que modela al <code>Robot</code> en diferentes estados
 */
public interface EstadosRobot {

	/**
	 * Metodo para que el <code>Robot</code> se active y atienda
	 */
	public abstract void activar();
	
	/**
	 * Metodo para que el <code>Robot</code> muestre los menus
	 */
	public abstract void mostrarMenu();
	
	/**
	 * Metodo para hacer que el <code>Robot</code> cocine el producto
	 */
	public abstract void cocinar();
	
	/**
	 * Metodo para hacer que el <code>Robot</code> entregue el producto
	 */
	public abstract void entregarProducto();
	
	/**
	 * Metodo que deveuelve como cadena el estado actual
	 */
	@Override
	public abstract String toString();

}
