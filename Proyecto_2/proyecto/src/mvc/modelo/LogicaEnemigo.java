package mvc.modelo;

import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;

public class LogicaEnemigo {
	
	private Enemigo enemigo;
	private Jugador jugador;
	 
	public LogicaEnemigo(Jugador jugador, Enemigo enemigo) {
		this.enemigo = enemigo;
		this.jugador = jugador;
	}
	
	public String acciones() {
		String g = "";
		if(enemigo.muerto() && !enemigo.obtenerMuerto()) {
			enemigo.revivir();
			if(enemigo.hayOtroEnteVivo()) {
				g = "Esa cosa se ha levantado ahora mismo";
			}
			return g;
		}
		if(enemigo.hayOtroEnteVivo()) {
			if(enemigo.atacar()) {
				g = "Esa cosa me ha atacado";
				if(jugador.muerto()) {
					g = g.concat("... me siento... debil...\nFIN DEL JUEGO");
				} else {
					g = g.concat(" tengo que hacer algo rapido antes de que m" +
						"e ataque de nuevo");
				}
				return g;
			}
		} else {
			enemigo.cambiarCuarto(' ');
			if(enemigo.hayOtroEnte()) {
				String ubi = "";
				switch(enemigo.obtenerUbicacionAnteriorCar()) {
					case 'N': ubi = "norte"; break;
					case 'S': ubi = "sur"; break;
					case 'E': ubi = "este"; break;
					case 'O': ubi = "oeste"; break;
				}
				return "Algo ha entrado al cuarto por el " + ubi + " . Sera m" + 
				"ejor que me vaya por cualquier lado menos esa direccion";
			}
		}
		return g;
	}
}
