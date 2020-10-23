package casa.esqueleto.reforzado.aislado;

import casa.esqueleto.reforzado.EsqueletoReforzado;

public class ReforzadoAisladoConcreto extends EsqueletoReforzado {
	
	public ReforzadoAisladoConcreto(){
		super();
		costo += 2000;
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected void aislarCasa() {
		System.out.println("Se hara un aislado de concreto");
	}
}
