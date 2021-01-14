package graficos.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import juego.cronometro.Cronometro;
import graficos.control.GestorVentana;

public class VentanaPrincipal extends Ventana{
	private JTextArea texto;
	private JLabel titulo, opciones;
	private JButton botonIniciar,botonSalir;
	
	/**
	 * Construcctor de la clase. Inicia y coloca todos los objetos necesarios en
	 * la ventana
	 * @param gv El encargado de coordinar las ventanas y la logica
	 */
	public VentanaPrincipal(GestorVentana gv) {
		super(gv);
		botonIniciar = new JButton();
		botonIniciar.setBounds(100, 280, 120, 25);
		botonIniciar.setText("Iniciar");
		
		botonSalir = new JButton();
		botonSalir.setBounds(240, 280, 120, 25);
		botonSalir.setText("Salir");

		titulo = new JLabel();
		//titulo.setText("Casa ajena");
		titulo.setText("Espacio");
		titulo.setBounds(60, 40, 380, 30);
		titulo.setFont(new java.awt.Font("Verdana", 1, 15));

		opciones = new JLabel();
		opciones.setText("\u00BFQue quiere hacer?");
		opciones.setBounds(75, 240, 250, 25);

		textoIntroduccion = "Esta es una aventura conversacional.\nEscriba ac" +
			"ciones dependiendo de la situacion, como verbos  acompa\u00F1ados" +
			" con mas palabras si lo cree necesario";

		texto = new JTextArea();
		texto.setBounds(50, 90, 380, 140);
		texto.setEditable(false);
		texto.setFont(new java.awt.Font("Verdana", 0, 14));
		texto.setLineWrap(true);
		//texto.setText(textoIntroduccion);
		texto.setText("");
		texto.setWrapStyleWord(true);
		texto.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonIniciar.addActionListener(this);
		botonSalir.addActionListener(this);
		add(botonIniciar);
		add(botonSalir);
		add(opciones);
		add(titulo);
		add(texto);
	}
	
	/**
	 * Metodo que recibe las aciones realizadas en la ventana
	 * @param e El <code>ActionEvent</code> registrado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIniciar) {
			Cronometro.instancia.iniciarCronometro();
			gv.mostrarVentana(1);
			//gv.cambiarEstado(new EnJuego(gv));
		}
		if (e.getSource() == botonSalir) {
			Cronometro.instancia.terminarCronometro();
			System.exit(0);
		}
	}
}
