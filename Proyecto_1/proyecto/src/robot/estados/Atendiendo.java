package robot.estados;

import java.util.Iterator;
import utilidad.Escritor;
import utilidad.Impresor;
import utilidad.consola.CaracterEspecial;
import robot.Robot;
import menu.MenuComponente;
import productos.menu.MenuItem;
import productos.mercancia.AdaptadorMenuItem;
import productos.Ticket;

/**
 * Clase que modela al <code>Robot</code> cuando esta <code>Atendiendo</code>
 */
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
			boolean verdad = true;
			int i = robot.imprimirMenu(), entero = 0;
			Impresor.imprimirInfo("\u00BFque desea ordenar?(De el numero del" +
				" platillo)");
			int borrar = i+9;
			do {
				String str = Escritor.leerCadena();
				if (Escritor.validarNumericoEntero(str)) {
					entero = Integer.parseInt(str);  
					if(entero > 0 && entero < i) {
						verdad = false;
						System.out.print(CaracterEspecial.arribaN(borrar) + CaracterEspecial.limpiaLinSig());
					} else {
						Impresor.imprimirError("No es un numero en el rango d" +
							"e los menus, intente de nuevo");
						borrar++;
					}
				} else {
					Impresor.imprimirError("No es un numero, intente de nuevo");
					borrar++;
				}
			} while(verdad);
			int contador = 1;
			MenuComponente mi = null;
			Iterator<MenuComponente> iterador = robot.obtenerIteradorMenu();
			while (iterador.hasNext() && contador++ <= entero) {
				mi = iterador.next();
			}
			Impresor.imprimirAlerta("Se escogio: " + mi.obtenerNombre());
			robot.asignarNumeroPlatillo(entero);
			
			if(mi instanceof AdaptadorMenuItem) {
				robot.asignarPlatillo(mi);
				robot.obtenerNumeroPlatillo();
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
			Ticket ticket = new Ticket(robot.obtenerPlatillo());
			Impresor.imprimirInfo("Se entrega el ticket de compra");
			Impresor.imprimirBien(ticket.toString());
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
