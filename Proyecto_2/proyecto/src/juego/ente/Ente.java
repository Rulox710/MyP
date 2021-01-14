package juego.ente;

import juego.casa.cuarto.Cuarto;

public abstract class Ente {
	protected int vida, ataque;
	protected final int vidaM = 5;
	protected Cuarto ubicacion;
	protected String ubicacionAnterior = "";
	
	public Ente(Cuarto ubicacion) {
		this.ubicacion = ubicacion;
		ubicacion.agregarEnte(this);
	}
	
	public boolean hayOtroEnte() {
		return (ubicacion.obtenerEnteAjeno(this) != null);
	}
	
	public abstract String atacar(boolean contraataque);
	
	public String recibirDanio(int d, boolean contraataque) {
		String str = "";
		if(d > vida) {
			vida = 0;
			str += "Ang";
		} else {
			vida = vida - d;
			if(!contraataque) {
				str += "Esa cosa me ha atacado, tengo que contraatacar\n";
				str += atacar(true);
			} 
		}
		return str;
	}
	
	public boolean muerto() {
		return (vida == 0);
	}
	
	public abstract String obtenerVida();
	
	public String buscarSalidas() {
		return "Parece ser que hay salidas hacia el ".concat(ubicacion.mostrarSalidas());
	}
	
	public abstract String cambiarCuarto(String direccion);
}
