package casa.esqueleto.reforzado;

import casa.Casa;

public abstract class EsqueletoReforzado extends Casa {
	
	public EsqueletoReforzado() {
		super();
		costo += 1000;
		nombre += "con esqueleto reforzado ";
	}
	/**
	 * Metodo para construir el esqueleto de la casa
	 */
	protected void construirEsqueleto() {
		System.out.println("Se hara un esqueleto de reforzado");
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected abstract void aislarCasa();
}
