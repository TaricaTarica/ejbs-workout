package practico1.pco1.datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import practico1.pco1.datatypes.DtLoteVacuna;
import practico1.pco1.logica.LoteVacuna;
/**
 * Session Bean implementation class Datos
 */
@Singleton
@LocalBean
public class Datos implements DatosLocal {
	private List<LoteVacuna> lotesVacunas = new ArrayList<>();
    
    public Datos() {
        // TODO Auto-generated constructor stub
    }
    @Lock(LockType.WRITE)
    public void guardarLoteVacuna(LoteVacuna lv) {
    	lotesVacunas.add(lv);
    }
    @Lock(LockType.READ)
    public List<String> obtenerNombres(){
    	List<String> retorno = new ArrayList<>();
    	for(LoteVacuna lv: lotesVacunas) {
    		retorno.add(lv.getNombre());
    	}
    	return retorno;
    }
    @Lock(LockType.READ)
    public DtLoteVacuna buscarLoteVacuna(String nombre) {
    	DtLoteVacuna retorno = null;
    	for(LoteVacuna lv: lotesVacunas) {
    		if(lv.getNombre().equals(nombre)) {
    			retorno = new DtLoteVacuna(lv);
    		}
    	}

		return retorno;
    }
    public boolean existeLoteVacuna(String nombre) {
    	boolean retorno = false;
    	for(LoteVacuna lv: lotesVacunas) {
    		if(lv.getNombre().equals(nombre)) {
    			retorno = true;
    		}
    	}
		return retorno;
    }
    
}
