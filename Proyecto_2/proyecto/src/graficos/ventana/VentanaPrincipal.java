package graficos.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import graficos.control.GestorVentana;

public class VentanaPrincipal extends Ventana{
	private JTextArea texto;
	private JLabel titulo, opciones;
	private JButton botonIniciar,botonSalir;
	
	public VentanaPrincipal(GestorVentana gv) {
		super(gv);
		botonIniciar = new JButton();
		botonIniciar.setBounds(100, 280, 120, 25);
		botonIniciar.setText("Iniciar");
		
		botonSalir = new JButton();
		botonSalir.setBounds(240, 280, 120, 25);
		botonSalir.setText("Salir");

		titulo = new JLabel();
		titulo.setText("Inserte titulo");
		titulo.setBounds(60, 40, 380, 30);
		titulo.setFont(new java.awt.Font("Verdana", 1, 15));

		opciones = new JLabel();
		opciones.setText("\u00BFQue quiere hacer?");
		opciones.setBounds(75, 240, 250, 25);

		textoIntroduccion = "nada aun";

		texto = new JTextArea();
		texto.setBounds(50, 90, 380, 140);
		texto.setEditable(false);
		texto.setFont(new java.awt.Font("Verdana", 0, 14));
		texto.setLineWrap(true);
		texto.setText(textoIntroduccion);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIniciar) {
			gv.mostrarVentana(1);
			//gv.cambiarEstado(new EnJuego(gv));
		}
		if (e.getSource() == botonSalir) {
			System.exit(0);
		}
	}
}
