package recursos.servicios;

import recursos.Contrato;
import recursos.interfaces.Servicio;
import recursos.interfaces.Suscriptor;

import java.util.ArrayList;

public abstract class ServicioGeneral implements Servicio {
	
	protected String nombreSer;
	
	protected ArrayList<Contrato> directorioPermanente;
	protected ArrayList<Contrato> directorioActual;
	
	@Override
	public abstract boolean agregarSuscriptor(Contrato con);
	
	protected boolean agregarNuevo(Contrato con) {
		if(directorioActual.indexOf(con) != -1) return false;
		directorioActual.add(con);
		return true;
	}
	
	protected boolean revisarPermanencia(Contrato con) {
		boolean verdad = (directorioPermanente.indexOf(con) == -1)? false: true;
		if(!verdad) directorioPermanente.add(con);
		return verdad;
	}
	
	@Override 
	public boolean cambiarSuscriptor(Contrato con, int i) {
		directorioActual.get(directorioActual.indexOf(con)).asignarTipo(i);
		
		return true;
	}
	
	@Override
	public boolean eliminarSuscriptor(Contrato con) {
		boolean valor = quitarSub(con);
		String mensaje;
		if(valor){
			mensaje = "Ya no cuenta con " + nombreSer + ", " +
				con.obtenerCliente().obtenerNombre() + ". Vuelva pronto";
		} else {
			mensaje = "No contaba con " + nombreSer + " 7_7";
		}
		System.out.println(mensaje);
		return valor;
	}
	
	protected boolean quitarSub(Contrato con) {
		int valor = directorioActual.indexOf(con);
		if(valor==-1) return false;
		directorioActual.remove(valor);
		return true;
	}
	
	@Override
	public abstract void pago();
	
	@Override
	public abstract void notificar();
	
	public void reiniciar() {
		directorioActual.clear();
		directorioPermanente.clear();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ServicioGeneral)) return false;
		ServicioGeneral ser = (ServicioGeneral)obj;
		return (nombreSer.equals(ser.nombreSer));
	}
}
