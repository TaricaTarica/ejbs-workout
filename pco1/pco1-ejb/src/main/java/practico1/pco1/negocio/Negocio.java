package practico1.pco1.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import practico1.pco1.datatypes.DtLoteVacuna;
import practico1.pco1.logica.LoteVacuna;

/**
 * Session Bean implementation class Negocio
 */
@Stateless
@LocalBean
public class Negocio implements NegocioRemote {
	@EJB
	private practico1.pco1.datos.DatosLocal datos;
	
    /**
     * Default constructor. 
     */
    public Negocio() {
        // TODO Auto-generated constructor stub
    }
    
    public void crearLoteVacuna(String nombre, LocalDate fechaCreado, int cantidad){
    	LoteVacuna lv = new LoteVacuna(nombre, fechaCreado, cantidad);
    	datos.guardarLoteVacuna(lv);
    }
    public List<String> listarNombres(){
    	return datos.obtenerNombres();
    }
    public DtLoteVacuna buscarLoteVacuna(String nombre){
    	return datos.buscarLoteVacuna(nombre);
    }
    public boolean existeLoteVacuna(String nombre){
    	return datos.existeLoteVacuna(nombre);
    }

}
