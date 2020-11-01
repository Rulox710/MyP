package productos.mercancia;

import productos.menu.MenuItem;

/**
 * Clase que adapta a <code>Mercancia</code> para que pueda ser usada como 
 * <code>MenuItem</code>
 */
public class AdaptadorMenuItem implements MenuItem {
	
	private Mercancia mercancia;
	
	/**
	 * Constructor de la clase
	 * @param mercancia Un objeto <code>Mercancia</code> que se adaptara
	 */
	public AdaptadorMenuItem(Mercancia mercancia) {
		this.mercancia = mercancia;
	}
	
	/**
	 * Metodo para obtener el nombre de la <code>Mercancia</code>
	 * @return Una cadena
	 */
	@Override
	public String obtenerNombre() {
		return mercancia.obtenerNombre();
	}
	
	/**
	 * Metodo para obtener la descripcion de la de <code>Mercancia</code>
	 * @return Una cadena 
	 */
	@Override
	public String obtenerDescripcion() {
		return mercancia.obtenerTipoArticulo() + " de color " + 
			mercancia.obtenerColor() + " hecha con " + 
			mercancia.obtenerMaterial();
	}
	
	/**
	 * Metodo que dice si la <code>Mercancia</code> es vegetariana
	 * @return <code>true</code>
	 */
	@Override
	public boolean obtenerEsVegetariano() {
		return true;
	}
	
	/**
	 * Metodo que devuelve el costo de la <code>Mercancia</code>
	 * @return Un numero
	 */
	@Override
	public double obtenerCosto() {
		return mercancia.obtenerCosto();
	}
}
