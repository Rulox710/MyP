package main;
import escritura.Escritor;
import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;
import recursos.suscriptores.Persona;
import recursos.servicios.hammazon.*;
import recursos.servicios.twitsh.*;
import recursos.servicios.yutube.*;
import recursos.servicios.netflis.*;
import recursos.servicios.spootify.*;

import java.util.ArrayList;
 
public class Main{
	
	public static Servicio hn = new HammazonNormal();
	public static Servicio hp = new HammazonPremium();
	public static Servicio tn = new TwitshNormal();
	public static Servicio tp = new TwitshPremium();
	public static Servicio ytg = new YuTubeGratis();
	public static Servicio ytp = new YuTubePremium();
	public static Servicio nu = new NetflisUno();
	public static Servicio nd = new NetflisDos();
	public static Servicio nt = new NetflisTres();
	public static Servicio sn = new SpootifyNormal();
	public static Servicio sp = new SpootifyPremium();
	
	public static void main(String[] args){
		
		String tecleado;
		boolean ciclo = true;
		int opcion = 0;
		
		System.out.println("Bienevenido a la simulacion de la practica 1");
		System.out.println("Selecctione una de las opciones:");
		
		System.out.println("1. Simulacion guiada(la indicada en la practica)");
		System.out.println("2. Simacion en tiempo real");
		
		do {
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
		/*personas.add(new Persona("Bob", 70));
		personas.add(new Persona("Cesar", 40));
		personas.add(new Persona("Diego", 200));
		personas.add(new Persona("Erika", 220));*/
		
		int dias = 5;
		int i = 0;
		
		System.out.println(personas.get(0).iniciarSuscripcion(hp));
		System.out.println(personas.get(0).iniciarSuscripcion(tp));
		System.out.println(personas.get(0).iniciarSuscripcion(ytp));
		System.out.println(personas.get(0).iniciarSuscripcion(nt));
		System.out.println(personas.get(0).iniciarSuscripcion(sp));
		
		while(i++ < 5){
			personas.get(0).renovarSuscripcion(hp);
			personas.get(0).renovarSuscripcion(tp);
			personas.get(0).renovarSuscripcion(ytp);
			personas.get(0).renovarSuscripcion(nt);
			personas.get(0).renovarSuscripcion(sp);
			System.out.println(personas.get(0).obtenerNombre() + " tiene " + personas.get(0).obtenerDinero());
		}
		System.exit(0);
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
