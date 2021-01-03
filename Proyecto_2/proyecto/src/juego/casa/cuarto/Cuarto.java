package juego.casa.cuarto;

import java.util.Hashtable;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;

import juego.ente.Ente;
import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;
import juego.casa.cuarto.mueble.Mueble;

public class Cuarto {
	private String id, nombre, descripcion;
	private Hashtable<String,Cuarto> salidasV = new Hashtable<>();
	private Hashtable<String,Cuarto> salidasI = new Hashtable<>();
	private Mueble mueble;
	private Ente[] entes = new Ente[2];
	
	public Cuarto(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public void agregarEnte(Ente ente) {
		if(ente instanceof Jugador) entes[0] = ente;
		if(ente instanceof Enemigo) entes[1] = ente;
	}
	
	public void retirarEnte(Ente ente) {
		if(ente instanceof Jugador) entes[0] = null;
		if(ente instanceof Enemigo) entes[1] = null;
	}
	
	public Ente obtenerEnteAjeno(Ente ente) {
		if(ente instanceof Jugador) return entes[1];
		if(ente instanceof Enemigo) return entes[0];
		return null;
	}
	
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
	
	public String mostrarSalidas() {
		String cadena = ""; 
		Set lados1 = salidasV.keySet();
		Set lados2 = salidasI.keySet();
        for(Iterator iter = lados1.iterator(); iter.hasNext(); )
            cadena += " " + iter.next();
        for(Iterator iter = lados2.iterator(); iter.hasNext(); )
            cadena += " " + iter.next();
        return cadena;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public String obtenerDescripcion() {
		return descripcion;
	}
	
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
	
	public Mueble obtenerMueble() {
		return mueble;
	}
	
	public void asignarMueble(Mueble mueble) {
		this.mueble = mueble;
	}
	
	public boolean validarId(String id) {
		return (id.equals(this.id));
	}
	
	public String toString() {
		String cadena = nombre + " colindante con ";
		String[] str = mostrarSalidas().split(" ");
		for(String s: str) {
			try {
				Cuarto cuarto = salidasV.get(s);
				cadena += cuarto.nombre + " ";
			} catch(Exception e) { }
		}
		cadena += "pero no puede acceder a ";
		for(String s: str) {
			try {
				Cuarto cuarto = salidasI.get(s);
				cadena += cuarto.nombre;
			} catch(Exception e) { }
		}
		return cadena;
	}
}
