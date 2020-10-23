package casa.esqueleto.concreto;

import casa.Casa;

public abstract class EsqueletoConcreto extends Casa {
	
	public EsqueletoConcreto() {
		super();
		costo += 1000;
	}
	
	/**
	 * Metodo para construir el esqueleto de la casa
	 */
	protected void construirEsqueleto() {
		System.out.println("Se hara un esqueleto de concreto");
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected abstract void aislarCasa();
}
