package recursos.servicios;

import recursos.Contrato;

public interface MetodoPago {
	
	public abstract void cobrar(Contrato con);

	public abstract boolean sePuedeCobrar(Contrato con);

}
