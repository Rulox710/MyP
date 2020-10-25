package casa;

import utilidad.CaracterEspecial;

/**
 * Clase abstracta que modela el proceso de creacion de una <code>casa</code>
 */
public abstract class Casa {
	
	/**
	 * Un numero que representa el el dinero que costara de la <code>Casa</code>
	 */
	protected double costo;
	
	/**
	 * Nombre de la casa, de que materiales esta hecha y costo
	 */
	protected String nombre;
	
	/**
	 * Constructor de la clase
	 */
	public Casa() {
		costo = 1000;
		nombre = "Casa ";
	}
	
	/**
	 * Inicia la contruccion de la <code>Casa</code>
	 */
	public void construccion() {
		System.out.println("Se empezara a construir la casa.");
		prepararTerreno();
		falsoAvance();
		colocarCimientos();
		falsoAvance();
		construirEsqueleto();
		falsoAvance();
		instalarElectricidad();
		falsoAvance();
		aislarCasa();
		falsoAvance();
		acabados();
		falsoAvance();
		System.out.println("");
	}
	
	/**
	 * Metodo privado que da la ilusion de progreso
	 */
	private void falsoAvance() {
		for (int i = 1; i < 9; i++){
			switch(i%4){
				case 1:
				System.out.print("/"+CaracterEspecial.izquierdaN(1));
				break;
				case 2:
				System.out.print("-"+CaracterEspecial.izquierdaN(1));
				break;
				case 3:
				System.out.print("\\"+CaracterEspecial.izquierdaN(1));
				break;
				case 4:
				System.out.print("|"+CaracterEspecial.izquierdaN(1));
				break;
			}
			try{
				Thread.sleep(60);
			} catch(Exception e){
			}
		}
		
	}
	
	/**
	 * Metodo para preparar el terreno
	 */
	protected void prepararTerreno() {
		System.out.println("Estoy preparando el terreno.");
	}
	
	/**
	 * Metodo para colocar los cimientos
	 */
	protected void colocarCimientos() {
			System.out.println("Estoy colocando los cimientos.");
	}
	
	/**
	 * Metodo para construir el esqueleto de la casa
	 */
	protected abstract void construirEsqueleto();
	
	/**
	 * Metodo para instalar la electricidad y la plomeria
	 */
	protected void instalarElectricidad() {
		System.out.println("Estoy instalando la electricidad y la plomeria.");
	}
	
	/**
	 * Metodo para aislar la <code>Casa</code>
	 */
	protected abstract void aislarCasa();
	
	/**
	 * Metodo para poner los acabados
	 */
	protected void acabados() {
		System.out.println("Estoy poniendo los acabados.");
	}
	
	/**
	 * Metodo para ver el nombre de a una <code>Casa</code>
	 * @return Nombre de la casa en una cadena
	 */
	public String toString() {
		return nombre + " de costo: " + costo;
	}
}
