package casa.esqueleto.reforzado.aislado;

import casa.esqueleto.reforzado.EsqueletoReforzado;

public class ReforzadoAisladoVidrio extends EsqueletoReforzado {
	
	public ReforzadoAisladoVidrio() {
		super();
		costo += 2500;
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de vidrio");
	}
}
