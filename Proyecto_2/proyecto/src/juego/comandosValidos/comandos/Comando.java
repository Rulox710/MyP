package juego.comandosValidos.comandos;

import java.util.ArrayList;

public class Comando {
	
	private String comando;
	private ArrayList<String> similares;
	
	public Comando(String comando) {
		this.comando = comando;
		similares = new ArrayList<>();
	}
	
	public boolean noProcesable() {
		return (comando == null)? true: false;
	}
	
	public void comandoSimilar(String cadena) {
		similares.add(cadena);
	}
	
	public boolean igual(String cadena) {
		if(cadena.equalsIgnoreCase(comando)) return true;
		for(String str: similares) {
			if(cadena.equalsIgnoreCase(str)) return true;
		}
		return false;
	}
	
	public String toString(){
		return comando;
	}
}
