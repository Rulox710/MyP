package casa.esqueleto.concreto.aislado;

import casa.esqueleto.concreto.EsqueletoConcreto;

public class ConcretoAisladoMadera extends EsqueletoConcreto {
	
	public ConcretoAisladoMadera() {
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
