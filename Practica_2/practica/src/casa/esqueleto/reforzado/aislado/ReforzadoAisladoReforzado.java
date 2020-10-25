package casa.esqueleto.reforzado.aislado;

import casa.esqueleto.reforzado.EsqueletoReforzado;

public class ReforzadoAisladoReforzado extends EsqueletoReforzado {
	
	public ReforzadoAisladoReforzado() {
		super();
		costo += 3000;
		nombre += "y aislado reforzado";
	} 
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de reforzado");
		costo += 3000;
	}
}
