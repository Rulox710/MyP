package graficos.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import graficos.control.GestorVentana;

public class VentanaPausa extends Ventana {
	
	private JButton botonReanudar, botonSalir;
	
	public VentanaPausa(GestorVentana gv) {
		super(gv);
		
		botonReanudar = new JButton();
		botonReanudar.setBounds(75,25,100,25);
		botonReanudar.setText("Continuar el juego");
		
		botonSalir = new JButton();
		botonSalir.setBounds(285,25,100,25);
		botonSalir.setText("Menu");
		
		botonReanudar.addActionListener(this);
		botonSalir.addActionListener(this);
		add(botonReanudar);
		add(botonSalir);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonReanudar) {
			gv.mostrarVentana(1);
			//gv.cambiarEstado(new EnJuego(gv));
		}
		if (e.getSource() == botonSalir) {
			gv.mostrarVentana(0);
			//gv.cambiarEstado(new Inicio(gv));
		}
	}
}
