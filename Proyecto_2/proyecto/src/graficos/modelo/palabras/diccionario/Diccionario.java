package graficos.modelo.palabras.diccionario;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import utilidad.ed.ArbolAVL;
import graficos.modelo.palabras.Palabra;
import graficos.modelo.palabras.Verbo;
import graficos.modelo.palabras.PalabraException;

public class Diccionario {
	
	private String separador = System.getProperty("file.separator");
	
	private ArbolAVL<Palabra> verbos = new ArbolAVL<>();
	private ArbolAVL<Palabra> sustantivos = new ArbolAVL<>();
	private ArbolAVL<Palabra> adverbios = new ArbolAVL<>();
	
	private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
	
	public void iniciar() {
		try {
			archivo = new File ("recursos"+ separador +"Diccionario.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
			int c = 0;
			while((linea = br.readLine()) != null) {
				if(linea.equals("/"))c++;
				switch(c) {
				case 0:
				iniciarVerbos(linea);
				break;
				case 1:
				break;
				case 2:
				break;
				case 3:
				break;
				}
				
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try {                    
				if( null != fr ){   
					fr.close();     
				}                  
			} catch(Exception e2){ 
				e2.printStackTrace();
			}
		}
	}
	
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
	
	
	
	public ArbolAVL obtenerDiccionarioVerbos() {
		return verbos;
	}
	
	public ArbolAVL obtenerDiccionarioSustantivos() {
		return sustantivos;
	}
	
	public ArbolAVL obtenerDiccionarioAdverbios() {
		return adverbios;
	}
}
