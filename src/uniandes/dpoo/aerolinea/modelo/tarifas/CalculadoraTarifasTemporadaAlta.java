package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	protected int COSTO_POR_KM = 1000;
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
		Aeropuerto origen = ruta.origen;
		Aeropuerto destino = ruta.destino;
		int distancia = Aeropuerto.calcularDistancia(origen,destino);
		return distancia*COSTO_POR_KM;
	}
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0.0;
	}}
