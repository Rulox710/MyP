package juego.ente.jugador;

import java.util.Iterator;
import java.util.ArrayList;

import juego.ente.Ente;
import juego.cuarto.Cuarto;
import juego.item.*;
import juego.inventario.Inventario;
import juego.inventario.InventarioGeneral;

/**
 * Clase que extiende a <code>Ente</code> que representa al jugador
 */
public class Jugador extends Ente {
	private InventarioGeneral ig = new InventarioGeneral();
	private Herramienta equipo = null;
	private Director director = new Director();
	
	/**
	 * Constructor
	 * @param cuarto La ubicacion inicial del jugador
	 */
	public Jugador(Cuarto cuarto) {
		super(cuarto);
		vida = 5;
		ataque = 1;
	}
	
	/**
	 * Metodo para obtener una cadena que describe la <code>ubicacion</code> 
	 * actual del jugador
	 * @return Una cadena
	 */
	public String describirCuarto() {
		String str = ubicacion.obtenerNombre();
		str = str.concat("\n" + ubicacion.obtenerDescripcion());
		if(hayOtroEnte() && !hayOtroEnteVivo()) {
			str = str.concat("\nHay una cosa aqui, pero esta derribada. Debo " +
				"irme mientras este inconciente");
		} else if(hayOtroEnte()) {
			str = str.concat("\nHay una cosa antorpomorfica aqui, pero seguro" +
			" que no es humano. Deberia regresar por donde entre");
		}
		return str;
	}
	
	/**
	 * Metodo para obtener una cadena con las posibles salidas del cuarto
	 * @return Un iterador de <code>String</code>
	 */
	public Iterator<String> buscarSalidas() {
		return ubicacion.mostrarSalidas();
	}
	
	/**
	 * Metodo para validar que una cadena represente al mueble de la ubicacion 
	 * del jugador
	 * @param mueble Una cadena
	 * @return Un boleano
	 */
	public boolean validarMueble(String mueble) {
		return ubicacion.obtenerMueble().validarMuebleCadena(mueble);
	}
	
	/**
	 * Metodo para ver el contenido del mueble en la ubicacion actual del 
	 * jugador. Da un iterador para luego ser tratado como corresponda
	 */
	public Iterator verContenidoMueble() {
		return ubicacion.obtenerMueble().verContenido();
	}
	
	/**
	 * Metodo para obtener la posicion de un objeto segun su nombre exacto en el
	 * inventario del jugador
	 * @param objeto Una cadena
	 * @return Un numero entero que es la pocision del objeto en el inventario.
	 * Este no excede <code>27</code> y es <code>-1</code> si el objeto no existe
	 */
	public int posicionEnInventario(String objeto) {
		return ig.indicePorCadena(objeto,true);
	}
	
	/**
	 * Metodo para obtener un iterador del inventario
	 * @return Un iterador
	 */
	public Iterator obtenerInventario() {
		return ig.obtenerIterador();
	}
	
	/**
	 * Metotdo para obtener un iterador del inventario pero de ciertos objetos
	 * @param c Si el caracter es 'L' entonces solo se dan llaves, si es 'H' 
	 * entonces son herramientas, si es 'C' entonces son consumibles, si es 'N'
	 * entonces son notas y si es cualquier otro caracter, devuelve un iterador 
	 * de todo {@link obtenerInventario() metodo} 
	 * @return Un iterador
	 */
	public Iterator obtenerInventario(char c) {
		return ig.obtenerIterador(c);
	}
	
	/**
	 * Metodo para combinar objetos del inventario del jugador. Debe usarse 
	 * {@link posicionEnInventario(String) metodo} antes para conocer los
	 * valores de i y j
	 * @param i La posicion en el inventario del primer objeto a combinar
	 * @param j La posicion del segundo objeto a combinar 
	 * @return <code>true</code> si se combinaron <code>false</code> si no
	 */
	public boolean combinarItems(int i,int j) {
		Item objeto1 = ig.retirar(i), objeto2 = ig.retirar(i);
		director.elementosCombinar(objeto1,objeto2);
		Item[] regreso = director.combinar();
		if(regreso.length == 1) {
			ig.agregar(regreso[0]);
			return true;
		} else {
			ig.agregar(regreso[0]);
			ig.agregar(regreso[1]);
		}
		return false;
	}
	
	/**
	 * Metodo para equipar una de las herremientas que tenga el jugador. Debe 
	 * usarse {@link posicionEnInventario(String) metodo} antes para 
	 * conocer el valor de i
	 * @param i La posicion de la herremienta a usar
	 * @return <code>true</code> si se equipo <code>false</code> si no
	 */
	public boolean equiparHerramienta(int i) {
		Item item = ig.retirar(i);
		Herramienta usar = null;
		if(item != null && item instanceof Herramienta) {
			usar = (Herramienta)item;	
			equipo = usar;
			return true;
			
		}
		ig.agregar(item);
		return false;
	}
	
	/**
	 * Metodo para leer una nota en el inventario
	 * @param nota Una cadena que represneta a la nota
	 * @return Una cadena que es la lectura de la nota
	 */
	public String leerNota(String nota) {
		String dicho = "No tengo ninguna nota que leer con ese nombre";
		int i = ig.indicePorCadena(nota,true);
		Item item = ig.retirar(i);
		Nota usar = null;
		if(item != null && item instanceof Nota) {
			usar = (Nota)item;
			dicho = usar.obtenerLectura();
			ig.agregar(usar);
		} else {
			ig.agregar(item);
		}
		return dicho;
	}
	
