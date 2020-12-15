package graficos.modelo.palabras;

public class PalabraException extends Exception {
	
	private int clave;
	
	public PalabraException(int clave) {
		super();
		this.clave = clave;
	}
	
	@Override
	public String getMessage() {
		String mensaje = "";
		switch(clave) {
		case 1: mensaje = "Esta cadena no es un verbo";
			break;
		case 2: mensaje = "Esta cadena no es un sustantivo";
			break;
		case 3: mensaje = "Esta cadena no es un adverbio";
			break;
		}
		return mensaje;
	}
}
