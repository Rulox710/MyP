package casa.esqueleto.reforzado.aislado;

import casa.esqueleto.reforzado.EsqueletoReforzado;

public class ReforzadoAisladoMadera extends EsqueletoReforzado {
	
	public ReforzadoAisladoMadera() {
		super();
		costo += 1000;
		nombre += "y aislado de madera";
	}
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de madera");
	}
}
