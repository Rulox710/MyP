package recursos.servicios.twitsh;

import recursos.Contrato;

public interface TwitshStrategy {
	
	public abstract void cobrar(Contrato con);

	public abstract boolean sePuedeCobrar(Contrato con);

}
