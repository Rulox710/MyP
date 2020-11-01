package productos.mercancia;

/**
 * Clase que modela varios objtos no comestibles para ser vendidos
 */
public class Mercancia {
	
	/**
	 * Cadenas que representas varios atributos de la mercancia
	 */
	private String nombre, tipoArticulo, color, material;
	
	/**
	 * El precio que tendra
	 */
	private double costo;
	
	/**
	 * Constructor de la clase
	 */
	public Mercancia(String nombre, String tipoArticulo, String color, 
		String material, double costo){
		this.nombre = nombre;
		this.tipoArticulo = tipoArticulo;
		this.color = color;
		this.material = material;
		this.costo = costo;
	}
	
	/**
	 * Metodo para obtener el nombre del articulo
	 * @return Una cadena
	 */
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para obtener el tipo de articulo
	 * @return Una cadena
	 */
	public String obtenerTipoArticulo() {
		return tipoArticulo;
	}
	
	/**
	 * Metodo para obtener el color del objeto
	 * @return Una cadena
	 */
	public String obtenerColor() {
		return color;
	}
	
	/**
	 * Metodo para obtener el material del que esta hecho
	 * @return Una cadena
	 */
	public String obtenerMaterial() {
		return material; 	
	}
	
	/**
	 * Metodo para obtener el costo
	 * @return Un numero
	 */
	public double obtenerCosto() {
		return costo;
	}

}
