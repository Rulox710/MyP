package lectorRecursos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import juego.comandosValidos.comandos.Comando;
import juego.casa.cuarto.Cuarto;

public class LectorRecursos {
	
	private ArrayList<Comando> comandosValidos = new ArrayList<>();
	private ArrayList<Cuarto> casa = new ArrayList<>();
	   
    private String separador = System.getProperty("file.separator");
	
	public LectorRecursos() {
		iniciar();
	}
	
	public ArrayList<Comando> obtenerComandosValidos() {
		return comandosValidos;
	}
	
	public ArrayList<Cuarto> obtenerCasa() {
		return casa;
	}
	
	private void iniciar() {
		try {
			Scanner in = new Scanner(new File("recursos" + separador + "Comandos.txt")); 
			while(in.hasNext()) {
				iniciarComando(in.nextLine());
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Scanner in = new Scanner(new File("recursos" + separador + "Mapa.txt")); 
			while(in.hasNext()) {
				iniciarCuarto(in.nextLine());
			}
			in.close();
			in = new Scanner(new File("recursos" + separador + "Mapa.txt"));
			while(in.hasNext()){
				conectarCuartos(in.nextLine());
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciarComando(String cadena) {
		String[] separada = cadena.split("<");
		Comando comando = new Comando(separada[0]);
		if (separada.length == 2) {
			String[] s = separada[1].split(",");
			for(String c:s) {
				comando.comandoSimilar(c);
			}
		}
		comandosValidos.add(comando);
	}
	
	public void iniciarCuarto(String cadena) {
		String[] separada = cadena.split(":");
		Cuarto cuarto = new Cuarto(separada[0],separada[1],"Por defecto");
		casa.add(cuarto);
	}
	
	public void conectarCuartos(String cadena) {
		String[] separada = cadena.split(":");;
		Cuarto asignar = null;
		for(Cuarto c1: casa) {
			if(c1.validarId(separada[0])) {
				asignar = c1;
				break;
			}
		}
		String[] salidas1 = separada[2].split(",");
		for(String cuarto: salidas1) {
			String[] dir = cuarto.split("-");
			try {
				asignar.asignarSalidaV(dir[0].charAt(0),casa.get(Integer.parseInt(dir[1])-1));
			} catch(Exception e) {}
		}
		if(separada.length == 4) {
			salidas1 = separada[3].split(",");
			for(String cuarto: salidas1) {
				String[] dir = cuarto.split("-");
				try {
					asignar.asignarSalidaI(dir[0].charAt(0),casa.get(Integer.parseInt(dir[1])-1));
				} catch(Exception e) {}
			}
		}
	}
}
