package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class ModeloBaseAdministracionElectronica {
	protected final Integer codigo;
	protected final String nombre;
	protected final Date fechaCreacion;
	protected final Date fechaUltimaActualizacion;

	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion,
			Date fechaUltimaActualizacion) {
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

		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

		hashCodeBuilder.append(codigo);
		hashCodeBuilder.append(nombre);
		hashCodeBuilder.append(fechaCreacion);
		hashCodeBuilder.append(fechaUltimaActualizacion);

		return hashCodeBuilder.toHashCode();

	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ModeloBaseAdministracionElectronica) {
			final ModeloBaseAdministracionElectronica param = (ModeloBaseAdministracionElectronica) obj;
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.append(this.codigo, param.codigo);
			equalsBuilder.append(this.nombre, param.nombre);
			equalsBuilder.append(this.fechaCreacion, param.fechaCreacion);
			equalsBuilder.append(this.fechaUltimaActualizacion, param.fechaUltimaActualizacion);

			return equalsBuilder.isEquals();
		}
		return false;
	}
}
