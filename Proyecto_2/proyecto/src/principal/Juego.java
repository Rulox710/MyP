package principal;

import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;
import graficos.control.GestorVentana;
import graficos.modelo.Logica;
import lectorRecursos.LectorRecursos;
import juego.cronometro.Cronometro;

public class Juego {
	
	private Jugador jugador;
	private Enemigo enemigo;
	private GestorVentana gv;
	private Logica lg;
	
	private boolean enFuncionamiento = false;
	
	private int x = 0;
	
	public Juego(GestorVentana gv) {
		this.gv = gv;
		Cronometro.instancia.agregarJuego(this);
		prepararJuego();
	}
	
	public boolean recibirCadena(String cadena) {
		return acciones(cadena);
	}
	
	public void accionarEnemigo() {
		if(enemigo.hayOtroEnte()) {
			enviarCadenaJuego(enemigo.atacar(false));
		} else {
			enemigo.cambiarCuarto("");
			if(jugador.hayOtroEnte())
			enviarCadenaJuego("Algo ha entrado al cuarto. Sera mejor que me v" +
				"aya");
		}
	}
	
	private void prepararJuego() {
		LectorRecursos.iniciar();
		lg = new Logica();
		jugador = new Jugador(LectorRecursos.obtenerCasa().get(3));
		enemigo = new Enemigo(LectorRecursos.obtenerCasa().get(1));
	}
	
	private void enviarCadenaConsola(String cadena) {
		gv.enviarCadenaConsola(cadena);
	}
	
	private void enviarCadenaJuego(String cadena) {
		gv.enviarCadenaJuego(cadena);
	}
	
	private boolean acciones(String cadena) {
		String resultado = lg.acciones(cadena, jugador);
		if(lg.obtenerEsParaJuego()) {
			enviarCadenaJuego(resultado);
			return true;
		} else {
			enviarCadenaConsola(resultado);
			return false;
		}
	}
}
