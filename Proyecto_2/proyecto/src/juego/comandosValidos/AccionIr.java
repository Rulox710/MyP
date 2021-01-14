package juego.comandosValidos;

import juego.ente.jugador.Jugador;

public class AccionIr extends AccionDefecto {
	
	boolean regresar = false;
	String usar = null;
	
	public AccionIr(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		String[] str = cadena.split(" ");
		String temp = "";
		if(str.length != 0 && str[str.length-1].equals("1")) {
			if(validarRegresar(str)) {
				esParaJuego = true;
			}
		} else if(str.length >= 2 && str.length <= 4) {
			if (validarNormal(str)) {
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	private boolean validarRegresar(String[] str) {
		for(int i = 0; i < str.length ;i++) System.out.print(str[i]+ " ");
		if(str.length == 2) {
			usar = "anterior";
			regresar = true;
		}
		if(str.length == 4) {
			String tem = "".concat(str[0]).concat(str[1]).concat(str[2]);
			if(tem.equalsIgnoreCase("alCuartoAnterior")) {
				usar = str[2];
				regresar = true;
			}
		}
		return usar != null;
	}
	
	private boolean validarNormal(String[] str) {
		String temp = "";
		for(int i = 0; i < str.length-1; i++) {
			temp = temp.concat(str[i]);
			if(i < str.length-2) {
				temp = temp.concat(" ");
			}
		}
		if(temp.equalsIgnoreCase("al") || temp.equalsIgnoreCase("hacia el")) {
			usar = str[str.length-1];
		} else if(temp.equalsIgnoreCase("al Cuarto") 
			|| temp.equalsIgnoreCase("hacia El Cuarto")) {
			usar = str[str.length-1];
			regresar = true;
		}
		return usar != null;
	}
	
	protected String ejecutarAccion() {
		if(regresar) {
			if(usar.equalsIgnoreCase("anterior")) return jugador.regresar();
		}
		return jugador.cambiarCuarto(usar);
	}
}
