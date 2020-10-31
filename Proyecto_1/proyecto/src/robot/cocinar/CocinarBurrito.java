package robot.cocinar;

import utilidad.Impresor;
import productos.menu.MenuItem;

public class CocinarBurrito implements Cocinar {
	
	private MenuItem platillo;
	
	public CocinarBurrito(MenuItem platillo) {
		this.platillo = platillo;
	}
	
	
	public void cocinar() {
		calentarTortilla();
		if(platillo.obtenerEsVegetariano()) {
			ponerIngredientesVegetarianos();
		} else {
			ponerIngredientesNormales();
		}
		doblarTortilla();
		empaquetar();
		Impresor.imprimirBien("Se termino de preparar el burrito");
	}
	
	public void calentarTortilla() {
		Impresor.imprimirInfo("Se esta calentando la tortilla en el comal");
	}
	
	public void ponerIngredientesVegetarianos() {
		Impresor.imprimirInfo("Se esta poniendo ingredientes excluyendo produ" +
			"ctos de origen animal");
	}
	
	public void ponerIngredientesNormales() {
		Impresor.imprimirInfo("Se esta poniendo ingredientes como carne y fri" +
			"joles");
	}
	
	public void doblarTortilla() {
		Impresor.imprimirInfo("Se esta doblando la tortilla para dar forma de" +
			" burrito ");
	}
	
	public void empaquetar() {
		Impresor.imprimirInfo("Se esta poniendo el burrito en un trozo de pap" +
			"el metalico");
	}
}
