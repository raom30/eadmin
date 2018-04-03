package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloBaseAdministracionElectronica {
	protected final Integer codigo;
	protected final String nombre;
	protected final Date fechaCreacion;
	protected final Date fechaUltimaActualizacion;
	
	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaActualizacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
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
	
	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	@Override
	public int hashCode() {
		
		return codigo.hashCode();
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeloBaseAdministracionElectronica) {
			return codigo.equals(((ModeloBaseAdministracionElectronica) obj).getCodigo());
		}
		return false;
	}
}
