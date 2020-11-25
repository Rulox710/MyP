package constructora.director;

import utilidad.Escritor;
import utilidad.Impresor;
import constructora.creadores.Creador;
import constructora.coche.Coche;
import constructora.coche.partes.Componente;
import constructora.coche.partes.llantas.*;
import constructora.coche.partes.motor.*;
import constructora.coche.partes.carroceria.*;
import constructora.coche.partes.blindaje.*;
import constructora.coche.partes.armas.*;

/**
 * Clase que modela las opciones para construir un <code>Coche</code> usando a
 * un <code>Creador</code>
 */
public class Director {
	private Creador cc; 

	/**
	 * Constructor de la clase
	 * @param cc Un objto de tipo <code>Creador</code>
	 */
	public Director(Creador cc) {
		this.cc = cc;
	}
	
	/**
	 * Metodo para crear un coche desde cero
	 */
	public void crearNuevo() {
		boolean verdad = true;
		while(verdad) {
			Impresor.imprimirInfo(cc.descripcion());
			Impresor.imprimir("\u00BFQuiere colocar alguna parte?(S/N)");
			switch(Escritor.leerCadena().toUpperCase()) {
				case "S":
					seleccionarPartes();
					break;
				case "N":
					verdad = false;
					break;
				default:
					Impresor.imprimirError("Escriba \"S\" o \"N\" para \"si" +
						"\" o \"no\", respectivamente");
			}
		}
	}
	
	/**
	 * Metodo para crear un coche tomando como base lo que seria un tanque
	 */
	public void crearTanque() {
		cc.asignarLlantas(new OrugaTanque());
		cc.asignarMotor(new MotorDisel());
		cc.asignarCarroceria(new CarroceriaCamion());
		cc.asignarBlindaje(new Tanque());
		cc.asignarArmas(new Caniones());
		tunear();
	}
	
	/**
	 * Metodo para crear un coche tomando como base lo que seria un coche 
	 * deportivo
	 */
	public void crearDeportivo() {
		cc.asignarLlantas(new LlantasDeportivas());
		cc.asignarMotor(new MotorDeportivo());
		cc.asignarCarroceria(new CarroceriaDeportiva());
		cc.asignarBlindaje(new BlindajeSimple());
		cc.asignarArmas(new Cierra());
		
		tunear();
	}
	
	/**
	 * Metodo para crear un coche tomando como modelo al coche mas economico
	 */
	public void crearEconomico() {
		cc.asignarLlantas(new LlantasSimples());
		cc.asignarMotor(new MotorDisel());
		cc.asignarCarroceria(new CarroceriaCasual());
		cc.asignarBlindaje(new BlindajeSimple());
		cc.asignarArmas(new Arpones());
		
		tunear();
	}
	
	private void tunear() {
		boolean verdad = true;
		while(verdad) {
			Impresor.imprimirInfo(cc.descripcion());
			Impresor.imprimir("\u00BFQuiere cambiar alguna parte?(S/N)");
			switch(Escritor.leerCadena().toUpperCase()) {
				case "S":
					seleccionarPartes();
					break;
				case "N":
					verdad = false;
					break;
				default:
					Impresor.imprimirError("Escriba \"S\" o \"N\" para \"si" +
						"\" o \"no\", respectivamente");
			}
		}
	}
	
	/**
	 * Metodo privado para seleccionar que <code>Componente</code> del 
	 * <code>Coche</code> se cambiara
	 */
	private void seleccionarPartes() {
		Impresor.imprimir("\u00BFQue quiere cambiar?(Escriba el numero)\n(1)L" +
			"lantas\t(2)Motor\t(3)Carroceria\t(4)Blindaje\t(5)Armas");
		boolean verdad = true;
		while(verdad) {
			String str = Escritor.leerCadena();
			int numero;
			numero = (Escritor.validarNumericoEntero(str))?Integer.parseInt(str):0;	
			switch(numero) {
				case 1:
					cambiarLlantas();
					verdad = false;
					break;
				case 2:
					cambiarMotor();
					verdad = false;
					break;
				case 3:
					cambiarCarroceria();
					verdad = false;
					break;
				case 4:
					cambiarBlindaje();
					verdad = false;
					break;
				case 5:
					cambiarArmas();
					verdad = false;
					break;
				default:
				Impresor.imprimirError("Ingrese un n" +
				"umero en el rango indidado [1,6]");
			}
		}
	}
	
