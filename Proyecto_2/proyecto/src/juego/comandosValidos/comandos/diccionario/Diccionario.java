package graficos.modelo.palabras.diccionario;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import utilidad.ed.ArbolAVL;
import graficos.modelo.palabras.Palabra;
import graficos.modelo.palabras.Verbo;
import graficos.modelo.palabras.Adverbio;
import graficos.modelo.palabras.Sustantivo;
import graficos.modelo.palabras.PalabraException;

/**
 * Clase que inicia el diccionrio. Lo lee de un txt si no se ha usado nunca o se
 * ha borrado el serializado; lo lee de un serializado si ya se ha iniciado
 */
public class Diccionario {
	
	private String separador = System.getProperty("file.separator");
	
	private ArbolAVL<Palabra> verbos = new ArbolAVL<>();
	private ArbolAVL<Palabra> sustantivos = new ArbolAVL<>();
	private ArbolAVL<Palabra> adverbios = new ArbolAVL<>();
	
	private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
	
	/**
	 * Metodo para iniciar las estructuras de datos con los verbos, sustantivos 
	 * y adverbios requeridos
	 */
	public void iniciar() {
		try {
			archivo = new File ("recursos"+ separador +"Diccionario.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
			int c = 0;
			while((linea = br.readLine()) != null) {
				if(linea.equals("/")) {
					c++;
				} else {
					switch(c) {
					case 0:
					iniciarVerbos(linea);
					break;
					case 1:
					iniciarAdverbios(linea);
					break;
					case 2:
					iniciarSustantivos(linea,false);
					break;
					case 3:
					iniciarSustantivos(linea,true);
					break;
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try {                    
				if(null != fr ){   
					fr.close();     
				}                  
			} catch(Exception e2){ 
				e2.printStackTrace();
			}
		}
		
		System.out.println(verbos);
		System.out.println(adverbios);
		System.out.println(sustantivos);
	}
	
	/**
	 * Toma una cadena y la separa en donde tenga comas, luego convierte a las 
	 * cadenas que obtuvo en <code>Verbo<code> para agregarlas a la 
	 * estructura de datos <code>verbos<code>
	 * @param cadena Una cadena
	 */
	private void iniciarVerbos(String cadena) {
		String[] palabras = cadena.split(",");
		ArrayList<Verbo> p = new ArrayList<>();
		for(int i = 0; i < palabras.length; i++) {
			try {
				p.add(Verbo.nuevo(palabras[i]));
			} catch(PalabraException e){
				System.out.println(e.getMessage());
			}
		}
		ArrayList<Verbo> p2 = new ArrayList<>(p);
		for(Verbo asignacion: p) {
			for(Verbo relativas: p2) {
				if(!asignacion.equals(relativas)) 
					asignacion.asignarRelativas(relativas);
			}
		}
		for(Palabra arbol: p) verbos.agrega(arbol);
	}
	
	/**
	 * Toma una cadena y la separa en donde tenga comos, luego convierte a las 
	 * cadenas que obtuvo en <code>Adverbio<code> para agregarlas a la 
	 * estructura de datos <code>adverbios<code>
	 * @param cadena Una cadena
	 */
	private void iniciarAdverbios(String cadena) {
		String[] palabras = cadena.split(",");
		ArrayList<Adverbio> p = new ArrayList<>();
		for(String ad: palabras) {
			try {
				p.add(Adverbio.nuevo(ad));
			} catch(PalabraException e){
				System.out.println(e.getMessage());
			}
		}
		ArrayList<Adverbio> p2 = new ArrayList<>(p);
		for(Adverbio asignacion: p) {
			for(Adverbio relativas: p2) {
				if(!asignacion.equals(relativas)) 
					asignacion.asignarRelativas(relativas);
			}
		}
		for(Palabra arbol: p) adverbios.agrega(arbol);
	}
	
	/**
	 * Toma una cadena y la separa en donde tenga comas, luego convierte a las 
	 * cadenas que obtuvo en <code>Sustantivo<code> donde dependiendo del valor 
	 * boleano dado las marca como masculinas o femeninas y las agrega a la 
	 * estructura de datos <code>sustantivos<code>
	 * @param cadena Una cadena
	 * @param es Masculino Un boleano que indica si cadena sera de unicamente 
	 * "masculinos" o no
	 */
	private void iniciarSustantivos(String cadena, boolean esMasculino) {
		String[] palabras = cadena.split(",");
		ArrayList<Sustantivo> p = new ArrayList<>();
		for(int i = 0; i < palabras.length; i++) {
			try {
				if(esMasculino) {
					p.add(Sustantivo.nuevoM(palabras[i]));
				} else {
					p.add(Sustantivo.nuevoF(palabras[i]));
				}
			} catch(PalabraException e){
				System.out.println(e.getMessage());
			}
		}
		ArrayList<Sustantivo> p2 = new ArrayList<>(p);
		for(Sustantivo asignacion: p) {
			for(Sustantivo relativas: p2) {
				if(!asignacion.equals(relativas)) 
					asignacion.asignarRelativas(relativas);
			}
		}
		for(Palabra arbol: p) sustantivos.agrega(arbol);
	}
	
	/**
	 * Metodo que obtiene a la estructura con los verbos
	 * @return Un <code>ArbolAVL</code>
	 */
	public ArbolAVL obtenerDiccionarioVerbos() {
		return verbos;
	}
	
	/**
	 * Metodo que obtiene a la estructura con los sustantivos
	 * @return Un <code>ArbolAVL</code>
	 */
	public ArbolAVL obtenerDiccionarioSustantivos() {
		return sustantivos;
	}
	
	/**
	 * Metodo que obtiene a la estructura con los adverbios
	 * @return Un <code>ArbolAVL</code>
	 */
	public ArbolAVL obtenerDiccionarioAdverbios() {
		return adverbios;
	}
}
