package recursos.servicios.hammazon;

import recursos.Contrato;

public interface HammazonStrategy {
	
	public abstract void cobrar(Contrato con);

	public abstract boolean sePuedeCobrar(Contrato con);
	
}
