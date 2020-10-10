package recursos;

import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;

public class Contrato {
	
	private Suscriptor cliente;
	private Servicio ser;
	private int tipo;
	
	public Contrato(Servicio ser, Suscriptor cliente) {
		this.ser = ser;
		this.cliente = cliente;
	}
	
	public Contrato(Servicio ser, Suscriptor cliente, int tipo) {
		this.ser = ser;
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public Servicio obtenerServicio() {
		return ser;
	}
	
	public Suscriptor obtenerCliente() {
		return cliente;
	}
	
	public int obtenerTipo() {
		return tipo;
	}
	
	public void asignarTipo(int tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Contrato)) return false;
		Contrato con = (Contrato)obj;
		return (cliente.equals(con.obtenerCliente()) && ser.equals(con.obtenerServicio()));
	}
}
