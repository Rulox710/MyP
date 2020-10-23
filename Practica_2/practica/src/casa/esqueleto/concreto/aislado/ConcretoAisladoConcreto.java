package casa.esqueleto.concreto.aislado;

import casa.esqueleto.concreto.EsqueletoConcreto;

public class ConcretoAisladoConcreto extends EsqueletoConcreto {
	
	public ConcretoAisladoConcreto(){
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
