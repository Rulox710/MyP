package casa.esqueleto.concreto.aislado;

import casa.esqueleto.concreto.EsqueletoConcreto;

public class ConcretoAisladoReforzado extends EsqueletoConcreto {
	
	public ConcretoAisladoReforzado() {
		super();
		costo += 3000;
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de reforzado");
		costo += 3000;
	}
}
