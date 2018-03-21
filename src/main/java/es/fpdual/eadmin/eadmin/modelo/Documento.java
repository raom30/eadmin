package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento {

	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Boolean publico;
	private EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		
		return codigo.hashCode();
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			return codigo.equals(((Documento) obj).getCodigo());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo ;
	}
	
}
