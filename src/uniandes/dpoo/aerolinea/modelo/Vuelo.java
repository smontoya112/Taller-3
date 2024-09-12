package uniandes.dpoo.aerolinea.modelo;
import java.util.Collection;
import java.util.HashSet;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Collection<Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta,String fecha,Avion avion) {
		this.fecha = fecha;
		this.avion = avion;
		this.ruta = ruta;
		this.tiquetes = new HashSet<>();
	}
	
	public Ruta getRuta(){
		return ruta;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		int vendidos=0;
		int capacidad = avion.getCapacidad();
		if (cantidad > capacidad) {
			return vendidos;
		}
	 else {
		for (int i=0; i<cantidad; i++) {
			int tarifa = calculadora.calcularTarifa(this, cliente);
			Tiquete tiquete = GeneradorTiquetes.generarTiquete(this,cliente,tarifa);
			tiquetes.add(tiquete);
			vendidos++;
		}
	}
		return vendidos;
		
	}
	@Override
	public boolean equals(Object objeto) {
		if(this == objeto) {
			return true;
		}
		if (objeto == null || getClass() != objeto.getClass()) {
			return false;
		}
		Vuelo vuelo = (Vuelo) objeto;
		if(fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion)) {
			return true;
		}else {
			return false;
		}
	}
}
