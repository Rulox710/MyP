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
	private Cronometro cronometro = Cronometro.obtenerInstancia();
	
	private LectorRecursos lr = new LectorRecursos();
	
	private boolean enFuncionamiento = false;
	
	private int x = 0;
	
	public Juego(GestorVentana gv) {
		this.gv = gv;
		cronometro.agregarJuego(this);
		prepararJuego();
	}
	
	public boolean recibirCadena(String cadena) {
		return acciones(cadena);
	}
	
	public void accionarEnemigo() {
		enemigo.cambiarCuarto("");
		if(jugador.entesJuntos() == 2)
			enviarCadenaJuego("Algo ha entrado al cuarto. Sera mejor que me v" +
				"aya");
	}
	
	private void prepararJuego() {
		lg = new Logica(lr.obtenerComandosValidos());
		jugador = new Jugador(lr.obtenerCasa().get(3));
		enemigo = new Enemigo(lr.obtenerCasa().get(1));
	}
	
	private void enviarCadenaConsola(String cadena) {
		gv.enviarCadenaConsola(cadena);
	}
	
	private void enviarCadenaJuego(String cadena) {
		gv.enviarCadenaJuego(cadena);
	}
	
	private boolean acciones(String cadena) {
		String[] arreglo = lg.acciones(cadena, jugador);
		if(arreglo[0].equals("a")) {
			enviarCadenaJuego(arreglo[1]);
			enviarCadenaConsola(enemigo.ubicacion());
			return true;
		} else {
			enviarCadenaConsola(arreglo[1]);
			return false;
		}
	}
}
