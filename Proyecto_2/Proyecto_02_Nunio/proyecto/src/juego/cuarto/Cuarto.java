package juego.cuarto;

import java.util.Hashtable;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;

import juego.ente.Ente;
import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;
import juego.mueble.Mueble;

/**
 * Clase que modela a un <code>Cuarto</code> donde estaran los entes entrando y 
 * saliendo 
 */
public class Cuarto {
	private String id, nombre, descripcion;
	private Hashtable<String,Cuarto> salidasV = new Hashtable<>();
	private Hashtable<String,Cuarto> salidasI = new Hashtable<>();
	private Mueble mueble;
	private Ente[] entes = new Ente[2];
	
	/**
	 * Constructor de la clase
	 * @param id Una cadena que representa el identificador del cuarto
	 * @param nombre Una cadena que representa el nombre del cuarto
	 * @param descripcion Una cadena que describe al cuarto
	 */
	public Cuarto(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * Metodo para registrar que un <code>Ente</code> entro al cuarto
	 * @param ente Un <code>Ente</code>
	 */
	public void agregarEnte(Ente ente) {
		if(ente instanceof Jugador) entes[0] = ente;
		if(ente instanceof Enemigo) entes[1] = ente;
	}
	
	/**
	 * Metodo para retirar un <code>Ente</code> del cuarto
	 * @param ente Un <code>Ente</code>
	 */
	public void retirarEnte(Ente ente) {
		if(ente instanceof Jugador) entes[0] = null;
		if(ente instanceof Enemigo) entes[1] = null;
	}
	
	/**
	 * Metodo para obtener un <code>Ente</code> ajeno al ente que pregunta en 
	 * este mismo cuarto
	 * @param ente Un <code>Ente</code> que pegunta si hay otro <code>Ente</code> 
	 * distinto a el en el cuarto
	 * @return Un <code>Ente</code>
	 */
	public Ente obtenerEnteAjeno(Ente ente) {
		if(ente instanceof Jugador) return entes[1];
		if(ente instanceof Enemigo) return entes[0];
		return null;
	}
	
	/**
     * Metodo para asignar una salida que sirve para cambiar de cuarto
     * @param direccion Un caracter que si es 'E' es hacie el este, si es 'O' es 
	 * hacia el oeste, si es 'S' es hacia el sur y si es 'N' es hacia el norte.
	 * Cualquier otro no vale
	 * @throws Exception Si la direccion dada no es valida
     */
	public void asignarSalidaV(char direccion, Cuarto r) throws Exception {
      String dir= "";
      switch (direccion){
      case 'E': dir = "este";break;
      case 'O': dir = "oeste";break;
      case 'S': dir = "sur";break;
      case 'N': dir = "norte";break;
      default: throw new Exception("Direccion invalida");
      }
      salidasV.put(dir, r);
    }
    
    /**
     * Metodo para asignar una salida pero que no sirve para cambiar de cuarto
     * @param direccion Un caracter que si es 'E' es hacie el este, si es 'O' es 
	 * hacia el oeste, si es 'S' es hacia el sur y si es 'N' es hacia el norte.
	 * Cualquier otro no vale
	 * @throws Exception Si la direccion dada no es valida
     */
    public void asignarSalidaI(char direccion, Cuarto r) throws Exception {
      String dir= "";
      switch (direccion){
      case 'E': dir = "este";break;
      case 'O': dir = "oeste";break;
      case 'S': dir = "sur";break;
      case 'N': dir = "norte";break;
      default: throw new Exception("Direccion invalida");
      }
      salidasI.put(dir, r);
    }
    
    /**
	 * Metodo para obtener el <code>Cuarto</code> en la direccion indicada
	 * Devuelve null si no existe tal o es una salida falsa
	 * @param direccion Un caracter. Si es 'E' es hacie el este, si es 'O' es 
	 * hacia el oeste, si es 'S' es hacia el sur y si es 'N' es hacia el norte.
	 * Cualquier otro no vale
	 * @return Un <code>Cuarto</code>
	 */
	public Cuarto cambiarCuarto(char direccion) {
		String dir = "";
		switch (direccion){
		case 'E': dir = "este";break;
		case 'O': dir = "oeste";break;
		case 'S': dir = "sur";break;
		case 'N': dir = "norte";break;
		}
		return (Cuarto)salidasV.get(dir);
	}
	
	/**
	 * Metodo para validar que una direccion dada tenga registrada una salida 
	 * falsa
	 * @param direccion Un caracter. Si es 'E' es hacie el este, si es 'O' es 
	 * hacia el oeste, si es 'S' es hacia el sur y si es 'N' es hacia el norte.
	 * Cualquier otro no vale y si la salida si se puede usar tampoco
	 * @return Un <code>Cuarto</code>
	 */
	public Cuarto sinSalida(char direccion) {
		String dir = "";
		switch (direccion){
		case 'E': dir = "este";break;
		case 'O': dir = "oeste";break;
		case 'S': dir = "sur";break;
		case 'N': dir = "norte";break;
		}
		return (Cuarto)salidasI.get(dir);
	}
    
    /**
     * Metodo para obtener las salidas validas del cuarto actual en forma de 
     * caracteres. Este es usado por la clase <code>Enemigo</code>
     * @return Un <code>ArrayList</code> de <code>Character</code> 
     */
    public ArrayList<Character> llaveSalidasValidas() {
		Set lados = salidasV.keySet();
		ArrayList<Character> car = new ArrayList<>();
		for(Iterator iter = lados.iterator(); iter.hasNext(); ) {
			String cadena = (String)iter.next();
			if(cadena.equals("norte")) {
				car.add('N');
			} else if(cadena.equals("sur")) {
				car.add('S');
			} else if(cadena.equals("este")) {
				car.add('E');
			} else if(cadena.equals("oeste")) {
				car.add('O');
			}
		}
		return car;
	}
	
	/**
	 * Metodo que devuelve un iterador con las direcciones de las salidas 
	 * verdaderas y falsas
	 * @return Un iterador de <code>String</code>
	 */
	public Iterator<String> mostrarSalidas() {
		String cadena = ""; 
		Set lados1 = salidasV.keySet();
		Set lados2 = salidasI.keySet();
        Iterator<String> iter1 = lados1.iterator();
        Iterator<String> iter2 = lados2.iterator();
        
        ArrayList<String> ar = new ArrayList(lados1);
        ar.addAll(lados2);
        return ar.iterator();
	}
	
	/**
	 * Metodo que obtiene el nombre del cuarto
	 * @return Una cadena
	 */
	public String obtenerNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que obtiene la descripcion del cuarto
	 * @return Una cadena
	 */
	public String obtenerDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo para obtener el mueble que tiene el cuarto
	 * @return Un <code>Mueble</code>
	 */
	public Mueble obtenerMueble() {
		return mueble;
	}
	
	/**
	 * Metodo para asignar un mueble al cuarto
	 * @param Un <code>Mueble</code> 
	 */
	public void asignarMueble(Mueble mueble) {
		this.mueble = mueble;
	}
	
	/**
	 * Metodo para obtener el id del cuarto
	 * @return Una cadena 
	 */
	public String obtenerId() {
		return id;
	}
	
	/**
	 * Metodo para validar la id de un cuarto con una cadena dada. Se usa en la 
	 * clase <code>LectorRecursos</code> para vincular las entradas de los 
	 * cuartos
	 * @return Un boleano
	 */
	public boolean validarId(String id) {
		return (id.equals(this.id));
	}
}
