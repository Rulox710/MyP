package juego.inventario;

import java.util.Iterator;

public abstract class ComponenteInventario {
	
	public void agregar(ComponenteInventario ci) {
		throw new UnsupportedOperationException();
	}
	
	public String obtenerNombre() {
		throw new UnsupportedOperationException();
	}
	
	public String obtenerDescripcion() {
		throw new UnsupportedOperationException();
	}
	
	public int obtenerId() {
		throw new UnsupportedOperationException();
	}
	
	public Iterator obtenerIterador() {
		throw new UnsupportedOperationException();
	}
}
