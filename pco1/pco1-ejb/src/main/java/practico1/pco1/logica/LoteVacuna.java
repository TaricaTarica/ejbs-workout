package practico1.pco1.logica;

import java.time.LocalDate;

public class LoteVacuna {
	private String nombre;
	private LocalDate fechaCreado;
	//pivate Vacuna vacuna (vacunas?)
	private int cantidad;
	
	public LoteVacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoteVacuna(String nombre, LocalDate fechaCreado, int cantidad) {
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
