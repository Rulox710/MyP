package juego.ente.jugador;

import juego.ente.Ente;
import juego.casa.cuarto.Cuarto;

public class Jugador extends Ente {
	
	public Jugador(Cuarto cuarto) {
		super(cuarto);
		vida = 5;
		ataque = 1;
	}
	
	public String describirCuarto() {
		String str = ubicacion.obtenerNombre();
		str += "\n" + ubicacion.obtenerDescripcion();
		if(entesJuntos() == 2) str += "\nHay una cosa antorpomorfica aqui, pe" +
			"ro seguro que no es humano";
		return str;
	}
	
	public String regresar() {
		return cambiarCuarto(ubicacionAnterior);
	}
	
	public String cambiarCuarto(String direccion) {
		String cadena = "";
		char d = ' ';
		if(direccion.equalsIgnoreCase("norte")) {
			d = 'N';
		} else if(direccion.equalsIgnoreCase("sur")) {
			d = 'S';
		} else if(direccion.equalsIgnoreCase("este")) {
			d = 'E';
		} else if(direccion.equalsIgnoreCase("oeste")) {
			d = 'O';
		} else {
			return "No creo que esa direccion exista";
		} 
		Cuarto nuevo = ubicacion.cambiarCuarto(d);
		if(nuevo == null) {
			nuevo = ubicacion.sinSalida(d);
			if(nuevo == null) { 
				cadena += "No parece haber una puerta en esa direccion";
			} else {
				cadena += "Intento pasar por esa puerta, pero no se abre, ten" +
					"dre que ir por otro lado";
			}
		} else {
			cadena += "Paso por la puerta al otro cuarto";
			ubicacion.retirarEnte();
			switch(d) {
				case 'N': ubicacionAnterior = "sur"; break;
				case 'S': ubicacionAnterior = "norte"; break;
				case 'E': ubicacionAnterior = "oeste"; break;
				case 'O': ubicacionAnterior = "este"; break;
			}
			ubicacion = nuevo;
			ubicacion.agregarEnte();
			if(ubicacion.entesPresentes() == 2) {
				cadena += "\nHay algo mas en el cuarto";
			}
		}
		return cadena;
	}
	
	public String obtenerVida() {
		String v = "";
		if(vida == 5) v = "Estoy bien";
		if(vida < 5 && vida > 2) v = "Estoy herido";
		if(vida <= 2) v = "Estoy en peligro";
		return v;
	}

}
