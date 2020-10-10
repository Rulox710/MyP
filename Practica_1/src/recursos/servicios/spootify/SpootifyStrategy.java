package recursos.servicios.spootify;

import recursos.Contrato;

public interface SpootifyStrategy {
	
	public abstract void cobrar(Contrato con);
	
	public abstract boolean sePuedeCobrar(Contrato con);

}
