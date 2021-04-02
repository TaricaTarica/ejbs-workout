package practico1.pco1.datatypes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.ejb.Local;

import practico1.pco1.logica.LoteVacuna;

public class DtLoteVacuna implements Serializable{
	private String nombre;
	private LocalDate fechaCreado;
	//pivate Vacuna vacuna (vacunas?)
	private int cantidad;
	
	public DtLoteVacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtLoteVacuna(LoteVacuna lv) {
		this.nombre = lv.getNombre();
		this.fechaCreado = lv.getFechaCreado();
		this.cantidad = lv.getCantidad();
	}
	public DtLoteVacuna(String nombre, LocalDate fechaCreado, int cantidad) {
		this.nombre = nombre;
		this.fechaCreado = fechaCreado;
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(LocalDate fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
