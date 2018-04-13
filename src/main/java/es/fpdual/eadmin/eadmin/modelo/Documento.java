package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Documento extends ModeloBaseAdministracionElectronica {

	private final Boolean publico;
	private final EstadoDocumento estado;
	private String codigoVerificacion;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);

		this.publico = publico;
		this.estado = estado;
	}

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado, String codigoVerificacion) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);

		this.publico = publico;
		this.estado = estado;
		this.codigoVerificacion = codigoVerificacion;
	}

	/*public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			Integer estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);
		this.publico = publico;
		if (estado.equals(1)) {
			this.estado = EstadoDocumento.ACTIVO;
		} else if (estado.equals(1)) {
			this.estado = EstadoDocumento.APROBADO;
		} else {
			this.estado = EstadoDocumento.ELIMINADO;
		}
	}*/

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	@Override
	public String toString() {
		return " Codigo :" + codigo + " Nombre:  " + nombre + " Fecha Creacion: " + fechaCreacion
				+ " Fecha Ultima Actualizacion: " + fechaUltimaActualizacion + " Publico: " + publico + " Estado: "
				+ estado;
	}

	public String calcularCodigoVerificacion() {
		codigoVerificacion = codigo + nombre + fechaCreacion + fechaUltimaActualizacion + publico + estado;
		return DigestUtils.shaHex(codigoVerificacion);
	}

	public String mostrar() {
		String cadena = "\n Codigo :" + codigo + "\n Nombre:  " + nombre + "\n Fecha Creacion: " + fechaCreacion
				+ "\n Fecha Ultima Actualizacion: " + fechaUltimaActualizacion + "\n Publico: " + publico
				+ "\n Estado: " + estado + "\n Codigo Verificacion: " + codigoVerificacion;
		return cadena;
	}

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

		hashCodeBuilder.appendSuper(super.hashCode());
		hashCodeBuilder.append(publico);
		hashCodeBuilder.append(estado);

		return hashCodeBuilder.toHashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			final Documento param = (Documento) obj;
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.appendSuper(super.equals(param));
			equalsBuilder.append(this.publico, param.publico);
			equalsBuilder.append(this.estado, param.estado);

			return equalsBuilder.isEquals();
		}
		return false;
	}

}
