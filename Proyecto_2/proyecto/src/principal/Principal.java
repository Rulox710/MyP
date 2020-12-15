package principal;

import graficos.control.GestorVentana;
import utilidad.ed.*;

public class Principal {
	public static void main(String[] args) {
		iniciar();
	}
	
	private static void iniciar() {
		GestorVentana gv = new GestorVentana();
		gv.mostrarVentana(0);
	}
}
