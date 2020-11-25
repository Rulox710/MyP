package constructora.creadores;

import cliente.Cliente;
import constructora.coche.Coche;
import constructora.coche.partes.Componente;
import constructora.coche.partes.llantas.Llantas;
import constructora.coche.partes.motor.Motor;
import constructora.coche.partes.carroceria.Carroceria;
import constructora.coche.partes.blindaje.Blindaje;
import constructora.coche.partes.armas.Armas;

public class Creador {
	private Llantas llantas;
	private Motor motor;
	private Carroceria carroceria;
	private Blindaje blindaje;
	private Armas armas;
	private Cliente cliente;
	private boolean validar = false;
	
	public Creador(Cliente cliente) {
		this.cliente = cliente;
		if(cliente.obtenerPresupuesto() >= 275) {
			validar = true;
		}
	}
	
	/**
	 * Metodo para obtener las <code>Llantas</code> que se usaran para construir
	 * el <code>Coche</code>
	 * @return Un objeto del tipo <code>Llantas</code>
	 */
	public Llantas obtenerLlantas() {
		return llantas;
	}
	
	/**
	 * Metodo para obtener el <code>Motor</code> que se usara para construir el
	 * <code>Coche</code>
	 * @return Un objeto del tipo <code>Motor</code>
	 */
	public Motor obtenerMotor() {
		return motor;
	}
	
	/**
	 * Metodo para obtener la <code>Carroceria</code> que se usara para 
	 * construir el <code>Coche</code>
	 * @return Un objeto del tipo <code>Carroceria</code>
	 */
	public Carroceria obtenerCarroceria() {
		return carroceria;
	}
	
	/**
	 * Metodo para obtener el <code>Blindaje</code> que se usara para construir
	 * el <code>Coche</code>
	 * @return Un objeto del tipo <code>Blindaje</code>
	 */
	public Blindaje obtenerBlindaje() {
		return blindaje;
	}
	
	/**
	 * Metodo para obtener las <code>Armas</code> que se usaran para construir
	 * el <code>Coche</code>
	 * @return Un objeto del tipo <code>Armas</code>
	 */
	public Armas obtenerArmas() {
		return armas;
	}
	
