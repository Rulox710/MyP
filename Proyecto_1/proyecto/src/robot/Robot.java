package robot;

import java.util.Iterator;
import utilidad.Impresor;
import utilidad.Escritor;
import robot.estados.EstadosRobot;
import robot.estados.Suspendido;
import menu.MenuComponente;
import menu.menus.burrito.MenuBurrito;
import menu.menus.hamburguesa.MenuHamburguesa;
import menu.menus.pizza.MenuPizza;

/**
 * Clase que modela a un robot de McBurgesas
 */
public class Robot {
	
	/**
	 * El <code>EstadoRobot</code> actual
	 */
	private EstadosRobot estado;
	
	private int nPlatillo = -1;
	
	private MenuComponente platillo;
	
	private MenuComponente mc;
	
	/**
	 * Contructor de la clase
	 * @param mc Un componente del menu. Debe se un <code>Menu</code> de 
	 * preferencia
	 */
	public Robot(MenuComponente mc) {
		estado = new Suspendido(this);
		this.mc = mc;
	}
	
	/**
	 * Metodo para cambiar el <code>EstadosRobot</code> actual
	 * @param er El nuevo <code>EstadosRobot</code>
	 */
	public void cambiarEstado(EstadosRobot er) {
		this.estado = er;
		Impresor.imprimirExtra("Actualmente el robot esta: " + 
			estado.toString());
	}
	
	/**
	 * Metodo para imprimir los tres menus enumerados
	 * @return Un nuemro entero que representa la cantidad de elementos de los 
	 * menus mas uno
	 */
	public int imprimirMenu() {
		System.out.println(mc.toString());
		return mc.tamanio();
	}
	
	/**
	 * Metodo pata obtener el <code>Iterator</code> de 
	 * <code>MenuHamburguesa</code>
	 * @return Un <code>Iterator</code>
	 */
	public Iterator<MenuComponente> obtenerIteradorMenu() {
		return mc.obtenerIterador();
	}
	
	/**
	 * Metodo para obtener el numero que representa al platillo a cocinar
	 * @return Un entero
	 */
	public int obtenerNumeroPlatillo() {
		return nPlatillo;
	}
	
	/**
	 * Metodo para obtener el platillo hecho, luego lo entrega
	 * @return Un <code>MenuItem</code>
	 */
	public MenuComponente obtenerPlatillo() {
		return platillo;
	}
	
	/**
	 * Metodo para asignar un platillo a cocinar
	 * @param nPlatillo Un entero que representa el platillo a preparar
	 */
	public void asignarNumeroPlatillo(int nPlatillo) {
		this.nPlatillo = nPlatillo;
	}
	
	/**
	 * Metodo para asignar un platillo a cocinar
	 * @param platillo Un <code>MenuComponente</code> que es el platillo listo
	 */
	public void asignarPlatillo(MenuComponente platillo) {
		this.platillo = platillo;
	}
	
	/**
	 * Metodo para comenzar la simulacion del <code>Robot</code>
	 */
	public void ejectutar() {
		boolean verdad = true;
		do {
			estado.activar();
			if(estado.toString() == "Atendiendo") {
				estado.mostrarMenu();
				if(estado.toString() != "Suspendido") {
					estado.cocinar();
					estado.cocinar();
					estado.entregarProducto();
					estado.entregarProducto();
				}
			}
			Impresor.imprimirInfo("\u00BFHay alguien mas en la fila?(S/N)");
			boolean v2 = true;
			do {
				switch(Escritor.leerCadena().toUpperCase()){
					case "S":
					v2 = false;
					break;
					case "N":
					Impresor.imprimirBien("Ha sido un largo dia, a mimir");
					Impresor.imprimir("\u00BFQuiere continuar la simulacion?" +
						"(S/N)");
					verdad = false;
					v2 = false;
					break;
					default:
					Impresor.imprimirError("No ha seleccionado una opcion val" +
						"ida, intente de nuevo(S/N)");
				}
			} while(v2);
			
		} while(verdad);
	}
	
}
