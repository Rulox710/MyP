package productos.menu;

import java.util.Iterator;
import menu.MenuComponente;
import menu.iteradores.IteradorNulo;
import productos.mercancia.Mercancia;

public abstract class MenuItem extends MenuComponente {
	
	/**
	 * Cadenas que represantan el nombre y la descripcion del objeto
	 */
	protected String nombre, descripcion;
	
	/**
	 * Booleano que representa si es patillo vegetarino o no
	 */
	protected boolean esVegetariano;
	
	/**
	 * Valor <code>double</code> que representa el costo del platillo
	 */
	protected double costo;
	
	protected Mercancia mercancia;
	
	/**
	 * Contructor de la clase para las comidas
	 * @param nombre Cadena con el nombre del platillo
 	 * @param descripcion Cadena con la descripcion del platillo
	 * @param esVegetariano Boleano que indica si es vegetariono o no
	 * @param costo El costo del platillo
	 */
	public MenuItem(String nombre, String descripcion, boolean esVegetariano, 
		double costo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.esVegetariano = esVegetariano;
		this.costo = costo;
	}
	
	/**
	 * Contructor de la clase para las mercancias
	 * @param mercacnia Un objeto que no es comida
	 */
	public MenuItem(Mercancia mercancia) {
		this.nombre = mercancia.obtenerNombre();;
		this.descripcion = mercancia.obtenerTipoArticulo() + " de color " + 
			mercancia.obtenerColor() + " hecha con " + 
			mercancia.obtenerMaterial();
		this.esVegetariano = true;
		this.costo = mercancia.obtenerCosto();
	}
	
	/**
	 * Metodo que obtiene <code>nombre</code>
	 * @return Una cadena
	 */
	@Override
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que obtiene <code>descripcion</code>
	 * @return Una cadena
	 */
	@Override
	public String obtenerDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo que obtiene <code>esVegetariano</code>
	 * @return Un boleano
	 */
	@Override
	public boolean obtenerEsVegetariano() {
		return esVegetariano;
	}
	
	/**
	 * Obtiene el costo del platillo
	 * @return Un <code>double</code>
	 */
	@Override
	public double obtenerCosto() {
		return costo;
	}
	
	/**
	 * Metodo que devuelve una cadena que representa al objeto
	 * @return Una cadena
	 */
	@Override
	public String toString() {
		String str = obtenerNombre() + ": " + obtenerDescripcion()+ " de cost" +
			"o " + obtenerCosto() + ". ";
		str += (obtenerEsVegetariano())? "Es vegetariano.":"No es vegetariano.";
		return str;
	}
	
	/**
	 * Metodo para obtener un iterador
	 * @return <code>IteradorNulo</code>
	 */
	@Override
	public Iterator obtenerIterador() {
		return new IteradorNulo();
	}
}