	/**
	 * Metodo para abrir el mueble en la ubicacion del jugador. Debe usarse 
	 * {@link posicionEnInventario(String) metodo} antes para conocer los
	 * valores de i
	 * @param i La ubicacion en el inventario de la llave a usar. Si se pasa 
	 * <code>-2</code> se interpreta como que no se usara llave.
	 * @return Un boleano que indica si el mueble fue abierto
	 */
	public boolean abrirMueble(int i) {
		boolean b = false;
		if(i == -2) {
			return ubicacion.obtenerMueble().abrir();
		} else {
			Item item = ig.retirar(i);
			Llave usar = null;
			if(item != null && item instanceof Llave) {
				usar = (Llave)item;
				b = ubicacion.obtenerMueble().abrir(usar);
				if(!ubicacion.obtenerMueble().obtenerAbierto()) {
					ig.agregar(usar);
				} else if(!b) {
					ig.agregar(usar);
				}
			} else {
				ig.agregar(item);
			}
		}
		return b;
	}
	
	/**
	 * Metodo para tomar un objeto en el mueble de la habitacion
	 * @param objeto Una cadena que representa a un objeto
	 * @return <code>true</code> si se pudo tomar, <code>false</code> si no
	 */
	public boolean tomarObjeto(String objeto) {
		if(muebleAbierto()) {
			Item item = ubicacion.obtenerMueble().tomarObjeto(objeto);
			if(item != null) {
				if(ig.agregar(item)) {
					return true;
				} else {
					ubicacion.obtenerMueble().agregarObjeto(item);
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve si el mueble en la habitacion ya esta abierto
	 * @return Un boleano 
	 */
	public boolean muebleAbierto() {
		return ubicacion.obtenerMueble().obtenerAbierto();
	}
	
	/**
	 * Metodo que devuelve si el mueble tiene un objeto que se identifica con 
	 * la cadena
	 * @param objeto Una cadena
	 * @return Un boleano
	 */
	public boolean muebleCon(String objeto) {
		return ubicacion.obtenerMueble().tieneObjeto(objeto);
	}
	
	/**
	 * Metodo que hace que el jugador consuma un cnosumible de su inventario que
	 *  esta en el indice indicado y cambia la salud de este
	 * @param posicion Un entero del indice en el inventario general de objeto 
	 * a consumir
	 * @return Un entero que dice de cuanta fue la curacion. Esta entre 
	 * <code>-2</code> y en adelante. Si es <code>-2</code> entonces no se 
	 * encontro el objeto a usar o no es un consumible
	 */
	public int curar(int posicion) {
		Item item = ig.retirar(posicion);
		System.out.println(item);
		Consumible c = null;
		if(item != null && item instanceof Consumible) {
			c = (Consumible)item;
			recuperarVida(c.obtenerCura());
			return c.obtenerCura();
		} else {
			ig.agregar(item);
		}
		return -2;
	}
	
	/**
	 * Metodo para atacar a un ente ajeno a este en la misma ubicacion
	 * @return <code>true</code> si se ha atacado al ente, <code>false</code>
	 * si no se ataca porque no hay a quien
	 */
	public boolean atacar() {
		int danio = ataque;
		if(equipo != null) danio += equipo.obtenerDanio();
		if(hayOtroEnteVivo()) {
			ubicacion.obtenerEnteAjeno(this).recibirDanio(danio);
			if(hayOtroEnteVivo()) ubicacion.obtenerEnteAjeno(this).atacar();
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para regresar a la ubicaion anterior a la actual usando 
	 * {@link cambiarCuarto(String) metodo} y la cadena para la ubicaion 
	 * anterior
	 * @return Una cadena
	 */
	public String regresar() {
		return cambiarCuarto(ubicacionAnteriorCar);
	}
	
	/**
	 * Metodo para ir a una ubicacion nueva en la direccion indicada
	 * @param direccion Una cadena que indica la direccion a donde se intenta ir
	 * @return Una cadena
	 */
	public String cambiarCuarto(char direccion) {
		String cadena = "";
		Cuarto nuevo = ubicacion.cambiarCuarto(direccion);
		if(nuevo == null) {
			nuevo = ubicacion.sinSalida(direccion);
			if(nuevo == null) { 
				cadena += "No parece haber una puerta en esa direccion";
			} else {
				cadena += "Intento pasar por esa puerta, pero no se abre, ten" +
					"dre que ir por otro lado";
				ubicacionAnterior = obtenerUbicacionActual();	
			}
		} else {
			cadena += "Paso por la puerta al otro cuarto";
			ubicacion.retirarEnte(this);
			ubicacionAnterior = obtenerUbicacionActual();
			switch(direccion) {
			case 'N': ubicacionAnteriorCar = 'S'; break;
			case 'S': ubicacionAnteriorCar = 'N'; break;
			case 'E': ubicacionAnteriorCar = 'O'; break;
			case 'O': ubicacionAnteriorCar = 'E'; break;
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
}
