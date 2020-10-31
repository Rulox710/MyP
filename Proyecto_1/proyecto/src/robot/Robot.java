package robot;

import java.util.Iterator;
import utilidad.Impresor;
import robot.estados.EstadosRobot;
import robot.estados.Suspendido;
import productos.menu.MenuItem;
import menu.burrito.MenuBurrito;
import menu.hamburguesa.MenuHamburguesa;
import menu.pizza.MenuPizza;

public class Robot {
	
	/**
	 * El <code>EstadoRobot</code> actual
	 */
	private EstadosRobot estado;
	
	private MenuItem platillo;
	
	private MenuHamburguesa mh;
	private MenuPizza mp;
	private MenuBurrito mb;
	
	/**
	 * Contructor de la clase
	 */
	public Robot(MenuHamburguesa mh, MenuPizza mp, MenuBurrito mb) {
		estado = new Suspendido(this);
		this.mh = mh;
		this.mp = mp;
		this.mb = mb;
	}
	
	/**
	 * Metodo paara cambiar el <code>EstadosRobot</code> actual
	 * @param er El nuevo <code>EstadosRobot</code>
	 */
	public void cambiarEstado(EstadosRobot er) {
		this.estado = er;
	}
	
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
			str += (mi.obtenerEsVegetariano())? "Es vegetariano":"No es vegetariano";
			i++;
			str += "\n";
		}
		str += "\n * Menu de Burritos \n";
		while(mb.hasNext()) {
			MenuItem mi = mb.next();
			str += "(" + i + ")" + mi.obtenerNombre() + ": " + 
			mi.obtenerDescripcion() + " de costo " + mi.obtenerCosto() + 
			" pesos. ";
			str += (mi.obtenerEsVegetariano())? "Es vegetariano":"No es vegetariano";
			i++;
			str += "\n";
		}
		Impresor.imprimir(str + "\n*\t*\t*\t*\n");
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
	
	public int obtenerTamanioHamburguesa() {
		return mh.obtenerElementos();
	}
	
	public int obtenerTamanioPizza() {
		return mp.obtenerElementos();
	}
	
	public int obtenerTamanioBurrito() {
		return mb.obtenerElementos();
	}
	 
	public MenuItem obtenerPlatillo() {
		return platillo;
	}
	 
	public void asignarPlatillo(MenuItem platillo) {
		this.platillo = platillo;
	}
	
}
