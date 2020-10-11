package main;

import escritura.Escritor;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;
import recursos.suscriptores.Persona;
import recursos.servicios.hammazon.Hammazon;
import recursos.servicios.yutube.YuTube;
import recursos.servicios.spootify.Spootify;
import recursos.servicios.twitsh.Twitsh;
import recursos.servicios.netflis.Netflis;

import java.util.ArrayList;
import java.lang.System;
 
public class Main{
	
	public static Servicio hammazon = new Hammazon();
	public static Servicio yutube = new YuTube();
	public static Servicio spootify = new Spootify();
	public static Servicio netflis = new Netflis();
	public static Servicio twitsh = new Twitsh();
		
	public static void main(String[] args){
		
		String tecleado;
		boolean ciclo = true;
		int opcion = 0;
		
		System.out.println("Bienvenido a la simulacion de la practica 1");
		
		
		do {
		System.out.println("Seleccione una de las opciones:\n");
		System.out.println("1. Simulacion guiada(la indicada en la practica)");
		System.out.println("2. Simacion en tiempo real");
		System.out.println("3. Terminar el programa");
		
			do {
				tecleado = Escritor.leerCadena();
				if (Escritor.validarNumerico(tecleado)){
					opcion = (int)Escritor.leerNumeros(tecleado);
					ciclo = false;
				} else {
					System.out.println("No ingreso numeros");
				}
			} while(ciclo);
			ciclo = true;
		
			switch(opcion){
				case 1:
				porDefecto();
				break;
				case 2:
				System.out.println("Implementar");
				break;
				case 3: 
				System.out.println("Se acabo la simulacion");
				ciclo = false;
				break;
				default:
				System.out.println("No ingreso un numero en el rango especificado");
			}
		} while(ciclo);
	}
	
	public static void porDefecto(){
		ArrayList<Suscriptor> personas = crearPersonas();
		
		int i = 0;
		while(i < 5) {
			if(i==0) {
				personas.get(0).iniciarSuscripcion(hammazon, 1);
				personas.get(0).iniciarSuscripcion(netflis, 2);
				personas.get(0).iniciarSuscripcion(yutube, 1);
				personas.get(0).iniciarSuscripcion(twitsh, 1);
				personas.get(0).iniciarSuscripcion(spootify, 1);
			
				personas.get(1).iniciarSuscripcion(hammazon, 1);
				personas.get(1).iniciarSuscripcion(netflis, 2);
				personas.get(1).iniciarSuscripcion(yutube, 1);
				personas.get(1).iniciarSuscripcion(twitsh, 1);
				personas.get(1).iniciarSuscripcion(spootify, 1);
				
				personas.get(2).iniciarSuscripcion(yutube, 0);
				personas.get(2).iniciarSuscripcion(spootify, 1);
			
				personas.get(3).iniciarSuscripcion(netflis, 1);
				personas.get(3).iniciarSuscripcion(hammazon, 1);
			
				personas.get(4).iniciarSuscripcion(netflis, 2);
				personas.get(4).iniciarSuscripcion(twitsh, 0);
				personas.get(4).iniciarSuscripcion(yutube, 0);
				personas.get(4).iniciarSuscripcion(spootify, 0);
			} if(i==1) {
				personas.get(3).iniciarSuscripcion(twitsh, 0);
				personas.get(4).cambiarSuscripcion(yutube, 1);
				personas.get(4).cambiarSuscripcion(spootify, 1);
			} if(i==2) {
				personas.get(3).iniciarSuscripcion(spootify, 0);
				personas.get(3).terminarSuscripcion(netflis);
			
				personas.get(4).terminarSuscripcion(netflis);
				personas.get(4).iniciarSuscripcion(hammazon, 1);
				personas.get(4).cambiarSuscripcion(twitsh, 1);
			} if(i==3) {
				personas.get(3).iniciarSuscripcion(netflis, 2);
			}
			
			hammazon.pago();
			hammazon.notificar();
			
			yutube.pago();
			yutube.notificar();
			
			netflis.pago();
			netflis.notificar();
			
			spootify.pago();
			spootify.notificar();
			
			twitsh.pago();
			twitsh.notificar();
			
			System.out.println(personas.get(0).obtenerNombre() + ", dia: " + (i+1));
			System.out.println(verNotificaciones(personas.get(0))+ "");
			
			System.out.println(personas.get(1).obtenerNombre() + ", dia: " + (i+1));
			System.out.println(verNotificaciones(personas.get(1))+ "");
			
			System.out.println(personas.get(2).obtenerNombre() + ", dia: " + (i+1));
			System.out.println(verNotificaciones(personas.get(2))+ "");
			
			System.out.println(personas.get(3).obtenerNombre() + ", dia: " + (i+1));
			System.out.println(verNotificaciones(personas.get(3))+ "");
			
			System.out.println(personas.get(4).obtenerNombre() + ", dia: " + (i+1));
			System.out.println(verNotificaciones(personas.get(4))+ "");
			i++;
		}
		
	}
	
	public static void ejecutar(){
		
	}
	
	public static ArrayList<Suscriptor> crearPersonas() {
		ArrayList<Suscriptor> personas = new ArrayList<Suscriptor>();
		personas.add(new Persona("Alicia", 500));
		personas.add(new Persona("Bob", 70));
		personas.add(new Persona("Cesar", 40));
		personas.add(new Persona("Diego", 200));
		personas.add(new Persona("Erika", 220));
		return personas;
	}
	
	public static String verNotificaciones(Suscriptor sub) {
		String cad = "";
		ArrayList<String> str = new ArrayList<String>(sub.verNotificaciones());
		for(String not: str) {
			cad += not + "\n";
		}
		return cad;
	}
}
