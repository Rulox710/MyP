package recursos.servicios.yutube;

import recursos.Contrato;

public interface YuTubeStrategy {
	
	public abstract void cobrar(Contrato con);

	public abstract boolean sePuedeCobrar(Contrato con);

}
