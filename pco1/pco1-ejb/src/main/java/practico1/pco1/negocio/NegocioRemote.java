package practico1.pco1.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import practico1.pco1.datatypes.DtLoteVacuna;

@Remote
public interface NegocioRemote {
	public void crearLoteVacuna(String nombre, LocalDate fechaCreado, int cantidad);
	public List<String> listarNombres();
	public DtLoteVacuna buscarLoteVacuna(String nombre);
	public boolean existeLoteVacuna(String nombre);
}
