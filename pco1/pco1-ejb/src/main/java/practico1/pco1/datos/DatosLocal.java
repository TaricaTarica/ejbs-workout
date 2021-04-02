package practico1.pco1.datos;

import java.util.List;

import javax.ejb.Local;

import practico1.pco1.datatypes.DtLoteVacuna;
import practico1.pco1.logica.LoteVacuna;

@Local
public interface DatosLocal {
	public void guardarLoteVacuna(LoteVacuna lv);
	public DtLoteVacuna buscarLoteVacuna(String nombre);
	public List<String> obtenerNombres();
	public boolean existeLoteVacuna(String nombre);
}
