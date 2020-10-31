package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

public class CocinarPizza implements Cocinar {
	
	private MenuItem platillo;
	
	public CocinarPizza(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	public void cocinar() {
		amasarMasa();
		ponerSalsa();
		ponerQueso();
		ponerIngredientes();
		hornear();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar la pizza");
	}
	
	public void amasarMasa() {
		Impresor.imprimirInfo("Se esta amasando la masa y se la da forma");
	}
	
	public void ponerSalsa() {
		Impresor.imprimirInfo("Se esta poniendo la salsa");
	}
	
	public void ponerQueso() {
		String str = "Se esta poniendo el queso";
		str += (platillo.obtenerEsVegetariano())? " vegano": "";
		Impresor.imprimirInfo(str);
	}
	
	public void ponerIngredientes() {
		Impresor.imprimirInfo("Se esta poniendo los ingradientes");
	}
	
	public void hornear() {
		Impresor.imprimirInfo("Se esta honeando la pizza");
	}
	
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo la pizza en una caja");
	}
}
