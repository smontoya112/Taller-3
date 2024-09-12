package uniandes.dpoo.aerolinea.modelo.cliente;
/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteNatural extends Cliente
{
    // TODO completar
    public static String NATURAL = "Natural";
    public String nombre;


    
    public ClienteNatural(String nombre) {
    	this.nombre = nombre;

    }

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return NATURAL;
	}


	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
