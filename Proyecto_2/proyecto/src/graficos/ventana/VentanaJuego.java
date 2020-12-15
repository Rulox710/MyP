package graficos.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utilidad.Escritor;
import graficos.control.GestorVentana;

public class VentanaJuego extends Ventana {
	
	private JTextArea textoInteractivo, textoConsola;
	private JButton botonEnviar, botonPausa;
	private JTextField campo;
	
	public VentanaJuego(GestorVentana gv) {
		super(gv);
		
		campo = new JTextField();
		campo.setBounds(75, 280, 220, 25);
		campo.setText("Escriba su accion");
		
		botonPausa = new JButton();
		botonPausa.setBounds(75,25,100,25);
		botonPausa.setText("Pausa");
		
		botonEnviar = new JButton();
		botonEnviar.setBounds(300, 280, 120, 25);
		botonEnviar.setText("Enviar");
		
		textoIntroduccion = "nada aun\n\n\n\n\n\n\nCola";
		
		textoInteractivo = new JTextArea();
		textoInteractivo.setBounds(50, 90, 380, 110);//140
		
		textoConsola = new JTextArea();
		textoConsola.setBounds(50, 220, 380, 20);
		
		//textoInteractivo.setEditable(false);
		textoInteractivo.setFont(new java.awt.Font("Verdana", 0, 14));
		textoInteractivo.setLineWrap(true);
		textoInteractivo.setText(textoIntroduccion);
		textoInteractivo.setWrapStyleWord(true);
		textoInteractivo.setBorder(javax.swing.BorderFactory.createBevelBorder(
			javax.swing.border.BevelBorder.LOWERED, null, null, null,
			new java.awt.Color(0, 0, 0))); 
		
		//textoConsola.setEditable(false);
		textoConsola.setFont(new java.awt.Font("Verdana", 0, 14));
		textoConsola.setLineWrap(true);
		textoConsola.setText(textoIntroduccion);
		textoConsola.setWrapStyleWord(true);
		
		botonEnviar.addActionListener(this);
		botonPausa.addActionListener(this);
		add(botonEnviar);
		add(botonPausa);
		add(textoInteractivo);
		add(textoConsola);
		add(campo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonEnviar) {
			String str = campo.getText();
			boolean letras = Escritor.validarAlfabetico(str);
			if(letras) {
				escribirLento(textoInteractivo,str);
				textoConsola.setText("");
				campo.setText("");
			} else {
				escribirLento(textoConsola,"No entiendo");
			}
		}
		if (e.getSource() == botonPausa) {
			gv.mostrarVentana(2);
			//gv.cambiarEstado(new EnPausa(gv));
		}
	}
}
