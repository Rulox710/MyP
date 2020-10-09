package recursos;

import recursos.interfaces.Suscriptor;
import recursos.interfaces.Servicio;
import recursos.servicios.MetodoPago;

public class Contrato {
	
	private Suscriptor cliente;
	private Servicio ser;
	private MetodoPago tipo;
	
	public Contrato(Servicio ser, Suscriptor cliente) {
		this.ser = ser;
		this.cliente = cliente;
	}
	
	public Contrato(Servicio ser, Suscriptor cliente, MetodoPago tipo) {
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
	
	public MetodoPago obtenerTipo() {
		return tipo;
	}
	
	public void asignarTipo(MetodoPago tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Contrato)) return false;
		Contrato con = (Contrato)obj;
		return (cliente.equals(con.obtenerCliente()) && ser.equals(con.obtenerServicio()));
	}
}
