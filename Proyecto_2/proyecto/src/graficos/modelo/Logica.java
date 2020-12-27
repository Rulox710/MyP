package graficos.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import utilidad.Escritor;
import juego.comandosValidos.comandos.Comando;
import juego.ente.jugador.Jugador;

/**
 * Clase que tiene las acciones que se podrán realizar en las diferentes 
 * ventanas
 */
public class Logica {
	
	private ArrayList<Comando> comandosValidos;
	
	/**
	 * Constructor de la clase
	 * @param gv El coordinador entre esta clase y las ventanas
	 */
	public Logica(ArrayList<Comando> comandosValidos) {
		this.comandosValidos = comandosValidos;
	}
	
	/**
	 * Metodo para revisar si una cadena esta escrita de tal forma que pueda 
	 * ser entendida por el programa al momento de jugar
	 * @param cadena Una cadena
	 * @return Un boleano 
	 */
	private boolean sePuedeProcesarCadena(String cadena) {
		String str = Escritor.limpiar(cadena);
		for(Comando comando: comandosValidos){
			if(comando.igual(str)) return true;
		}
		System.out.println("No lo entendio");
		return false;
	}
	
	public String[] acciones(String cadena, Jugador jugador) {
		String[] str = cadena.split(" ");
		String cc = "a";
		String resultado = "No entiendo lo que hay que hacer";
		if(sePuedeProcesarCadena(str[0])) {
			if(comandosValidos.get(0).igual(str[0])) {//ayuda
				if(str.length == 1) {
					resultado = "Los comandos que puede usar son: ";
					Iterator it = comandosValidos.iterator();
					while(it.hasNext()) {
						resultado += it.next();
						if(it.hasNext()) resultado += ", ";
					}
				} else {
					cc = "b";
				}
			} else if(comandosValidos.get(1).igual(str[0])) {//inventario
				
			} else if(comandosValidos.get(2).igual(str[0])) {//vida
				if(str.length == 1 || str[1].equalsIgnoreCase("actual")) {
					resultado = jugador.obtenerVida();
				} else {
					cc = "b";
				}
			} else if(comandosValidos.get(3).igual(str[0])) {//regresar
				String tem = "";
				if(str.length == 4) {
					tem = str[1] + str[2] + str[3];
				}
				if(tem.equalsIgnoreCase("alCuartoAnterior") || str.length == 1) {
					resultado = jugador.regresar();
				} else {
					cc = "b";
				}
			} else if(comandosValidos.get(4).igual(str[0])) {//ir
				boolean direccion = false;
				String tem = "";
				if(str.length == 3) {
					tem = str[1];
				} else if(str.length == 4) {
					tem = str[1] + str[2];
				}
				if(tem.equalsIgnoreCase("al") || tem.equalsIgnoreCase("haciaEl")) {
					resultado = jugador.cambiarCuarto(str[str.length-1]);
				} else {
					cc = "b";
				}
			} else if(comandosValidos.get(5).igual(str[0])) {//comer
				
			} else if(comandosValidos.get(6).igual(str[0])) {//incendiar
				
			} else if(comandosValidos.get(7).igual(str[0])) {//leer
				
			} else if(comandosValidos.get(8).igual(str[0])) {//observar
				String tem = "";
				if(str.length == 2) {
					tem = str[1];
				} else if(str.length == 3) {
					tem = str[1] + str[2];
				}
				if(tem.equalsIgnoreCase("cuarto") || tem.equalsIgnoreCase("elCuarto")) {
					resultado = jugador.describirCuarto();
				} else {
					cc = "b";
				}
			} else if(comandosValidos.get(9).igual(str[0])) {//entrar
				
			} else if(comandosValidos.get(10).igual(str[0])) {//girar
				
			} else if(comandosValidos.get(11).igual(str[0])) {//pelear
				
			} 
		} else {
			cc = "b";
		}
		String[] a = {cc,resultado};
		return a;
	}
}