	/**
	 * Metodo que asigna un tipo de <code>Llantas</code> al <code>Coche</code> a
	 * crear
	 * @param llantas Un objeto <code>Llantas</code> que tendra
	 * @return Un boleano. <code>true>/code> si se pueden poner las 
	 * <code>Llantas</code>, <code>false</code> si no se pueden poner
	 */
	public boolean asignarLlantas(Llantas llantas) {
		if (validar) {
			if(cliente.obtenerPresupuesto() - costoFuturo(1) >= 
				llantas.obtenerCosto()) {
				this.llantas = llantas;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que asigna un tipo de <code>Motor</code> al <code>Coche</code> a
	 * crear
	 * @param motor Un objeto <code>Motor</code> que tendra
	 * @return Un boleano. <code>true>/code> si se puede poner el
	 * <code>Motor</code>, <code>false</code> si no se puede poner
	 */
	public boolean asignarMotor(Motor motor) {
		if (validar) {
			if(cliente.obtenerPresupuesto() - costoFuturo(2) >= 
				motor.obtenerCosto()) {
				this.motor = motor;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que asigna un tipo de <code>Carroceria</code> al 
	 * <code>Coche</code> a crear
	 * @param carroceria Un objeto <code>Carroceria</code> que tendra
	 * @return Un boleano. <code>true>/code> si se puede poner la
	 * <code>Carroceria</code>, <code>false</code> si no se puede poner
	 */
	public boolean asignarCarroceria(Carroceria carroceria) {
		if (validar) {
			if(cliente.obtenerPresupuesto() - costoFuturo(3) >= 
				carroceria.obtenerCosto()) {
				this.carroceria = carroceria;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que asigna un tipo de <code>Blindaje</code> al 
	 * <code>Coche</code> a crear
	 * @param carroceria Un objeto <code>Blindaje</code> que tendra
	 * @return Un boleano. <code>true>/code> si se puede poner el
	 * <code>Blindaje</code>, <code>false</code> si no se puede poner
	 */
	public boolean asignarBlindaje(Blindaje blindaje) {
		if (validar) {
			if(cliente.obtenerPresupuesto() - costoFuturo(4) >=
				blindaje.obtenerCosto()) {
				this.blindaje = blindaje;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que asigna el tipo de <code>Armas</code> al 
	 * <code>Coche</code> a crear
	 * @param armas Un objeto <code>Armas</code> que tendra
	 * @return Un boleano. <code>true>/code> si se pueden poner las
	 * <code>Armas</code>, <code>false</code> si no se puede poner
	 */
	public boolean asignarArmas(Armas armas) {
		if (validar) {
			if(cliente.obtenerPresupuesto() - costoFuturo(5) >=
				armas.obtenerCosto()) {
				this.armas = armas;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve el <code>Componente</code> mas costoso puesto en el 
	 * <code>Coche</code> hasta ahora
	 * @return Un objeto de tipo <code>Componente</code>. <code>null</code> si 
	 * no se encontro ninguno que cumpla la condicion descrita
	 */
	public Componente mayorCosto() {
		int mayor = 0;
		Componente componente = null;
		if(llantas != null && llantas.obtenerCosto() > mayor) {
			mayor = llantas.obtenerCosto();
			componente = llantas;
		}
		if(motor != null && motor.obtenerCosto() > mayor) {
			mayor = motor.obtenerCosto();
			componente = motor;
		}
		if(carroceria != null && carroceria.obtenerCosto() > mayor) {
			mayor = carroceria.obtenerCosto();
			componente = carroceria;
		}
		if(blindaje != null && blindaje.obtenerCosto() > mayor) {
			mayor = blindaje.obtenerCosto();
			componente = blindaje;
		}
		if(armas != null && armas.obtenerCosto() > mayor) {
			mayor = armas.obtenerCosto();
			componente = armas;
		}
		return componente;
	}
	
	/**
	 * Metodo que devuelve una cadena con la descripcion del coche que se esta 
	 * armando
	 * @return Una cadena
	 */
	public String descripcion() {
		String str = "Actualmente el coche tiene: ";
		str += (llantas != null)? llantas + "\t": "";
		str += (motor != null)? motor + "\t": "";
		str += (carroceria != null)? carroceria + "\t": "";
		str += (blindaje != null)? blindaje + "\t": "";
		str += (armas != null)? armas: "";
		
		if(str.length() == 28) {
			str = "Actualmente el coche no tiene ninguna parte seleccionada";
		} 
		return str + "\n" + cliente + "\tLa construccion actual costara: " + 
			costoFuturo(6) + " madpesos";
	}
	
	/**
	 * Obtiene el costo que tienen las partes del <code>Coche</code> escogidas 
	 * hasta el momento, menos una indicada con un entero
	 * @param i Un numero entero. 1 Si no se tomaran en cuenta las 
	 * <code>Llantas</code>. 2 Si no se tomara en cuenta el <code>Motor</code>.
	 * 3 Si no se tomara en cuenta la <code>Carroceria</code>. 4 Si no se tomara
	 * en cuenta el <code>Blindaje</code>. 5 Si no se tomaran en cuenta las 
	 * <code>Armas</code>. 6 Si se quiere contar todos los componentes.
	 * Cualquier otro numero devuelve 0.
	 */
	private int costoFuturo(int i) {
		if(i < 1 || i > 6) return 0;
		int costo = 0;
		costo +=(llantas != null && i != 1)? llantas.obtenerCosto(): 0;
		costo +=(motor != null && i != 2)? motor.obtenerCosto(): 0;
		costo +=(carroceria != null && i != 3)? carroceria.obtenerCosto(): 0;
		costo +=(blindaje != null && i != 4)? blindaje.obtenerCosto(): 0;
		costo +=(armas != null && i != 5)? armas.obtenerCosto(): 0;
		return costo;
	}
	
	/**
	 * Metodo que devuelve el <code>Coche</code> construido
	 * @return Un objeto de tipo <code>Coche</code>. <code>null</code> si no 
	 * puede construise aun
	 */
	public Coche obtenerCoche() {
		if(llantas != null && motor != null && carroceria != null && 
			blindaje != null && armas != null) {
				Coche coche = new Coche(llantas, motor, carroceria, blindaje, armas);
				cliente.asignarPresupuesto(cliente.obtenerPresupuesto()-costoFuturo(6));
				cliente.agregarCoche(coche);
				return coche;
			}
		return null;
	}
}