	/**
	 * Metodo privado para seleccionar que tipo <code>Llanta</code> del 
	 * <code>Coche</code> se usara
	 */
	private void cambiarLlantas() {
		Impresor.imprimir("\u00BFQue llantas desea?(Escriba el numero)\n(1)Ll" +
			"antas Simples\t(2)Llantas deportivas\t(3)Llantas Off Road\t(4)Or" +
			"uga de Tanque");
		boolean verdad = true;
		Llantas l = null; 
		while(verdad){
			int numero = 0;
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) numero = Integer.parseInt(str);	
			switch(numero) {
				case 1:
					l = new LlantasSimples();
					verdad = false;
					break;
				case 2:
					l = new LlantasDeportivas();
					verdad = false;
					break;
				case 3:
					l = new LlantasOffRoad();
					verdad = false;
					break;
				case 4:
					l = new OrugaTanque();
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado [1-4]");
			}
		}	
		if(l.equals(cc.obtenerLlantas())) {
			Impresor.imprimirBien("Ya cuenta con ese tipo de llan" +
				"tas, no hay necesidad de cambiarlas");
		} else if(!cc.asignarLlantas(l)){
			Impresor.imprimirAlerta("No cuenta con el presupuesto" +
				" para poner estas llantas\nLa parte mas cara de " +
				"su coche es: " + cc.mayorCosto() + ". Considere " +
				"cambiarla por una opcion mas economica");
		} 
	}
	
	/**
	 * Metodo privado para seleccionar que tipo <code>Motor</code> del 
	 * <code>Coche</code> se usara
	 */
	private void cambiarMotor() {
		Impresor.imprimir("\u00BFQue motor desea?(Escriba el numero)\n(1)Mo" +
			"tor disel\t(2)Motor deportivo\t(3)Motor turbo");
		boolean verdad = true;
		Motor m = null; 
		while(verdad){
			int numero = 0;
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) numero = Integer.parseInt(str);	
			switch(numero) {
				case 1:
					m = new MotorDisel();
					verdad = false;
					break;
				case 2:
					m = new MotorDeportivo();
					verdad = false;
					break;
				case 3:
					m = new MotorTurbo();
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado [1-3]");
			}
		}	
		if(m.equals(cc.obtenerMotor())) {
			Impresor.imprimirBien("Ya cuenta con ese tipo de motor, no hay" +
				" necesidad de cambiarlas");
		} else if(!cc.asignarMotor(m)){
			Impresor.imprimirAlerta("No cuenta con el presupuesto para poner " +
				"este motor\nLa parte mas cara de su coche es: " +
				cc.mayorCosto() + ". Considere cambiarla por una opcion mas e" +
				"conomica");
		} 
	}
	
	/**
	 * Metodo privado para seleccionar que tipo <code>Carroceria</code> del 
	 * <code>Coche</code> se usara
	 */
	private void cambiarCarroceria() {
		Impresor.imprimir("\u00BFQue carroceria desea?(Escriba el numero)\n(1" +
			")Casual\t(2)Deportiva\t(3)De camion");
		boolean verdad = true;
		Carroceria c = null; 
		while(verdad){
			int numero = 0;
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) numero = Integer.parseInt(str);	
			switch(numero) {
				case 1:
					c = new CarroceriaCasual();
					verdad = false;
					break;
				case 2:
					c = new CarroceriaDeportiva();
					verdad = false;
					break;
				case 3:
					c = new CarroceriaCamion();
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado [1-3]");
			}
		}	
		if(c.equals(cc.obtenerCarroceria())) {
			Impresor.imprimirBien("Ya cuenta con ese tipo de carroceria, no h" +
				"ay necesidad de cambiarlas");
		} else if(!cc.asignarCarroceria(c)){
			Impresor.imprimirAlerta("No cuenta con el presupuesto para poner " +
				"esta carroceria\nLa parte mas cara de su coche es: " +
				cc.mayorCosto() + ". Considere cambiarla por una opcion mas e" +
				"conomica");
		} 
	}
	
	/**
	 * Metodo privado para seleccionar que tipo <code>Blindaje</code> del 
	 * <code>Coche</code> se usara
	 */
	private void cambiarBlindaje() {
		Impresor.imprimir("\u00BFQue blindaje desea?(Escriba el numero)\n(1)S" +
			"imple\t(2)Reforzado\t(3)De tanque");
		boolean verdad = true;
		Blindaje b = null; 
		while(verdad){
			int numero = 0;
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) numero = Integer.parseInt(str);	
			switch(numero) {
				case 1:
					b = new BlindajeSimple();
					verdad = false;
					break;
				case 2:
					b = new BlindajeReforzado();
					verdad = false;
					break;
				case 3:
					b = new Tanque();
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado [1-3]");
			}
		}	
		if(b.equals(cc.obtenerBlindaje())) {
			Impresor.imprimirBien("Ya cuenta con ese tipo de blindaje no hay " +
				"necesidad de cambiarlo");
		} else if(!cc.asignarBlindaje(b)){
			Impresor.imprimirAlerta("No cuenta con el presupuesto para poner " +
				"este blindaje\nLa parte mas cara de su coche es: " + 
				cc.mayorCosto() + ". Considere cambiarla por una opcion mas e" +
				"conomica");
		} 
	}
	
	/**
	 * Metodo privado para seleccionar que tipo <code>Armas</code> del 
	 * <code>Coche</code> se usara
	 */
	private void cambiarArmas() {
		Impresor.imprimir("\u00BFQue armas desea?(Escriba el numero)\n(1)Arpo" +
			"nes\t(2)Lanzallamas\t(3)Caniones\t(4)Cierra\t(5)Metralleta");
		boolean verdad = true;
		Armas a = null; 
		while(verdad){
			int numero = 0;
			String str = Escritor.leerCadena();
			if(Escritor.validarNumericoEntero(str)) numero = Integer.parseInt(str);	
			switch(numero) {
				case 1:
					a = new Arpones();
					verdad = false;
					break;
				case 2:
					a = new Lanzallamas();
					verdad = false;
					break;
				case 3:
					a = new Caniones();
					verdad = false;
					break;
				case 4:
					a = new Cierra();
					verdad = false;
					break;
				case 5:
					a = new Metralleta();
					verdad = false;
					break;
				default:
					Impresor.imprimirError("No es un numero en el rango espec" +
						"ificado [1-5]");
			}
		}	
		if(a.equals(cc.obtenerArmas())) {
			Impresor.imprimirBien("Ya cuenta con ese tipo de armas, no hay ne" +
				"cesidad de cambiarlas");
		} else if(!cc.asignarArmas(a)){
			Impresor.imprimirAlerta("No cuenta con el presupuesto para poner " +
				"estas armas\nLa parte mas cara de su coche es: " + 
				cc.mayorCosto() + ". Considere cambiarla por una opcion mas e" +
				"conomica");
		}
	}
}
