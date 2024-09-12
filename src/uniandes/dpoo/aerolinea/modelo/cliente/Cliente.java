package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private List<Tiquete> tiquetesUsados=new ArrayList<Tiquete>(); 
	private List<Tiquete> tiquetesSinUsar=new ArrayList<Tiquete>(); 
	
	public Cliente() {
	}
	
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador() ;
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int valor = 0; 
		for (Tiquete tiquete:tiquetesUsados) {
			valor += tiquete.getTarifa();
		}
		for (Tiquete tiquete:tiquetesSinUsar) {
			valor += tiquete.getTarifa();
		}
		return valor;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for (Tiquete tiquete:tiquetesSinUsar) {
			if (tiquete.getVuelo().equals(vuelo)) {
				tiquete.marcarComoUsado();
				tiquetesUsados.add(tiquete);
				tiquetesUsados.remove(tiquete);
			}
		}
	}
}
