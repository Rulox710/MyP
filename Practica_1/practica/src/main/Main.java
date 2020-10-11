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
		
		System.out.println("Bienevenido a la simulacion de la practica 1");
		System.out.println("Selecctione una de las opciones:");
		
		do {
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
		ArrayList<Suscriptor> personas = new ArrayList<Suscriptor>();
		personas.add(new Persona("Alicia", 500));
		personas.add(new Persona("Bob", 70));
		personas.add(new Persona("Cesar", 40));
		personas.add(new Persona("Diego", 200));
		personas.add(new Persona("Erika", 220));
		
		int dias = 5;
		int i = 0;
		
		personas.get(0).iniciarSuscripcion(hammazon, 1);
		personas.get(0).iniciarSuscripcion(netflis, 2);
		personas.get(0).iniciarSuscripcion(netflis, 1);
		personas.get(0).iniciarSuscripcion(yutube, 1);
		personas.get(0).iniciarSuscripcion(twitsh, 1);
		personas.get(0).iniciarSuscripcion(spootify, 1);
		
		while(i++ < 5){
			if(i==3){
				personas.get(0).terminarSuscripcion(hammazon);
			}
			if(i==4){
				personas.get(0).iniciarSuscripcion(hammazon,0);
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
			
			System.out.println(personas.get(0).verNotificaciones());

			System.out.println(personas.get(0).obtenerDinero());
			
		}
		
		System.out.println();
	}
	
	public static void ejecutar(){
		
	}
	
/*
Bob, creyendo que puede pagar todos los servicios, contrata la versión más cara disponible, sin embargo inicia con $70.

César inicia con $40 y él contrata Spootify Premium y se suscribe a Yutube en su versión gratuita.

Diego se suscribe a Netflis para dos dispositivos y Hammazon Prime video en su versión premium. En el segundo día, se suscribe a Twitsh en su versión normal. Para el tercer día se suscribe a Spootify gratis y cancela su suscripción a Netflis. Para el cuarto día se suscribe nuevamente a Netflis para 4 dispositivos. Él inicia con $200.

Erika se suscribe a Netflis para 4 dispositivos, Twitsh en su versión normal y, Spootify y YuTube gratis. Para el segundo día cambia su suscripción a Spootify premium y Yutube premium. El tercer día cancela la suscripción de Netflis y contrata Hammazon Prime video premium y cambia su suscripción de Twitsh a su versión premium. Ella inicia con $220.
*/
}
