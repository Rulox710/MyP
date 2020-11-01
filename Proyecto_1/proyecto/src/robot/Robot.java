package robot;

import java.util.Iterator;
import utilidad.Impresor;
import utilidad.Escritor;
import robot.estados.EstadosRobot;
import robot.estados.Suspendido;
import productos.menu.MenuItem;
import menu.burrito.MenuBurrito;
import menu.hamburguesa.MenuHamburguesa;
import menu.pizza.MenuPizza;

/**
 * Clase que modela a un robot de McBurgesas
 */
public class Robot {
	
	/**
	 * El <code>EstadoRobot</code> actual
	 */
	private EstadosRobot estado;
	
	private MenuItem platillo;
	
	private boolean ordenLista;
	
	private MenuHamburguesa mh;
	private MenuPizza mp;
	private MenuBurrito mb;
	
	/**
	 * Contructor de la clase
	 * @param mh Un menu de hamburguesas
	 * @param mp Un menu de pizzas
	 * @param mb Un menu de burritos
	 */
	public Robot(MenuHamburguesa mh, MenuPizza mp, MenuBurrito mb) {
		estado = new Suspendido(this);
		this.mh = mh;
		this.mp = mp;
		this.mb = mb;
		ordenLista = false;
	}
	
	/**
	 * Metodo paara cambiar el <code>EstadosRobot</code> actual
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
		Iterator<MenuItem> mh = this.mh.obtenerIterador();
		Iterator<MenuItem> mp = this.mp.obtenerIterador();
		Iterator<MenuItem> mb = this.mb.obtenerIterador();
		int i = 1;
		String str = " * Menu de Hamburguesas \n";
		while(mh.hasNext()) {
			MenuItem mi = mh.next();
			str += "(" + i + ")" + mi.obtenerNombre() + ": " + 
			mi.obtenerDescripcion() + " de costo " + mi.obtenerCosto() + 
			" pesos. ";
			str += (mi.obtenerEsVegetariano())? "Es vegetariano":"No es veget" +
			"ariano";
			str += "\n"; 
			i++;
		}
		str += "\n * Menu de Pizzas \n";
		while(mp.hasNext()) {
			MenuItem mi = mp.next();
			str += "(" + i + ")" + mi.obtenerNombre() + ": " + 
			mi.obtenerDescripcion() + " de costo " + mi.obtenerCosto() + 
				" pesos. ";
			str += (mi.obtenerEsVegetariano())? "Es vegetariano":"No es veget" +
				"ariano";
			i++;
			str += "\n";
		}
		str += "\n * Menu de Burritos \n";
		while(mb.hasNext()) {
			MenuItem mi = mb.next();
			str += "(" + i + ")" + mi.obtenerNombre() + ": " + 
			mi.obtenerDescripcion() + " de costo " + mi.obtenerCosto() + 
			" pesos. ";
			str += (mi.obtenerEsVegetariano())? "Es vegetariano":"No es veget" +
				"ariano";
			i++;
			str += "\n";
		}
		Impresor.imprimir(str + "*\t*\t*\t*\n");
		return i;
	}
	
	/**
	 * Metodo pata obtener el <code>Iterator</code> de 
	 * <code>MenuHamburguesa</code>
	 * @return Un <code>Iterator</code>
	 */
	public Iterator<MenuItem> obtenerMenuHamburguesa() {
		return mh.obtenerIterador();
	}
	
	/**
	 * Metodo pata obtener el <code>Iterator</code> de 
	 * <code>MenuPizza</code>
	 * @return Un <code>Iterator</code>
	 */
	public Iterator<MenuItem> obtenerMenuPizza() {
		return mp.obtenerIterador();
	}
	
	/**
	 * Metodo pata obtener el <code>Iterator</code> de 
	 * <code>MenuBurrito</code>
	 * @return Un <code>Iterator</code>
	 */
	public Iterator<MenuItem> obtenerMenuBurrito() {
		return mb.obtenerIterador();
	}
	
	/**
	 * Obtiene el numero de elementos en el menu de hamburguesas
	 * @return Un entero
	 */
	public int obtenerTamanioHamburguesa() {
		return mh.obtenerElementos();
	}
	
	/**
	 * Obtiene el numero de elementos en el menu de pizzas
	 * @return Un entero
	 */
	public int obtenerTamanioPizza() {
		return mp.obtenerElementos();
	}
	
	/**
	 * Obtiene el numero de elementos en el menu de burritos
	 * @return Un entero
	 */
	public int obtenerTamanioBurrito() {
		return mb.obtenerElementos();
	}
	
	/**
	 * Metodo para obtener el platillo a cocinar
	 * @return Un <code>MenuItem</code>
	 */
	public MenuItem obtenerPlatillo() {
		return platillo;
	}
	
	/**
	 * Metodo para asignar un platillo a cocinar
	 * @param platillo Un platillo a preparar
	 */
	public void asignarPlatillo(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	/**
	 * Metodo que obtiene si la orden esta lista o no
	 * @return <code>true</code> si esta lista, <code>false</code> si no
	 */
	public boolean obtenerOrdenLista() {
		return ordenLista;
	}
	
	/**
	 * Asigan un valor boleano que indica si la orden esta lista
	 * @param ordenLista Un booleano
	 */
	public void asignarOrdenLista(boolean ordenLista) {
		this.ordenLista = ordenLista;
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
