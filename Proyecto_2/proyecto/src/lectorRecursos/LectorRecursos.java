package lectorRecursos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import juego.comandosValidos.comandos.Comando;
import juego.casa.cuarto.Cuarto;
import juego.casa.cuarto.mueble.Mueble;
import juego.casa.cuarto.mueble.item.*;

public final class LectorRecursos {
	
	private static ArrayList<Comando> comandosValidos = new ArrayList<>();
	private static ArrayList<Cuarto> casa = new ArrayList<>();
	private static ArrayList<Mueble> muebles = new ArrayList<>();
	private static ArrayList<Item> items = new ArrayList<>();
	   
    private static String separador = System.getProperty("file.separator");
	
	private static boolean iniciado = false;
	
	public static ArrayList<Comando> obtenerComandosValidos() {
		return comandosValidos;
	}
	
	public static ArrayList<Cuarto> obtenerCasa() {
		return casa;
	}
	
	public static ArrayList<Mueble> obtenerMuebles() {
		return muebles;
	}
	
	public static ArrayList<Item> obtenerItems() {
		return items;
	}
	
	public static void iniciar() {
		if(iniciado) return;
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
		
		try {
			Scanner in = new Scanner(new File("recursos" + separador + "Items.txt")); 
			int clave = 0;
			while(in.hasNext()) {
				String str = in.nextLine();
				if(str.equals(">")) {
					clave++;
				} else {
					iniciarItems(str,clave);
				}
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Scanner in = new Scanner(new File("recursos" + separador + "Muebles.txt")); 
			while(in.hasNext()) {
				iniciarMuebles(in.nextLine());
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		asignarMuebles();
	}
	
	private static void iniciarComando(String cadena) {
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
	
	private static void iniciarCuarto(String cadena) {
		String[] separada = cadena.split(":");
		Cuarto cuarto = new Cuarto(separada[0],separada[1],separada[2]);
		casa.add(cuarto);
	}
	
	private static void conectarCuartos(String cadena) {
		String[] separada = cadena.split(":");;
		Cuarto asignar = null;
		for(Cuarto c1: casa) {
			if(c1.validarId(separada[0])) {
				asignar = c1;
				break;
			}
		}
		String[] salidas1 = separada[3].split(",");
		for(String cuarto: salidas1) {
			String[] dir = cuarto.split("-");
			try {
				asignar.asignarSalidaV(dir[0].charAt(0),casa.get(Integer.parseInt(dir[1])-1));
			} catch(Exception e) {}
		}
		if(separada.length == 5) {
			salidas1 = separada[4].split(",");
			for(String cuarto: salidas1) {
				String[] dir = cuarto.split("-");
				try {
					asignar.asignarSalidaI(dir[0].charAt(0),casa.get(Integer.parseInt(dir[1])-1));
				} catch(Exception e) {}
			}
		}
	}
	
	private static void iniciarMuebles(String mueble) {
		Mueble m = null;
		String[] str = mueble.split(">");

		String[] creador = str[0].split(",");
		if(creador.length == 1) {
			m = new Mueble(creador[0]);
		} else {
			m = new Mueble(creador[0],creador[1]);
		}
		if(str.length == 2) {
			String[] lista = str[1].split(",");
			for(String s: lista) {
				m.agregarObjeto(items.get(Integer.parseInt(s)-1));
			}
		}
		muebles.add(m);
	}
	
	private static void iniciarItems(String item, int clave) {
		String[] str= item.split(":");
		switch(clave) {
			case 1:
			Consumible c = new Consumible(Integer.parseInt(str[0]),str[1],str[2]);
			c.asignarCura(Integer.parseInt(str[3]));
			items.add(c);
			break;
			case 3:
			Llave l = new Llave(Integer.parseInt(str[0]),str[1],str[2]);
			if(str.length == 4) l.asignarClave(str[3]);
			items.add(l);
			break;
			case 2:
			Herramienta h = new Herramienta(Integer.parseInt(str[0]),str[1],str[2]);
			h.asignarDanio(Integer.parseInt(str[3]));
			items.add(h);
			break;
			case 4:
			Nota n = new Nota(Integer.parseInt(str[0]),str[1],str[2]);
			items.add(n);
			break;
		}
	}
	
	private static void asignarMuebles() {
		Iterator<Cuarto> itCasa = casa.iterator();
		Iterator<Mueble> itMuebles = muebles.iterator();
		int i = 0;
		while(itCasa.hasNext()) {
			itCasa.next().asignarMueble(itMuebles.next());
		}
	}
}
