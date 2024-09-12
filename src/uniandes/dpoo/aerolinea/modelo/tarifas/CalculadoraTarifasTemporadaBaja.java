package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.01;
	protected double DESCUENTO_GRANDES = 0.2;
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int costo = 0;
		Ruta ruta = vuelo.getRuta();
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		int distancia = Aeropuerto.calcularDistancia(origen,destino);
		if (cliente.getTipoCliente().equals("Natural")) {
			costo = distancia*COSTO_POR_KM_NATURAL;
		}else {
			costo = distancia*COSTO_POR_KM_CORPORATIVO;
		}
		return costo;
	}


	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		double porcentaje = 0.0;
		if (cliente.getTipoCliente().equals( "Corporativo")) {
			ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;
			int tam = clienteCorp.getTamanoEmpresa();
			if (tam == 1) {
				porcentaje = DESCUENTO_GRANDES;
			}else if(tam == 2) {
				porcentaje = DESCUENTO_MEDIANAS;
			}else if(tam == 1) {
				porcentaje = DESCUENTO_PEQ;
			}
		}
		return porcentaje;
	}


}
