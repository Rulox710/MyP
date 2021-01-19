package mvc.vista;

import java.lang.InterruptedException;
import java.lang.reflect.InvocationTargetException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.lang.Thread;

import mvc.controlador.GestorVentana;

/**
 * Clase que modela una ventana usando <code>JFrame</code>
 * @see <a href="https://java.databasedevelop.com/article/12056094/Setting+text+in+a+jTextArea+character+by+character+in+slow+motion">
 */
public abstract class Ventana extends JFrame implements ActionListener {
	public String textoIntroduccion = "";
	
	protected GestorVentana gv;
	protected static boolean escribiendoJuego = false;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 * @param gv El coordinador entre las ventanas y la logica
	 */
	public Ventana(GestorVentana gv) {
		this.gv = gv;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(480, 350);
		setTitle("Inserte titulo");
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setLayout(null);
	}
	
	/**
	 * Metodo para hacer que las palabras aparezacan letra por letra.
	 * Este fue tomado de una pagina de internet, pero no recuerdo cual era
	 * @param componente Un <code>JTextArea</code> en el que quieres que se escriba lento
	 * @param cadena Una cadena que se va a escribir
	 */
	protected void escribirLento(JTextArea componente, String cadena) {
		if (cadena.equals("")) return;
		new Thread() {
			public void run() {
				while(escribiendoJuego) {
					System.out.print("");
					try {
						sleep(5000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				escribiendoJuego = true;
				componente.setText("");
				char[] letras = cadena.toCharArray();
				for (char l: letras) {
                        try {
                            SwingUtilities.invokeAndWait(new Runnable() {
								public void run() {
									componente.append(""+l);
								}
							});
							sleep(20);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
					} catch (InvocationTargetException ex) {
						ex.printStackTrace();
					}
				}
				escribiendoJuego = false;
			}
		}.start();
	}
	
	/**
	 * Metodo que recibe las aciones realizadas en la ventana
	 * @param e El <code>ActionEvent</code> registrado
	 */
	@Override
	public abstract void actionPerformed(ActionEvent e);
}
