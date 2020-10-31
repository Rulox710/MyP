package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

public class CocinarHamburguesa implements Cocinar {
	
	private MenuItem platillo;
	
	public CocinarHamburguesa(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	public void cocinar() {
		calentarPan();
		cocinarCarne();
		ponerCondimentos();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar la hamburguesa");
	}
	
	public void cocinarCarne() {
		String str = "Se esta cocinando la carne";
		str += (platillo.obtenerEsVegetariano())? " de tofu": "";
		Impresor.imprimirInfo(str);
	}
	
	public void calentarPan() {
		Impresor.imprimirInfo("Se esta calentando el pan");
	}
	
	public void ponerCondimentos() {
		 Impresor.imprimirInfo("Se esta poniendo la carne en el pan junto a l" +
			"os condimentos");
	}
	
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo la hamburguesa en un paquete");
	}
	
}
