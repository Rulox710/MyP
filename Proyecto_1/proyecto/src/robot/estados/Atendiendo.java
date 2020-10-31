package robot.estados;

import java.util.Iterator;
import robot.Robot;
import utilidad.Escritor;
import utilidad.Impresor;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;

public class Atendiendo implements EstadosRobot {
	
	/**
	 * <code>Robot</code> a asiganr este estado
	 */
	private Robot robot;
	
	/**
	 * Contructor de la clase
	 * @param robot Un <code>Robot</code>
	 */
	public Atendiendo(Robot robot) {
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
		if(robot.obtenerPlatillo() == null) {
			Impresor.imprimirInfo("Estos son los menus");
			int i = robot.imprimirMenu();
			boolean verdad = true;
			int entero;
			Impresor.imprimirInfo("\u00BFque desea ordenar?(De el numero del" +
				" platillo)");
			do {
				String str = Escritor.leerCadena();
				if (Escritor.validarNumericoEntero(str)) {
					entero = Integer.parseInt(str);  
					if(entero > 0 && entero < i) {
						verdad = false;
					} else {
						Impresor.imprimirError("No es un numero en el rango d" +
							"e los menus, intente de nuevo");
					}
				} else {
					Impresor.imprimirError("No es un numero, intente de nuevo");
				}
			} while(verdad);
			int contador = 0;
			MenuItem mi = null;
			if(robot.obtenerTamanioHamburguesa() - i < -1) {
				if(robot.obtenerTamanioPizza() - i < -1) {
					Iterator<MenuItem> it = robot.obtenerMenuBurrito();
					contador = robot.obtenerTamanioHamburguesa() + 
						robot.obtenerTamanioPizza();
					while(it.hasNext() && contador < i) {
						mi = it.next();
						contador++;
					}
				} else {
					Iterator<MenuItem> it = robot.obtenerMenuPizza();
					contador = robot.obtenerTamanioHamburguesa();
					while(it.hasNext() && contador < i) {
						mi = it.next();
						contador++;
					}
				}
			} else { 
				Iterator<MenuItem> it = robot.obtenerMenuHamburguesa();
				while(it.hasNext() && contador < i) {
					mi = it.next();
					contador++;
				}
			}
			robot.asignarPlatillo(mi);
			if(mi instanceof AdaptadorMenuItem) {
				entregarProducto();
			} else {
				robot.cambiarEstado(new Caminando(robot));
			}
		} else {
			entregarProducto();
		}
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
		if(robot.obtenerPlatillo() != null){
			MenuItem mi = robot.obtenerPlatillo();
			Impresor.imprimirBien("Se entrega un: " + mi.obtenerNombre() + "." + 
				" Vuelva pronto");
			robot.asignarPlatillo(null);
			robot.cambiarEstado(new Suspendido(robot));
		} else {
			mostrarMenu();
		}
	}
	
	/**
	 * Metodo que deveuelve como cadena el estado actual
	 */
	@Override
	public String toString() {
		return "Atendiendo";
	}
}
