package recursos.servicios.netflis;

import recursos.Contrato;

public interface NetflisStrategy {
	
	public abstract void cobrar(Contrato con);

	public abstract boolean sePuedeCobrar(Contrato con);

}
