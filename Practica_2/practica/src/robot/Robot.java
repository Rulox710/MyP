package robot;

import java.util.ArrayList;
import utilidad.Escritor;
import utilidad.Color;
import utilidad.CaracterEspecial;
import robot.estados.Suspendido;
import casa.Casa;

/**
 * Clase que modela al <code>Robot</code> que trabajara en la <code>Casa</code>
 */
public class Robot {
	
	/**
	 * Objeto que tiene el estado actual del <code>Robot</code>
	 */
	private EstadoRobot estado;
	
	/**
	 * Valores boleanos que representan si tiene una orden y material para 
	 * trabajar
	 */
	private boolean material;
	
	/**
	 * <code>Casa</code> en la que se trabaja
	 */
	private Casa casa;
	
	/**
	 * Objeto que tiene todas las casas construidas por el robot durante la 
	 * ejecucion
	 */
	private ArrayList<Casa> casas;
	
	/**
	 * Contructor de la clase. Inicia con el estado <code>Suspendido</code>
	 */
	public Robot(){
		estado = new Suspendido(this);
		casa = null;
		material = false;
		casas = new ArrayList<Casa>();
	}
	
	/**
	 * Metodo para cambiar el estado del robot
	 * @param 
	 */
	public void cambiarEstado(EstadoRobot er){
		estado = er;
	}
	
	public void casaLista(Casa casa) {
		casas.add(casa);
	}
	
	public String estadoCadena() {
		return estado.obtenerEstado();
	}
	
	public void opcionesRobot() {
		boolean ciclo = true;
		do {
			EstadoRobot er = estado;
			System.out.println("Ahora estoy " + er.obtenerEstado());
			System.out.println("\u00BFQue deberia hacer?");
			System.out.println("1. Suspenderme\n2. Activarme\n3. Tomo una orden\n" +
			"4. Trabajo\n5. Reabastecerme\n6. Ver las casas listas\n7. Terminar todo");
		
			String str = Escritor.leerCadena();
			System.out.println(CaracterEspecial.arribaN(9) + 
				CaracterEspecial.limpiaLinSig());
			
			switch(str) {
				case "1":
				er.suspender();
				break;
				case "2":
				er.activar();
				break;
				case "3":
				er.tomarOrden();
				break;
				case "4":
				er.trabajar();
				break;
				case "5":
				er.reabastecer();
				break;
				case "6":
				System.out.println(casas + "\n");
				break;
				case "7":
				if(er.obtenerEstado() == "Suspendido"){
					System.out.println("Buenas noches ^^\n");
					ciclo = false;
				} else {
					System.out.println("Estoy en medio de algo, no me apague\n");
				}
				break;
				default:
				System.out.println("No me dio una opcion correcta, intente d" +
				"e nuevo");
			}	
		} while(ciclo);
	}
	
	/**
	 * Metodo para obtener si tiene material o no
	 * @return Boleano que indica si tiene material o no
	 */
	public boolean obtenerMaerial() {
		return material;
	}
	
	/**
	 * Metodo para cambiar si tiene material para trabajar o no
	 * @param casa Una <Casa>
	 */
	public void asignarMaterial(boolean material) {
		this.material = material;
	}
	
	/**
	 * Metodo para obtener el proyecto de la <code>Casa</code>
	 * @return Objeto <code>Casa</code>
	 */
	public Casa obtenerCasa() {
		return casa;
	}
	
	/**
	 * Metodo para guardar las especificaciones de la <code>Casa</code> en la 
	 * que se trabaja
	 * @param casa Una <Casa>
	 */
	public void asignarCasa(Casa casa) {
		this.casa = casa;
	}
	
}
