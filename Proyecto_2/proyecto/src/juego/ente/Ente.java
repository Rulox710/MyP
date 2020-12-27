package juego.ente;

import juego.casa.cuarto.Cuarto;

public abstract class Ente {
	protected int vida, ataque;
	protected Cuarto ubicacion;
	protected String ubicacionAnterior = "";
	
	public Ente(Cuarto ubicacion) {
		this.ubicacion = ubicacion;
		ubicacion.agregarEnte();
	}
	
	public int entesJuntos() {
		return ubicacion.entesPresentes();
	}
	
	public abstract String obtenerVida();
	
	public String buscarSalidas() {
		return "Parece ser que hay salidas hacia el " + 
			ubicacion.mostrarSalidas();
	}
	
	public abstract String cambiarCuarto(String direccion);
	
	public String abrirMueble(){
		return "";
	}
}
