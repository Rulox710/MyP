package juego.ente;

import juego.cuarto.Cuarto;

/**
 * Clase abstracta que modela a un ente
 */
public abstract class Ente {
	protected int vida, ataque;
	protected final int vidaM = 5;
	protected Cuarto ubicacion;
	protected char ubicacionAnteriorCar = ' ';
	protected String ubicacionAnterior;
	
	/**
	 * Constructor de la clase. Tiene vida actual, vida maxima que es igual a 
	 * <code>5</code>, puntos de ataque, ubicacion que es un <code>Cuarto</code>
	 * y la ubicacion anterior que es un <code>String</code>
	 * @param cuarto La ubicacion inicial del jugador
	 */
	public Ente(Cuarto ubicacion) {
		this.ubicacion = ubicacion;
		ubicacion.agregarEnte(this);
		ubicacionAnterior = obtenerUbicacionActual();
	}
	
	/**
	 * Metodo que devuelve si hay otro ente distinto al que pregunta en la 
	 * ubicacion actual
	 * @return <code>true</code> si lo hay, <code>false</code> si no
	 */
	public boolean hayOtroEnte() {
		return (ubicacion.obtenerEnteAjeno(this) != null);
	}
	
	/**
	 * Metodo que devuelve si hay otro ente distinto al que pregunta en la 
	 * ubicacion actual
	 * @return <code>true</code> si lo hay, <code>false</code> si no
	 */
	public boolean hayOtroEnteVivo() {
		return (ubicacion.obtenerEnteAjeno(this) != null && 
			!ubicacion.obtenerEnteAjeno(this).muerto());
	}
	
	/**
	 * Metodo abstracto para atacar a un ente ajeno a este en la misma ubicacion
	 * @return Un boleano
	 */
	public abstract boolean atacar();
	
	/**
	 * Metodo que hace que este ente reciba danio y reduce sus puntos de vida 
	 * actual. Solo llega hasta <code>0</code> si hay un exedente
	 * @param d Puntos de vida actual a reducir
	 */
	public void recibirDanio(int d) {
		if(d > vida) {
			vida = 0;
		} else {
			vida = vida - d; 
		}
	}
	
	/**
	 * Metodo para recuperar la una cantidad de vida actual dada. Si esta excede
	 * a la vida maxima, se iguala a la vida maxima
	 * @param v Puntos de vida actual a aumentar
	 */
	protected void recuperarVida(int v) {
		if(v > vidaM) {
			vida = vidaM;
		} else {
			vida += v;
		}
	}
	
	/**
	 * Metodo para indicar si el enete esta muerto o no. Si su vida es igual a 
	 * <code>0</code>
	 * @return Un boleano
	 */
	public boolean muerto() {
		return (vida == 0);
	}
	
	/**
	 * Metodo para obtener la vida actual del ente
	 * @return Un numero de entre <code>0</code> y <code>5</code>
	 */
	public int obtenerVida() {
		return vida;
	}
	
	/**
	 * Metodo que obtiene la ubicaion anterior
	 * @return Un caracter que puede ser 'N', 'S', 'E', 'O' o ' ' en caso de no 
	 * tenerla
	 */
	public char obtenerUbicacionAnteriorCar() {
		return ubicacionAnteriorCar;
	}
	
	/**
	 * Metodo que obtiene el id de la ubicaion anterior
	 * @return Una cadena
	 */
	public String obtenerUbicacionAnterior() {
		return ubicacionAnterior;
	}
	
	/**
	 * Metodo que obtiene el id de la ubicaion actual
	 * @return Una cadena
	 */
	public String obtenerUbicacionActual() {
		return ubicacion.obtenerId();
	}
	
	/**
	 * Metodo abstracto para cambiar la ubicaion del ente a una nueva en cierta 
	 * direccion
	 * @param direccion Un caracter que representa la direccion a moverse
	 */
	public abstract String cambiarCuarto(char direccion);
}
