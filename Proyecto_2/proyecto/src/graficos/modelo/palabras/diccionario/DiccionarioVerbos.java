package graficos.modelo.palabras.diccionario;

import utilidad.ed.ArbolAVL;
import graficos.modelo.palabras.Palabra;
import graficos.modelo.palabras.Verbo;
import graficos.modelo.palabras.PalabraException;

public class DiccionarioVerbos {
	
	private ArbolAVL<Palabra> verbos = new ArbolAVL<>();
	
	public void iniciar() {
		try {
			verbos.agrega(Verbo.nuevo("Agarrar"));
			verbos.agrega(Verbo.nuevo("Tomar"));
		} catch(PalabraException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArbolAVL obtenerDiccionarioVerbos() {
		return verbos;
	}
}
