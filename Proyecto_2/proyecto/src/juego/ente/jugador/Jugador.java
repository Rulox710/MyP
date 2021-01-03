package juego.ente.jugador;

import java.util.Iterator;

import juego.ente.Ente;
import juego.casa.cuarto.Cuarto;
import juego.casa.cuarto.mueble.item.*;
import juego.inventario.Inventario;

public class Jugador extends Ente {
	//llaves herramientas consumibles
	private Inventario[] inventario = new Inventario[3];
	
	public Jugador(Cuarto cuarto) {
		super(cuarto);
		vida = 5;
		ataque = 3;
		inventario[0] = new Inventario(10);
		inventario[1] = new Inventario(2);
		inventario[2] = new Inventario(6);
	}
	
	public String describirCuarto() {
		String str = ubicacion.obtenerNombre();
		str += "\n" + ubicacion.obtenerDescripcion();
		if(ubicacion.obtenerEnteAjeno(this) != null)
		str += "\nHay una cosa antorpomorfica aqui, pero seguro que no es hum" +
			"ano";
		return str;
	}
	
	public String abrirMueble(String llave) {
		String cadena = "";
		if(llave.length() == 0) {
			cadena = ubicacion.obtenerMueble().abrir();
		} else {
			Llave usar = null;
			Iterator<Item> it = inventario[2].obtenerIterador();
			while(it.hasNext()) {
				Item item = it.next();
				if(item.equals(llave)) {
					usar = (Llave)item;
					break;
				}
			}
			cadena = ubicacion.obtenerMueble().abrir(usar);
		}
		return cadena;
	}
	
	public String tomarObjeto(String objeto) {
		Object[] procesar = ubicacion.obtenerMueble().tomarObjeto(objeto);
		boolean tomado = false;
		if(procesar[0] != null) {
			if(procesar[0] instanceof Consumible) {
				tomado = inventario[0].agregar((Consumible)procesar[0]);
			} else if (procesar[0] instanceof Herramienta) {
				tomado = inventario[1].agregar((Herramienta)procesar[0]);
			} else {
				tomado = inventario[2].agregar((Llave)procesar[0]);
			}
			if(!tomado) {
				ubicacion.obtenerMueble().agregarObjeto((Item)procesar[0]);
				return "No puedo tomar el objeto porque no puedo cargar mas" +
					". Voy a devolver el objeto";
			}
		}
		return (String)procesar[1];
	}
	
	public String atacar(boolean contraataque) {
		String str = "";
		Ente enemigo = ubicacion.obtenerEnteAjeno(this);
		if(enemigo != null) {
			if(enemigo.muerto()) return "Aunque le siga atacando, se levantara";
			enemigo.recibirDanio(ataque, contraataque);
			str += "Le he atacado";
			if(enemigo.muerto()) {
				str += " y lo he derribado, pero parece como si se fuese a le" +
					"vantar en cualquier momento";
			} else {
				if(!contraataque)
					str += " y ahora parace dispuesto a contraatacar";
			}
		} else {
			str += "\u00BFPero a que debo atacar?";
		}
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
			ubicacion.retirarEnte(this);
			switch(d) {
				case 'N': ubicacionAnterior = "sur"; break;
				case 'S': ubicacionAnterior = "norte"; break;
				case 'E': ubicacionAnterior = "oeste"; break;
				case 'O': ubicacionAnterior = "este"; break;
			}
			ubicacion = nuevo;
			ubicacion.agregarEnte(this);
			if(ubicacion.obtenerEnteAjeno(this) != null) {
				cadena += "\nHay algo mas en el cuarto, sera mejor que regres" +
					"e por donde entre";
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
