package productos.mercancia;

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
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public String obtenerTipoArticulo() {
		return tipoArticulo;
	}
	
	public String obtenerColor() {
		return color;
	}
	
	public String obtenerMaterial() {
		return material; 	
	}
	
	public double obtenerCosto() {
		return costo;
	}

}
