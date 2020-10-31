package productos.mercancia;

import productos.menu.MenuItem;

public class AdaptadorMenuItem implements MenuItem {
	
	private Mercancia mercancia;
	
	/**
	 * Constructor de la clase
	 * @param mercancia Un objeto <code>Mercancia</code> que se adaptara
	 */
	public AdaptadorMenuItem(Mercancia mercancia) {
		this.mercancia = mercancia;
	}
	
	@Override
	public String obtenerNombre() {
		return mercancia.obtenerNombre();
	}
	
	@Override
	public String obtenerDescripcion() {
		return mercancia.obtenerTipoArticulo() + " de color " + 
			mercancia.obtenerColor() + " hecha con " + 
			mercancia.obtenerMaterial();
	}

	@Override
	public boolean obtenerEsVegetariano() {
		return true;
	}
	
	@Override
	public double obtenerCosto() {
		return mercancia.obtenerCosto();
	}
}
