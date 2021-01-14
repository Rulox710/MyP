package graficos.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import juego.cronometro.Cronometro;
import graficos.control.GestorVentana;

public class VentanaPausa extends Ventana {
	
	private JButton botonReanudar, botonSalir;
	
	/**
	 * Construcctor de la clase. Inicia y coloca todos los objetos necesarios en
	 * la ventana
	 * @param gv El encargado de coordinar las ventanas y la logica
	 */
	public VentanaPausa(GestorVentana gv) {
		super(gv);
		
		botonReanudar = new JButton();
		botonReanudar.setBounds(75,25,100,25);
		botonReanudar.setText("Continuar");
		
		botonSalir = new JButton();
		botonSalir.setBounds(285,25,100,25);
		botonSalir.setText("Menu");
		
		botonReanudar.addActionListener(this);
		botonSalir.addActionListener(this);
		add(botonReanudar);
		add(botonSalir);
	}
	
	/**
	 * Metodo que recibe las aciones realizadas en la ventana
	 * @param e El <code>ActionEvent</code> registrado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonReanudar) {
			Cronometro.instancia.iniciarCronometro();
			gv.mostrarVentana(1);
		}
		if (e.getSource() == botonSalir) {
			gv.mostrarVentana(0);
		}
	}
}
