package recursos.interfaces;

import recursos.Contrato;

public interface Servicio {

	public abstract boolean agregarSuscriptor(Contrato con);
	
	public abstract boolean cambiarSuscriptor(Contrato con, int i);

	public abstract boolean eliminarSuscriptor(Contrato con);
	
	public abstract void pago();
	
	public abstract void notificar();
	
	public abstract boolean equals(Object obj);
	
}
