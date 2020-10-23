package casa.esqueleto.concreto.aislado;

import casa.esqueleto.concreto.EsqueletoConcreto;

public class ConcretoAisladoVidrio extends EsqueletoConcreto {
	
	public ConcretoAisladoVidrio() {
		super();
		costo += 2500;
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de vidrio");
		costo += 2500;
	}
}
