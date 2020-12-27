package juego.ente.enemigo;

import java.util.ArrayList;
import java.util.Random;

import juego.ente.Ente;
import juego.casa.cuarto.Cuarto;

public class Enemigo extends Ente{
	
	Random r = new Random();
	
	public Enemigo(Cuarto cuarto) {
		super(cuarto);
		vida = 5;
		ataque = 3;
	}
	
	public String obtenerVida() {
		if(vida > 0) {
			return "Esa cosa esta viva";
		} else {
			return "Parece muerta, pero se mueve un poco. Sera mejor que me v" +
				"aya";
		}
	}
	
	public String cambiarCuarto(String str) {
		ArrayList<Character> car = ubicacion.llaveSalidasValidas();
		char c = car.get(r.nextInt(car.size()));
		Cuarto cuarto = ubicacion.cambiarCuarto(c);
		switch(c) {
			case 'N': ubicacionAnterior = "sur"; break;
			case 'S': ubicacionAnterior = "norte"; break;
			case 'E': ubicacionAnterior = "oeste"; break;
			case 'O': ubicacionAnterior = "este"; break;
		}
		ubicacion.retirarEnte();
		ubicacion = cuarto;
		ubicacion.agregarEnte();
		return "";
	}
	
	public String ubicacion() {
		return ubicacion.toString();
	}
}
